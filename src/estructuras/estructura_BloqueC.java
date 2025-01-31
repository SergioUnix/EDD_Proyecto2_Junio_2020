package estructuras;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Alejandro Lorenty
 */
public class estructura_BloqueC<T, V> {

    public static class Encriptar {

        //MÉTODO PARA LA ENCRIPTAR LA PALABRA O CONJUNTO DE LETRAS QUE SE DESE CODIFICAR
        public static String generarEncriptamiento(String clave, String modo) throws NoSuchAlgorithmException {
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
        public static String MD5Code(String word) throws NoSuchAlgorithmException {
            return generarEncriptamiento(word, "MD5");
        }

        //RETORNAR LA PALABRA ENCRIPTADA EN SHA1
        public static String SHA1Code(String word) throws NoSuchAlgorithmException {
            return generarEncriptamiento(word, "SHA1");
        }
    }
//***************************************************************************************************************************************

    public class nodo_bloque<T, V> {

        private nodo_bloque<T, V> siguiente;
        private nodo_bloque<T, V> anterior;
        private String selloTiempo;
        private int nonce;
        private V llaveAnterior;
        private V llave;
        private T transaccion;

        public nodo_bloque() {
            this.siguiente = null;
            this.anterior = null;
            this.selloTiempo = null;
            this.nonce = 0;
            this.llaveAnterior = null;
            this.llave = null;
            this.transaccion = null;
        }

        public nodo_bloque(nodo_bloque<T, V> siguiente, nodo_bloque<T, V> anterior, String selloTiempo, int nonce, V llaveAnterior, V llave, T transaccion) {
            this.siguiente = siguiente;
            this.anterior = anterior;
            this.selloTiempo = selloTiempo;
            this.nonce = nonce;
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

        public String getSelloTiempo() {
            return selloTiempo;
        }

        public int getNonce() {
            return nonce;
        }

        public void setNonce(int nonce) {
            this.nonce = nonce;
        }

        public void setSelloTiempo(String selloTiempo) {
            this.selloTiempo = selloTiempo;
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

    public void nuevoBloque(T transaccion, V llave, String selloTiempo) {
        nodo_bloque<T, V> nuevoBloque = new nodo_bloque();
        nuevoBloque.setTransaccion(transaccion);
        nuevoBloque.setLlave(llave);
        nuevoBloque.setSelloTiempo(selloTiempo);
        nuevoBloque.setNonce(numeroBloques + 1);
        if (cadenaVacia()) {
            nuevoBloque.setLlaveAnterior(null);
            inicio = nuevoBloque;
            ultimo = inicio;
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
                if (alter.getLlave().equals(llave)) {
                    return alter;
                }
                alter = alter.getSiguiente();
            }
        }
        return null;
    }

    public T buscarTransaccion(V llave) {
        if (cadenaVacia()) {
            return null;
        } else {
            alter = inicio;
            for (int i = 0; i < numeroBloques; i++) {
                if (alter.getLlave().equals(llave)) {
                    return alter.getTransaccion();
                }
                alter = alter.getSiguiente();
            }
        }
        return null;
    }

    public nodo_bloque<T, V> retornarBloque(int indice) {
        alter = inicio;
        if (cadenaVacia()) {
            return null;

        }
        if (indice == 0) {
            return alter;
        } else {

            for (int i = 0; i < indice; i++) {
                alter = alter.getSiguiente();

            }
            return alter;
        }
    }
}
