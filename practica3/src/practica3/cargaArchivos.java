package practica3;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wayne
 */
public class cargaArchivos {
    JFrame ventanaPrincipalF;
    JLabel fondoL;
    
    JButton botonD,botonC,botonB,botonA,botonE,botonF;
    
    public cargaArchivos(){
        //AQUÍ CREAMOS LA VENTANA PRINCIPAL
        ventanaPrincipalF = new JFrame("Cargar archivos");
        ventanaPrincipalF.setSize(600,400);
        ventanaPrincipalF.setLocationRelativeTo(null);
        ventanaPrincipalF.setVisible(true);
        ventanaPrincipalF.setLayout(null);
        ventanaPrincipalF.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //AQUÍ AGREGAMOS UN LABEL DE FONDO AL PANEL 1
        fondoL = new JLabel();
        fondoL.setSize(600,400);
        fondoL.setVisible(true);
        fondoL.setLayout(null);
        fondoL.setIcon(redimensionarImagen(600, 400, "colegio.jpg"));
        ventanaPrincipalF.add(fondoL);
 try{
       //AQUÍ DEFINO MI BOTÓN PARA ADMINISTRACION DE VENTAS
        botonB = new JButton("Cargar alumnos");
        botonB.setBounds(200,90,200,30);
        botonB.setVisible(true);
        botonB.setLayout(null);
        
        //DEFINIENDO ACCIONES PARA MÍ BOTÓN VENTAS
       botonB.addActionListener(new ActionListener() {
            //EL CÓDIGO DE MIS ACCIONES VA ACÁ
            @Override
            public void actionPerformed(ActionEvent ae) {
                alumnos al= new alumnos();
                 ventanaPrincipalF.dispose();
                //reporteApps re= new reporteApps();
            }
            private void dispose() {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }); 
       fondoL.add(botonB);       
       ventanaPrincipalF.repaint();
               
        
        
        //AQUÍ DEFINO MI BOTÓN PARA ADMINISTRACION DE VENTAS
        botonC = new JButton("Cargar cursos");
        botonC.setBounds(200,140,200,30);
        botonC.setVisible(true);
        botonC.setLayout(null);
        
        //DEFINIENDO ACCIONES PARA MÍ BOTÓN VENTAS
        botonC.addActionListener(new ActionListener() {
            //EL CÓDIGO DE MIS ACCIONES VA ACÁ
            @Override
            public void actionPerformed(ActionEvent ae) {
                 cursos cs= new cursos();
                 ventanaPrincipalF.dispose();
                //reporteApps re= new reporteApps();
            }
            private void dispose() {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }); 
       fondoL.add(botonC);       
       ventanaPrincipalF.repaint();
       
       //AQUÍ DEFINO MI BOTÓN PARA REPORTES
        botonD = new JButton("Asignación");
        botonD.setBounds(200,190,200,30);
        botonD.setVisible(true);
        botonD.setLayout(null);
        
        //DEFINIENDO ACCIONES PARA MÍ BOTÓN REPORTES
        botonD.addActionListener(new ActionListener() {
            //EL CÓDIGO DE MIS ACCIONES VA ACÁ
            @Override
            public void actionPerformed(ActionEvent ae) {
                asignacion as= new asignacion();
                ventanaPrincipalF.dispose();
                
            }
            private void dispose() {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
         fondoL.add(botonD);      
      ventanaPrincipalF.repaint();
      
      //AQUÍ DEFINO MI BOTÓN PARA REPORTES
        botonF = new JButton("Regresar al menú");
        botonF.setBounds(200,240,200,30);
        botonF.setVisible(true);
        botonF.setLayout(null);
        
        //DEFINIENDO ACCIONES PARA MÍ BOTÓN REPORTES
        botonF.addActionListener(new ActionListener() {
            //EL CÓDIGO DE MIS ACCIONES VA ACÁ
            @Override
            public void actionPerformed(ActionEvent ae) {
                menu me= new menu();
                ventanaPrincipalF.dispose();
            }
            private void dispose() {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
         fondoL.add(botonF);      
      ventanaPrincipalF.repaint();
      
 }catch(Exception e){
            
        }
    }
    //MÉTODO PARA EL REDIMENSIONAMIENTO DE UNA IMÁGEN
    public ImageIcon redimensionarImagen(int x, int y, String url) {
        ImageIcon a = new ImageIcon(url);
        ImageIcon b = new ImageIcon(a.getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT));
        return b;
    }
}
