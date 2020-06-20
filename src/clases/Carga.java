/**
 *
 * @author Alejandro Lorenty
 */
package clases;

import java.io.File;
import clases.Cliente;
import clases.Conductor;
import clases.Vehiculo;
import clases.Ruta;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Carga {

    public static void cargaCliente(String ruta) throws FileNotFoundException {
        File archivoLeer = new File(ruta);
        FileReader FR = new FileReader(archivoLeer);
        BufferedReader BR = new BufferedReader(FR);
        try {
            String linea = BR.readLine();
            while (linea != null) {
                String[] objetos = linea.split(";");
                for (String objeto : objetos) {
                    Cliente nuevoCliente = new Cliente();
                    String[] atributos = objeto.split(",");
                    nuevoCliente.setDPI(Long.parseLong(atributos[0].trim()));
                    nuevoCliente.setNombres(atributos[1].trim());
                    nuevoCliente.setApellidos(atributos[2].trim());
                    nuevoCliente.setGenero(atributos[3].trim());
                    nuevoCliente.setFecha_nac(atributos[4].trim());
                    nuevoCliente.setTelefono(Integer.parseInt(atributos[5].trim()));
                    nuevoCliente.setDireccion(atributos[6].trim());

                    System.out.println(nuevoCliente.toString());
                }

                linea = BR.readLine();
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());

        }
    }

    public static void cargaVehiculo(String ruta) throws FileNotFoundException {
        File archivoLeer = new File(ruta);
        FileReader FR = new FileReader(archivoLeer);
        BufferedReader BR = new BufferedReader(FR);
        try {
            String linea = BR.readLine();
            while (linea != null) {
                String[] objetos = linea.split(";");
                for (String objeto : objetos) {
                    Vehiculo nuevoVehiculo = new Vehiculo();
                    String[] atributos = objeto.split(":");
                    nuevoVehiculo.setPlaca(atributos[0].trim());
                    nuevoVehiculo.setMarca(atributos[1].trim());
                    nuevoVehiculo.setModelo(atributos[2].trim());
                    nuevoVehiculo.setAnio(Integer.parseInt(atributos[3].trim()));
                    nuevoVehiculo.setColor(atributos[4].trim());
                    nuevoVehiculo.setPrecio(Double.parseDouble(atributos[5].trim()));
                    nuevoVehiculo.setTransmision(atributos[6].trim());

                    System.out.println(nuevoVehiculo.toString());
                }

                linea = BR.readLine();
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());

        }
    }

    public static void cargaConductor(String ruta) throws FileNotFoundException {
        File archivoLeer = new File(ruta);
        FileReader FR = new FileReader(archivoLeer);
        BufferedReader BR = new BufferedReader(FR);
        try {
            String linea = BR.readLine();
            while (linea != null) {
                String[] objetos = linea.split(";");
                for (String objeto : objetos) {
                    Conductor nuevoConductor = new Conductor();
                    String[] atributos = objeto.split("%");
                    nuevoConductor.setDPI(Long.parseLong(atributos[0].trim()));
                    nuevoConductor.setNombres(atributos[1].trim());
                    nuevoConductor.setApellidos(atributos[2].trim());
                    nuevoConductor.setLicencia(atributos[3].trim().charAt(0));
                    nuevoConductor.setGenero(atributos[4].trim());
                    nuevoConductor.setFecha_nac(atributos[5].trim());
                    nuevoConductor.setTelefono(Integer.parseInt(atributos[6].trim()));
                    nuevoConductor.setDireccion(atributos[7].trim());

                    System.out.println(nuevoConductor.toString());
                }

                linea = BR.readLine();
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());

        }
    }

    public static void cargaRuta(String ruta) throws FileNotFoundException {
        File archivoLeer = new File(ruta);
        FileReader FR = new FileReader(archivoLeer);
        BufferedReader BR = new BufferedReader(FR);
        try {
            String linea = BR.readLine();
            while (linea != null) {
                String[] objetos = linea.split("%");
                for (String objeto : objetos) {
                    Ruta nuevaRuta = new Ruta();
                    String[] atributos = objeto.split("/");
                    
                    nuevaRuta.setOrigen(atributos[0].trim());
                    nuevaRuta.setDestino(atributos[1].trim());
                    nuevaRuta.setTiempo(Integer.parseInt(atributos[2].trim()));
                    
                    System.out.println(nuevaRuta.toString());
                }

                linea = BR.readLine();
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());

        }
    }
}
