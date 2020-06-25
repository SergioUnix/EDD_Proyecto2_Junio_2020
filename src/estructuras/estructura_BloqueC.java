package estructuras;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Alejandro Lorenty
 */
public class estructura_BloqueC<T, V> {

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
//***************************************************************************************************************************************

    public class nodo_bloque<T, V> {

        private nodo_bloque<T, V> siguiente;
        private nodo_bloque<T, V> anterior;
        private V llaveAnterior;
        private V llave;
        private T transaccion;

        public nodo_bloque() {
            this.siguiente = null;
            this.anterior = null;
            this.llaveAnterior = null;
            this.llave = null;
            this.transaccion = null;
        }

        public nodo_bloque(nodo_bloque<T, V> siguiente, nodo_bloque<T, V> anterior, V llaveAnterior, V llave, T transaccion) {
            this.siguiente = siguiente;
            this.anterior = anterior;
            this.llaveAnterior = llaveAnterior;
            this.llave = llave;
            this.transaccion = transaccion;
        }

        public nodo_bloque<T, V> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(nodo_bloque<T, V> siguiente) {
            this.siguiente = siguiente;
        }

        public nodo_bloque<T, V> getAnterior() {
            return anterior;
        }

        public void setAnterior(nodo_bloque<T, V> anterior) {
            this.anterior = anterior;
        }

        public V getLlaveAnterior() {
            return llaveAnterior;
        }

        public void setLlaveAnterior(V llaveAnterior) {
            this.llaveAnterior = llaveAnterior;
        }

        public V getLlave() {
            return llave;
        }

        public void setLlave(V llave) {
            this.llave = llave;
        }

        public T getTransaccion() {
            return transaccion;
        }

        public void setTransaccion(T transaccion) {
            this.transaccion = transaccion;
        }
    }
//***************************************************************************************************************************************
    private nodo_bloque<T, V> inicio;
    private nodo_bloque<T, V> ultimo;
    private nodo_bloque<T, V> alter;
    private int numeroBloques;

    public estructura_BloqueC() {
        this.inicio = null;
        this.ultimo = null;
        this.numeroBloques = 0;
    }

    public boolean cadenaVacia() {
        return this.inicio == null;
    }

    public int tamanioCadena() {
        return this.numeroBloques;
    }

    public void nuevoBloque(T transaccion, V llave) {
        nodo_bloque<T, V> nuevoBloque = new nodo_bloque();
        nuevoBloque.setTransaccion(transaccion);
        nuevoBloque.setLlave(llave);
        if (cadenaVacia()) {
            nuevoBloque.setLlaveAnterior(null);
            inicio = nuevoBloque;
            ultimo = nuevoBloque;
        } else {
            nuevoBloque.setLlaveAnterior(ultimo.getLlave());
            ultimo.setSiguiente(nuevoBloque);
            nuevoBloque.setAnterior(ultimo);
            ultimo = nuevoBloque;
        }
        numeroBloques++;
    }

    public nodo_bloque<T, V> buscarBloque(V llave) {
        if (cadenaVacia()) {
            return null;
        } else {
            alter = inicio;
            for (int i = 0; i < numeroBloques; i++) {
                if (alter.getLlave() == llave) {
                    return alter;
                }
                alter = alter.getSiguiente();
            }
        }
        return null;
    }

}
