/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc4g550.controlador;

import com.mycompany.parchisc4g550.vista.GUICreditos;
import com.mycompany.parchisc4g550.vista.GUIHistoria;
import com.mycompany.parchisc4g550.vista.GUIInstrucciones;
import com.mycompany.parchisc4g550.vista.GUIPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author user
 */
public class ControladorPrincipal implements ActionListener  {
    private GUIPrincipal guiPrincipal;
    private GUICreditos guiCreditos;
    private GUIInstrucciones guiInstrucciones;
    private GUIHistoria guiHistoria;
    private ControladorJuego controladorJuego;
    
    public ControladorPrincipal(){
        guiPrincipal= new GUIPrincipal(this);
        guiPrincipal.setVisible(true);
        guiCreditos = new GUICreditos(this);
        guiInstrucciones= new GUIInstrucciones(this);
        guiHistoria= new GUIHistoria(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         switch (e.getActionCommand()){
             case "Jugar":
                 guiPrincipal.setVisible(false);
                 controladorJuego=new ControladorJuego(guiPrincipal);
             break;
             case "Instrucciones":
                 guiInstrucciones.setVisible(true);
                 guiPrincipal.setVisible(false);
             break;
               case "AtrasInstrucciones":
                  guiInstrucciones.setVisible(false);
                  guiPrincipal.setVisible(true);
             break;
             case "Historia":
                 guiHistoria.setVisible(true);
                 guiPrincipal.setVisible(false);
             break;
             case "AtrasHistoria":
                  guiHistoria.setVisible(false);
                  guiPrincipal.setVisible(true);
             break;
             case "Creditos":
                 guiCreditos.setVisible(true);
                 guiPrincipal.setVisible(false);
             break;
             case "AtrasCreditos":
                 guiPrincipal.setVisible(true);
                  guiCreditos.setVisible(false);
             break;
             case "Salir":
                 System.exit(0);
             break;
         }
        
    }
    
}
