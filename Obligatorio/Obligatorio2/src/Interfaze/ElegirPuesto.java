/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaze;

import Controlador.ControladorElegirPuesto;
import Controlador.VistaElegirPuesto;
import javax.swing.JOptionPane;
import modelo.Puesto;
import modelo.Trabajador;

/**
 *
 * @author Intel i7
 */
public class ElegirPuesto extends javax.swing.JFrame implements VistaElegirPuesto{

    private Trabajador trabajador;
    private ControladorElegirPuesto controlador;
    /**
     * Creates new form ElegirPuesto
     */
    public ElegirPuesto(Trabajador trabajador) {
        initComponents();
        btnPuestos.setEnabled(false);
        this.trabajador = trabajador;
        this.controlador = new ControladorElegirPuesto(this, trabajador.getSector());
        mostrarPuestos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        comboPuestos = new javax.swing.JList();
        btnPuestos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        comboPuestos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                comboPuestosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(comboPuestos);

        btnPuestos.setText("Seleccionar");
        btnPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuestosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnPuestos)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuestosActionPerformed
        Puesto P = (Puesto)comboPuestos.getSelectedValue();
        controlador.asignarTrabajadorAlPuesto(P, trabajador); 
    }//GEN-LAST:event_btnPuestosActionPerformed

    private void comboPuestosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_comboPuestosValueChanged
        if(comboPuestos.getSelectedValue() == null){
            btnPuestos.setEnabled(false);
        }else{
            btnPuestos.setEnabled(true);
        }
    }//GEN-LAST:event_comboPuestosValueChanged

    @Override
    public void mostrarPuestos(){
        comboPuestos.setListData(trabajador.getSector().puestosDisponibles().toArray());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPuestos;
    private javax.swing.JList comboPuestos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarError(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void crearVentanaAtencion(Puesto p) {
        new AtenderCliente(p,trabajador).setVisible(true);  
    }
    @Override
    public void dispose(){
        this.setVisible(false);
        controlador.salir();
    }
    
}
