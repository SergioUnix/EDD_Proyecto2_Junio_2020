/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.MouseInfo;
import java.awt.Point;
import java.io.File;
import javax.swing.JFileChooser;

import clases.Carga;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro Lorenty
 */
public class carga_Masiva extends javax.swing.JFrame {

    private int x;
    private int y;
    /**
     * Creates new form carga_Masiva
     */
    public carga_Masiva() {
        initComponents();
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
        titulo = new javax.swing.JLabel();
        Salir = new javax.swing.JLabel();
        Crutas = new javax.swing.JButton();
        Cconductores = new javax.swing.JButton();
        Cvehiculos = new javax.swing.JButton();
        Cclientes = new javax.swing.JButton();
        FondoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        setResizable(false);
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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("CARGA DE DATOS");
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/logout72.png"))); // NOI18N
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        jPanel1.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, -1));

        Crutas.setBackground(new java.awt.Color(255, 255, 255));
        Crutas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/irutas.png"))); // NOI18N
        Crutas.setText("RUTAS");
        Crutas.setAutoscrolls(true);
        Crutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrutasActionPerformed(evt);
            }
        });
        jPanel1.add(Crutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 170, 50));

        Cconductores.setBackground(new java.awt.Color(255, 255, 255));
        Cconductores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/iconductores.png"))); // NOI18N
        Cconductores.setText("CONDUCTORES");
        Cconductores.setAutoscrolls(true);
        Cconductores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CconductoresActionPerformed(evt);
            }
        });
        jPanel1.add(Cconductores, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 170, 50));

        Cvehiculos.setBackground(new java.awt.Color(255, 255, 255));
        Cvehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/ivehiculos.png"))); // NOI18N
        Cvehiculos.setText("VEHICULOS");
        Cvehiculos.setAutoscrolls(true);
        Cvehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CvehiculosActionPerformed(evt);
            }
        });
        jPanel1.add(Cvehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 170, 50));

        Cclientes.setBackground(new java.awt.Color(255, 255, 255));
        Cclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/iusuarios.png"))); // NOI18N
        Cclientes.setText("CLIENTES");
        Cclientes.setAutoscrolls(true);
        Cclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CclientesActionPerformed(evt);
            }
        });
        jPanel1.add(Cclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 170, 50));

        FondoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/carga.jpg"))); // NOI18N
        jPanel1.add(FondoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 330));

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
        System.exit(0);
    }//GEN-LAST:event_SalirMouseClicked

    private void CclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CclientesActionPerformed
        String rutaLectura;
        JFileChooser JF = new JFileChooser();
        JF.showOpenDialog(null);
        File archivo = JF.getSelectedFile();
        if (archivo != null) {
            rutaLectura = archivo.getAbsolutePath();
            try {
                Carga.cargaCliente(rutaLectura);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(carga_Masiva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "SELECCIONE UN ARCHIVO PARA REALIZAR LA CARGA");
        }
    }//GEN-LAST:event_CclientesActionPerformed

    private void CvehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CvehiculosActionPerformed
        String rutaLectura;
        JFileChooser JF = new JFileChooser();
        JF.showOpenDialog(null);
        File archivo = JF.getSelectedFile();
        if (archivo != null) {
            rutaLectura = archivo.getAbsolutePath();
            try {
                Carga.cargaVehiculo(rutaLectura);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(carga_Masiva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "SELECCIONE UN ARCHIVO PARA REALIZAR LA CARGA");
        }
    }//GEN-LAST:event_CvehiculosActionPerformed

    private void CconductoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CconductoresActionPerformed
     
        String rutaLectura;
        
        JFileChooser JF = new JFileChooser();
        JF.showOpenDialog(null);
        File archivo = JF.getSelectedFile();
        if (archivo != null) {
            rutaLectura = archivo.getAbsolutePath();
            try {
                Carga.cargaConductor(rutaLectura);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(carga_Masiva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "SELECCIONE UN ARCHIVO PARA REALIZAR LA CARGA");
        }
       //MÉTODO PARA CREAR EL ARCHIVO.DOT Y LA IMAGEN.PNG
        try {
           Path CMD= Carga.lista_doble_ciruclar_GRAPHVIZ();
           Carga.dibujarGRAPHVIZ(CMD,"Conductores.png");
        } catch (IOException ex) {
            Logger.getLogger(carga_Masiva.class.getName()).log(Level.SEVERE, null, ex);
        }
        //*/ 
    }//GEN-LAST:event_CconductoresActionPerformed

    private void CrutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrutasActionPerformed
        String rutaLectura;
        JFileChooser JF = new JFileChooser();
        JF.showOpenDialog(null);
        File archivo = JF.getSelectedFile();
        if (archivo != null) {
            rutaLectura = archivo.getAbsolutePath();
            try {
                Carga.cargaRuta(rutaLectura);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(carga_Masiva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "SELECCIONE UN ARCHIVO PARA REALIZAR LA CARGA");
        }
    }//GEN-LAST:event_CrutasActionPerformed

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
            java.util.logging.Logger.getLogger(carga_Masiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(carga_Masiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(carga_Masiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(carga_Masiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new carga_Masiva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cclientes;
    private javax.swing.JButton Cconductores;
    private javax.swing.JButton Crutas;
    private javax.swing.JButton Cvehiculos;
    public javax.swing.JLabel FondoLabel;
    private javax.swing.JLabel Salir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
