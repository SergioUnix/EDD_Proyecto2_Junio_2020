/**
 *
 * @author ADMIN
 */

package estructuras;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import clases.Vehiculo;


class arbolPagina {   
    public lista_enlazada_simple<Integer> datos_existentes;
    public arbolPagina(){datos_existentes = new lista_enlazada_simple<Integer>(); }        
    public boolean buscar_valor(int placa) throws Exception{
        boolean esta = false;
        int index=0;
        int tamano=datos_existentes.tamanioLista();        
        while(index<tamano && !esta){
        if (datos_existentes.retornarValor(index) == placa){esta = true;}        
        index++;
        }
        
        return esta;
    }
}


class cabeceras{    
    public int ocupados = 0;
    public cabeceras father;
    public int []valores;
    public cabeceras []nodo;
    public static int numValores;
    public static int count;
    public boolean existen_hijos = false;
    public cabeceras(){count++;
       nodo = new cabeceras [arbol_por_paginas.pag_primera_particion * 2 + 3];
       valores = new int [arbol_por_paginas.pag_primera_particion * 2 + 1];
  }
}
    
public class arbol_por_paginas {
    public static int pag_primera_particion;   
    public static boolean verifico_pag_primero;
    public static int altura_N = 1;
    ArrayList <Vehiculo> v=new ArrayList<>();
    public static int imprimir = 1;
    public static String cadena_dot_ghrapviz = ""; 
    public cabeceras cabeza_nodo;
    String cadena="digraph arbol_por_paginas{\nrankdir=TB;\nnode[fillcolor =green , fontcolor = navy , color = darkolivegreen3 ,style = filled, shape = record, width = .1, height = .1];   \n";
    public arbolPagina arbolPagina = new arbolPagina();
    
    public arbol_por_paginas(int pag_primera_particion)
    {   this.pag_primera_particion = pag_primera_particion; 
        cabeza_nodo = new cabeceras ();
        arbolPagina llevarIngresos = new arbolPagina();
        verifico_pag_primero = true;
    }
    public void agregar_datos(Vehiculo vehi) {
        String subCadena=null;
        int placa=0;
        if(vehi.getPlaca()!=null){
        subCadena=vehi.getPlaca();
        placa=Integer.parseInt(subCadena.substring(0,3));
        v.add(vehi);}
        if (cabeza_nodo.existen_hijos==true) {
         Ingreso_cambio_hijos(cabeza_nodo);
         Ingreso_en_hijos(cabeza_nodo, placa);
        } else {
         int index_insert=0;     
         int auxiliar = 0;
         int tamano_cabeceras=cabeza_nodo.valores.length;
         while(index_insert<tamano_cabeceras){
               if (cabeza_nodo.valores[index_insert] == 0) {
                    cabeza_nodo.valores[index_insert] = placa;
                    arbolPagina.datos_existentes.agregarNodo(placa);
                    auxiliar = index_insert;
                    OrganizarNodos(cabeza_nodo.valores,6);
                    break;
                }
            index_insert=index_insert+1;
            }
            if (auxiliar == 2*pag_primera_particion) {
                Ingresar_en(cabeza_nodo);
            }            
        }
    }
    
    public String obtenerPlaca(int subCadena){//solo para grafic
    String placa_entera="";     
        
      for(int i=0;i<=this.v.size()-1;i++){
          String sub=this.v.get(i).getPlaca().substring(0,3);
         
          String subCa=String.valueOf(subCadena);
          if(subCa.length()==2){
          if(sub.equals("0"+subCa)){                  
               placa_entera = this.v.get(i).getPlaca();
               }
          
          }else{ if(sub.equals(subCa)){                  
               placa_entera = this.v.get(i).getPlaca();
               } }
          
    
    }
      return placa_entera;
    }
    
    public void OrganizarNodos(int arreglo[], int tamanio_orga){
     
        int i=0;
        int ordenar1=0;
        tamanio_orga = 0;
        while(i<arreglo.length){
            if(arreglo[i] == 0){break; 
            }else{tamanio_orga++; }
           i=i+1;
        }

       while(ordenar1<tamanio_orga){
           
          for(int ordenar2 = 0; ordenar2 < tamanio_orga - 1 ; ordenar2++){
             if(arreglo[ordenar2] > arreglo[ordenar2 + 1]){
                int tmp = arreglo[ordenar2];
                arreglo[ordenar2] = arreglo[ordenar2+1];
                arreglo[ordenar2+1] = tmp;      
              }
             
           }       
       ordenar1=ordenar1+1;
       }
           
    }
       
       
       
       
    public void Ingreso_cambio_hijos (cabeceras nodo) {
        int index=0;
        if (nodo == cabeza_nodo) {
            if (cabeza_nodo.nodo[0]== null) {
            }else{ cabeza_nodo.existen_hijos = true;   } 
        }
        while(index <nodo.nodo.length){
        if (nodo.nodo[index] == null) {
            }else{ nodo.existen_hijos = true;
                Ingreso_cambio_hijos(nodo.nodo[index]); }
            index=index +1;
        }
    } 
    public void Ingreso_en_hijos(cabeceras viene_padre, int placa) {
        int indexar=0;
        boolean entro = false;
        if(!viene_padre.existen_hijos && viene_padre != null){
            Obtener_dato_arreglo(viene_padre, placa);
            entro = true;
        }else{      }
        while(viene_padre != null && indexar < 2*pag_primera_particion + 1  && !entro){
        if(placa < viene_padre.valores[indexar] || viene_padre.valores[indexar] == 0){
                entro = true; Ingreso_en_hijos(viene_padre.nodo[indexar], placa);
                indexar = 2*pag_primera_particion;
            }
            indexar=indexar+1;     }
    }    
    public void Obtener_dato_arreglo(cabeceras nodo_lado, int placa){
          for(int cont=0;cont <= 2*pag_primera_particion;cont++){
          if (nodo_lado.valores[cont]==0) {
           nodo_lado.valores[cont]=placa;   OrganizarNodos(nodo_lado.valores, 5);    arbolPagina.datos_existentes.agregarNodo(placa);
                if (cont == 2*pag_primera_particion) {Ingresar_en(nodo_lado);}
                break;
            } }
    }    
     public void Organizar_Nodos(cabeceras desordenado){
       int primer_indice,segundo_indice;
       primer_indice = 0;
       cabeceras tmp;
       for(int t=0;primer_indice < 2 * pag_primera_particion + 3 && desordenado.nodo[primer_indice] != null;primer_indice++){
            segundo_indice=0;
            for(int b=0;segundo_indice < 2 * pag_primera_particion +2  && desordenado.nodo[segundo_indice] != null && desordenado.nodo[segundo_indice+1] != null;segundo_indice++){
                if(desordenado.nodo[segundo_indice].valores[0] > desordenado.nodo[segundo_indice+1].valores[0] ){
                   tmp = desordenado.nodo[segundo_indice]; desordenado.nodo[segundo_indice] = desordenado.nodo[segundo_indice+1];
                   desordenado.nodo[segundo_indice+1] = tmp;
                }
            }}    
    }
    public void Ingresar_en (cabeceras nodo) {    
    cabeceras Nodo_L = new cabeceras();
    cabeceras Nodo_R = new cabeceras();
    if (nodo.nodo[0]!=null) {
        int index=0;
        while(index<pag_primera_particion+1){
        Nodo_L.nodo[index] = nodo.nodo[index];
        Nodo_L.nodo[index].father = Nodo_L;
        nodo.nodo[index] = null;
        Nodo_R.nodo[index] = nodo.nodo[pag_primera_particion+1+index];
        Nodo_R.nodo[index].father = Nodo_R;
        nodo.nodo[pag_primera_particion+1+index] = null;
        index=index+1;
            }
    }
    int index_aux =0;
    while(index_aux<pag_primera_particion){
        Nodo_L.valores[index_aux] = nodo.valores[index_aux];
        nodo.valores[index_aux] = 0;
        Nodo_R.valores[index_aux] = nodo.valores[pag_primera_particion+1+index_aux];
        nodo.valores[pag_primera_particion+1+index_aux] = 0;

        index_aux=index_aux+1;
    }
        nodo.valores[0] = nodo.valores[pag_primera_particion];
        nodo.valores[pag_primera_particion] = 0;         
        nodo.nodo[0] = Nodo_L;
        nodo.nodo[0].father = nodo; 
        nodo.nodo[1] = Nodo_R;
        nodo.nodo[1].father = nodo;       
        Ingreso_cambio_hijos(cabeza_nodo);
        Organizar_Nodos(nodo);      

    if (nodo.father!=null) { 
    boolean verifico_paso_Araiz = false;
    int indexar =0;
        while(indexar<nodo.father.valores.length && verifico_paso_Araiz==false){
        if (nodo.father.valores[indexar] == 0) {
            nodo.father.valores[indexar] = nodo.valores[0];
            verifico_paso_Araiz = true;
            nodo.valores[0] = 0;
            OrganizarNodos(nodo.father.valores, 5);
            }
        indexar=indexar+1;
    }
    int posicion_children = 0;
    int index_nodo =0;
    while(index_nodo<2*pag_primera_particion+3){
    if (nodo.father.nodo[index_nodo]!=null) {
     posicion_children++;
    } else {break;  }
    index_nodo=index_nodo+1;
    }
    nodo.father.nodo[posicion_children] = nodo.nodo[0];
    nodo.father.nodo[posicion_children+1] = nodo.nodo[1];
    nodo.father.nodo[posicion_children].father = nodo.father;
    nodo.father.nodo[posicion_children+1].father = nodo.father;
    int aqui = 0;
    int index_dark=0;
    while(index_dark<2*pag_primera_particion+3 && nodo.father.nodo[index_dark]!=null){
      if (nodo.father.nodo[index_dark].valores[0] == nodo.valores[0]) {
       aqui = index_dark;
       break;
       }
       index_dark=index_dark+1;
     }
    cabeceras nono_father = nodo.father;
    nodo = null;
    int iteracion_aux=aqui;
    for(int k=0;iteracion_aux<2*pag_primera_particion+2 && nono_father.nodo[iteracion_aux]!=null && nono_father.nodo[iteracion_aux+1]!=null;iteracion_aux++){
    nono_father.nodo[iteracion_aux] = nono_father.nodo[iteracion_aux+1];
    }
    nono_father.nodo[iteracion_aux] = null;
    OrganizarNodos(nono_father.valores,5);
    Organizar_Nodos(nono_father);
    if (nono_father.valores[2*pag_primera_particion]!=0) {
        Ingresar_en(nono_father);
        }
    }
    }   
    
    public String obtenerMarca(int subCadena){//solo para grafic
    String marca="";     
        
      for(int i=0;i<=this.v.size()-1;i++){
          String sub=this.v.get(i).getPlaca().substring(0,3);
          String subCa=String.valueOf(subCadena);
                    if(subCa.length()==2){
              if(sub.equals("0"+subCa)){                  
               marca = this.v.get(i).getMarca();
               }}else{  if(sub.equals(subCa)){                  
               marca = this.v.get(i).getMarca();
               }}
    
    }
      return marca;
    }
    
    public String obtenerModelo(int subCadena){//solo para grafic
    String modelo="";     
        
      for(int i=0;i<=this.v.size()-1;i++){
          String sub=this.v.get(i).getPlaca().substring(0,3);
          String subCa=String.valueOf(subCadena);
           if(subCa.length()==2){
              if(sub.equals("0"+subCa)){                  
               modelo = this.v.get(i).getModelo();
               }}else{  if(sub.equals(subCa)){                  
               modelo = this.v.get(i).getModelo();
               }}
    
    }
      return modelo;
    }
    public void eliminar_dato(int placa) throws Exception { 
    boolean existe_placa = false;
        int indes1= 0;
        int indes2=1;
        while(indes2<arbolPagina.datos_existentes.tamanioLista()+1&& !existe_placa){
        if (arbolPagina.datos_existentes.retornarValor(indes2) == placa) {
                existe_placa = true;
                indes1 = indes2;
            }
          indes2=indes2+1;  
        }
        if (existe_placa==true) { arbolPagina.datos_existentes.eliminarNodo(indes1); } else {
         System.out.println("No existe dato");
        }
        lista_enlazada_simple<Integer> arreglo_comodin = arbolPagina.datos_existentes;
        arbolPagina.datos_existentes = new lista_enlazada_simple<Integer>();
        cabeza_nodo = new cabeceras();
        cabeza_nodo.existen_hijos = false;
        int kindex=0;
        while (kindex< arreglo_comodin.tamanioLista()){
        Integer y = arreglo_comodin.retornarValor(kindex);
            int o = y.intValue();
            Vehiculo nada=new Vehiculo();
            agregar_datos(nada);
         // agregar_datos(o);
            kindex=kindex+1; 
        }
    }      
    public boolean buscar_valor(int placa) throws Exception{
        int desk=0;
        boolean existe_placa_aca = false;
        while(desk<arbolPagina.datos_existentes.tamanioLista()&& !existe_placa_aca){
        if(arbolPagina.datos_existentes.retornarValor(desk) == placa){
                existe_placa_aca = true;
                System.out.println("Si existe");
                return existe_placa_aca;
            }
            desk=desk+1;
        }
        System.out.println("No existe");
        return false;
    }
    
    
    public String generar_recursivo(cabeceras nodo) {
        cadena_dot_ghrapviz += "\n";
        int iterBusca=0;
        while(iterBusca<2*pag_primera_particion+1){   

        if (nodo.nodo[iterBusca] != null) {
            if (iterBusca != 0) { imprimir ++;
        } else {     altura_N++;  imprimir = 1;}
        generar_recursivo(nodo.nodo[iterBusca]);    }     
        if (nodo.nodo[iterBusca] != null) { cadena_dot_ghrapviz += "[ "; }
        int hijo=0;  int father=0;
        int j=0;
        while(nodo.nodo[iterBusca]!=null && j<nodo.nodo[iterBusca].valores.length){
            if (nodo.nodo[iterBusca].valores[j] != 0) {
            father=nodo.nodo[iterBusca].father.valores[0];
            hijo= nodo.nodo[iterBusca].valores[0];                      
            aux+="{"+obtenerPlaca(nodo.nodo[iterBusca].valores[j])+"|"+
                    obtenerMarca(nodo.nodo[iterBusca].valores[j])+"|"+ obtenerModelo(nodo.nodo[iterBusca].valores[j])+
                    "}"+"|";                                              
            cadena_dot_ghrapviz += nodo.nodo[iterBusca].valores[j] + "N"+nodo.nodo[iterBusca].father.valores[0]+", ";                                  
            }
        j=j+1;
        }
        if (nodo.nodo[iterBusca] != null) {         
        this.cadena_nodos +="nodo"+hijo+"[ label =\""+aux+"\"]  \n";
        this.cadena_direccion += "nodo"+father+"->"+"nodo"+hijo+"\n";
        aux="";
        cadena_dot_ghrapviz += " ]";
        } 
        iterBusca=iterBusca+1;
        }
        if (cadena_dot_ghrapviz.length() > (2*pag_primera_particion+3)*4) {return cadena_dot_ghrapviz;}
        return cadena_dot_ghrapviz;
    }

String aux="";
String cadena_nodos="";
String cadena_direccion="";
public String getTxt() {
this.cadena_dot_ghrapviz="";
this.aux="";
this.cadena_nodos="";
this.cadena_direccion="";
String cadena_dot = generar_recursivo(cabeza_nodo);
int hijo=0;  int father=0;
String aux="";
for(int i = 0; i < cabeza_nodo.valores.length && cabeza_nodo.valores[i] != 0; i++){
    hijo =cabeza_nodo.valores[0];
    aux += "{" +obtenerPlaca(cabeza_nodo.valores[i])+"|"+
         obtenerMarca(cabeza_nodo.valores[i])+"|"+ obtenerModelo(cabeza_nodo.valores[i])
            +"}"+ "|";
 }
cadena +="nodo"+hijo+"[ label =\""+aux+"\"]  \n";
cadena+=this.cadena_nodos;
cadena+=this.cadena_direccion;
cadena+="label=\"{Arbol B | placas}\";\n}";       
        return cadena;
    }    
    Random r = new Random();
    int valorDado =0; 

 public void crearTxT(String cadena) {
    File f;
    FileWriter wr;
    try {
        f = new File("Arbol_B.txt");
        wr = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(wr);
        PrintWriter salida = new PrintWriter(bw);
        salida.write(cadena + "\n");
        salida.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " NO ESCRIBE ");
        }
    }
    public void obtener_generar_grafico() {
        
           try {
       
        String archivoDot=getTxt();
        this.crearTxT(archivoDot);     
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder("dot", "-Tpng","-Gdpi=300", "-o", "Arbol_B.png", "Arbol_B.txt");
            pbuilder.redirectErrorStream(true);
            pbuilder.start();                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se creo la imagen ");
        }
        File miArchivo = new File("Arbol_B.png");
        try {
            Desktop.getDesktop().open(miArchivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No esta la Ruta");
        }
    } 
}



