/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author wayne
 */
public class reporteEdad {
   public reporteEdad(){
        reporte();
    }
    
    public static void reporte(){
        try {
            PrintWriter reporteA = new PrintWriter("reporteEdades.html", "UTF-8");
            reporteA.println("<!DOCTYPE html>");
            reporteA.println("<head>");
            reporteA.println("<title>Estadistica de edades en el curso </title> ");
            reporteA.println("<link href=\"estilo.css\" rel=\"stylesheet\" type=\"text/css\">");
            reporteA.println("</head>");
            reporteA.println("<body>");
            reporteA.println("<h1> Estadistica de edades en el curso "+graficar.vari+" </h1>");
            reporteA.println("<center>");
            reporteA.println("</center>");
            reporteA.println("<center>");
             reporteA.println("");
            reporteA.println("<table border=\"1\" ");
            reporteA.println("<tr>");
            reporteA.println("<td> Estudiante</td>");
            reporteA.println("<td> Carné </td>");
            reporteA.println("</tr>");
            reporteA.println("<tr>");
            reporteA.println("<td> Wayner Nehemías López Raymundo </td>");
            reporteA.println("<td> 201801456 </td>");
            reporteA.println("</tr>");
            reporteA.println("</table>");
         reporteA.println("<p>Grafica de curso "+graficar.vari+"</p>\n" +
                                "<center><img src=\"Grafica de edades.jpeg\"></center>");

             reporteA.println("");
             JOptionPane.showMessageDialog(null,"Se creo el reporte de la operación en reportes/reporteApps.htm");
                 System.out.println();
                 System.out.println("");
             reporteA.println("");
            reporteA.println("</center>");
            reporteA.println("</body>");
            reporteA.println("</html>");
            reporteA.close();
            //archivo CSS
            PrintWriter escribir = new PrintWriter("estilo.css", "UTF-8");
                    escribir.print("html {   font-size: 20px; font-family: 'Open Sans', sans-serif; }");
                    escribir.print("h1 { font-size: 60px; text-align: center; }");
                    escribir.print("p, li {   font-size: 16px;   line-height: 2;   letter-spacing: 1px; }");
                    escribir.print("html { background-color: #00539F; }");
                    escribir.print("body { width: 800px; margin: 0 auto; background-color: #FF9500; padding: 0 20px 20px 20px; border: 5px solid black; }");
                    escribir.print("h1 { margin: 0; padding: 20px 0; color: #00539F; text-shadow: 3px 3px 1px black; }");
                    escribir.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"No se pudo crear el archivo");
            System.out.println("");
        }
    } 
}
