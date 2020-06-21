/**
 *
 * @author Alejandro Lorenty
 */
package estructuras;

public class lista_enlazada_simple<T> {

    //************************************************************************************
    /*
     *
     * CLASE PARA EL NODO SIMPLE PARA IMPLEMENTARLO 
     * EN NUESTRA CLASE LISTA SIMPLE, CLASE PARAMÉTRICA PARA CUALQUIER DATO
     */
    public class nodo_simple<T> {

        private nodo_simple<T> siguiente;
        private T dato;

        public nodo_simple() {
            this.siguiente = null;
            this.dato = null;
        }

        public nodo_simple<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(nodo_simple<T> siguiente) {
            this.siguiente = siguiente;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }

    }
    //************************************************************************************

    /*
        *
        * CLASE PARA FUNCIONES DE LA LISTA ENLAZADA SIMPLE
     */
    private nodo_simple<T> inicio;
    private nodo_simple<T> aux;
    private int tamanio;

    public lista_enlazada_simple() {
        this.inicio = null;
        this.aux = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return this.inicio == null;
    }

    public int tamanioLista() {
        return tamanio;
    }

    //ESTA FUNCIÓN ES EN OTRAS PALABRAS INSERTAR AL INICIO
    public void agregarInicio(T dato) {
        nodo_simple<T> nuevoNodo = new nodo_simple();
        nuevoNodo.setDato(dato);
        if (estaVacia()) {
            inicio = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(inicio);
            inicio = nuevoNodo;
        }
        tamanio++;
    }

    //ESTA FUNCIÓN ES EN OTRAS PALABRAS INSERTAR AL FINAL
    public void agregarNodo(T dato) {
        nodo_simple<T> nuevoNodo = new nodo_simple();
        nuevoNodo.setDato(dato);
        if (estaVacia()) {
            inicio = nuevoNodo;
        } else {
            aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevoNodo);
        }
        tamanio++;
    }

    //ESTA FUNCIÓN DEVUELVE LA EXISTENCIA DE UN NODO
    public boolean buscarNodo(T dato) {
        aux = inicio;
        for (int i = 0; i < tamanio; i++) {
            if (aux.getDato().equals(dato)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    //ESTA FUNCIÓN DEVUELVE EL NODO CON TODA SU INFORMACIÓN
    public nodo_simple<T> retornarNodo(T dato) {
        aux = inicio;
        for (int i = 0; i < tamanio; i++) {
            if (aux.getDato().equals(dato)) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    //ESTA FUNCIÓN RETORNA EL VALOR O DATO QUE CONTENGA NUESTRO NODO
    public T retornarValor(int indice) throws Exception {
        //FACTOR PARA DEVOLVER EL ÚLTIMO VALOR DE LA LISTA
        if (indice >= tamanio) {
            indice = tamanio - 1;
        }

        if (indice >= 0 && tamanio > indice) {
            if (indice == 0) {
                return inicio.getDato();
            } else {
                aux = inicio;
                for (int i = 0; i < indice - 1; i++) {
                    aux = aux.getSiguiente();
                }
                return aux.getDato();
            }
        } else{
            throw new Exception("Posición No encontrada");
        }
    }

    //ELIMINAR UN NODO POR SU POSICIÓN 
    public void eliminarNodo(int indice) {
        if (indice >= 0 && tamanio > indice) {
            if (indice == 0) {
                inicio = inicio.getSiguiente();
            } else {
                aux = inicio;
                for (int i = 0; i < indice - 1; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
            }
            tamanio--;
        }
    }
}
