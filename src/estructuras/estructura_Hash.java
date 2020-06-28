/**
 *
 * @author ADMIN
 */
package estructuras;


public class estructura_Hash<T> {

    private lista_simple<T> tabla_H[];
    private int capacidad;
    private double ocupacion;

    public estructura_Hash() {
        this.tabla_H = null;
        this.capacidad = 0;
        this.ocupacion = 0;
    }

    public lista_simple<T>[] getTabla_H() {
        return tabla_H;
    }

    public void setTabla_H(lista_simple<T>[] tabla_H) {
        this.tabla_H = tabla_H;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(int ocupacion) {
        this.ocupacion = ocupacion;
    }
//*************************************************************************************************************

    public estructura_Hash(int capacidad, double ocupacion) {
        this.tabla_H = new lista_simple[capacidad];
        this.capacidad = capacidad;
        this.ocupacion = ocupacion;
    }

    public int funcion_hash(long argumento) {
        return Integer.parseInt(String.valueOf(argumento % Long.parseLong(String.valueOf(this.capacidad))));
    }

    public void add(T dato, long parametroH) {
        if (tabla_H[funcion_hash(parametroH)] == null) {
            tabla_H[funcion_hash(parametroH)] = new lista_simple();
        }
        tabla_H[funcion_hash(parametroH)].add(dato);
    }

    public lista_simple<T> devolver_nodo(long parametroH) {
        if (tabla_H[funcion_hash(parametroH)] == null) {
            return null;
        }
        if (!tabla_H[funcion_hash(parametroH)].isEmpty()) {
            return tabla_H[funcion_hash(parametroH)];
        } else {
            return null;
        }
    }

    public lista_simple<T> devolverDato(int indice) {
        if (indice <= capacidad) {
            for (int i = 0; i < indice; i++) {
                if (!tabla_H[i].isEmpty()) {
                    return tabla_H[indice];
                }
            }
        }
        return null;
    }

    public lista_simple<T> restablecer_tamanio() throws Exception {
        int uso = 0;
        double utilidad;
        lista_simple<T> aux = new lista_simple();
        for (int i = 1; i < capacidad; i++) {
            if (tabla_H[i] != null) {
                uso++;
            }
            if (tabla_H[i] != null && tabla_H[i].isEmpty()) {
                uso--;
            }
        }
        utilidad = (uso * 100) / capacidad;
        if (utilidad >= ocupacion) {
            System.out.println("SE HA REVASADO EL PORCENTAJE DE OCUPACION SE HARA REHASHING " + utilidad + "%" + "\n");
            for (int i = 0; i < capacidad; i++) {
                if (tabla_H[i] != null) {
                    for (int j = 0; j < tabla_H[i].size(); j++) {
                        T datoExtraido;
                        datoExtraido = tabla_H[i].get(j);
                        aux.add(datoExtraido);
                    }
                }
            }
        } else if (utilidad <= 50.0) {
            System.out.println("LA TABLA TODAVÍA ES UTILIZABLE " + utilidad + "%");
        } else if (utilidad >= 50.0 && utilidad < 60.0) {
            System.out.println("LA TABLA SE ENCUENTRA A MAS 50% DE SU CAPACIDAD, Y SE HARA REHASHING \"" + utilidad + "\"%");
        } else if (utilidad >= 60.0 && utilidad < 70.0) {
            System.out.println("LA TABLA SE ENCUENTRA A MAS 60% DE SU CAPACIDAD, Y SE HARA REHASHING \"" + utilidad + "\"%");
        } else if (utilidad >= 70.0) {
            System.out.println("LA TABLA SE ENCUENTRA A MAS 70% DE SU CAPACIDAD, Y SE HARA REHASHING \"" + utilidad + "\"%");
        }

        return aux;
    }
}
