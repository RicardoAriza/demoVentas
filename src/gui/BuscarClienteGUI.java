package gui;

import dao.ClienteDAO;
import hilo.AudioConHilos;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class BuscarClienteGUI extends javax.swing.JInternalFrame {

    AudioConHilos exit = new AudioConHilos("/sonidos/WExit.wav");
    AudioConHilos select = new AudioConHilos("/sonidos/WSelect.wav");
    DefaultTableModel objDtm;
    ClienteDAO objClienteDAO = new ClienteDAO();
    ResultSet rsCliente;

    public BuscarClienteGUI() {
        initComponents();
        objDtm = (DefaultTableModel) jtblRegistros.getModel();
        setSize(707, 254);
        setVisible(true);
        setLocation(700, 50);
    }

    private void limpiarJTable() {
        while (objDtm.getRowCount() > 0) {
            objDtm.removeRow(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtxtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRegistros = new javax.swing.JTable();
        jbtnAgregar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ingrese nombre de cliente:");

        jtxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtBuscarKeyReleased(evt);
            }
        });

        jtblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "DIRRECION", "CIUDAD", "CELULAR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jbtnAgregar.setText("Agregar a factura");
        jbtnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxtBuscar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addComponent(jbtnCancelar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBuscarKeyReleased
        try {
            limpiarJTable();
            if (!jtxtBuscar.getText().isEmpty()) {
                rsCliente = objClienteDAO.buscar(jtxtBuscar.getText());
                while (rsCliente.next()) {
                    Object registro[] = {rsCliente.getInt(1), rsCliente.getString(3), rsCliente.getString(4), rsCliente.getString(5), rsCliente.getString(7)};
                    objDtm.addRow(registro);
                }
                jtblRegistros.setModel(objDtm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jtxtBuscarKeyReleased

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        try {
            select.run();
            FacturaGUI.jtxtIdcliente.setText(jtblRegistros.getValueAt(jtblRegistros.getSelectedRow(), 0).toString());
            FacturaGUI.jtxtNombclie.setText(jtblRegistros.getValueAt(jtblRegistros.getSelectedRow(), 1).toString());
            FacturaGUI.jtxtDireclie.setText(jtblRegistros.getValueAt(jtblRegistros.getSelectedRow(), 2).toString());
            FacturaGUI.jtxtCiudad.setText(jtblRegistros.getValueAt(jtblRegistros.getSelectedRow(), 3).toString());
            FacturaGUI.jtxtCelular.setText(jtblRegistros.getValueAt(jtblRegistros.getSelectedRow(), 4).toString());
            dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        exit.run();
        dispose();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jtblRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblRegistrosMouseClicked
        if (evt.getClickCount()==2) {
            try {
            select.run();
            FacturaGUI.jtxtIdcliente.setText(jtblRegistros.getValueAt(jtblRegistros.getSelectedRow(), 0).toString());
            FacturaGUI.jtxtNombclie.setText(jtblRegistros.getValueAt(jtblRegistros.getSelectedRow(), 1).toString());
            FacturaGUI.jtxtDireclie.setText(jtblRegistros.getValueAt(jtblRegistros.getSelectedRow(), 2).toString());
            FacturaGUI.jtxtCiudad.setText(jtblRegistros.getValueAt(jtblRegistros.getSelectedRow(), 3).toString());
            FacturaGUI.jtxtCelular.setText(jtblRegistros.getValueAt(jtblRegistros.getSelectedRow(), 4).toString());
            dispose();
        } catch (Exception e) {
        }
        }
    }//GEN-LAST:event_jtblRegistrosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JTable jtblRegistros;
    private javax.swing.JTextField jtxtBuscar;
    // End of variables declaration//GEN-END:variables
}
