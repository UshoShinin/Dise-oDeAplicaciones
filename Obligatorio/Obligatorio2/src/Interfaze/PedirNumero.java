/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaze;

import java.util.ArrayList;
import Controlador.ControladorPedirNumero;
import modelo.NumeroAtencion;
import modelo.Sector;
import modelo.Area;
import Controlador.VistaPedirNumero;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */
public class PedirNumero extends javax.swing.JFrame implements VistaPedirNumero  {

    /**
     * Creates new form ContadorTEst
     */
    private ControladorPedirNumero con;
    
    public PedirNumero(Area A) {
        initComponents();
        setLocationRelativeTo(null);
        btnSectores.setEnabled(false);
        //El sector me tiene que llegar por parametros en siguente prueb
        con = new ControladorPedirNumero(this,A); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSectores = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        comboSectores = new javax.swing.JList();
        CICliente = new javax.swing.JTextField();
        MostNum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSectores.setText("Pedir número");
        btnSectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSectoresActionPerformed(evt);
            }
        });

        comboSectores.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                comboSectoresValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(comboSectores);

        CICliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CICliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CIClienteActionPerformed(evt);
            }
        });

        MostNum.setEditable(false);
        MostNum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MostNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostNumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSectores, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(CICliente)
                    .addComponent(MostNum))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(CICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSectores)
                        .addGap(70, 70, 70)
                        .addComponent(MostNum, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSectoresActionPerformed
        Sector S =(Sector)comboSectores.getSelectedValue();
        con.pedirNumero(S, CICliente.getText());
    }//GEN-LAST:event_btnSectoresActionPerformed

    private void CIClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CIClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CIClienteActionPerformed

    private void MostNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MostNumActionPerformed

    private void comboSectoresValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_comboSectoresValueChanged
        if(comboSectores.getSelectedValue() == null){
            btnSectores.setEnabled(false);
        }else{
            btnSectores.setEnabled(true);
        }
    }//GEN-LAST:event_comboSectoresValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CICliente;
    private javax.swing.JTextField MostNum;
    private javax.swing.JButton btnSectores;
    private javax.swing.JList comboSectores;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarSectores(ArrayList<Sector> sectores) {
         comboSectores.setListData(sectores.toArray());
    }

    @Override
    public void mostrarError(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void mostrarNumeroCliente(NumeroAtencion N) {
        MostNum.setText(String.valueOf(N.getValor()));
    }

}
