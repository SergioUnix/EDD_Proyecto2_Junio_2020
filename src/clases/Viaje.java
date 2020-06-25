/**
 *
 * @author Alejandro Lorenty
 */
package clases;

import estructuras.lista_enlazada_simple;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Viaje {

    private String lugarOrigen;
    private String lugarDestino;

    private int anio;
    private int mes;
    private int dia;
    private int hora;
    private int minuto;
    private int segundo;

    private Cliente cliente;
    private Vehiculo vehiculo;
    private Conductor conductor;
    private lista_enlazada_simple<String, String> viaje;
    private String clave; //PLACAFECHAHORAMINUTO

    public Viaje() {
        Calendar fecha = new GregorianCalendar();
        this.lugarOrigen = null;
        this.lugarDestino = null;
        this.anio = fecha.get(Calendar.YEAR);
        this.mes = fecha.get(Calendar.MONTH);;
        this.dia = fecha.get(Calendar.DAY_OF_MONTH);
        this.hora = fecha.get(Calendar.HOUR_OF_DAY);
        this.minuto = fecha.get(Calendar.MINUTE);
        this.segundo = fecha.get(Calendar.SECOND);
        this.cliente = null;
        this.vehiculo = null;
        this.conductor = null;
        this.viaje = null;
        this.clave = null;
    }

    public Viaje(String lugarOrigen, String lugarDestino, Cliente cliente, Vehiculo vehiculo, Conductor conductor, lista_enlazada_simple<String, String> viaje, String clave) {
        this.lugarOrigen = lugarOrigen;
        this.lugarDestino = lugarDestino;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.conductor = conductor;
        this.viaje = viaje;
        this.clave = clave;
    }

    public String getLugarOrigen() {
        return lugarOrigen;
    }

    public void setLugarOrigen(String lugarOrigen) {
        this.lugarOrigen = lugarOrigen;
    }

    public String getLugarDestino() {
        return lugarDestino;
    }

    public void setLugarDestino(String lugarDestino) {
        this.lugarDestino = lugarDestino;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public lista_enlazada_simple<String, String> getViaje() {
        return viaje;
    }

    public void setViaje(lista_enlazada_simple<String, String> viaje) {
        this.viaje = viaje;
    }

    public String getClave() {
        return clave;
    }

    public void setClave() {
        this.clave = vehiculo.getPlaca() + String.valueOf(dia) + String.valueOf(mes) + String.valueOf(anio) + String.valueOf(hora) + ":" + String.valueOf(minuto);
    }

}
