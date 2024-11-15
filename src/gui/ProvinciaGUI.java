/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ProvinciaDAO;
import hilo.AudioConHilos;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import to.ProvinciaTO;

public class ProvinciaGUI extends javax.swing.JInternalFrame {

    DefaultTableModel objDtm;
    ProvinciaDAO objProvinciaDAO = new ProvinciaDAO();
    ResultSet rsProvincia;
    int xidprovincia;
    boolean sw;
    AudioConHilos borrar = new AudioConHilos("/sonidos/RegistroBorrado.wav");
    AudioConHilos nuevo = new AudioConHilos("/sonidos/RegistroNuevo.wav");
    AudioConHilos actualizado = new AudioConHilos("/sonidos/RegistroActualizado.wav");
    AudioConHilos cancelado = new AudioConHilos("/sonidos/RegistroCancelado.wav");
    AudioConHilos grabado = new AudioConHilos("/sonidos/RegistroGrabado.wav");
    AudioConHilos error = new AudioConHilos("/sonidos/SeleccioneRegistro.wav");
    AudioConHilos start = new AudioConHilos("/sonidos/Start.wav");
    AudioConHilos exclamtion = new AudioConHilos("/sonidos/WExclamation.wav");
    AudioConHilos cancelar = new AudioConHilos("/sonidos/WCancelar.wav");
    AudioConHilos exit = new AudioConHilos("/sonidos/WExit.wav");
    AudioConHilos off = new AudioConHilos("/sonidos/WOff.wav");
    AudioConHilos salir = new AudioConHilos("/sonidos/WSalir.wav");
    AudioConHilos select = new AudioConHilos("/sonidos/WSelect.wav");
    public ProvinciaGUI() {
        initComponents();
        setVisible(true);
        setSize(410, 417);
        objDtm = (DefaultTableModel) jtblRegistros.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtId = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRegistros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtxtBuscar = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jbtnNuevo = new javax.swing.JButton();
        jbtnGrabar = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jbtnBorrar = new javax.swing.JButton();
        jbtnSalir = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("ID");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setText("NOMBRE");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jtxtId.setEditable(false);
        jPanel4.add(jtxtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 150, 30));

        jtxtNombre.setEditable(false);
        jtxtNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 170, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 370, 100));

        jtblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblRegistros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtblRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblRegistrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblRegistros);
        if (jtblRegistros.getColumnModel().getColumnCount() > 0) {
            jtblRegistros.getColumnModel().getColumn(0).setResizable(false);
            jtblRegistros.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 370, 90));

        jLabel1.setText(" Ingresar provincia a buscar ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jtxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(jtxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 200, 30));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo_1.png"))); // NOI18N
        jbtnNuevo.setText("Nuevo");
        jbtnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });
        jPanel5.add(jbtnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 45));

        jbtnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/grabar_1.png"))); // NOI18N
        jbtnGrabar.setText("Grabar");
        jbtnGrabar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnGrabar.setEnabled(false);
        jbtnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGrabarActionPerformed(evt);
            }
        });
        jPanel5.add(jbtnGrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 130, 45));

        jbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        jbtnEditar.setText("Editar");
        jbtnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });
        jPanel5.add(jbtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 110, 45));

        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar_1.png"))); // NOI18N
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCancelar.setEnabled(false);
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });
        jPanel5.add(jbtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 45));

        jbtnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/borrar.png"))); // NOI18N
        jbtnBorrar.setText("Borrar");
        jbtnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBorrarActionPerformed(evt);
            }
        });
        jPanel5.add(jbtnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 130, 45));

        jbtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salir_1.png"))); // NOI18N
        jbtnSalir.setText("Salir");
        jbtnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });
        jPanel5.add(jbtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 110, 45));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 380, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtblRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblRegistrosMouseClicked
        try {
            start.run();
            xidprovincia = Integer.parseInt(jtblRegistros.getValueAt(jtblRegistros.getSelectedRow(), 0).toString());
            rsProvincia.first();
            do {
                if (xidprovincia == rsProvincia.getInt(1)) {
                    jtxtId.setText(String.valueOf(rsProvincia.getInt(1)));
                    jtxtNombre.setText(rsProvincia.getString(2));
                    rsProvincia.last();
                }
            } while (rsProvincia.next());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jtblRegistrosMouseClicked

    private void jtxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBuscarKeyReleased
        try {
            limpiarJTable();
            if (!jtxtBuscar.getText().isEmpty()) {
                rsProvincia = objProvinciaDAO.buscar(jtxtBuscar.getText());
                while (rsProvincia.next()) {
                    Object registro[] = {rsProvincia.getInt(1), rsProvincia.getString(2)};
                    objDtm.addRow(registro);
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jtxtBuscarKeyReleased

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
        start.run();
        habilitaControles(true);
        limpiaControles();
        sw = true;
    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jbtnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGrabarActionPerformed
        try {
            String mensaje;
            start.run();
            ProvinciaTO objProvinciaTO = new ProvinciaTO();
            objProvinciaTO.setNombprov(jtxtNombre.getText().toUpperCase());
            if (sw) {
                grabado.run();
                objProvinciaDAO.insert(objProvinciaTO);
                mensaje = "REGISTRO GRABADO";
            } else {
                objProvinciaTO.setIdprovincia(xidprovincia);
                objProvinciaDAO.update(objProvinciaTO);
                actualizado.run();
                mensaje = "REGISTRO ACTUALIZADO";
            }
            habilitaControles(false);
            JOptionPane.showMessageDialog(rootPane, mensaje);
            limpiaControles();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jbtnGrabarActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed
        start.run();
        habilitaControles(true);
        sw = false;
    }//GEN-LAST:event_jbtnEditarActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        cancelar.run();
        cancelado.run();
        habilitaControles(false);
        limpiaControles();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBorrarActionPerformed
        try {
            exclamtion.run();
            int op = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro que deseas eliminar?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {
                select.run();
                ProvinciaTO objProvinciaTO = new ProvinciaTO();
                objProvinciaTO.setIdprovincia(xidprovincia);
                objProvinciaDAO.delete(objProvinciaTO);
                borrar.run();
                limpiaControles();
                JOptionPane.showMessageDialog(rootPane, "Registro borrado");
            }else{
                select.run();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jbtnBorrarActionPerformed

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        exit.run();
        dispose();
    }//GEN-LAST:event_jbtnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnBorrar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnGrabar;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JButton jbtnSalir;
    private javax.swing.JTable jtblRegistros;
    private javax.swing.JTextField jtxtBuscar;
    private javax.swing.JTextField jtxtId;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
    private void habilitaControles(boolean b) {
        jtxtNombre.setEditable(b);
        jtxtBuscar.setEditable(!b);
        jbtnGrabar.setEnabled(b);
        jbtnCancelar.setEnabled(b);
        jbtnNuevo.setEnabled(!b);
        jbtnEditar.setEnabled(!b);
        jbtnBorrar.setEnabled(!b);
        jbtnSalir.setEnabled(!b);
        jtxtNombre.grabFocus();
    }

    private void limpiaControles() {
        limpiarJTable();
        jtxtBuscar.setText(null);
        jtxtId.setText(null);
        jtxtNombre.setText(null);

    }

    private void limpiarJTable() {
        while (objDtm.getRowCount() > 0) {
            objDtm.removeRow(0);
        }
    }
}