/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Carga;
import clases.Conductor;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
//import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Alejandro Lorenty
 */
public class menu_Conductor extends javax.swing.JFrame {

    private int x;
    private int y;
    private DefaultTableModel modeloConductores;
    private ImageIcon fondo = new ImageIcon("src/imagenes/conductor.png");
    private long edit;

    /**
     * Creates new form menu_Conductor
     */
    public menu_Conductor() {
        initComponents();
        correrTabla();
    }

    public void correrTabla() {
        modeloConductores = (DefaultTableModel) this.ConductoresTabla.getModel();
        Conductor c;

        modeloConductores.setRowCount(0);
        modeloConductores.setColumnCount(0);

        modeloConductores.setNumRows(0);
        modeloConductores.addColumn("DPI");
        modeloConductores.addColumn("Nombre");
        modeloConductores.addColumn("Apellido");
        modeloConductores.addColumn("Licencia");
        modeloConductores.addColumn("Genero");
        modeloConductores.addColumn("Nacimiento");
        modeloConductores.addColumn("Telefono");
        modeloConductores.addColumn("Direccion");

        //ConductoresTabla.setRowSorter(filtro);
        if (Carga.conductores.tamanioLista() != 0) {
            for (int i = 1; i < Carga.conductores.tamanioLista() + 1; i++) {
                c = Carga.conductores.retornarNodobyIndex(i);
                modeloConductores.addRow(new Object[]{c.getDPI(), c.getNombres(), c.getApellidos(), c.getLicencia(),
                    c.getGenero(), c.getFecha_nac(), c.getTelefono(), c.getDireccion()});
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ConductoresTabla = ConductoresTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        LimpiarBoton = new javax.swing.JButton();
        EliminarBoton = new javax.swing.JButton();
        CrearBoton = new javax.swing.JButton();
        ImagenBoton = new javax.swing.JButton();
        grafico = new javax.swing.JButton();
        selecionar = new javax.swing.JButton();
        buscarLabel = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();
        Salir = new javax.swing.JLabel();
        direccionLabel1 = new javax.swing.JLabel();
        licencia = new javax.swing.JComboBox<>();
        direccionLabel = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        telefonoLabel = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        fechaLabel = new javax.swing.JLabel();
        anio = new javax.swing.JComboBox<>();
        mes = new javax.swing.JComboBox<>();
        dia = new javax.swing.JComboBox<>();
        generoLabel = new javax.swing.JLabel();
        genero = new javax.swing.JComboBox<>();
        apellidoLabel = new javax.swing.JLabel();
        apellido = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        dpiLabel = new javax.swing.JLabel();
        DPI = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ConductoresTabla.setBackground(new java.awt.Color(0, 0, 0));
        ConductoresTabla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ConductoresTabla.setForeground(new java.awt.Color(102, 51, 0));
        ConductoresTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(ConductoresTabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 1010, 290));

        LimpiarBoton.setBackground(new java.awt.Color(255, 255, 255));
        LimpiarBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/limpiar.png"))); // NOI18N
        LimpiarBoton.setText("LIMPIAR");
        LimpiarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarBotonActionPerformed(evt);
            }
        });
        jPanel1.add(LimpiarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        EliminarBoton.setBackground(new java.awt.Color(255, 255, 255));
        EliminarBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/eliminar.png"))); // NOI18N
        EliminarBoton.setText("ELIMINAR");
        EliminarBoton.setEnabled(false);
        EliminarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarBotonActionPerformed(evt);
            }
        });
        jPanel1.add(EliminarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, -1, -1));

        CrearBoton.setBackground(new java.awt.Color(255, 255, 255));
        CrearBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/crear.png"))); // NOI18N
        CrearBoton.setText("CREAR");
        CrearBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearBotonActionPerformed(evt);
            }
        });
        jPanel1.add(CrearBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, -1, -1));

        ImagenBoton.setBackground(new java.awt.Color(255, 255, 255));
        ImagenBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/imagen.png"))); // NOI18N
        ImagenBoton.setText("IMAGEN");
        ImagenBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImagenBotonActionPerformed(evt);
            }
        });
        jPanel1.add(ImagenBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 200, -1, -1));

        grafico.setBackground(new java.awt.Color(255, 255, 255));
        grafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/graphviz.png"))); // NOI18N
        grafico.setText("GRAPHVIZ");
        grafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficoActionPerformed(evt);
            }
        });
        jPanel1.add(grafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, -1, -1));

        selecionar.setBackground(new java.awt.Color(255, 255, 255));
        selecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/seleccionar.png"))); // NOI18N
        selecionar.setText("SELECCIONAR");
        selecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionarActionPerformed(evt);
            }
        });
        jPanel1.add(selecionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 340, -1, -1));

        buscarLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscarLabel.setForeground(new java.awt.Color(255, 255, 255));
        buscarLabel.setText("BUSCAR:");
        jPanel1.add(buscarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, -1, -1));

        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarKeyTyped(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, 100, -1));

        errorLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 750, 20));

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/logout72.png"))); // NOI18N
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        jPanel1.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, -1));

        direccionLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        direccionLabel1.setForeground(new java.awt.Color(255, 255, 255));
        direccionLabel1.setText("LICENCIA:");
        jPanel1.add(direccionLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        licencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione uno ...", "A", "B", "C" }));
        jPanel1.add(licencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 150, -1));

        direccionLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        direccionLabel.setForeground(new java.awt.Color(255, 255, 255));
        direccionLabel.setText("DIRECCION:");
        jPanel1.add(direccionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));
        jPanel1.add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 150, -1));

        telefonoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        telefonoLabel.setForeground(new java.awt.Color(255, 255, 255));
        telefonoLabel.setText("TELEFONO:");
        jPanel1.add(telefonoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });
        jPanel1.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 150, -1));

        fechaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fechaLabel.setForeground(new java.awt.Color(255, 255, 255));
        fechaLabel.setText("NACIMIENTO:");
        jPanel1.add(fechaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        anio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0000", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003" }));
        jPanel1.add(anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

        mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        jPanel1.add(mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, -1));

        dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel1.add(dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        generoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        generoLabel.setForeground(new java.awt.Color(255, 255, 255));
        generoLabel.setText("GENERO:");
        jPanel1.add(generoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione uno ...", "Masculino", "Femenino", "No deseo especificar", "Helicoptero Apache de Guerra" }));
        jPanel1.add(genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 150, -1));

        apellidoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        apellidoLabel.setForeground(new java.awt.Color(255, 255, 255));
        apellidoLabel.setText("APELLIDOS:");
        jPanel1.add(apellidoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidoKeyTyped(evt);
            }
        });
        jPanel1.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 150, -1));

        nombreLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombreLabel.setForeground(new java.awt.Color(255, 255, 255));
        nombreLabel.setText("NOMBRES:");
        jPanel1.add(nombreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 150, -1));

        dpiLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dpiLabel.setForeground(new java.awt.Color(255, 255, 255));
        dpiLabel.setText("DPI:");
        jPanel1.add(dpiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        DPI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DPIKeyTyped(evt);
            }
        });
        jPanel1.add(DPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 150, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DE CONDUCTORES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, -1, -1));

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/conductor.png"))); // NOI18N
        jPanel1.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_SalirMouseClicked

    private void DPIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DPIKeyTyped
        char c = evt.getKeyChar();
        //SOLO SE ADMITIRÁN NÚMEROS EN ESTE TEXTBOX
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            errorLabel.setText("SOLO NUMEROS PARA EL DPI");
        }
        //LIMITAR NUMERO PARA DPI {XXXX XXXXX XXXX}
        if (DPI.getText().length() == 13 && Character.isDigit(c)) {
            evt.consume();
            errorLabel.setText("");
        } else if (DPI.getText().length() < 13 && Character.isDigit(c)) {
            errorLabel.setText("EL DPI DEBE RESPETAR SU TAMAÑO {XXXX XXXXX XXXX}");
        }
    }//GEN-LAST:event_DPIKeyTyped

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        char c = evt.getKeyChar();
        //SOLO SE ADMITIRÁN NÚMEROS EN ESTE TEXTBOX
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            errorLabel.setText("SOLO NUMEROS PARA EL TELEFONO");
        }
        //LIMITAR NUMERO PARA TELEFONO {XXXX XXXX}
        if (telefono.getText().length() == 8 && Character.isDigit(c)) {
            evt.consume();
            errorLabel.setText("");
        } else if (telefono.getText().length() < 8 && Character.isDigit(c)) {
            errorLabel.setText("EL TELEFONO DEBE RESPETAR SU TAMAÑO {XXXX XXXX}");
        }
    }//GEN-LAST:event_telefonoKeyTyped

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        char c = evt.getKeyChar();
        //SOLO SE ADMITIRÁN LETRAS EN ESTE TEXTBOX
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            errorLabel.setText("SOLO LETRAS PARA SU NOMBRE");
        }
    }//GEN-LAST:event_nombreKeyTyped

    private void apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidoKeyTyped
        char c = evt.getKeyChar();
        //SOLO SE ADMITIRÁN LETRAS EN ESTE TEXTBOX
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            errorLabel.setText("SOLO LETRAS PARA SU APELLIDO");
        }
    }//GEN-LAST:event_apellidoKeyTyped

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        TableRowSorter<TableModel> filtro = new TableRowSorter<>(ConductoresTabla.getModel());
        ConductoresTabla.setRowSorter(filtro);
        String text = buscar.getText();
        if (text.trim().length() == 0) {
            filtro.setRowFilter(null);
        } else {
            filtro.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }//GEN-LAST:event_buscarKeyTyped

    private void CrearBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearBotonActionPerformed

        if (CrearBoton.getText().equals("CREAR")) {
            if (!DPI.getText().isEmpty() && !nombre.getText().isEmpty()
                    && !apellido.getText().isEmpty() && !genero.getSelectedItem().toString().equals("Seleccione uno ...")
                    && !dia.getSelectedItem().toString().equals("00") && !mes.getSelectedItem().toString().equals("00")
                    && !anio.getSelectedItem().toString().equals("0000") && !telefono.getText().isEmpty()
                    && !direccion.getText().isEmpty() && !licencia.getSelectedItem().toString().equals("Seleccione uno ...")) {
                if (DPI.getText().length() < 13 || telefono.getText().length() < 8) {
                    errorLabel.setText("RESPETAR TODAS LAS RESTRICCIONES DE DATOS");
                } else {
                    System.out.println("CAMPOS LLENADOS CORRECTAMENTE");
                    Conductor nuevoConductor = new Conductor();
                    nuevoConductor.setDPI(Long.parseLong(DPI.getText().trim()));
                    nuevoConductor.setNombres(nombre.getText().trim());
                    nuevoConductor.setApellidos(apellido.getText().trim());
                    nuevoConductor.setLicencia(licencia.getSelectedItem().toString().trim().charAt(0));
                    nuevoConductor.setGenero(genero.getSelectedItem().toString().trim());
                    nuevoConductor.setFecha_nac(dia.getSelectedItem().toString() + "/" + mes.getSelectedItem().toString() + "/"
                            + anio.getSelectedItem().toString());
                    nuevoConductor.setTelefono(Integer.parseInt(telefono.getText().trim()));
                    nuevoConductor.setDireccion(direccion.getText().trim());

                    System.out.println(nuevoConductor.toString());
                    Carga.conductores.insertarOrdenado(nuevoConductor, nuevoConductor.getDPI());

                    for (Component component : jPanel1.getComponents()) {
                        if (component instanceof JTextField) {
                            ((JTextField) component).setText("");
                        }
                    }
                    for (Component component : jPanel1.getComponents()) {
                        if (component instanceof JComboBox) {
                            ((JComboBox) component).setSelectedIndex(0);
                        }
                    }
                    //ConductoresTabla.setVisible(true);
                    //SwingUtilities.updateComponentTreeUI(jPanel1);
                }

            } else {
                errorLabel.setText("LLENAR TODOS LOS CAMPOS");
            }
        } else {
            if (!DPI.getText().isEmpty() && !nombre.getText().isEmpty()
                    && !apellido.getText().isEmpty() && !genero.getSelectedItem().toString().equals("Seleccione uno ...")
                    && !dia.getSelectedItem().toString().equals("00") && !mes.getSelectedItem().toString().equals("00")
                    && !anio.getSelectedItem().toString().equals("0000") && !telefono.getText().isEmpty()
                    && !direccion.getText().isEmpty() && !licencia.getSelectedItem().toString().equals("Seleccione uno ...")) {
                if (DPI.getText().length() < 13 || telefono.getText().length() < 8) {
                    errorLabel.setText("RESPETAR TODAS LAS RESTRICCIONES DE DATOS");
                } else {
                    System.out.println("CAMPOS LLENADOS CORRECTAMENTE");
                    Conductor nuevoConductor = new Conductor();
                    nuevoConductor.setDPI(Long.parseLong(DPI.getText().trim()));
                    nuevoConductor.setNombres(nombre.getText().trim());
                    nuevoConductor.setApellidos(apellido.getText().trim());
                    nuevoConductor.setLicencia(licencia.getSelectedItem().toString().trim().charAt(0));
                    nuevoConductor.setGenero(genero.getSelectedItem().toString().trim());
                    nuevoConductor.setFecha_nac(dia.getSelectedItem().toString() + "/" + mes.getSelectedItem().toString() + "/"
                            + anio.getSelectedItem().toString());
                    nuevoConductor.setTelefono(Integer.parseInt(telefono.getText().trim()));
                    nuevoConductor.setDireccion(direccion.getText().trim());

                    System.out.println(nuevoConductor.toString());
                    Carga.conductores.eliminarNodo(this.edit);
                    Carga.conductores.insertarOrdenado(nuevoConductor, nuevoConductor.getDPI());

                    for (Component component : jPanel1.getComponents()) {
                        if (component instanceof JTextField) {
                            ((JTextField) component).setText("");
                        }
                    }
                    for (Component component : jPanel1.getComponents()) {
                        if (component instanceof JComboBox) {
                            ((JComboBox) component).setSelectedIndex(0);
                        }
                    }
                    CrearBoton.setText("CREAR");
                    //ConductoresTabla.setVisible(true);
                    //SwingUtilities.updateComponentTreeUI(jPanel1);
                }

            } else {
                errorLabel.setText("LLENAR TODOS LOS CAMPOS");
            }
        }
        CrearBoton.setText("CREAR");
        CrearBoton.setIcon(new ImageIcon("src/imagenes/iconos/crear.png"));
        CrearBoton.repaint();
        EliminarBoton.setEnabled(false);
        correrTabla();
        modeloConductores.fireTableDataChanged();
        //ConductoresTabla.repaint();
    }//GEN-LAST:event_CrearBotonActionPerformed

    private void selecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionarActionPerformed
        if (ConductoresTabla.getSelectedRow() != -1) {
            long dpi = Long.parseLong(String.valueOf(ConductoresTabla.getValueAt(ConductoresTabla.getSelectedRow(), 0)));
            System.out.println(dpi);
            Conductor eC;
            eC = Carga.conductores.retornarDato(dpi);
            DPI.setText(String.valueOf(eC.getDPI()));
            nombre.setText(eC.getNombres());
            apellido.setText(eC.getApellidos());
            licencia.setSelectedItem(String.valueOf(eC.getLicencia()));
            genero.setSelectedItem(eC.getGenero());

            String[] fecha = eC.getFecha_nac().split("/");
            dia.setSelectedItem(fecha[0]);
            mes.setSelectedItem(fecha[1]);
            anio.setSelectedItem(fecha[2]);

            telefono.setText(String.valueOf(eC.getTelefono()));
            direccion.setText(eC.getDireccion());
            ConductoresTabla.clearSelection();
            errorLabel.setText("");

            CrearBoton.setText("EDITAR");
            CrearBoton.setIcon(new ImageIcon("src/imagenes/iconos/editar.png"));
            CrearBoton.repaint();
            EliminarBoton.setEnabled(true);
            this.edit = eC.getDPI();
        } else {
            errorLabel.setText("SELECCIONE UN CONDUCTOR ANTES");
        }

    }//GEN-LAST:event_selecionarActionPerformed

    private void graficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficoActionPerformed
        //MÉTODO PARA CREAR EL ARCHIVO.DOT Y LA IMAGEN.PNG
        try {
            Path CMD = Carga.lista_doble_ciruclar_GRAPHVIZ();
            Carga.dibujarGRAPHVIZ(CMD, "Conductores.png");
        } catch (IOException ex) {
            Logger.getLogger(carga_Masiva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_graficoActionPerformed

    private void EliminarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBotonActionPerformed
        long dpi = Long.parseLong(String.valueOf(DPI.getText()));
        System.out.println(dpi);
        Carga.conductores.eliminarNodo(dpi);

        for (Component component : jPanel1.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            }
        }
        for (Component component : jPanel1.getComponents()) {
            if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);
            }
        }
        CrearBoton.setText("CREAR");
        CrearBoton.setIcon(new ImageIcon("src/imagenes/iconos/crear.png"));
        CrearBoton.repaint();
        correrTabla();
        modeloConductores.fireTableDataChanged();
        EliminarBoton.setEnabled(false);
    }//GEN-LAST:event_EliminarBotonActionPerformed

    private void LimpiarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarBotonActionPerformed
        for (Component component : jPanel1.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            }
        }
        for (Component component : jPanel1.getComponents()) {
            if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);
            }
        }
        CrearBoton.setText("CREAR");
        CrearBoton.setIcon(new ImageIcon("src/imagenes/iconos/crear.png"));
        CrearBoton.repaint();
        EliminarBoton.setEnabled(false);
    }//GEN-LAST:event_LimpiarBotonActionPerformed

    private void ImagenBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImagenBotonActionPerformed
        File miGraphviz = new File("Conductores.png");
        try {
            Desktop.getDesktop().open(miGraphviz);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "IMAGEN CARGANDO");
        }
        mostrador_imagen imagen = new mostrador_imagen();
        ImageIcon foto = new ImageIcon("./Conductores.png");
        Icon icono = new ImageIcon(foto.getImage().getScaledInstance(imagen.GraphvizLabel.getWidth(), imagen.GraphvizLabel.getHeight(), Image.SCALE_DEFAULT));
        imagen.GraphvizLabel.setIcon(icono);
        imagen.setVisible(true);
    }//GEN-LAST:event_ImagenBotonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu_Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_Conductor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ConductoresTabla;
    private javax.swing.JButton CrearBoton;
    private javax.swing.JTextField DPI;
    private javax.swing.JButton EliminarBoton;
    private javax.swing.JButton ImagenBoton;
    private javax.swing.JButton LimpiarBoton;
    private javax.swing.JLabel Salir;
    private javax.swing.JComboBox<String> anio;
    private javax.swing.JTextField apellido;
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JTextField buscar;
    private javax.swing.JLabel buscarLabel;
    private javax.swing.JComboBox<String> dia;
    private javax.swing.JTextField direccion;
    private javax.swing.JLabel direccionLabel;
    private javax.swing.JLabel direccionLabel1;
    private javax.swing.JLabel dpiLabel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JComboBox<String> genero;
    private javax.swing.JLabel generoLabel;
    private javax.swing.JButton grafico;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> licencia;
    private javax.swing.JComboBox<String> mes;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JButton selecionar;
    private javax.swing.JTextField telefono;
    private javax.swing.JLabel telefonoLabel;
    // End of variables declaration//GEN-END:variables
}
