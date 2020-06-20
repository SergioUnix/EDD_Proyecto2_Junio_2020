/**
 *
 * @author Alejandro Lorenty
 */
package clases;

public class Ruta {

    private String origen;
    private String destino;
    private int tiempo;

    public Ruta() {
        this.origen = null;
        this.destino = null;
        this.tiempo = 0;
    }

    public Ruta(String origen, String destino, int tiempo) {
        this.origen = origen;
        this.destino = destino;
        this.tiempo = tiempo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Ruta{" + "origen=" + origen + ", destino=" + destino + ", tiempo=" + tiempo + '}';
    }

}
