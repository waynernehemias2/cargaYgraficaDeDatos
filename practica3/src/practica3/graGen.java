/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author wayne
 */
public class graGen {
    JFrame ventanaPrincipalF;
    JLabel fondoL,login,mens;
   public void graGene(Generos[] arr, String titulo, String ejeX, String ejeY ) throws IOException
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for ( int i = 0 ; i < 2 ; i++ )
        {
            dataset.addValue(arr[i].getCantidad(), arr[i].getGenero(), arr[i].getGenero());
        }
        
        JFreeChart barChart = ChartFactory.createBarChart(
                titulo, //TÍTULO PARA LA GRÁFICA
                ejeX,   //TÍTULO PARA EL EJE X
                ejeY,    //TÍTULO PARA EL EJE Y
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        
        int anchoImagen = 600;
        int altoImagen = 400;
        
        String grafica = titulo +".jpeg";
        File BarChart = new File(grafica);
        ChartUtilities.saveChartAsJPEG(BarChart, barChart, anchoImagen, altoImagen);
    }
   
}
