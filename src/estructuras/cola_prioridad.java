/**
 *
 * @author Alejandro Lorenty
 */
package estructuras;

public class cola_prioridad<T, V> {

    public class nodo_prioridad<T, V> {

        nodo_prioridad siguiente;
        T dato;
        V prioridad;

        public nodo_prioridad() {
            this.siguiente = null;
            this.dato = null;
            this.prioridad = null;
        }

        public nodo_prioridad(nodo_prioridad siguiente, T dato, V prioridad) {
            this.siguiente = siguiente;
            this.dato = dato;
            this.prioridad = prioridad;
        }

        public nodo_prioridad getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(nodo_prioridad siguiente) {
            this.siguiente = siguiente;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }

        public V getPrioridad() {
            return prioridad;
        }

        public void setPrioridad(V prioridad) {
            this.prioridad = prioridad;
        }

    }
    nodo_prioridad<T, V> cabeza;
    nodo_prioridad<T, V> alter;
    int tamanio;

    public cola_prioridad() {
        this.cabeza = null;
        this.alter = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int tamanioCola() {
        return tamanio;
    }

    public void encolar(T dato, V prioridad) {
        nodo_prioridad<T, V> aux;
        nodo_prioridad<T, V> nuevoNodo = new nodo_prioridad();
        nuevoNodo.setDato(dato);
        nuevoNodo.setPrioridad(prioridad);
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            alter = cabeza;
            aux = cabeza;
            do {
                if (alter.getPrioridad().toString().compareTo(prioridad.toString()) > 0 && alter == cabeza) {
                    nuevoNodo.setSiguiente(alter);
                    cabeza = nuevoNodo;
                } else if (alter.getPrioridad().toString().compareTo(prioridad.toString()) > 0 && alter != cabeza) {
                    aux.setSiguiente(nuevoNodo);
                    nuevoNodo.setSiguiente(alter);
                } else if (alter.getPrioridad().toString().compareTo(prioridad.toString()) < 0 && alter.getSiguiente() == null) {
                    alter.setSiguiente(nuevoNodo);
                }
                aux = alter;
                if (alter.getSiguiente() != null) {
                    alter = alter.getSiguiente();
                }

            } while (alter.getSiguiente() != null);

        }
        tamanio++;
    }

    public nodo_prioridad descolar() {
        if (estaVacia()) {
            return null;
        } else {
            alter = cabeza;
            cabeza = cabeza.getSiguiente();
            tamanio--;
            return alter;
        }

    }

}
