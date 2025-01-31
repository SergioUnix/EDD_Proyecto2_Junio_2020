/**
 *
 * @author ADMIN
 */
package estructuras;

class Nodo<T> {

    private T valor;
    private Nodo<T> siguiente;

    public void Nodo() {
        this.valor = null;
        this.siguiente = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}

public class lista_simple<T> {

    public Nodo<T> getInicio() {
        return inicio;
    }

    public int getSize() {
        return size;
    }

    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public int size() {
        return this.size;
    }

    private Nodo<T> inicio;
    int size;

    lista_simple() {
        this.inicio = null;
        this.size = 0;

    }

    public boolean isEmpty() {
        return inicio == null;
    }
    //Siempre agrega al inicio.. por si se necesitara en este proyecto 2

    public void addFirst(T valor) {
        Nodo<T> nuevo = new Nodo<T>();
        nuevo.setValor(valor);
        if (estaVacia()) {
            this.inicio = nuevo;
        } else {
            nuevo.setSiguiente(this.inicio);
            this.inicio = nuevo;
        }
        this.size++;
    }
    //Aca agrego al Final de la lista

    public void add(T valor) {
        Nodo<T> nuevo = new Nodo<T>();
        nuevo.setValor(valor);
        if (estaVacia()) {
            this.inicio = nuevo;
        } else {
            Nodo<T> aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        this.size++;
    }

    public boolean buscar(T referencia) {
        Nodo<T> aux = inicio;
        boolean encontrado = false;
        while (aux != null && encontrado != true) {
            if (referencia == aux.getValor()) {
                encontrado = true;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return encontrado; //Retorna si esta el dato buscado ..
    }
    ////// Ago una sobrecarga a este metodo por si hay que comparar strings.. Solo tipo string

    public boolean buscar(String referencia) {
        Nodo aux = inicio;
        boolean encontrado = false;
        while (aux != null && encontrado != true) {
            if (referencia.equals(aux.getValor())) {
                encontrado = true;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return encontrado; //Retorna si esta el dato buscado ..
    }

    public T get(int posicion){
        if (posicion >= 0 && posicion < size) {  //Si esta en el rago entra..
            if (posicion == 0) {
                return this.inicio.getValor();
            } else {
                Nodo<T> aux = inicio;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                return aux.getValor();
            }
        } else {///si no existe esto retorna una excepcion.. por si falla jaja
        //    throw new Exception("si no esta el dato muestro este mensaje..");
        }
         return null;
    }

    public void set(int posicion, T valor) {
        if (posicion >= 0 && posicion < size) {
            if (posicion == 0) {
                inicio.setValor(valor);
            } else {
                // En caso que el nodo a eliminar este por el medio o pueda ser el ultimo
                Nodo<T> aux = inicio;
                // Recorre la lista hasta lleger al nodo anterior al eliminar ..
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                // Actualiza el nodo Aux
                aux.setValor(valor);
            }
        }
    }

    public void remove(int posicion) {
        if (posicion >= 0 && posicion < size) {
            if (posicion == 0) {
                inicio = inicio.getSiguiente();
            } // En caso que el nodo a eliminar este por el medio o pueda  sea el ultimo
            else {
                Nodo<T> aux = inicio;
                // Recorre la lista hasta lleger al nodo anterior al eliminar.
                for (int i = 0; i < posicion - 1; i++) {
                    aux = aux.getSiguiente();
                }
                Nodo<T> siguiente = aux.getSiguiente(); //Cambio los punteros se podria decir..
                aux.setSiguiente(siguiente.getSiguiente());
            }
            this.size--;
        }
    }

    public void vaciarLista() {
        this.inicio = null;
        size = 0;
    }

    public void imprimir() {
        if (!estaVacia()) {
            Nodo<T> aux = inicio;
            int i = 0;
            while (aux != null) {
                System.out.print(i + "--- " +aux.getValor() + "\n ");
                aux = aux.getSiguiente();
                i++;
            }
        }
    }
    //acepta string y devuelve su posicion en forma de indice... 
    public int getPosicion(String referencia){       
        if (buscar(referencia)) {
            Nodo aux = inicio;
            int cont = 0;
            while(!referencia.equals(aux.getValor())){
                              
                cont ++;
                aux = aux.getSiguiente();
            }
            return cont;
        } else {
        //    throw new Exception("Valor inexistente en la lista.");
        }
       return -1;
    }

    
       public void addOrdenado(T valor) {
      Nodo<T> nuevo = new Nodo ();
      String x;
        nuevo.setValor(valor);
        if (inicio==null) {
            inicio=nuevo;
        } else {
            //if (valor.compareTo(inicio.valor)<0) {
            if ((Long)valor<(Long)inicio.getValor()) {
                nuevo.setSiguiente(inicio);
                inicio=nuevo;
            } else {
                Nodo recorre=inicio;
                Nodo atras=inicio;
                //while ((x.compareTo(recorre.info)>=0) && recorre.sig!=null) {
                while (((Long)valor >=(Long)recorre.getValor()) && recorre.getSiguiente() !=null) {
                    atras=recorre;
                    recorre=recorre.getSiguiente();
                }
                //if (valor.compareTo(recorre.info)>0) {
                if ((Long)valor>(Long)recorre.getValor()) {
                    recorre.setSiguiente(nuevo);
                } else {
                    nuevo.setSiguiente(recorre);
                    atras.setSiguiente(nuevo);
                }
            }
           
           
        }    
       }



}
