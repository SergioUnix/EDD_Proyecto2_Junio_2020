/**
 *
 * @author Alejandro Lorenty
 */
package clases;

public class Vehiculo {

    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    private String color;
    private double precio;
    private String transmision;

    public Vehiculo() {
        this.placa = null;
        this.marca = null;
        this.modelo = null;
        this.anio = 0;
        this.color = null;
        this.precio = 0.0;
        this.transmision = null;
    }

    public Vehiculo(String placa, String marca, String modelo, int anio, String color, double precio, String transmision) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.precio = precio;
        this.transmision = transmision;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", color=" + color + ", precio=" + precio + ", transmision=" + transmision + '}';
    }

}
