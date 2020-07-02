/**
 *
 * @author Alejandro Lorenty
 */
package clases;

import static clases.Carga.viajes;
import estructuras.lista_enlazada_doble_circular;
import estructuras.lista_simple;

public class Reportes {

    public static lista_enlazada_doble_circular<Cliente, Integer> TopClientes() {
        lista_enlazada_doble_circular<Cliente, Integer> TOP = new lista_enlazada_doble_circular();
        Viaje analisis;
        Viaje conteo;
        Cliente cliente;
        for (int i = 0; i < viajes.tamanioCadena(); i++) {
            int viajesRealizados = 0;

            analisis = viajes.retornarBloque(i).getTransaccion();
            cliente = analisis.getCliente().retornarNodobyIndex(0);
            for (int j = 0; j < viajes.tamanioCadena(); j++) {
                conteo = viajes.retornarBloque(j).getTransaccion();
                if (cliente.equals(conteo.getCliente().retornarNodobyIndex(0))) {
                    viajesRealizados++;
                }
            }

            TOP.insertarOrdenadoSinRepetido(cliente, viajesRealizados);

        }
        return TOP;
    }

    public static lista_enlazada_doble_circular<Conductor, Integer> TopConductores() {
        lista_enlazada_doble_circular<Conductor, Integer> TOP = new lista_enlazada_doble_circular();
        Viaje analisis;
        Viaje conteo;
        Conductor conductor;
        for (int i = 0; i < viajes.tamanioCadena(); i++) {
            int viajesRealizados = 0;

            analisis = viajes.retornarBloque(i).getTransaccion();
            conductor = analisis.getConductor().retornarNodobyIndex(0);
            for (int j = 0; j < viajes.tamanioCadena(); j++) {
                conteo = viajes.retornarBloque(j).getTransaccion();
                if (conductor.equals(conteo.getConductor().retornarNodobyIndex(0))) {
                    viajesRealizados++;
                }
            }

            TOP.insertarOrdenadoSinRepetido(conductor, viajesRealizados);

        }
        return TOP;
    }

    public static lista_enlazada_doble_circular<Vehiculo, Integer> TopVehiculos() {
        lista_enlazada_doble_circular<Vehiculo, Integer> TOP = new lista_enlazada_doble_circular();
        Viaje analisis;
        Viaje conteo;
        Vehiculo vehiculo;
        for (int i = 0; i < viajes.tamanioCadena(); i++) {
            int viajesRealizados = 0;

            analisis = viajes.retornarBloque(i).getTransaccion();
            vehiculo = analisis.getVehiculo().retornarNodobyIndex(0);
            for (int j = 0; j < viajes.tamanioCadena(); j++) {
                conteo = viajes.retornarBloque(j).getTransaccion();
                if (vehiculo.equals(conteo.getVehiculo().retornarNodobyIndex(0))) {
                    viajesRealizados++;
                }
            }

            TOP.insertarOrdenadoSinRepetido(vehiculo, viajesRealizados);

        }
        return TOP;
    }

    public static lista_enlazada_doble_circular<Viaje, Integer> TopViajes() {
        lista_enlazada_doble_circular<Viaje, Integer> TOP = new lista_enlazada_doble_circular();
        Viaje analisis;
        lista_simple<String> viaje;
        for (int i = 0; i < viajes.tamanioCadena(); i++) {
            analisis = viajes.retornarBloque(i).getTransaccion();
            viaje = analisis.getViaje();
            TOP.insertarOrdenadoSinRepetido(analisis, viaje.getSize());
        }
        return TOP;
    }

}
