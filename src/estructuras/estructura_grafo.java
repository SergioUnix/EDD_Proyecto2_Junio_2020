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

        int estado;
        String Id;
        String Tipo;    
        ArrayList<transicion> transiciones = new ArrayList<transicion>();

        public estructura_grafo()
        {
            this.Id = "";
            this.Tipo = "";
            this.estado = 0;
            this.next1 = null;
            this.next2 = null;
        }
        public String getId()
        {
            return this.Id;
        }
                public void setId(String i)
        {
            this.Id = i;
        }
          public void setTipo(String b)
        {
            this.Tipo = b;
        }
        public String getTipo()
        {
            return this.Tipo;
        }
                public int getEstado()
        {
           return  this.estado;
        }
                public void setEstado(int s)
        {
            this.estado = s;
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
        
        
        
        
        
        
        
        
        
}
