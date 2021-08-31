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
import static practica3.cursos.columna;
import static practica3.cursos.fila;
import static practica3.cursos.idCu;
import static practica3.cursos.nombreCu;

/**
 *
 * @author wayne
 */
public class asignacion {
    //public static String noencon[]= new String[];
    public static int idAl[];
    public static int idCur[];
    public static int nota[];
    JFrame ventanaPrincipalF;
    JLabel fondoL,login,mens;
    JTextField ruta;
    JButton botonA,botonB;
    public static int fila,columna,Fas;
    public asignacion(){
        ventanaPrincipalF = new JFrame("Asignación");
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
        login = new JLabel("Asignación");
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
                    asigna(en);
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
    
    public void asigna(String ruta){
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
            String aux[][];
            String aux1[][];
            String aux2[][];
             aux = new String [fila][columna];
             aux1 = new String [fila][columna];
             aux2 = new String [fila][columna];
            idAl= new int [fila];
            idCur= new int [fila];
            nota= new int[fila];
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
            
            //verificar la existencia de alumno y curso
            int esp=0,x=0;
            for(int k=0;k< fila ;k++){
                        for(int m=0;m< alumnos.Fa;m++){
                            if(Integer.parseInt(aux[k][0])== alumnos.id[m] ){
                                    for(int j=0;j<cursos.Fc;j++){
                                        if(Integer.parseInt(aux[k][1]) == cursos.idCu[j]){
                                            aux1[esp][0]= aux[k][0];
                                            aux1[esp][1]= aux[k][1];
                                            aux1[esp][2]= aux[k][2];
                                            esp++;
                                        }
                                    }
                              
                            }                               
                        }
            }          
            //verificar numero asignado en una clase
            for(int j=0;j<esp;j++){
                for(int b=0;b<esp;b++){
                    if(aux1[j][1].equals(aux1[b][1])){
                              contador++;
                        if(contador>30){
                                contador=0;
                                var=false;                                 
                                //JOptionPane.showMessageDialog(null,"Curso "+aux[j][1]+" no se asigna el curso");     
                        }
                    }
                }
                if(var=true){
                aux2[j][0]=aux1[j][0];
                aux2[j][1]=aux1[j][1];
                aux2[j][2]=aux1[j][2];
                var=true;
                }
            }
            //verificar que no este asignado dos veces al mismo curso
            int au=0,ae=0;
            for(int y=0;y<esp;y++){
                for(int d=0;d<esp;d++){
                    if((aux2[y][0]==aux2[d][0])&&(aux2[y][1]==aux2[d][1])){
                        au++;
                    }
                }
                if(au>1){
                    JOptionPane.showMessageDialog(null,"alumno "+aux2[y][0]+" asignado al curso "+aux2[y][1]+" "+au+" veces");
                }else{
                    idAl[ae]=Integer.parseInt(aux2[y][0]);
                    idCur[ae]=Integer.parseInt(aux2[y][1]);
                    nota[ae]=Integer.parseInt(aux2[y][2]);
                    ae++;
                    Fas=ae;
                   au=0; 
                }
                
            }
            ae=0;
                       /* if (var==true && lugar<71){
                            idCu[lugar]=Integer.parseInt(aux[k][0]);
                            nombreCu[lugar]=aux[k][1];
                            lugar++;
                            }
                        var=true;
                        contador=0;*/
            lugar=0;
            esp=0;
            System.out.println("ID | ID C | NOTA ");
            for(int i=0; i<fila; i++){
                    System.out.print (idAl[i] + " | "+idCur[i]+" | "+nota[i]);
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
