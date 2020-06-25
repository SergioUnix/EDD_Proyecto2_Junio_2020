/**
 *
 * @author Alejandro Lorenty
 */
package estructuras;

public class lista_enlazada_simple<T, V> {

    //************************************************************************************
    /*
     *
     * CLASE PARA EL NODO SIMPLE PARA IMPLEMENTARLO 
     * EN NUESTRA CLASE LISTA SIMPLE, CLASE PARAMÉTRICA PARA CUALQUIER DATO
     */
    public class nodo_simple<T, V> {

        private nodo_simple<T, V> siguiente;
        private T dato;
        private V etiqueta;

        public nodo_simple() {
            this.siguiente = null;
            this.dato = null;
            this.etiqueta = null;
        }

        public nodo_simple<T, V> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(nodo_simple<T, V> siguiente) {
            this.siguiente = siguiente;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }

        public V getEtiqueta() {
            return etiqueta;
        }

        public void setEtiqueta(V etiqueta) {
            this.etiqueta = etiqueta;
        }

    }
    //************************************************************************************

    /*
        *
        * CLASE PARA FUNCIONES DE LA LISTA ENLAZADA SIMPLE
     */
    private nodo_simple<T, V> inicio;
    private nodo_simple<T, V> ultimo;
    private nodo_simple<T, V> alter;
    private int tamanio;
    private int nodos;

    public lista_enlazada_simple() {
        this.inicio = null;
        this.ultimo = null;
        this.alter = null;
        this.tamanio = 0;
        this.nodos = 0;
    }

    public boolean estaVacia() {
        return this.inicio == null;
    }

    public int tamanioLista() {
        return tamanio;
    }

    public int numeroNodos() {
        return nodos;
    }

    //ESTA FUNCIÓN ES EN OTRAS PALABRAS INSERTAR AL INICIO
    public void agregarInicio(T dato, V etiqueta) {
        nodo_simple<T, V> nuevoNodo = new nodo_simple();
        nuevoNodo.setDato(dato);
        nuevoNodo.setEtiqueta(etiqueta);
        if (estaVacia()) {
            inicio = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(inicio);
            inicio = nuevoNodo;

        }
        tamanio++;
        nodos++;
    }

    //ESTA FUNCIÓN ES EN OTRAS PALABRAS INSERTAR AL FINAL
    public void agregarNodo(T dato, V etiqueta) {
        nodo_simple<T, V> nuevoNodo = new nodo_simple();
        nuevoNodo.setDato(dato);
        nuevoNodo.setEtiqueta(etiqueta);
        if (estaVacia()) {
            inicio = nuevoNodo;
            ultimo = inicio;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
        tamanio++;
        nodos++;
    }

    //ESTA FUNCIÓN DEVUELVE LA EXISTENCIA DE UN NODO
    public boolean buscarNodo(T dato) {
        alter = inicio;
        for (int i = 0; i < tamanio; i++) {
            if (alter.getDato().equals(dato)) {
                return true;
            }
            alter = alter.getSiguiente();
        }
        return false;
    }

    //ESTA FUNCIÓN DEVUELVE EL NODO CON TODA SU INFORMACIÓN
    public nodo_simple<T, V> retornarNodo(T dato) {
        alter = inicio;
        for (int i = 0; i < tamanio; i++) {
            if (alter.getDato().equals(dato)) {
                return alter;
            }
            alter = alter.getSiguiente();
        }
        return null;
    }
    //ESTA FUNCIÓN DEVUELVE EL NODO CON TODA SU INFORMACIÓN "BUSQUEDA POR ETIQUETA"

    public nodo_simple<T, V> retornarPorEtiqueta(V etiqueta) {
        alter = inicio;
        for (int i = 0; i < tamanio; i++) {
            if (alter.getEtiqueta().equals(etiqueta)) {
                return alter;
            }
            alter = alter.getSiguiente();
        }
        return null;
    }

    //ESTA FUNCIÓN RETORNA EL VALOR O DATO QUE CONTENGA NUESTRO NODO
    public T retornarValor(int indice) throws Exception {
        //FACTOR PARA DEVOLVER EL ÚLTIMO VALOR DE LA LISTA
        if (indice >= tamanio) {
            return this.ultimo.getDato();
        }

        if (indice >= 0 && tamanio > indice) {
            if (indice == 0) {
                return inicio.getDato();
            } else {
                alter = inicio;
                for (int i = 0; i < indice; i++) {
                    alter = alter.getSiguiente();
                }
                return alter.getDato();
            }
        } else {
            throw new Exception("Posición No encontrada");
        }
    }

    //ELIMINAR UN NODO POR SU POSICIÓN 
    public void eliminarNodo(int indice) {
        if (indice >= 0 && tamanio > indice) {
            if (indice == 0) {
                inicio = inicio.getSiguiente();
                
            } else {
                alter = inicio;
                for (int i = 0; i < indice-1; i++) {
                    alter = alter.getSiguiente();
                }
                if (alter == ultimo) {
                    alter = null;
                } else {
                    alter.setSiguiente(alter.getSiguiente().getSiguiente());
                }

            }
            tamanio--;
            nodos--;
        }
    }

}
