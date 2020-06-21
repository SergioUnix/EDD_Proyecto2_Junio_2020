/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llegarapidito;

//import estructuras.lista_enlazada_simple;
//import clases.Carga;

import estructuras.arbol_por_paginas;
import ventanas.carga_Masiva;

/**
 *
 * @author ADMIN
 */
public class LlegaRapidito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
    arbol_por_paginas pag =new arbol_por_paginas(2);
    
        pag.agregar_datos(14);
    pag.agregar_datos(79);
    pag.agregar_datos(85);
        pag.agregar_datos(2);
    pag.agregar_datos(1);
    pag.agregar_datos(4);
    pag.agregar_datos(3);
    pag.agregar_datos(5);
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //****************************************************************************************************    
        /*
         PRUEBA LISTA ENLAZADA SIMPLE
         
        lista_enlazada_simple<Integer> miLista = new lista_enlazada_simple();
        miLista.agregarNodo(1);
        miLista.agregarNodo(2);
        
        for (int i = 0; i < miLista.tamanioLista(); i++) {
            System.out.println(miLista.retornarValor(i+1));
        }
        
         */
         /*
        METODO PARA GRAPHVIZ
        Carga.dibujar(png, dot);
         */
        //Carga.lista_doble_ciruclar_GRAPHVIZ();
        carga_Masiva ventana = new carga_Masiva();
        ventana.setVisible(true);

    }

}
