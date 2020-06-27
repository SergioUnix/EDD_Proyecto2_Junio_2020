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
    public String destino;
    public String direccion;
    public transicion(){
    this.destino="";
    this.destino="";
    }
     public transicion(String no,String dir)
        {
            this.destino = no;
            this.direccion = dir;
        }

        public void setNombre(String a)
        {
            this.destino = a;
        }
        public void setDireccion(String b)
        {
            this.destino = b;
        }
        public String getNombre()
        {
            return destino;
        }
        public String getDireccion()
        {
            return direccion;
        }

}
