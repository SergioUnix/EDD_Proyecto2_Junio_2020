/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Carga;
import clases.Conductor;
import clases.Graficas;
import clases.Vehiculo;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class menu_Rutas extends javax.swing.JFrame {

     
    private int x;
    private int y;
    String nombre;
    Pattern pat;
    Matcher mat;
    private DefaultTableModel modeloVehiculos;
    public ImageIcon fondo = new ImageIcon("src/imagenes/rutas.jpg");

    /**
     * Creates new form menu_Conductor
     */
    public menu_Rutas() {
        initComponents();
        correrTabla();
        variable();

        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TableRowSorter<TableModel> filtro = new TableRowSorter<>(VehiculosTabla.getModel());
                VehiculosTabla.setRowSorter(filtro);
                String text = buscar.getText();
                if (text.trim().length() == 0) {
                    filtro.setRowFilter(null);
                } else {
                    filtro.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                };

            }
        });

    }

    private void correrTabla() {
        modeloVehiculos = (DefaultTableModel) this.VehiculosTabla.getModel();
   

        modeloVehiculos.setRowCount(0);
        modeloVehiculos.setColumnCount(0);
        modeloVehiculos.setNumRows(0);
        modeloVehiculos.addColumn("No.Ruta");
        modeloVehiculos.addColumn("NOMBRE");

        //Rutas
        if (Carga.grafo.getSize()!= 0) {
            
            for (int i = 0; i < Carga.grafo.getSize(); i++) {
                
                modeloVehiculos.addRow(new Object[]{i+1, Carga.grafo.getRuta(i) });
            }
        }

    }

    public void variable() {
       

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
        VehiculosTabla = VehiculosTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        LimpiarBoton = new javax.swing.JButton();
        CrearBoton = new javax.swing.JButton();
        ImagenBoton = new javax.swing.JButton();
        grafico = new javax.swing.JButton();
        selecionar = new javax.swing.JButton();
        buscarLabel = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();
        Salir = new javax.swing.JLabel();
        apellidoLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        dpiLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        placa = new javax.swing.JTextField();
        marca = new javax.swing.JTextField();
        modelo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
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

        VehiculosTabla.setBackground(new java.awt.Color(0, 0, 0));
        VehiculosTabla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        VehiculosTabla.setForeground(new java.awt.Color(255, 0, 0));
        VehiculosTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(VehiculosTabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 1030, 170));

        LimpiarBoton.setBackground(new java.awt.Color(255, 255, 255));
        LimpiarBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/limpiar.png"))); // NOI18N
        LimpiarBoton.setText("LIMPIAR");
        LimpiarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarBotonActionPerformed(evt);
            }
        });
        jPanel1.add(LimpiarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        CrearBoton.setBackground(new java.awt.Color(255, 255, 255));
        CrearBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/crear.png"))); // NOI18N
        CrearBoton.setText("CREAR");
        CrearBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearBotonActionPerformed(evt);
            }
        });
        jPanel1.add(CrearBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        ImagenBoton.setBackground(new java.awt.Color(255, 255, 255));
        ImagenBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/imagen.png"))); // NOI18N
        ImagenBoton.setText("IMAGEN");
        ImagenBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImagenBotonActionPerformed(evt);
            }
        });
        jPanel1.add(ImagenBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, -1, -1));

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
        jPanel1.add(selecionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, -1, -1));

        buscarLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscarLabel.setForeground(new java.awt.Color(255, 255, 255));
        buscarLabel.setText("BUSCAR:");
        jPanel1.add(buscarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, -1, -1));

        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarKeyTyped(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 280, -1));

        errorLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 750, 20));

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/logout72.png"))); // NOI18N
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        jPanel1.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, -1));

        apellidoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        apellidoLabel.setForeground(new java.awt.Color(255, 255, 255));
        apellidoLabel.setText("Tiempo Ruta:");
        jPanel1.add(apellidoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        nombreLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombreLabel.setForeground(new java.awt.Color(255, 255, 255));
        nombreLabel.setText("Lugar Destino:");
        jPanel1.add(nombreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        dpiLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dpiLabel.setForeground(new java.awt.Color(255, 255, 255));
        dpiLabel.setText("Lugar Origen:");
        jPanel1.add(dpiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DE RUTAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        placa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                placaFocusLost(evt);
            }
        });
        placa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                placaKeyTyped(evt);
            }
        });
        jPanel1.add(placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 120, -1));

        marca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                marcaFocusLost(evt);
            }
        });
        marca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                marcaKeyTyped(evt);
            }
        });
        jPanel1.add(marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 120, -1));

        modelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                modeloKeyTyped(evt);
            }
        });
        jPanel1.add(modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 120, -1));

        jButton1.setText("prueba de llenado matriz adyacente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rutas.jpg"))); // NOI18N
        jPanel1.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        TableRowSorter<TableModel> filtro = new TableRowSorter<>(VehiculosTabla.getModel());
        VehiculosTabla.setRowSorter(filtro);
        String text = buscar.getText();
        if (text.trim().length() == 0) {
            filtro.setRowFilter(null);
        } else {
            filtro.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }//GEN-LAST:event_buscarKeyTyped

    private void CrearBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearBotonActionPerformed

        if (CrearBoton.getText().equals("CREAR")) {
            if (!placa.getText().isEmpty() && !marca.getText().isEmpty()
                    && !modelo.getText().isEmpty()) {
                if (placa.getText().length() < 6) {
                    errorLabel.setText("RESPETAR TODAS LAS RESTRICCIONES DE DATOS");
                } else {
                    System.out.println("CAMPOS LLENADOS CORRECTAMENTE");
 
                    Carga.grafo.agregoRuta(placa.getText(),marca.getText(),modelo.getText());
                    System.out.println(placa.getText()+"   "+marca.getText()+"   "+modelo.getText());
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
                   
                }

            } else {
                errorLabel.setText("LLENAR TODOS LOS CAMPOS");
            }
        } else {
            if (!placa.getText().isEmpty() && !marca.getText().isEmpty()
                    && !modelo.getText().isEmpty() ) {
                if (placa.getText().length() < 6) {
                    errorLabel.setText("RESPETAR TODAS LAS RESTRICCIONES DE DATOS");
                } else {
                  ///// Es para modificar..
                  
                }

            } else {
                errorLabel.setText("LLENAR TODOS LOS CAMPOS");
            }
        }
        CrearBoton.setText("CREAR");
        CrearBoton.setIcon(new ImageIcon("src/imagenes/iconos/crear.png"));
        CrearBoton.repaint();
      //EliminarBoton.setEnabled(false);
        correrTabla();
        modeloVehiculos.fireTableDataChanged();
        //ConductoresTabla.repaint();
    }//GEN-LAST:event_CrearBotonActionPerformed
    public long valorAssci(String subCadena) {

        long result = 0;
        String str = null;
        str = subCadena;
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append((int) c);
        }
        result = Long.parseLong(sb.toString());
        return result;
    }

    private void selecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionarActionPerformed

        //seleccionar el vehiculo
        if (VehiculosTabla.getSelectedRow() != -1) {
            long placaNo = valorAssci(String.valueOf(VehiculosTabla.getValueAt(VehiculosTabla.getSelectedRow(), 0)));
            System.out.println(placaNo);
            Vehiculo eC;
            try {
                eC = Carga.vehiculos.obtenerVehiculo(placaNo);
            placa.setText(String.valueOf(eC.getPlaca()));
            marca.setText(String.valueOf(eC.getMarca()));
            modelo.setText(eC.getModelo());
            
            
            
            } catch (Exception ex) {
                Logger.getLogger(menu_Rutas.class.getName()).log(Level.SEVERE, null, ex);
            }
    
           

            VehiculosTabla.clearSelection();
            errorLabel.setText("");

            CrearBoton.setText("EDITAR");
            CrearBoton.setIcon(new ImageIcon("src/imagenes/iconos/editar.png"));
            CrearBoton.repaint();
       //     EliminarBoton.setEnabled(true);
        } else {
            errorLabel.setText("SELECCIONE UN CONDUCTOR ANTES");
        }


    }//GEN-LAST:event_selecionarActionPerformed

    private void graficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficoActionPerformed
    
        try {
            Carga.grafo.imprimir();
            
            Graficas.graficar(Carga.grafo.cadenaGrafico(), "Grafo");
        } catch (Exception ex) {
            Logger.getLogger(menu_Vehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_graficoActionPerformed

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
      //  EliminarBoton.setEnabled(false);
    }//GEN-LAST:event_LimpiarBotonActionPerformed




    private void placaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_placaFocusLost

    }//GEN-LAST:event_placaFocusLost


    private void marcaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_marcaFocusLost


    }//GEN-LAST:event_marcaFocusLost

    private void marcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marcaKeyTyped

        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {     ///////////////////  Solo se admiten Letras
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo se admiten letras");

        }
    }//GEN-LAST:event_marcaKeyTyped

    private void modeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modeloKeyTyped
    char c=evt.getKeyChar();
     if(Character.isLetter(c)){     ///////////////////  Solo se admiten Numeros
     getToolkit().beep(); evt.consume();
     JOptionPane.showMessageDialog(null, "Solo se admiten Numeros");
     
     }
    }//GEN-LAST:event_modeloKeyTyped

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarActionPerformed

    private void placaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_placaKeyTyped
 char c = evt.getKeyChar();
        if (Character.isDigit(c)) {     ///////////////////  Solo se admiten Letras
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo se admiten letras");

        }
        
        
        
    }//GEN-LAST:event_placaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Carga.grafo.llenoMatriz();
        } catch (Exception ex) {
            Logger.getLogger(menu_Rutas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ImagenBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImagenBotonActionPerformed
        File miGraphviz = new File("Grafo.png");
        try {
            Desktop.getDesktop().open(miGraphviz);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IMAGEN CARGANDO");
        }
        
        mostrador_imagen imagen = new mostrador_imagen();
        ImageIcon foto = new ImageIcon("./Grafo.png");
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
            java.util.logging.Logger.getLogger(menu_Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_Rutas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CrearBoton;
    private javax.swing.JButton ImagenBoton;
    private javax.swing.JButton LimpiarBoton;
    private javax.swing.JLabel Salir;
    private javax.swing.JTable VehiculosTabla;
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JTextField buscar;
    private javax.swing.JLabel buscarLabel;
    private javax.swing.JLabel dpiLabel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton grafico;
    private javax.swing.JLabel imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField modelo;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField placa;
    private javax.swing.JButton selecionar;
    // End of variables declaration//GEN-END:variables
}
