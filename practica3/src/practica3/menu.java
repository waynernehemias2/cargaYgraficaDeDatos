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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author wayne
 */
public class menu {
    JFrame ventanaPrincipalF;
    JLabel fondoL, login, InNom, contra;
    JButton carga,grafica;
    
    public menu(){
       ventanaPrincipalF = new JFrame("Bienvenido");
        ventanaPrincipalF.setSize(400,200);
        ventanaPrincipalF.setLocationRelativeTo(null);
        ventanaPrincipalF.setVisible(true);
        ventanaPrincipalF.setLayout(null);
        ventanaPrincipalF.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        fondoL = new JLabel();
        fondoL.setSize(400,200);
        fondoL.setVisible(true);
        fondoL.setLayout(null);
        fondoL.setIcon(redimensionarImagen(400, 200, "colegio.jpg"));
        ventanaPrincipalF.add(fondoL);
        
        //AQUÍ CREAMOS UN JLABEL LOGIN
        login = new JLabel("Bienvenido");
        login.setForeground(Color.red);
        login.setBounds(165, 25, 100, 15);
        login.setVisible(true);
        login.setLayout(null);
        fondoL.add(login);
        
        //AQUÍ CREAMOS UN JLABEL LOGIN
        InNom = new JLabel("Carge todos los datos primero para poder graficar");
        InNom.setForeground(Color.red);
        InNom.setBounds(35, 40,500, 15);
        InNom.setVisible(true);
        InNom.setLayout(null);
        fondoL.add(InNom);
        
        carga= new JButton ("Cargar");
        carga.setBounds(60,70,110,40);
        carga.setVisible(true);
        carga.setLayout (null);
        fondoL.add(carga);
        
        //DEFINIENDO ACCIONES PARA MÍ BOTÓN INGRESAR
        carga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               cargaArchivos ca= new cargaArchivos();              
               ventanaPrincipalF.dispose();
            }
        });    
        fondoL.add(carga);
        ventanaPrincipalF.repaint();
        
        grafica= new JButton ("Graficar");
        grafica.setBounds(220,70,110,40);        
        grafica.setVisible(true);
        grafica.setLayout (null);
        fondoL.add(grafica);
        
        grafica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               graficar gra= new graficar(); //EL CÓDIGO DE MIS ACCIONES VA ACÁ
               ventanaPrincipalF.dispose();
            }
        });    
        fondoL.add(grafica);
        ventanaPrincipalF.repaint();
    }
    
    public ImageIcon redimensionarImagen(int x, int y, String url) {
        ImageIcon a = new ImageIcon(url);
        ImageIcon b = new ImageIcon(a.getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT));
        return b;
    }
}
