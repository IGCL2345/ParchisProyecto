/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc4g550.modelo;

/**
 *
 * @author user
 */
public class CeldaEspecial extends Celda {
    protected String tipo;
    
    public CeldaEspecial(Posicion posicion, String tipo) {
        super(posicion);
        this.tipo= tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
