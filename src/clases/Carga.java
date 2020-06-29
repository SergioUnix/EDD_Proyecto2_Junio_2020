/**
 *
 * @author Alejandro Lorenty
 */
package clases;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import estructuras.estructura_Hash;
import estructuras.arbol_por_paginas;
import estructuras.estructura_BloqueC;
import estructuras.estructura_BloqueC.nodo_bloque;
import estructuras.estructura_grafo;
import estructuras.lista_enlazada_doble_circular;
import estructuras.lista_enlazada_doble_circular.nodo_doble;
import estructuras.lista_simple;

/*
     *
     *
     *CLASE PARA CARGAR Y GRAFICAR TODAS LAS ESTRUCTURAS
 */
public class Carga {

    public static lista_enlazada_doble_circular<Conductor, Long> conductores = new lista_enlazada_doble_circular();
    public static arbol_por_paginas vehiculos = new arbol_por_paginas(2);
    public static estructura_Hash<Cliente> clientes = new estructura_Hash(37, 75.0);
    public static lista_simple<Cliente> clientesAUX;
    public static estructura_grafo grafo = new estructura_grafo();
    public static estructura_BloqueC<Viaje, String> viajes = new estructura_BloqueC();

    public static void cargaCliente(String ruta) throws FileNotFoundException, Exception {
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

                    clientes.add(nuevoCliente, nuevoCliente.getDPI());
                    clientesAUX = clientes.restablecer_tamanio();
                    if (!clientesAUX.isEmpty()) {
                        estructura_Hash<Cliente> clientesAlternative = new estructura_Hash(clientes.getCapacidad() + 37, 75.0);
                        for (int i = 0; i < clientesAUX.size(); i++) {
                            clientesAlternative.add(clientesAUX.get(i), clientesAUX.get(i).getDPI());
                        }
                        clientes = clientesAlternative;
                    }

                    System.out.println(nuevoCliente.toString());
                }

                linea = BR.readLine();
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());

        }
    }

    public static void cargaVehiculo(String ruta) throws FileNotFoundException {
        long result = 0;
        String str = null;
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
                    str = atributos[0].trim();
                    nuevoVehiculo.setMarca(atributos[1].trim());
                    nuevoVehiculo.setModelo(atributos[2].trim());
                    nuevoVehiculo.setAnio(Integer.parseInt(atributos[3].trim()));
                    nuevoVehiculo.setColor(atributos[4].trim());
                    nuevoVehiculo.setPrecio(Double.parseDouble(atributos[5].trim()));
                    nuevoVehiculo.setTransmision(atributos[6].trim());
                    StringBuilder sb = new StringBuilder();
                    for (char c : str.toCharArray()) {
                        sb.append((int) c);
                    }
                    result = Long.parseLong(sb.toString());
                    vehiculos.agregar_datos(result, nuevoVehiculo);

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

                    conductores.insertarOrdenado(nuevoConductor, nuevoConductor.getDPI());

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
                    grafo.agregoRuta(atributos[0].trim(), atributos[1].trim(), atributos[2].trim());
                    System.out.println(nuevaRuta.toString());
                }

                linea = BR.readLine();
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());

        }
    }
//************************************************************************************************

    public static Path tabla_hash_GRAPHVIZ() throws IOException, Exception {
        Cliente clienteG;
        Cliente clienteG2;
        //VARIALBES PARA CREAR NUESTRO ARCHIVO .DOT CON SU RUTA
        String ARCHIVO = "Clientes.dot";
        Path rutaRelativa = Paths.get(ARCHIVO);
        Path rutaAbsoluta = rutaRelativa.toAbsolutePath();
        //IMPRIMIR LA RUTA PARA REVISAR
        System.out.println(rutaAbsoluta);
        //CREAMOS EL ARCHIVO EN LA RUTA ABSOLUTA DE NUESTRO PROYECTO
        File archivo = new File(rutaAbsoluta.toString());
        BufferedWriter BW;

        //SI EXISTE NUESTRO ARCHIVO SOLO LO EDITAMOS
        if (archivo.exists()) {

            BW = new BufferedWriter(new FileWriter(archivo));
            BW.write("digraph HashTable {\n");
            BW.write("node[shape=box style=\"filled\" color=\"cyan3\" fontcolor = \"white\" penwidth=3];\n");
            BW.write("edge[style=filled fillcolor=\"darkgreen\" color=\"darkgoldenrod3\"];\n");
            BW.write("rankdir=LR;\n");
            BW.write("subgraph cluster_0{\n");
            BW.write("style=filled;\n");
            BW.write("color=black;\n");

            for (int i = 0; i < clientes.getTabla_H().length; i++) {
                if (clientes.getTabla_H()[i] != null && !clientes.getTabla_H()[i].isEmpty()) {
                    lista_simple<Cliente> vector = clientes.getTabla_H()[i];
                    BW.write("\"" + i + "\";\n");

                    for (int j = 0; j < vector.size(); j++) {
                        clienteG = vector.get(j);
                        BW.write("\"" + String.valueOf(clienteG.getDPI()) + "\"" + "[label =" + "\"" + clienteG.getDPI() + "\n" + clienteG.getNombres() + "\"];\n");
                    }
                    for (int j = 0; j < vector.size() - 1; j++) {
                        clienteG = vector.get(j);
                        clienteG2 = vector.get(j + 1);
                        BW.write("\"" + String.valueOf(clienteG.getDPI()) + "\"" + "->\"" + String.valueOf(clienteG2.getDPI()) + "\";\n");

                    }
                    clienteG = vector.get(0);
                    BW.write(i + "->" + "\"" + String.valueOf(clienteG.getDPI()) + "\";\n");
                }
            }
            BW.write("}" + "\n");
            BW.write("}" + "\n");

        } //SI NO EXISTE CREAMOS UNO NUEVO Y LLENAMOS DE INFORMACIÓN
        else {
            BW = new BufferedWriter(new FileWriter(archivo));
            BW.write("digraph HashTable {\n");
            BW.write("node[shape=box style=\"filled\" color=\"cyan3\" fontcolor = \"white\" penwidth=3];\n");
            BW.write("edge[style=filled fillcolor=\"darkgreen\" color=\"darkgoldenrod3\"];\n");
            BW.write("rankdir=LR;\n");
            BW.write("subgraph cluster_0{\n");
            BW.write("style=filled;\n");
            BW.write("color=black;\n");

            for (int i = 0; i < clientes.getTabla_H().length; i++) {
                if (clientes.getTabla_H()[i] != null && !clientes.getTabla_H()[i].isEmpty()) {
                    lista_simple<Cliente> vector = clientes.getTabla_H()[i];
                    BW.write("\"" + i + "\";\n");

                    for (int j = 0; j < vector.size(); j++) {
                        clienteG = vector.get(j);
                        BW.write("\"" + String.valueOf(clienteG.getDPI()) + "\"" + "[label =" + "\"" + clienteG.getDPI() + "\n" + clienteG.getNombres() + "\"];\n");
                    }
                    for (int j = 0; j < vector.size() - 1; j++) {
                        clienteG = vector.get(j);
                        clienteG2 = vector.get(j + 1);
                        BW.write("\"" + String.valueOf(clienteG.getDPI()) + "\"" + "->\"" + String.valueOf(clienteG2.getDPI()) + "\";\n");

                    }
                    clienteG = vector.get(0);
                    BW.write(i + "->" + "\"" + String.valueOf(clienteG.getDPI()) + "\";\n");
                }
            }
            BW.write("}" + "\n");
            BW.write("}" + "\n");

        }

        BW.close();
        //RETORNAMOS LA RUTA PARA CREAR EL GRÁFICO
        return rutaAbsoluta;
    }

    public static Path lista_doble_ciruclar_GRAPHVIZ() throws IOException {
        //VARIABLES PARA OBTENER LOS DATOS DE LOS CONDUTORES EN LA LISTA
        Conductor conductor;
        Conductor inicial;
        Conductor ultimo;

        //NODOS PARA OBTENER LA INFORMACIÓN DEL PRIMER Y ÚLTIMO NODO
        inicial = conductores.retornarNodobyIndex(0);
        ultimo = conductores.retornarNodobyIndex(conductores.tamanioLista());

        //VARIALBES PARA CREAR NUESTRO ARCHIVO .DOT CON SU RUTA
        String ARCHIVO = "Conductores.dot";
        Path rutaRelativa = Paths.get(ARCHIVO);
        Path rutaAbsoluta = rutaRelativa.toAbsolutePath();
        //IMPRIMIR LA RUTA PARA REVISAR
        System.out.println(rutaAbsoluta);
        //CREAMOS EL ARCHIVO EN LA RUTA ABSOLUTA DE NUESTRO PROYECTO
        File archivo = new File(rutaAbsoluta.toString());
        BufferedWriter BW;

        //SI EXISTE NUESTRO ARCHIVO SOLO LO EDITAMOS
        if (archivo.exists()) {
            BW = new BufferedWriter(new FileWriter(archivo));
            BW.write("digraph DoublyCList {\n");
            BW.write("subgraph cluster_0{\n");
            BW.write("style=filled;\n");
            BW.write("color=black;");
            BW.write("node[shape=record];\n");
            BW.write("rankdir=TB;\n");
            for (int i = 1; i < conductores.tamanioLista() + 1; i++) {
                conductor = conductores.retornarNodobyIndex(i);
                BW.write(String.valueOf(conductor.getDPI()) + "[label=\"{<before>|<ID>" + String.valueOf(conductor.getDPI()) + "|<data>" + conductor.getNombres().replace(" ", "") + "|<next>}\" style=\"filled\" fillcolor=\"indigo\" color=\"lightseagreen\" fontcolor=\"whitesmoke\" penwidth=3];\n");
            }
            BW.write("edge[tailclip=false,arrowtail=dot,dir=both style=filled fillcolor=\"red\" color=\"red\"];\n");
            BW.write("{node[shape=point height=0] p0 p4}" + "\n");
            BW.write("p0:n -> \"" + String.valueOf(inicial.getDPI()) + "\"[arrowtail=none];\n");
            BW.write("p0:s -> p4:s[arrowtail=none];\n");

            for (int i = 1; i < conductores.tamanioLista(); i++) {
                String prev;
                conductor = conductores.retornarNodobyIndex(i);
                prev = String.valueOf(conductor.getDPI());
                BW.write(String.valueOf(conductor.getDPI()) + ":next:c ->");
                conductor = conductores.retornarNodobyIndex(i + 1);
                BW.write(String.valueOf(conductor.getDPI()) + ":before;\n");
                BW.write(String.valueOf(conductor.getDPI()) + ":before:c ->" + prev + ":next;\n");
            }
            //BW.write(String.valueOf(inicial.getDPI())+":before:c ->"+String.valueOf(ultimo.getDPI())+":next;\n");
            //BW.write(String.valueOf(ultimo.getDPI())+":next:c ->"+ String.valueOf(inicial.getDPI())+":before;\n");
            BW.write(String.valueOf(ultimo.getDPI()) + ":next:c -> p4:n[arrowhead=none]\n");
            BW.write("}" + "\n");
            BW.write("}" + "\n");
            //SI NO EXISTE CREAMOS UNO NUEVO Y LLENAMOS DE INFORMACIÓN
        } else {
            BW = new BufferedWriter(new FileWriter(archivo));
            BW.write("digraph DoublyCList {\n");
            BW.write("subgraph cluster_0{\n");
            BW.write("style=filled;\n");
            BW.write("color=black;");
            BW.write("node[shape=record];\n");
            BW.write("rankdir=TB;\n");
            for (int i = 1; i < conductores.tamanioLista() + 1; i++) {
                conductor = conductores.retornarNodobyIndex(i);
                BW.write(String.valueOf(conductor.getDPI()) + "[label=\"{<before>|<ID>" + String.valueOf(conductor.getDPI()) + "|<data>" + conductor.getNombres().replace(" ", "") + "|<next>}\" style=\"filled\" fillcolor=\"indigo\" color=\"lightseagreen\" fontcolor=\"whitesmoke\" penwidth=3];\n");
            }
            BW.write("edge[tailclip=false,arrowtail=dot,dir=both style=filled fillcolor=\"red\" color=\"red\"];\n");
            BW.write("{node[shape=point height=0] p0 p4}" + "\n");
            BW.write("p0:n -> \"" + String.valueOf(inicial.getDPI()) + "\"[arrowtail=none];\n");
            BW.write("p0:s -> p4:s[arrowtail=none];\n");

            for (int i = 1; i < conductores.tamanioLista(); i++) {
                String prev;
                conductor = conductores.retornarNodobyIndex(i);
                prev = String.valueOf(conductor.getDPI());
                BW.write(String.valueOf(conductor.getDPI()) + ":next:c ->");
                conductor = conductores.retornarNodobyIndex(i + 1);
                BW.write(String.valueOf(conductor.getDPI()) + ":before;\n");
                BW.write(String.valueOf(conductor.getDPI()) + ":before:c ->" + prev + ":next;\n");
            }
            //BW.write(String.valueOf(inicial.getDPI())+":before:c ->"+String.valueOf(ultimo.getDPI())+":next;\n");
            //BW.write(String.valueOf(ultimo.getDPI())+":next:c ->"+ String.valueOf(inicial.getDPI())+":before;\n");
            BW.write(String.valueOf(ultimo.getDPI()) + ":next:c -> p4:n[arrowhead=none]\n");
            BW.write("}" + "\n");
            BW.write("}" + "\n");

        }
        BW.close();
        //RETORNAMOS LA RUTA PARA CREAR EL GRÁFICO
        return rutaAbsoluta;
    }

    public static Path block_chain_GRAPHVIZ() throws IOException, Exception {
        nodo_bloque aux, aux2;
        //VARIALBES PARA CREAR NUESTRO ARCHIVO .DOT CON SU RUTA
        String ARCHIVO = "Viajes.dot";
        Path rutaRelativa = Paths.get(ARCHIVO);
        Path rutaAbsoluta = rutaRelativa.toAbsolutePath();
        //IMPRIMIR LA RUTA PARA REVISAR
        System.out.println(rutaAbsoluta);
        //CREAMOS EL ARCHIVO EN LA RUTA ABSOLUTA DE NUESTRO PROYECTO
        File archivo = new File(rutaAbsoluta.toString());
        BufferedWriter BW;
        //SI EXISTE NUESTRO ARCHIVO SOLO LO EDITAMOS
        if (archivo.exists()) {
            Viaje miViaje, viaje2;
            BW = new BufferedWriter(new FileWriter(archivo));
            BW.write("digraph BlockChain {\n");
            BW.write("node[shape=component style=\"solid\" color=\"blue\" fontcolor = \"black\" penwidth=3];\n");
            BW.write("edge[style=filled fillcolor=\"darkgreen\" color=\"darkgoldenrod3\"];\n");
            BW.write("rankdir=LR;\n");
            BW.write("subgraph cluster_0{\n");
            BW.write("style=filled;\n");
            BW.write("color=white;\n");

            aux = viajes.retornarBloque(0);
            miViaje = (Viaje) aux.getTransaccion();
            BW.write("\"" + aux.getLlave() + "\"[label=\"" + aux.getLlave() + "\n" + " FECHA: " + aux.getSelloTiempo() + "\n"
                    + "CLIENTE: " + String.valueOf(miViaje.getCliente().retornarNodobyIndex(0).getDPI()) + "\n"
                    + "CONDUCTOR: " + String.valueOf(miViaje.getConductor().retornarNodobyIndex(0).getDPI()) + "\n"
                    + "VEHICULO: " + String.valueOf(miViaje.getVehiculo().retornarNodobyIndex(0).getPlaca()) + "\"];" + "\n");
            for (int j = 0; j < miViaje.getViaje().getSize(); j++) {
                BW.write("\"0" + miViaje.getViaje().get(j) + "\"" + "[label=\"" + miViaje.getViaje().get(j)
                        + "\n" + miViaje.getPesoCamino().get(j) + "\"];" + "\n");
            }
            for (int j = 0; j < miViaje.getViaje().getSize() - 1; j++) {
                BW.write("\"0" + miViaje.getViaje().get(j) + "\"" + "->" + "\"0" + miViaje.getViaje().get(j + 1) + "\"" + "\n");
            }
            BW.write("{ rank = same;\"" + aux.getLlave() + "\";");
            for (int j = 0; j < miViaje.getViaje().getSize(); j++) {
                BW.write("\"0" + miViaje.getViaje().get(j) + "\"" + ";");
            }
            BW.write("}\n");
            BW.write("\"" + aux.getLlave() + "\"->" + "\"0" + miViaje.getViaje().get(0) + "\"");

            for (int i = 1; i < viajes.tamanioCadena(); i++) {
                viaje2 = new Viaje();
                aux2 = viajes.retornarBloque(i);
                viaje2 = (Viaje) aux2.getTransaccion();
                BW.write("\"" + aux2.getLlave() + "\"[label=\"" + aux2.getLlaveAnterior() + "\n" + " FECHA: " + aux2.getSelloTiempo() + "\n"
                        + "CLIENTE: " + String.valueOf(viaje2.getCliente().retornarNodobyIndex(1).getDPI()) + "\n"
                        + "CONDUCTOR: " + String.valueOf(viaje2.getConductor().retornarNodobyIndex(0).getDPI()) + "\n"
                        + "VEHICULO: " + String.valueOf(viaje2.getVehiculo().retornarNodobyIndex(0).getPlaca()) + "\"];" + "\n");

                for (int j = 0; j < viaje2.getViaje().getSize(); j++) {
                    BW.write("\"" + i + viaje2.getViaje().get(j) + "\"" + "[label=\"" + viaje2.getViaje().get(j)
                            + "\n" + viaje2.getPesoCamino().get(j) + "\"];" + "\n");
                }
                for (int j = 0; j < viaje2.getViaje().getSize() - 1; j++) {
                    BW.write("\"" + i + viaje2.getViaje().get(j) + "\"" + "->" + "\"" + i + viaje2.getViaje().get(j + 1) + "\"" + "\n");
                }
                BW.write("{ rank = same;\"" + aux2.getLlave() + "\";");
                for (int j = 0; j < viaje2.getViaje().getSize(); j++) {
                    BW.write("\"" + i + viaje2.getViaje().get(j) + "\"" + ";");
                }
                BW.write("}\n");
                BW.write("\"" + aux2.getLlave() + "\"->" + "\"" + i + viaje2.getViaje().get(0) + "\"" + "\n");

            }
            for (int i = 1; i < viajes.tamanioCadena(); i++) {
                aux = viajes.retornarBloque(i);
                BW.write("\"" + aux.getLlaveAnterior() + "\"->\"" + aux.getLlave() + "\"" + "\n");
            }
            BW.write("}" + "\n");
            BW.write("}" + "\n");
        } //SI NO EXISTE CREAMOS UNO NUEVO Y LLENAMOS DE INFORMACIÓN
        else {
            Viaje miViaje, viaje2;
            BW = new BufferedWriter(new FileWriter(archivo));
            BW.write("digraph BlockChain {\n");
            BW.write("node[shape=component style=\"solid\" color=\"blue\" fontcolor = \"black\" penwidth=3];\n");
            BW.write("edge[style=filled fillcolor=\"darkgreen\" color=\"darkgoldenrod3\"];\n");
            BW.write("rankdir=LR;\n");
            BW.write("subgraph cluster_0{\n");
            BW.write("style=filled;\n");
            BW.write("color=white;\n");

            aux = viajes.retornarBloque(0);
            miViaje = (Viaje) aux.getTransaccion();
            BW.write("\"" + aux.getLlave() + "\"[label=\"" + aux.getLlave() + "\n" + " FECHA: " + aux.getSelloTiempo() + "\n"
                    + "CLIENTE: " + String.valueOf(miViaje.getCliente().retornarNodobyIndex(0).getDPI()) + "\n"
                    + "CONDUCTOR: " + String.valueOf(miViaje.getConductor().retornarNodobyIndex(0).getDPI()) + "\n"
                    + "VEHICULO: " + String.valueOf(miViaje.getVehiculo().retornarNodobyIndex(0).getPlaca()) + "\"];" + "\n");
            for (int j = 0; j < miViaje.getViaje().getSize(); j++) {
                BW.write("\"0" + miViaje.getViaje().get(j) + "\"" + "[label=\"" + miViaje.getViaje().get(j)
                        + "\n" + miViaje.getPesoCamino().get(j) + "\"];" + "\n");
            }
            for (int j = 0; j < miViaje.getViaje().getSize() - 1; j++) {
                BW.write("\"0" + miViaje.getViaje().get(j) + "\"" + "->" + "\"0" + miViaje.getViaje().get(j + 1) + "\"" + "\n");
            }
            BW.write("{ rank = same;\"" + aux.getLlave() + "\";");
            for (int j = 0; j < miViaje.getViaje().getSize(); j++) {
                BW.write("\"0" + miViaje.getViaje().get(j) + "\"" + ";");
            }
            BW.write("}\n");
            BW.write("\"" + aux.getLlave() + "\"->" + "\"0" + miViaje.getViaje().get(0) + "\"");

            for (int i = 1; i < viajes.tamanioCadena(); i++) {
                viaje2 = new Viaje();
                aux2 = viajes.retornarBloque(i);
                viaje2 = (Viaje) aux2.getTransaccion();
                BW.write("\"" + aux2.getLlave() + "\"[label=\"" + aux2.getLlaveAnterior() + "\n" + " FECHA: " + aux2.getSelloTiempo() + "\n"
                        + "CLIENTE: " + String.valueOf(viaje2.getCliente().retornarNodobyIndex(1).getDPI()) + "\n"
                        + "CONDUCTOR: " + String.valueOf(viaje2.getConductor().retornarNodobyIndex(0).getDPI()) + "\n"
                        + "VEHICULO: " + String.valueOf(viaje2.getVehiculo().retornarNodobyIndex(0).getPlaca()) + "\"];" + "\n");

                for (int j = 0; j < viaje2.getViaje().getSize(); j++) {
                    BW.write("\"" + i + viaje2.getViaje().get(j) + "\"" + "[label=\"" + viaje2.getViaje().get(j)
                            + "\n" + viaje2.getPesoCamino().get(j) + "\"];" + "\n");
                }
                for (int j = 0; j < viaje2.getViaje().getSize() - 1; j++) {
                    BW.write("\"" + i + viaje2.getViaje().get(j) + "\"" + "->" + "\"" + i + viaje2.getViaje().get(j + 1) + "\"" + "\n");
                }
                BW.write("{ rank = same;\"" + aux2.getLlave() + "\";");
                for (int j = 0; j < viaje2.getViaje().getSize(); j++) {
                    BW.write("\"" + i + viaje2.getViaje().get(j) + "\"" + ";");
                }
                BW.write("}\n");
                BW.write("\"" + aux2.getLlave() + "\"->" + "\"" + i + viaje2.getViaje().get(0) + "\"" + "\n");

            }
            for (int i = 1; i < viajes.tamanioCadena(); i++) {
                aux = viajes.retornarBloque(i);
                BW.write("\"" + aux.getLlaveAnterior() + "\"->\"" + aux.getLlave() + "\"" + "\n");
            }
            BW.write("}" + "\n");
            BW.write("}" + "\n");
        }

        BW.close();
        //RETORNAMOS LA RUTA PARA CREAR EL GRÁFICO
        return rutaAbsoluta;

    }

    public static void dibujarGRAPHVIZ(Path dot, String png) {
        try {
            //CREAMOS UN PROCESO PARA LLAMAR LA FUNCIÓN DOT
            ProcessBuilder graficarDot;
            //CREAMOS EL CONSTRUCTOR CON LOS PARAMETROS DE LA FUNCIÓN
            graficarDot = new ProcessBuilder("dot", "-Tpng", "-Gdpi=300", "-o", png, dot.toString());
            //VERIFICA O REDIRIGE SI HAY UN ERROR
            graficarDot.redirectErrorStream(true);
            //EJECUTA LA FUCNIÓN
            graficarDot.start();
        } catch (IOException e) {
        }
    }
}
