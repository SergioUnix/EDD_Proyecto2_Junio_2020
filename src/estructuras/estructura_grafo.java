/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import clases.transicion;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class estructura_grafo {
        estructura_grafo next1;
        estructura_grafo next2;

        int peso;
        String origen;
        String destino;    
        ArrayList<transicion> transiciones = new ArrayList<transicion>();

        public estructura_grafo()
        {
            this.origen = "";
            this.destino = "";
            this.peso = 0;
            this.next1 = null;
            this.next2 = null;
        }
        
        public String getOrigen()
        {
            return this.origen;
        }
                public void setOrigen(String i)
        {
            this.origen = i;
        }
          public void setDestino(String b)
        {
            this.destino = b;
        }
        public String getDestino()
        {
            return this.destino;
        }
                public int getPeso()
        {
           return  this.peso;
        }
                public void setPeso(int s)
        {
            this.peso = s;
        }
                public void setNext1(estructura_grafo next1)
        {
            this.next1 = next1;
        }
        public estructura_grafo getNext1()
       {
            return this.next1;
       }

        public void setNext2(estructura_grafo next2)
        {
            this.next2 = next2;
        }
        public estructura_grafo getNext2()
        {
          return this.next2;
        }
        public void addTransicion(transicion b)
        {
            this.transiciones.add(b);
        }
        
        
        public void agregoRuta(String origenC, String destinoC,String pesoC){
            estructura_grafo nuevo=new estructura_grafo();
            nuevo.setOrigen(origenC);
            nuevo.setDestino(pesoC);
            nuevo.addTransicion(new transicion(destinoC,pesoC));
            
            estructura_grafo aux=this.next1;
            
            boolean verifco=false;
            if(origen.equals(origenC)){              
               transiciones.add(new transicion(destinoC,pesoC));
            // System.out.println(">>>> primer if"+origenC);
            }else if(origen.equals("")){
            this.origen=origenC;
            this.addTransicion(new transicion (destinoC,pesoC));
           //System.out.println("++++++   segundo if"+origenC);
            }else{
              //System.out.println("---  entro al else  "+origenC);
                while(aux!=null){
                // System.out.println("---  entro al while"+origenC);
                 
                 if(aux.origen.equals(origenC)){
                     aux.addTransicion(new transicion(destinoC,pesoC));                     
                 break;  
                 }
                 if(aux.getNext1()==null){aux.setNext1(nuevo); break; }
                aux=aux.getNext1();
                }
                if(aux==null){this.setNext1(nuevo);}
              
            }
           
            
        }
        
         public void imprimir(){
            estructura_grafo aux=this.next1;
            System.out.println("-----------"+origen);
            for(int i=0;i<transiciones.size();i++){
            System.out.println("           "+transiciones.get(i).getNombre()+"    "+transiciones.get(i).getDireccion()); 
            }
            while(aux!=null){                
            System.out.println(" ----------"+aux.getOrigen());
            for(int i=0;i<aux.transiciones.size();i++){
            System.out.println("           "+aux.transiciones.get(i).getNombre()+"    "+aux.transiciones.get(i).getDireccion()); 
            }           
            aux=aux.getNext1();
            }
         }
         public String cadenaGrafico(){
             String res="";
            estructura_grafo aux=this.next1;
            System.out.println("-----------"+origen);
            for(int i=0;i<transiciones.size();i++){
            System.out.println("           "+transiciones.get(i).getNombre()+"    "+transiciones.get(i).getDireccion()); 
            }
            while(aux!=null){                
            System.out.println(" ----------"+aux.getOrigen());
            for(int i=0;i<aux.transiciones.size();i++){
            System.out.println("           "+aux.transiciones.get(i).getNombre()+"    "+aux.transiciones.get(i).getDireccion()); 
            }           
            aux=aux.getNext1();
            }
            return res+"}";
         }

}