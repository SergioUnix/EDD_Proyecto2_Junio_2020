/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Graficas {
    
    public static void graficar(String cadena, String nombre_grafica) throws FileNotFoundException, Exception {
    File f;
    FileWriter wr;
    try {
        ///////Creo el TXT
        f = new File(nombre_grafica+".txt");
        wr = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(wr);
        PrintWriter salida = new PrintWriter(bw);
        salida.write(cadena + "\n");
        salida.close();
        ///Ingreso comando en Cmd
          ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", nombre_grafica+".png", nombre_grafica+".txt");
            pbuilder.redirectErrorStream(true);
            pbuilder.start();     
        //Abro mi Imagen generada
        File miArchivo = new File(nombre_grafica+".png");
        Desktop.getDesktop().open(miArchivo);     
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, "No esta la Ruta");
        }      
    }
    
    
}
