package estructuras;

import clases.Cliente;
import clases.Conductor;
import clases.Ruta;
import clases.Vehiculo;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Alejandro Lorenty
 */
public class estructura_BloqueC {

    public class Encriptar {
        //MÉTODO PARA LA ENCRIPTAR LA PALABRA O CONJUNTO DE LETRAS QUE SE DESE CODIFICAR
        public String generarEncriptamiento(String clave, String modo) throws NoSuchAlgorithmException {
            try {
                //CREAMOS NUESTRO DECODIFICADOR DE MENSAJES "EL MODO DEPENDE SI SE DESEA MD5 O SHA1"
                java.security.MessageDigest MD = java.security.MessageDigest.getInstance(modo);
                //GENERAMOS UN VECTOR DE CLAVES DE BYTES BASADO EN LA CLAVE O PALABRA INGRESADA PARA GENERAR EL ALGORITMO MD5 O SHA1
                byte[] arreglo = MD.digest(clave.getBytes());
                //NUESTRO BUFFER QUE RECIBIRA NUESTRA NUEVA LECTURA DE BYTES CONBINADA CON LA CONVERSIÓN HEXADECIMAL NECESARIA 
                StringBuffer codigo = new StringBuffer();
                //CON EL CICLO SE AGREGA UN NUEVO ELEMENTO A EL CODIGO O PALABRA ENCRIPTADA
                for (int i = 0; i < arreglo.length; i++) {
                    codigo.append(Integer.toHexString((arreglo[i] & 0xFF) | 0x100).substring(1, 3));
                }
                //RETORNAMOS EL CODIGO CONVERTIDO A UN STRING
                return codigo.toString();
            } catch (java.security.NoSuchAlgorithmException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
        //RETORNAR LA PALABRA ENCRIPTADA EN MD5
        public String MD5Code(String word) throws NoSuchAlgorithmException {
            return generarEncriptamiento(word, "MD5");
        }
        //RETORNAR LA PALABRA ENCRIPTADA EN SHA1
        public String SHA1Code(String word) throws NoSuchAlgorithmException {
            return generarEncriptamiento(word, "SHA1");
        }
    }
    private String llave;
    private String llaveEncriptada;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Conductor conductor;
    private Ruta ruta;
    private lista_enlazada_simple cadenaBloque;
}
