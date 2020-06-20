/**
 *
 * @author Alejandro Lorenty
 */
package estructuras;

public class lista_enlazada_doble_circular<T, V> {

    public class nodo_doble<T, V> {
        //************************************************************************************

        /*
     *
     * CLASE PARA EL NODO DOBLE PARA IMPLEMENTARLO 
     * EN NUESTRA CLASE LISTA DOBLEMENTE ENLAZADA, CLASE PARAMÉTRICA PARA CUALQUIER DATO
         */
        private nodo_doble<T, V> anterior;
        private nodo_doble<T, V> siguiente;
        private T dato;
        private V etiqueta;

        public nodo_doble() {
            this.anterior = null;
            this.siguiente = null;
            this.dato = null;
            this.etiqueta = null;
        }

        public nodo_doble<T, V> getAnterior() {
            return anterior;
        }

        public void setAnterior(nodo_doble<T, V> anterior) {
            this.anterior = anterior;
        }

        public nodo_doble<T, V> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(nodo_doble<T, V> siguiente) {
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
        * CLASE PARA FUNCIONES DE LA LISTA DOBLEMENTE ENLAZADA
     */

    private nodo_doble<T, V> inicio;
    private nodo_doble<T, V> aux;
    private int tamanio;

    public lista_enlazada_doble_circular() {
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
    public void agregarInicio(T dato, V index) {
        nodo_doble<T, V> nuevoNodo = new nodo_doble();
        nuevoNodo.setDato(dato);
        nuevoNodo.setEtiqueta(index);

        if (estaVacia()) {
            inicio = nuevoNodo;
            inicio.setAnterior(inicio);
            inicio.setSiguiente(inicio);
        } else {
            inicio.getAnterior().setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(inicio.getAnterior());
            nuevoNodo.setSiguiente(inicio);
            inicio.setAnterior(nuevoNodo);

        }
        inicio = nuevoNodo;
        tamanio++;
    }

    //ESTA FUNCIÓN ES EN OTRAS PALABRAS INSERTAR AL FINAL
    public void agregarNodo(T dato, V index) {
        nodo_doble<T, V> nuevoNodo = new nodo_doble();
        nuevoNodo.setDato(dato);
        nuevoNodo.setEtiqueta(index);

        if (estaVacia()) {
            inicio = nuevoNodo;
            inicio.setAnterior(inicio);
            inicio.setSiguiente(inicio);
        } else {
            inicio.getAnterior().setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(inicio.getAnterior());
            nuevoNodo.setSiguiente(inicio);
            inicio.setAnterior(nuevoNodo);
        }
        tamanio++;
    }

    //ESTA FUNCIÓN ES PARA INSERTAR ORDENADO DESDE EL INICIO
    public void insertarOrdenado(T dato, V index) {
        nodo_doble<T, V> nuevoNodo = new nodo_doble();
        nuevoNodo.setDato(dato);
        nuevoNodo.setEtiqueta(index);

        if (estaVacia()) {
            inicio = nuevoNodo;
            inicio.setAnterior(inicio);
            inicio.setSiguiente(inicio);
        } else {
            aux = inicio;
            do {

                if (aux.getEtiqueta().toString().compareTo(index.toString()) > 0 && aux == inicio) {
                    nuevoNodo.setSiguiente(aux);
                    nuevoNodo.setAnterior(aux.getAnterior());
                    aux.getAnterior().setSiguiente(nuevoNodo);
                    aux.setAnterior(nuevoNodo);
                    inicio = nuevoNodo;
                    aux = inicio.getAnterior();

                } else if (aux.getEtiqueta().toString().compareTo(index.toString()) > 0) {
                    nuevoNodo.setSiguiente(aux);
                    nuevoNodo.setAnterior(aux.getAnterior());
                    aux.getAnterior().setSiguiente(nuevoNodo);
                    aux.setAnterior(nuevoNodo);
                    aux = inicio.getAnterior();

                } else if (aux.getSiguiente() == inicio) {
                    inicio.getAnterior().setSiguiente(nuevoNodo);
                    nuevoNodo.setAnterior(inicio.getAnterior());
                    nuevoNodo.setSiguiente(inicio);
                    inicio.setAnterior(nuevoNodo);
                    aux = inicio.getAnterior();
                }
                aux = aux.getSiguiente();
            } while (aux != inicio);

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
    public nodo_doble<T, V> retornarNodo(T dato) {
        aux = inicio;
        for (int i = 0; i < tamanio; i++) {
            if (aux.getDato().equals(dato)) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    //ESTA FUNCIÓN DEVUELVE EL NODO CON TODA SU INFORMACIÓN
    public T retornarNodobyIndex(int indice) {
        if (indice > tamanio) {
            indice = tamanio - 1;
        }

        if (indice >= 0 && tamanio >= indice) {
            if (indice == 0) {
                return inicio.getDato();
            } else {
                aux = inicio;
                for (int i = 0; i < indice - 1; i++) {
                    aux = aux.getSiguiente();
                }
                return aux.getDato();
            }
        }
        return null;
    }

    //FUNCIÓN PARA RETORNAR DATO EN EL NODO DE LA LISTA
    public T retornarDato(V index) {
        aux = inicio;
        do {
            if (aux.getEtiqueta().toString().compareTo(index.toString()) == 0) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        } while (aux != inicio);
        return null;
    }

    //FUNCIÓN PARA EDITAR EL DATO DE NUESTRO NODO
    public void editarDato(T dato, V index) {
        aux = inicio;
        do {
            if (aux.getEtiqueta().toString().compareTo(index.toString()) == 0) {
                aux.setDato(dato);
                aux = inicio.getAnterior();
            }
            aux = aux.getSiguiente();
        } while (aux != inicio);
    }

    //MÉTODO PARA ELIMINAR EL NODO DE LA LISTA
    public void eliminarNodo(V index) {
        aux = inicio;
        do {
            if (aux.getEtiqueta().toString().compareTo(index.toString()) == 0) {
                aux.getAnterior().setSiguiente(aux.getSiguiente());
                aux.getSiguiente().setAnterior(aux.getAnterior());
                aux = null;
                aux = inicio.getAnterior();
            }
            aux = aux.getSiguiente();
        } while (aux != inicio);
    }
}
