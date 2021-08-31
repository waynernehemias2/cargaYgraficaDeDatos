/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static practica3.alumnos.edad;

/**
 *
 * @author wayne
 */
public class graficar {
    JFrame ventanaPrincipalF,ventanaPrincipalF1,ventanaPrincipalF2;
    JLabel fondoL,ing,login,mens,mensa;
    JTextField ruta;
    public static String vari;
    JButton botonD,botonC,botonB,botonA,botonE,botonF,botonx;
    public static int ma=0,fe=0;
    public static int un=0,ds=0,tr=0, cu=0, ci=0;
    public static int gen[]= new int[2];
    public graficar(){
    //AQUÍ CREAMOS LA VENTANA PRINCIPAL
        ventanaPrincipalF = new JFrame("Graficar");
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
        
        ing = new JLabel("Ingrese ID de cuso asignado");
        ing.setForeground(Color.red);
        ing.setBounds(90, 50, 200, 15);
        ing.setVisible(true);
        ing.setLayout(null);
        fondoL.add(ing);
        
        //AQUÍ CREAMOS UN TEXTFIELD
        ruta = new JTextField();
        ruta.setBounds(260,50,25,20);
        ruta.setVisible(true);
        ruta.setLayout(null);
        fondoL.add(ruta);
 try{
       //AQUÍ DEFINO MI BOTÓN PARA ADMINISTRACION DE VENTAS
        botonB = new JButton("Grafica por generos");
        botonB.setBounds(200,90,200,30);
        botonB.setVisible(true);
        botonB.setLayout(null);
        
        //DEFINIENDO ACCIONES PARA MÍ BOTÓN VENTAS
       botonB.addActionListener(new ActionListener() {
            //EL CÓDIGO DE MIS ACCIONES VA ACÁ
            @Override
            public void actionPerformed(ActionEvent ae) {
                vari=ruta.getText();
                boolean va=false;
                int ver=Integer.parseInt(ruta.getText());
                for(int i=0;i<asignacion.Fas;i++){
                if(ver == asignacion.idCur[i]){
                    va=true;
                }else{
                    //JOptionPane.showMessageDialog(null,"Curso "+ruta.getText()+" no se encontro en cursos asignados");                  
                    //break;
                }
                
                }
                try {
                    if(va==true){
                        ejecutar();
                    }
                    } catch (IOException ex) {
                        Logger.getLogger(graficar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                ventana();
                 ventanaPrincipalF.dispose();
            }
            private void dispose() {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }); 
       fondoL.add(botonB);       
       ventanaPrincipalF.repaint();
               
        
        
        //AQUÍ DEFINO MI BOTÓN PARA ADMINISTRACION DE VENTAS
        botonC = new JButton("Grafica por edad");
        botonC.setBounds(200,140,200,30);
        botonC.setVisible(true);
        botonC.setLayout(null);
        
        //DEFINIENDO ACCIONES PARA MÍ BOTÓN VENTAS
        botonC.addActionListener(new ActionListener() {
            //EL CÓDIGO DE MIS ACCIONES VA ACÁ
            @Override
            public void actionPerformed(ActionEvent ae) {
            vari=ruta.getText();
            boolean va=false;
            int ver=Integer.parseInt(ruta.getText());
            for(int i=0;i<asignacion.Fas;i++){
                if(ver == asignacion.idCur[i]){
                    va=true;
                }else{
                    //JOptionPane.showMessageDialog(null,"Curso "+ruta.getText()+" no se encontro en cursos asignados");                  
                    //break;
                }
                
                }
            try {
                    if(va==true){
                        edades();
                    }
                    } catch (IOException ex) {
                        Logger.getLogger(graficar.class.getName()).log(Level.SEVERE, null, ex);
                    }
            ventana1();
                 ventanaPrincipalF.dispose();
            }
            private void dispose() {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }); 
       fondoL.add(botonC);       
       ventanaPrincipalF.repaint();
       
       //AQUÍ DEFINO MI BOTÓN PARA REPORTES
        botonD = new JButton("Grafica por notas");
        botonD.setBounds(200,190,200,30);
        botonD.setVisible(true);
        botonD.setLayout(null);
        
        //DEFINIENDO ACCIONES PARA MÍ BOTÓN REPORTES
        botonD.addActionListener(new ActionListener() {
            //EL CÓDIGO DE MIS ACCIONES VA ACÁ
            @Override
            public void actionPerformed(ActionEvent ae) {
                
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
    public void ejecutar() throws IOException{
        int conta=0,m=0,f=0;
        //contar genero masculino
        for(int i=0;i<asignacion.Fas;i++){
            for(int j=0;j<alumnos.Fa;j++){
                if(asignacion.idAl[i]==alumnos.id[j]){
                    if(alumnos.genero[j].equals("M")){
                        m++;
                        ma=m;
                    }
                }
            }
        }
        //contar genero femenino
        for(int i=0;i<asignacion.Fas;i++){
            for(int j=0;j<alumnos.Fa;j++){
                if(asignacion.idAl[i]==alumnos.id[j]){
                    if(alumnos.genero[j].equals("F")){
                        f++;
                        fe=f;
                    }
                }
            }
        }
        for(int i=0;i<asignacion.Fas;i++){
            System.out.println("M "+ma+" F "+fe);
        }
        gen[0]=ma;
        gen[1]=fe;
        
        Generos generos[] = new Generos[2];
        graGen gG= new graGen();
                generos[0] = new Generos("F", fe);
                generos[1] = new Generos("M", ma);          
        gG.graGene(generos,"Grafica de generos","Genero","Cantidad");

    }
    
    public void edades() throws IOException{
        //contar edad de 5 en 5
        for(int i=0;i< alumnos.Fa;i++){
            for(int j=0;j<asignacion.Fas;j++){
                if(asignacion.idAl[j]==alumnos.id[i]){
                    if((14<alumnos.edad[i])){
                        if((alumnos.edad[i]<21)){
                            un++;
                        } 
                    }
                }
            }
        }
        //contar edad de 5 en 5
        for(int i=0;i< alumnos.Fa;i++){
            for(int j=0;j<asignacion.Fas;j++){
                if(asignacion.idAl[j]==alumnos.id[i]){
                    if((20<alumnos.edad[i]) && (alumnos.edad[i]<26)){
                        ds++;
                    }
                }
            }
        }
        //contar edad de 5 en 5
        for(int i=0;i< alumnos.Fa;i++){
            for(int j=0;j<asignacion.Fas;j++){
                if(asignacion.idAl[j]==alumnos.id[i]){
                    if((25<alumnos.edad[i]) && (alumnos.edad[i]<31)){
                        tr++;
                    }
                }
            }
        }
        //contar edad de 5 en 5
        for(int i=0;i< alumnos.Fa;i++){
            for(int j=0;j<asignacion.Fas;j++){
                if(asignacion.idAl[j]==alumnos.id[i]){
                    if((30<alumnos.edad[i]) && (alumnos.edad[i]<36)){
                        cu++;
                    }
                }
            }
        }
        //contar edad de 5 en 5
        for(int i=0;i< alumnos.Fa;i++){
            for(int j=0;j<asignacion.Fas;j++){
                if(asignacion.idAl[j]==alumnos.id[i]){
                    if((35<alumnos.edad[i] )&&(alumnos.edad[i]<41)){
                        ci++;
                    }
                }
            }
        }
        for(int i=0;i<asignacion.Fas;i++){
            System.out.println(+un+" "+ds+" "+tr+" "+cu+" "+ci+" ");
        }
        
        Edades edad[] = new Edades[5];
        graEdad gE= new graEdad();
                edad[0] = new Edades("15 a 20", un);
                edad[1] = new Edades("21 a 25", ds);
                edad[2] = new Edades("26 a 30", tr);
                edad[3] = new Edades("31 a 35", cu);
                edad[4] = new Edades("36 a 40", ci);
                
        gE.graEdad(edad,"Grafica de edades","Rando de edad","Cantidad");

    }
    
    public void ventana(){
       ventanaPrincipalF1 = new JFrame("Asignación");
        ventanaPrincipalF1.setSize(600,400);
        ventanaPrincipalF1.setLocationRelativeTo(null);
        ventanaPrincipalF1.setVisible(true);
        ventanaPrincipalF1.setLayout(null);
        ventanaPrincipalF1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        mens = new JLabel();
        mens.setForeground(Color.red);
        mens.setBounds(30,5,500,300);
        mens.setVisible(true);
        mens.setLayout(null);
        mens.setIcon(redimensionarImagen(500,300, "Grafica de generos.jpeg"));
        ventanaPrincipalF1.add(mens);

        //AQUÍ DEFINO MI BOTÓN PARA REPORTES
        botonA = new JButton("Generar reporte");
        botonA.setBounds(280,320,200,30);
        botonA.setVisible(true);
        botonA.setLayout(null);
        
        //DEFINIENDO ACCIONES PARA MÍ BOTÓN REPORTES
        botonA.addActionListener(new ActionListener() {
            //EL CÓDIGO DE MIS ACCIONES VA ACÁ
            @Override
            public void actionPerformed(ActionEvent ae) {
                reportegenero rg= new reportegenero();
                menu me= new menu();
                ventanaPrincipalF1.dispose();
            }
            private void dispose() {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
         ventanaPrincipalF1.add(botonA);      
      ventanaPrincipalF1.repaint();  
   }
    
    public void ventana1(){
       ventanaPrincipalF2 = new JFrame("Asignación");
        ventanaPrincipalF2.setSize(600,400);
        ventanaPrincipalF2.setLocationRelativeTo(null);
        ventanaPrincipalF2.setVisible(true);
        ventanaPrincipalF2.setLayout(null);
        ventanaPrincipalF2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        mensa = new JLabel();
        mensa.setForeground(Color.red);
        mensa.setBounds(30,5,500,300);
        mensa.setVisible(true);
        mensa.setLayout(null);
        mensa.setIcon(redimensionarImagen(500,300, "Grafica de edades.jpeg"));
        ventanaPrincipalF2.add(mensa);

        //AQUÍ DEFINO MI BOTÓN PARA REPORTES
        botonx = new JButton("Generar reporte");
        botonx.setBounds(280,320,200,30);
        botonx.setVisible(true);
        botonx.setLayout(null);
        
        //DEFINIENDO ACCIONES PARA MÍ BOTÓN REPORTES
        botonx.addActionListener(new ActionListener() {
            //EL CÓDIGO DE MIS ACCIONES VA ACÁ
            @Override
            public void actionPerformed(ActionEvent ae) {
                reporteEdad re= new reporteEdad();
                menu me= new menu();
                ventanaPrincipalF2.dispose();
            }
            private void dispose() {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
         ventanaPrincipalF2.add(botonx);      
      ventanaPrincipalF2.repaint();  
   }
    
     public ImageIcon redimensionarImagen(int x, int y, String url) {
        ImageIcon a = new ImageIcon(url);
        ImageIcon b = new ImageIcon(a.getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT));
        return b;
    }
}
