/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc4g550.modelo;

import java.awt.Component;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class AreaJuego {

    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private int turno = 1;
    private Ficha ficha;

    public AreaJuego(String colorJugador1, String nombreJugador1, String nombreJugador2) {
        tablero = new Tablero();
        crearJugadores(colorJugador1, nombreJugador1, nombreJugador2);
        tablero.crearCasas(colorJugador1);
        jugador1.setCasa(tablero.getCasaJugador1());
        jugador2.setCasa(tablero.getCasaJugador2());
    }

//   public int getIndexFicha(int x, int y){
//     return tablero.getIndexFicha(x, y);
//   }
//   
//    public boolean isContains(int x,int y){
//       return tablero.isContains(x, y);
//    }
    public void crearJugadores(String colorJugador1, String nombreJugador1, String nombreJugador2) {
        switch (colorJugador1) {
            case "Amarillo":
                jugador1 = new Jugador(nombreJugador1, colorJugador1);
                jugador2 = new Jugador(nombreJugador2, "Rojo");
                break;
            case "Azul":
                jugador1 = new Jugador(nombreJugador1, colorJugador1);
                jugador2 = new Jugador(nombreJugador2, "Verde");
                break;
            case "Rojo":
                jugador1 = new Jugador(nombreJugador1, colorJugador1);
                jugador2 = new Jugador(nombreJugador2, "Amarillo");
                break;
            case "Verde":
                jugador1 = new Jugador(nombreJugador1, colorJugador1);
                jugador2 = new Jugador(nombreJugador2, "Azul");
                break;
        }

    }

    public void dibujar(Component componente, Graphics g) {
        tablero.dibujar(componente, g);
    }

    public void realizarJugada(int x, int y) {
        int numDado=5;
        if (turno == 1) {
            if (jugador1.getCasa().isContains(x, y)) {
                //hacer las acciones para sacar al jugador 1
                if(numDado==5){
                salir(jugador1,x,y);
                }
            }
            //cuando la ficha esta en el tablero
            else{
             //Se debe verificar el color 
             //Obtener la posicion de la ficha en el tablero
             //Mover la ficha la cantidad de posiciones que da el dado
            }
            

            //la ficha podria estar en el tablero
            //Si esta en el tablero deberia moverse
        } else {
            if (jugador2.getCasa().isContains(x, y)) {
                //hacer las acciones para sacar al jugador 2
                salir(jugador2,x,y);
            }

            //la ficha podria estar en el tablero
            //Si esta en el tablero deberia moverse
        }
    }
    

     public void salir(Jugador jugador, int x, int y) {
        ficha = jugador.getCasa().getFicha(jugador.getCasa().getIndexFicha(x, y));
        tablero.setFicha(jugador.getCasa().getSalida(), ficha);
        jugador.getCasa().setFicha(jugador.getCasa().getIndexFicha(x, y), null);
     }

    public void moverFicha(int x, int y, int numDado) {
         int numCelda = -1;
    System.out.println("La ficha no está en el tablero " 
            + tablero.getIndexFicha(x, y) + " " 
            + tablero.isContains(x, y));

    if (tablero.isContains(x, y)) {
        numCelda = tablero.getIndexFicha(x, y);
        System.out.println("Mover la ficha");

        int celdaDestino = numCelda + numDado;
        tablero.setFicha(celdaDestino, ficha);
        tablero.setFicha(numCelda, null);
    }
    }

}
