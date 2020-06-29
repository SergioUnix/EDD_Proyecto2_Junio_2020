/**
 *
 * @author Alejandro Lorenty
 */
package clases;

import estructuras.lista_enlazada_doble_circular;
import estructuras.lista_simple;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Viaje {

    private String lugarOrigen;
    private String lugarDestino;
    private int tiempoTotal;       //// suma de todo el recorrido  
    public lista_simple<Integer> pesoCamino;  /// 0, 250, 150, .....

    private String fecha;
    private int anio;
    private int mes;
    private int dia;
    private int hora;
    private int minuto;
    private int segundo;

    private lista_enlazada_doble_circular<Cliente, Long> cliente;
    private lista_enlazada_doble_circular<Conductor, Long> conductor;
    private lista_enlazada_doble_circular<Vehiculo, String> vehiculo;

    private lista_simple<String> viaje;
    private String clave; //PLACAFECHAHORAMINUTO

    public Viaje() {

        Calendar fecha = new GregorianCalendar();
        this.lugarOrigen = null;
        this.lugarDestino = null;
        this.fecha = null;
        this.anio = fecha.get(Calendar.YEAR);
        this.mes = fecha.get(Calendar.MONTH);;
        this.dia = fecha.get(Calendar.DAY_OF_MONTH);
        this.hora = fecha.get(Calendar.HOUR_OF_DAY);
        this.minuto = fecha.get(Calendar.MINUTE);
        this.segundo = fecha.get(Calendar.SECOND);
        this.cliente = new lista_enlazada_doble_circular();
        this.vehiculo = new lista_enlazada_doble_circular();
        this.conductor = new lista_enlazada_doble_circular();
        this.viaje = null;
        this.clave = null;
        this.pesoCamino = null;
    }

    public Viaje(String lugarOrigen, String lugarDestino, lista_simple<String> viaje, String clave) {
        this.lugarOrigen = lugarOrigen;
        this.lugarDestino = lugarDestino;
        this.viaje = viaje;
        this.clave = clave;
    }

    public lista_simple<Integer> getPesoCamino() {
        return pesoCamino;
    }

    public void setPesoCamino(lista_simple<Integer> pesoCamino) {
        this.pesoCamino = pesoCamino;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(int tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
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

    public lista_enlazada_doble_circular<Cliente, Long> getCliente() {
        return cliente;
    }

    public void setCliente(lista_enlazada_doble_circular<Cliente, Long> cliente) {
        this.cliente = cliente;
    }

    public lista_enlazada_doble_circular<Conductor, Long> getConductor() {
        return conductor;
    }

    public void setConductor(lista_enlazada_doble_circular<Conductor, Long> conductor) {
        this.conductor = conductor;
    }

    public lista_enlazada_doble_circular<Vehiculo, String> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(lista_enlazada_doble_circular<Vehiculo, String> vehiculo) {
        this.vehiculo = vehiculo;
    }

    public lista_simple<String> getViaje() {
        return viaje;
    }

    public void setViaje(lista_simple<String> viaje) {
        this.viaje = viaje;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String placa) {
        this.clave = placa + String.valueOf(dia) + String.valueOf(mes) + String.valueOf(anio) + String.valueOf(hora) + ":" + String.valueOf(minuto);
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha() {
        this.fecha = String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(anio)+" " + String.valueOf(hora) + ":" + String.valueOf(minuto);
    }

}
