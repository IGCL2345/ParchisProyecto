/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc4g550.controlador;

import com.mycompany.parchisc4g550.modelo.AreaJuego;
import com.mycompany.parchisc4g550.modelo.Casa;
import com.mycompany.parchisc4g550.modelo.Cronometro;
import com.mycompany.parchisc4g550.modelo.Ficha;
import com.mycompany.parchisc4g550.modelo.Posicion;
import com.mycompany.parchisc4g550.vista.GUIJuego;
import com.mycompany.parchisc4g550.vista.GUIPrincipal;
import com.mycompany.parchisc4g550.vista.NewJFrame;
import com.mycompany.parchisc4g550.vista.PanelControl;
import com.mycompany.parchisc4g550.vista.PanelJuego;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author user
 */
public class ControladorJuego implements ActionListener,MouseListener {
    private GUIJuego guiJuego;
    private PanelJuego panelJuego;
    private PanelControl panelControl;
    private GUIPrincipal guiPrincipal;
    private Ficha ficha;
    private AreaJuego areaJuego;
    private Casa casa;
    private Posicion posicion;
    private Cronometro cronometro;
     private Timer timer;
    private NewJFrame frame;
    
    public ControladorJuego(GUIPrincipal guiPrincipal, String colorJugador1, String nombreJugador1, String nombreJugador2){
        this.guiPrincipal=guiPrincipal;
        guiJuego=new GUIJuego(this);
        panelJuego=guiJuego.getPanelJuego();
        panelControl=guiJuego.getPanelControl();
        guiJuego.setVisible(true);
        this.casa= new Casa();
        areaJuego= new AreaJuego(colorJugador1,nombreJugador1,nombreJugador2);
         this.cronometro= new Cronometro();
        timer = new Timer(30, this);
        frame = new NewJFrame(this);
        update();
         frame.setVisible(true);
        panelControl.setJlNombreJugador1(nombreJugador1);
        panelControl.setJlNombreJugador2(nombreJugador2);
        //ficha=new Ficha(new Posicion(100,100),new  ImageIcon("./src/main/resources/img/pieceblue.png"),"Amarillo");
    }//453,468
    public void dibujar (Component c, Graphics g){
        //ficha.dibujar(c, g);
        areaJuego.dibujar(c, g);
         panelJuego.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getActionCommand() != null) {
        switch(e.getActionCommand()){
            case "Dado":
                System.out.println("Presiono el dado");
                areaJuego.realizarJugada(posicion.getX(), posicion.getY());
            break;
            case "Atras":
                guiJuego.dispose();
                guiPrincipal.setVisible(true);
            break;  
            case "Iniciar":
                     
                    cronometro.start();
                    timer.start();
                   
                    break;
                case "Detener":

                   cronometro.stop();
                   timer.stop();
                    break;
                case "Pausar":
                    cronometro.reset();
                    timer.restart();
                    break;

        }
     }
          if (timer.isRunning()) {
            update();
          
             if (cronometro.getElapsedTime()>= 20000) {
                        timer.stop();
                        cronometro.stop();
                    }
     }
  }
    
    public void update() {

        frame.setJlTime(cronometro.getFormattedTime());
    }
      
       
    
    
   
    

    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("x "+e.getX()+" Y "+e.getY());
//        ficha.getPosicion().setX(e.getX());
//        ficha.getPosicion().setY(e.getY());
          if(casa.isContains(e.getX(), e.getY())){
             System.out.println("Si hay una ficha");
             System.out.println("Indice de la ficha  "+casa.getIndexFicha(e.getX(), e.getY()));
          } else{
               System.out.println("No hay una ficha");
          }
        posicion=new Posicion(e.getX(),e.getY());
        panelJuego.repaint();
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}

