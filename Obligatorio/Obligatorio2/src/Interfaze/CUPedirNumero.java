/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaze;

import Controlador.VistaPedirNumero;
import java.util.ArrayList;
import modelo.Area;
import modelo.Sector;

/**
 *
 * @author Ivan
 */
public class CUPedirNumero extends javax.swing.JFrame implements VistaPedirNumero {

    private ArrayList<Area> areas;
    /**
     * Creates new form SeleccionArea
     */
    public CUPedirNumero(ArrayList<Area> areas) {
        initComponents();
        this.areas = areas;
        mostrarAreas(this.areas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAreas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        comboAreas = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAreas.setText("Seleccionar");
        btnAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAreasActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(comboAreas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnAreas)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAreas)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAreasActionPerformed
        Area A =(Area)comboAreas.getSelectedValue();
        System.out.println(A);
        mostrarSectores(A.getSectores());
       
    }//GEN-LAST:event_btnAreasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAreas;
    private javax.swing.JList comboAreas;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarContador(int valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarAreas(ArrayList<Area> areas) {
        comboAreas.setListData(areas.toArray());
    }

    @Override
    public void mostrarSectores(ArrayList<Sector> sectores) {
         new MostrarSectores(sectores).setVisible(true);
    }
}
