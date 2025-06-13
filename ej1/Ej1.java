package ej1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ej1<T> {
    private ArrayList<T> caminoMaxCantSalas;
    private Estado e;

    Ej1(){
        this.caminoMaxCantSalas = new ArrayList<>();
        this.e = new Estado();
    }

    public ArrayList<T> buscarCamino(T verticeOrigen, T verticeDestino, GrafoDirigido<T> g){
        this.caminoMaxCantSalas.clear(); // Limpiar si tengo algun camino de otro llamado
        this.e.clear(); // Reiniciar el estado (visitados, camino y sala destino)
        this.e.setSalaDestino(verticeDestino); // Setear al estado la sala destino
        this.e.avanzar(verticeOrigen); // Avanzo con el vertice origen
        this.buscarCaminoMaxCantSalas(verticeDestino, g); // Llamo al algoritmo principal de backtracking
        return new ArrayList<T>(this.caminoMaxCantSalas);
    }

    private void buscarCaminoMaxCantSalas(T vertice, GrafoDirigido<T> g){
        if(this.e.encontreCamino()){
            if(this.caminoMaxCantSalas.size() < this.e.caminoCantSalas()){
                this.caminoMaxCantSalas =  new ArrayList<T>(this.e.obtenerCamino());
            }
            return;
        }
        // Desde donde estoy generar el espacio de busqueda (nodos hijos)
        Iterator<T> adyacentes = g.obtenerAdyacentes(vertice);
        while(adyacentes.hasNext()){
            T ady = adyacentes.next();
            // Verificar si es factible ir al adyacente (Si no visite el vertice)
            if(this.e.esFactible(ady)){
                this.e.avanzar(ady); // Avanzar el estado, agregar ady al camino y a visitados
                this.buscarCaminoMaxCantSalas(ady, g); // Llamada recursiva
                this.e.deshacer(ady); // Deshacer el estado, eliminar ady del camino y de visitados
            }
        }
    }
}
