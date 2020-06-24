/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author ADMIN
 */
public class transicion {
    String nombre;
    String direccion;
    public transicion(){
    this.nombre="";
    }
     public transicion(String no,String dir)
        {
            this.nombre = no;
            this.direccion = dir;
        }

        public void setNombre(String a)
        {
            this.nombre = a;
        }
        public void setDireccion(String b)
        {
            this.nombre = b;
        }
        public String getNombre()
        {
            return nombre;
        }
        public String getDireccion()
        {
            return direccion;
        }

}
