/**
 *
 * @author Alejandro Lorenty
 */
package clases;

import estructuras.arbol_por_paginas;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import estructuras.lista_enlazada_doble_circular;

/*
     *
     *
     *CLASE PARA CARGAR Y GRAFICAR TODAS LAS ESTRUCTURAS
 */
public class Carga {

    static lista_enlazada_doble_circular<Conductor, Long> conductores = new lista_enlazada_doble_circular();
    public static arbol_por_paginas vehiculos=new arbol_por_paginas(2);      

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
                    vehiculos.agregar_datos(nuevoVehiculo);

                    




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

                    System.out.println(nuevaRuta.toString());
                }

                linea = BR.readLine();
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());

        }
    }
//************************************************************************************************
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
            BW.write("node[shape=record];\n");
            BW.write("rankdir=TB;\n");
            for (int i = 1; i < conductores.tamanioLista() + 1; i++) {
                conductor = conductores.retornarNodobyIndex(i);
                BW.write(String.valueOf(conductor.getDPI()) + "[label=\"{<before>|<ID>" + String.valueOf(conductor.getDPI()) + "|<data>" + conductor.getNombres().replace(" ", "") + "|<next>}\" style=\"filled\" fillcolor=\"indigo\" color=\"lightseagreen\" fontcolor=\"whitesmoke\" penwidth=3];\n");
            }
            BW.write("edge[tailclip=false,arrowtail=dot,dir=both style=filled fillcolor=\"red\"];\n");
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
            BW.write("}");

        //SI NO EXISTE CREAMOS UNO NUEVO Y LLENAMOS DE INFORMACIÓN
        } else {
            BW = new BufferedWriter(new FileWriter(archivo));
            BW.write("digraph DoublyCList {\n");
            BW.write("node[shape=record];\n");
            BW.write("rankdir=TB;\n");
            for (int i = 1; i < conductores.tamanioLista() + 1; i++) {
                conductor = conductores.retornarNodobyIndex(i);
                BW.write(String.valueOf(conductor.getDPI()) + "[label=\"{<before>|<ID>" + String.valueOf(conductor.getDPI()) + "|<data>" + conductor.getNombres().replace(" ", "") + "|<next>}\" style=\"filled\" fillcolor=\"indigo\" color=\"lightseagreen\" fontcolor=\"whitesmoke\" penwidth=3];\n");
            }
            BW.write("edge[tailclip=false,arrowtail=dot,dir=both style=filled fillcolor=\"red\"];\n");
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
            BW.write("}");

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
            graficarDot = new ProcessBuilder("dot", "-Tpng","-Gdpi=300" ,"-o", png, dot.toString());
            //VERIFICA O REDIRIGE SI HAY UN ERROR
            graficarDot.redirectErrorStream(true);
            //EJECUTA LA FUCNIÓN
            graficarDot.start();
        } catch (IOException e) {
        }
    }
}
