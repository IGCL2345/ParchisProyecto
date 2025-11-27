/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc4g550.modelo;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class BancoPregunta {
    private ArrayList<Pregunta> listaPreguntas;

    public BancoPregunta() {
        listaPreguntas= new ArrayList<Pregunta>();
    }
    
    public void crearPreguntas(){
       agregar(new Pregunta("Bruselas es la capital de Belgica?",0));
       agregar(new Pregunta("Santa Cruz esta en Guanacaste?",0));
       agregar(new Pregunta("¿El tomate es una fruta?",0));
       agregar(new Pregunta("Jicaral es parte de Guanacaste?",1));
        
    }
    
    public void agregar (Pregunta pregunta){
        listaPreguntas.add(pregunta);
    }
    
    public Pregunta getPregunta(int posicion){
        return listaPreguntas.get(posicion);
    }
    
    public int getElementos(){
        return listaPreguntas.size();
     }  
}//fin de la clase
