/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author wayne
 */
public class graEdad {
    JFrame ventanaPrincipalF;
    JLabel fondoL,login,mens;
   public void graEdad(Edades[] arr, String titulo, String ejeX, String ejeY ) throws IOException
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for ( int i = 0 ; i < 5 ; i++ )
        {
            dataset.addValue(arr[i].getCantidad(), arr[i].getNombre(), arr[i].getNombre());
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
