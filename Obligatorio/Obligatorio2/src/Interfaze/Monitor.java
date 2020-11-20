/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaze;

import Controlador.ControladorMonitoreo;
import Controlador.VistaMonitoreo;
import java.util.ArrayList;
import modelo.Area;
import modelo.Puesto;

/**
 *
 * @author Ivan
 */
public class Monitor extends javax.swing.JFrame implements VistaMonitoreo {

    /**
     * Creates new form Monitor
     */
    private ControladorMonitoreo con;
    
    public Monitor(Area A) {
        initComponents();
        this.con = new ControladorMonitoreo(this,A);
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
        ListPuestos = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ListPuestos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(ListPuestos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void mostrarPuestos(ArrayList<Puesto> puestos){
        ListPuestos.setListData(puestos.toArray());
        String item;
        for (Puesto p : puestos) {
            item = p.getSector().getNombre() + " "+ p.getNumeroActual().getValor()+" "+p.getNumeroActual().getCliente().getNombreCompleto()+" "+p.getNumPuesto()+" ";//FALTA EL PROMEDIO DEL SECTOR
            //ListPuestos.add(item);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ListPuestos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
