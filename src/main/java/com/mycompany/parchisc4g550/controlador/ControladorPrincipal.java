/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc4g550.controlador;

import com.mycompany.parchisc4g550.vista.GUICreditos;
import com.mycompany.parchisc4g550.vista.GUIHistoria;
import com.mycompany.parchisc4g550.vista.GUIInstrucciones;
import com.mycompany.parchisc4g550.vista.GUIJugador;
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
    private GUIJugador guiJugador;
    private AudioController audio;
    
    public ControladorPrincipal(){
        guiPrincipal= new GUIPrincipal(this);
        guiPrincipal.setVisible(true);
        guiCreditos = new GUICreditos(this);
        guiInstrucciones= new GUIInstrucciones(this);
        guiHistoria= new GUIHistoria(this);
        guiJugador=new GUIJugador(this);
        audio= new AudioController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         switch (e.getActionCommand()){
             case "Jugar":
                 guiPrincipal.setVisible(false);
                 guiJugador.setVisible(true);
             break;
             case "Continuar":
                 System.out.println(guiJugador.getCbColor());
                 System.out.println(guiJugador.getTxtJugador1());
                 System.out.println(guiJugador.getTxtJugador2());
                 controladorJuego=new ControladorJuego(guiPrincipal,guiJugador.getCbColor(),guiJugador.getTxtJugador1(),guiJugador.getTxtJugador2());
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
             case "Sonido":
                 System.out.println("Esta escuchando");
                 if(audio.estaReproduciendo()){
                     audio.detener();
                 
                 }else{
                     audio.iniciarMusica("/audios/audio1.wav");
                 }
             break;    
         }
                
    }
    
}
