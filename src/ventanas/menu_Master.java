/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.MouseInfo;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Lorenty
 */
public class menu_Master extends javax.swing.JFrame {

    private menu_Conductor con = new menu_Conductor();
    private carga_Masiva car = new carga_Masiva();
    private menu_Viajes via = new menu_Viajes();
    private menu_Reportes repo = new menu_Reportes();
    private int x;
    private int y;

    /**
     * Creates new form menu_Master
     */
    public menu_Master() {
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
        Salir = new javax.swing.JLabel();
        ReporteBoton = new javax.swing.JButton();
        ReporteBoton1 = new javax.swing.JButton();
        CargaBoton = new javax.swing.JButton();
        ClienteBoton1 = new javax.swing.JButton();
        ConductorBoton = new javax.swing.JButton();
        VehiculoBoton = new javax.swing.JButton();
        ClienteBoton = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jPanel1.setLayout(null);

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/logout72.png"))); // NOI18N
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        jPanel1.add(Salir);
        Salir.setBounds(990, 10, 72, 72);

        ReporteBoton.setBackground(new java.awt.Color(255, 102, 0));
        ReporteBoton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReporteBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/iviajes.png"))); // NOI18N
        ReporteBoton.setText("MENU VIAJES");
        ReporteBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteBotonActionPerformed(evt);
            }
        });
        jPanel1.add(ReporteBoton);
        ReporteBoton.setBounds(820, 300, 240, 100);

        ReporteBoton1.setBackground(new java.awt.Color(255, 102, 0));
        ReporteBoton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReporteBoton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/graphviz.png"))); // NOI18N
        ReporteBoton1.setText("MENU REPORTE");
        ReporteBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteBoton1ActionPerformed(evt);
            }
        });
        jPanel1.add(ReporteBoton1);
        ReporteBoton1.setBounds(820, 410, 240, 100);

        CargaBoton.setBackground(new java.awt.Color(255, 102, 0));
        CargaBoton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CargaBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/crear.png"))); // NOI18N
        CargaBoton.setText("MENU CARGA");
        CargaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargaBotonActionPerformed(evt);
            }
        });
        jPanel1.add(CargaBoton);
        CargaBoton.setBounds(820, 190, 240, 100);

        ClienteBoton1.setBackground(new java.awt.Color(255, 102, 0));
        ClienteBoton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ClienteBoton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/irutas.png"))); // NOI18N
        ClienteBoton1.setText("MENU RUTAS");
        ClienteBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteBoton1ActionPerformed(evt);
            }
        });
        jPanel1.add(ClienteBoton1);
        ClienteBoton1.setBounds(210, 410, 240, 100);

        ConductorBoton.setBackground(new java.awt.Color(255, 102, 0));
        ConductorBoton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ConductorBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/iconductores.png"))); // NOI18N
        ConductorBoton.setText("MENU CONDUCTORES");
        ConductorBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConductorBotonActionPerformed(evt);
            }
        });
        jPanel1.add(ConductorBoton);
        ConductorBoton.setBounds(390, 280, 240, 100);

        VehiculoBoton.setBackground(new java.awt.Color(255, 102, 0));
        VehiculoBoton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        VehiculoBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/ivehiculos.png"))); // NOI18N
        VehiculoBoton.setText("MENU VEHICULOS");
        VehiculoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehiculoBotonActionPerformed(evt);
            }
        });
        jPanel1.add(VehiculoBoton);
        VehiculoBoton.setBounds(20, 280, 240, 100);

        ClienteBoton.setBackground(new java.awt.Color(255, 102, 0));
        ClienteBoton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ClienteBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/iusuarios.png"))); // NOI18N
        ClienteBoton.setText("MENU CLIENTES");
        ClienteBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteBotonActionPerformed(evt);
            }
        });
        jPanel1.add(ClienteBoton);
        ClienteBoton.setBounds(210, 150, 240, 100);

        titulo.setFont(new java.awt.Font("TI Uni", 1, 48)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 102, 0));
        titulo.setText("LlegaRapidido");
        jPanel1.add(titulo);
        titulo.setBounds(370, 10, 380, 130);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/main_wallpapper.png"))); // NOI18N
        jPanel1.add(fondo);
        fondo.setBounds(0, 0, 1080, 530);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1077, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_SalirMouseClicked

    private void ClienteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteBotonActionPerformed
        menu_Cliente clie = null;
        try {
            clie = new menu_Cliente();
        } catch (Exception ex) {
            Logger.getLogger(menu_Master.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            clie.setVisible(true);
            clie.correrTabla();
        } catch (Exception ex) {
            Logger.getLogger(menu_Master.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ClienteBotonActionPerformed

    private void ConductorBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConductorBotonActionPerformed
        con.setVisible(true);
        con.correrTabla();
    }//GEN-LAST:event_ConductorBotonActionPerformed

    private void CargaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargaBotonActionPerformed
        car.setVisible(true);
    }//GEN-LAST:event_CargaBotonActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void VehiculoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehiculoBotonActionPerformed
        menu_Vehiculos vehi;
        try {
            vehi = new menu_Vehiculos();
            vehi.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(menu_Master.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_VehiculoBotonActionPerformed

    private void ClienteBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteBoton1ActionPerformed
        menu_Rutas rut = new menu_Rutas();
        rut.setVisible(true);
    }//GEN-LAST:event_ClienteBoton1ActionPerformed

    private void ReporteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteBotonActionPerformed
        via.setVisible(true);
        try {
            via.llenarComboBox();
        } catch (Exception ex) {
            Logger.getLogger(menu_Master.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_ReporteBotonActionPerformed

    private void ReporteBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteBoton1ActionPerformed
        repo.setVisible(true);
    }//GEN-LAST:event_ReporteBoton1ActionPerformed

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
            java.util.logging.Logger.getLogger(menu_Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_Master().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CargaBoton;
    private javax.swing.JButton ClienteBoton;
    private javax.swing.JButton ClienteBoton1;
    private javax.swing.JButton ConductorBoton;
    private javax.swing.JButton ReporteBoton;
    private javax.swing.JButton ReporteBoton1;
    private javax.swing.JLabel Salir;
    private javax.swing.JButton VehiculoBoton;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
