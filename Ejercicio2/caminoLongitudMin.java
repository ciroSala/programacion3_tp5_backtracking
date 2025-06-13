package Ejercicio2;

import java.util.ArrayList;

public class caminoLongitudMin {
    private Estado<Casilla> e;
    private ArrayList<Integer> caminoMenor;
    private int longitudMin;
    private ArrayList<String> direcciones;

    public caminoLongitudMin(){
        this.e = new Estado<>();
        this.longitudMin = 1000000000;
        this.caminoMenor = new ArrayList<>();
        this.direcciones = new ArrayList<>();
        this.direcciones.add("Norte");
        this.direcciones.add("Este");
        this.direcciones.add("Oeste");
        this.direcciones.add("Sur");
    }

    public ArrayList<Integer> obtenerCaminoLongitudMin(int casillaOrigen, int casillaDestino){
        this.longitudMin = ;
        this.e.clear(); // Reinicia camino, casillas visitadas y longitud.
        // Seteo la posicion de la casilla Origen, agrego su valor a longitud del estado, agrego la casilla
        // como visitada y agrego esa casilla a visitadas.
        ArrayList<Integer> posO = this.e.setPos(casillaOrigen);
        this.e.setCasillaDestino(casillaDestino); // Seteo destino de la casilla destino
        this.obtenerCaminoLongitudMin();
        return new ArrayList<>(this.caminoMenor);
    }

    private void obtenerCaminoLongitudMin(){
        //  CB: Cuando llegue a la casilla destino, verifica el estado si la casilla de mi pos actual es igual a la casilla destino
        if(this.e.llegueCasillaDestino()){
            // Verifico si la longitud del camino del estado, es menor
            // a la longitudMin, si es asi guardo el camino y la longitudMin del estado
            if(e.longitudCamino() < this.longitudMin){
                this.longitudMin = e.obtenerLongitudCamino(); // Obtiene la longitud del camino del estado
                this.caminoMenor = new ArrayList<Integer>(e.obtenerCamino());
            }
        }
        // Desde la pos del estado, genero mis posciciones posibles para ir (espacio de busquedo)
        foreach(String direc : direcciones){
            // Pregunto a la casilla de la pos actual, si es factible moverse a esa direccion
            if(e.esFactible(direc)){
                //  Avanzo a la direccion, cambio la posicion segun la direc, sumo el valor natural de la casilla de mi pos a longitud,
                // agrego al camino la casilla de mi pos, y agrego la casilla como visitada
                e.avanzar(direc);
                // Realizo llamada recursiva
                this.obtenerCaminoLongitudMin();
                //  Deshacer segun la direccion, elimino el valor natural de la casilla de mi pos, elimino del camino la
                // casilla de mi pos, saco la casilla de mi pos como visitada y cambio la pos segun la direccion.
                e.deshacer(direc);
            }
        }
    }
}
