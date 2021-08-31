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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static practica3.alumnos.edad;
import static practica3.alumnos.genero;
import static practica3.alumnos.id;
import static practica3.alumnos.nombre;

/**
 *
 * @author wayne
 */
public class cursos {
    public static int idCu[]= new int[70];
    public static String nombreCu[]= new String[70];
JFrame ventanaPrincipalF;
    JLabel fondoL,login,mens;
    JTextField ruta;
    JButton botonA,botonB;
    public static int fila,columna,Fc;
public cursos(){
     ventanaPrincipalF = new JFrame("Cursos");
        ventanaPrincipalF.setSize(410,200);
        ventanaPrincipalF.setLocationRelativeTo(null);
        ventanaPrincipalF.setVisible(true);
        ventanaPrincipalF.setLayout(null);
        ventanaPrincipalF.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        fondoL = new JLabel();
        fondoL.setSize(410,200);
        fondoL.setVisible(true);
        fondoL.setLayout(null);
        fondoL.setIcon(redimensionarImagen(410, 200, "colegio.jpg"));
        ventanaPrincipalF.add(fondoL);
        
        //AQUÍ CREAMOS UN JLABEL LOGIN
        login = new JLabel("Cargar cursos");
        login.setForeground(Color.red);
        login.setBounds(165, 25, 100, 15);
        login.setVisible(true);
        login.setLayout(null);
        fondoL.add(login);
        
        mens = new JLabel("Ingrese la ruta del archivo");
        mens.setForeground(Color.red);
        mens.setBounds(10, 70, 150, 15);
        mens.setVisible(true);
        mens.setLayout(null);
        fondoL.add(mens);
        
        //AQUÍ CREAMOS UN TEXTFIELD
        ruta = new JTextField();
        ruta.setBounds(160,70, 230,20);
        ruta.setVisible(true);
        ruta.setLayout(null);
        fondoL.add(ruta);
        
        botonA= new JButton ("Cargar");
        botonA.setBounds(60,120,100,30);
        botonA.setVisible(true);
        botonA.setLayout (null);
        fondoL.add(botonA);
                //DEFINIENDO ACCIONES PARA MÍ BOTÓN INGRESAR
        botonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //EL CÓDIGO DE MIS ACCIONES VA ACÁ
               String en=ruta.getText();
                    cargaCurso(en);
            }
        });    
        fondoL.add(botonA);
        ventanaPrincipalF.repaint();
        
        botonB= new JButton ("Volver");
        botonB.setBounds(220,120,100,30);
        botonB.setVisible(true);
       botonB.setLayout (null);
        fondoL.add(botonB);
        
        //DEFINIENDO ACCIONES PARA MÍ BOTÓN INGRESAR
        botonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               cargaArchivos ca= new cargaArchivos(); //EL CÓDIGO DE MIS ACCIONES VA ACÁ
               ventanaPrincipalF.dispose();
            }
        });    
        fondoL.add(botonB);
        ventanaPrincipalF.repaint();
}

public void cargaCurso(String ruta){
    try{
            //Obtener dimensiones del archivo
            BufferedReader archivoFiltro = new BufferedReader(new FileReader(ruta));
            String linea = "";
            while(linea != null){
                linea = archivoFiltro.readLine();
                if(linea != null){
                    fila++;
                    String [] vector = linea.split(",");
                    columna = vector.length;
                }
            }
            System.out.println("");
            archivoFiltro.close();
            
            //asignar valores del txt a la matriz
            if(fila<71 && columna<3){        
                    }else{
               JOptionPane.showMessageDialog(null,"Error campo extra en el archivo scv");
                cargaArchivos in= new cargaArchivos();
                ventanaPrincipalF.dispose();
            }
            String aux[][];
            aux = new String [fila][columna];
            BufferedReader archivoFiltro1 = new BufferedReader(new FileReader(ruta));
            String linea1 = "";
            int fil = 0;
            while(linea1 != null){
                linea1 = archivoFiltro1.readLine();
                if(linea1 != null){
                    String [] vector = linea1.split(",");
                    for(int i=0; i<vector.length; i++){
                        aux[fil][i] = vector[i];                     
                    }
                    fil++;
                }
            }
            archivoFiltro.close();
            //verificar que no existe id repetido
            int contador=0,lugar=0;
            boolean var=true;
            for(int k=0;k<fila;k++){
                        for(int m=0;m<fila;m++){
                            if(aux[k][0].equals(aux[m][0])){
                              contador++;
                              if(contador>1){
                                  contador=0;
                                  var=false;                                 
                                  JOptionPane.showMessageDialog(null,"Id "+aux[k][0]+" de curso existe dos veces con nombre "+aux[k][1]+" no se carga el curso");     
                              }
                            }                            
                            }
                        if (var==true && lugar<71){
                            idCu[lugar]=Integer.parseInt(aux[k][0]);
                            nombreCu[lugar]=aux[k][1];
                            lugar++;
                            Fc=lugar;
                            }
                        var=true;
                        contador=0;
                            }
            lugar=0;
            System.out.println("ID | NOMBRE ");
            for(int i=0; i<fila; i++){
                    System.out.print (idCu[i] + " | "+nombreCu[i]);
                System.out.println("");
            }
            System.out.println("");
            JOptionPane.showMessageDialog(null,"Se cargo los datos de los cursos");
            System.out.println("Se cargo los datos de los cursos");
            System.out.println("");
            fila = 0;
            columna = 0;
            cargaArchivos in= new cargaArchivos();
                ventanaPrincipalF.dispose();
        }catch(IOException error){
             JOptionPane.showMessageDialog(null,"No se pudo abrir el archivo");
            System.out.println("No se pudo abrir el archivo");
           cargaArchivos in= new cargaArchivos();
                ventanaPrincipalF.dispose();
        }
}

public ImageIcon redimensionarImagen(int x, int y, String url) {
        ImageIcon a = new ImageIcon(url);
        ImageIcon b = new ImageIcon(a.getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT));
        return b;
    }
}
