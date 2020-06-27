/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llegarapidito;

//import estructuras.lista_enlazada_simple;
//import clases.Carga;
//import estructuras.arbol_por_paginas;
import clases.Graficas;
import clases.Vehiculo;
import estructuras.arbol_por_paginas;
import estructuras.estructura_BloqueC.Encriptar;
import estructuras.estructura_Hash;
import estructuras.lista_enlazada_simple;
import ventanas.carga_Masiva;
import ventanas.menu_Cliente;
import ventanas.menu_Conductor;
import ventanas.menu_Master;
//import clases.Vehiculo;

/**
 *
 * @author ADMIN
 */
public class LlegaRapidito {

    /**
     * @param args the command line arguments
     */
    Encriptar c;
  
    public static void main(String[] args) throws Exception {
       menu_Master master = new menu_Master();
       master.setVisible(true);
   //String resultado=Encriptar.MD5Code("6e21d5c6caf8016e88aba2aca59929a7");
  // System.out.print("resultado     "+resultado);
   
//String str = "123abc123";  
//
//StringBuilder sb = new StringBuilder();
//for (char c : str.toCharArray())
//sb.append((int)c);
//
//long mInt = new Long(sb.toString());
//System.out.println(mInt);  
//        
//        
//        
//    








//        
//        
//        
//        
//        
//        
//        
//    
//
//prueba.agregar_datos("arte");
//prueba.agregar_datos("bart");
//prueba.agregar_datos("tulio");
//prueba.agregar_datos("xulio");
//prueba.agregar_datos("zorro");
//prueba.agregar_datos("xeulio");
//prueba.agregar_datos("tablas");
//prueba.agregar_datos("sumaquina");
//prueba.agregar_datos("queja");
//prueba.agregar_datos("zum");
//prueba.agregar_datos("casa");
//prueba.agregar_datos("emilio");
//
//prueba.agregar_datos("foca");
//prueba.agregar_datos("funk");
//prueba.agregar_datos("gato");
//prueba.agregar_datos("humo");
//
//prueba.obtener_generar_grafico();
//
//           prueba.agregar_datos(12);
//           prueba.agregar_datos(13);
//           prueba.agregar_datos(14);
//          
//           prueba.agregar_datos(18);
//           prueba.agregar_datos(20);
//           prueba.agregar_datos(22);
//           prueba.agregar_datos(28);
//           prueba.agregar_datos(30);
//           prueba.agregar_datos(33);
//  
//    
//    prueba.obtener_generar_grafico();
//        
        //****************************************************************************************************    
//        estructura_Hash<Integer> h = new estructura_Hash(37,75.0);
//        h.agregar_nodo(100, 100);
//        h.agregar_nodo(50, 50);
//        h.agregar_nodo(200, 200);
//        h.agregar_nodo(10, 10);
//        h.agregar_nodo(30, 30);
//        h.agregar_nodo(50, 50);
//        h.agregar_nodo(60, 60);
//        h.agregar_nodo(320, 320);
//        h.agregar_nodo(130, 130);
//        h.agregar_nodo(350, 350);
//        
//        h.agregar_nodo(301, 301);
//        h.agregar_nodo(302, 302);
//        h.agregar_nodo(303, 303);
//        h.agregar_nodo(304, 304);
//        h.agregar_nodo(305, 305);
//        h.agregar_nodo(306, 306);
//        h.agregar_nodo(307, 307);
//        h.agregar_nodo(308, 308);
//        h.agregar_nodo(309, 309);
//        h.agregar_nodo(310, 310);
//        
//        h.agregar_nodo(311, 311);
//        h.agregar_nodo(312, 312);
//        h.agregar_nodo(313, 313);
//        h.agregar_nodo(402, 402);
//        h.agregar_nodo(403, 403);
//        h.agregar_nodo(404, 404);
//        h.agregar_nodo(405, 405);
//        h.agregar_nodo(406, 406);
//        h.agregar_nodo(407, 407);
//        h.agregar_nodo(408, 408);
//        
//        h.agregar_nodo(409, 409);
//        h.agregar_nodo(410, 410);
//        h.agregar_nodo(411, 411);
//        h.agregar_nodo(412, 412);
//        h.agregar_nodo(413, 413);
//        h.agregar_nodo(493, 493);
//        h.agregar_nodo(494, 494);
//        h.agregar_nodo(713, 713);
//        h.agregar_nodo(1813, 1813);
//        h.agregar_nodo(2813, 2813);
//        
//        h.agregar_nodo(3813, 3813);
//        h.agregar_nodo(4813, 4813);
//        h.agregar_nodo(1, 1);
//        h.agregar_nodo(5, 5);
//        h.agregar_nodo(2, 2);
//        h.agregar_nodo(12, 12);
//        h.agregar_nodo(3, 3);
//        h.agregar_nodo(55, 55);
//        h.agregar_nodo(6, 6);
//
//        lista_enlazada_simple<Integer> auxiliar = h.restablecer_tamanio();
//        if (!auxiliar.estaVacia()) {
//            System.out.println("NUEVA LISTA CREADA");
//            estructura_Hash<Integer> h2 = new estructura_Hash(37 * 2,75.0);
//            for (int i = 1; i < auxiliar.tamanioLista() + 1; i++) {
//                h2.agregar_nodo(auxiliar.retornarValor(i), Long.parseLong(String.valueOf(auxiliar.retornarValor(i))));
//            }
//            h = h2;
//        } else {
//            System.out.println("NO HAY LISTA CREADA");
//        }
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
        //carga_Masiva ventana = new carga_Masiva();
        //ventana.setVisible(true);
        //menu_Cliente cl = new menu_Cliente();
        //cl.setVisible(true);
        //menu_Conductor co1 = new menu_Conductor();
        //co1.setVisible(true);
  //      menu_Master master = new menu_Master();
   //     master.setVisible(true);
   
   
    }

}
