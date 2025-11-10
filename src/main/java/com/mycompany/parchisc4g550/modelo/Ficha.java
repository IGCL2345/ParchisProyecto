/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc4g550.modelo;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class Ficha {
    private Posicion posicion;
    private ImageIcon imagen;
    private String color;
    private Rectangle hitbox;
    
    public boolean isContains(int x,int y){
       return hitbox.contains(x, y);
    }
    public Ficha(Posicion posicion, ImageIcon imagen, String color) {
        this.posicion = posicion;
        this.imagen = imagen;
        this.color = color;
        hitbox= new Rectangle(posicion.getX(),posicion.getY(), 30,30);
        
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void dibujar(Component c, Graphics g){
        imagen.paintIcon(c,g,posicion.getX(),posicion.getY());
    }
    
}
