/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaze;


import Controlador.ControladorAtencion;
import Controlador.VistaAtencionCliente;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Puesto;
import modelo.Sector;
import modelo.Area;
import modelo.Trabajador;
import modelo.NumeroAtencion;

/**
 *
 * @author Ivan
 */
public class AtenderCliente extends javax.swing.JFrame implements VistaAtencionCliente {

    private Puesto puesto;
    private Sector sector;
    private Area area;
    private ControladorAtencion con;
    /**
     * Creates new form AtenderCliente
     */
    public AtenderCliente(Puesto P,Trabajador T){
        initComponents();
        this.puesto = P;
        this.sector = puesto.getSector();
        this.area = sector.getArea();
        this.con = new ControladorAtencion(this,P,T);
        seteoInicial();
        
    }
    
    public void seteoInicial(){
        this.setTitle(puesto.getTrabajador().getNombreCompleto());
        NPuesto.setText(String.valueOf(puesto.getNumPuesto()));
        NSector.setText(sector.getNombre());
        NArea.setText(area.getNombre());
        CantNum.setText(String.valueOf(puesto.numerosProcesados()));
        IAtencion.setEnabled(false);
        description.setEnabled(false);
        FAtencion.setEnabled(false);
        FS.setEnabled(false);
    }
    
    public void estadoDesocupado(){
        IAtencion.setEnabled(false);
        description.setEnabled(false);
        FAtencion.setEnabled(false);
        FS.setEnabled(false);
        Salir.setEnabled(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        NumAtencion.setText("0");
        NomCliente.setText("Cliente sin asignar");
        NumFecha.setText("0");
        description.setText("");
    }
    
    public void finAtencion(){
        description.setEnabled(false);
        FAtencion.setEnabled(false);
        FS.setEnabled(false);
        description.setText("");
        int Time = puesto.tiempoPromedio();
        String T = String.valueOf((Time-(Time%60))/60) + ":";
        if(Time%60<10) T+="0"+String.valueOf(Time%60);
        else T+=String.valueOf(Time%60);
        Tprom.setText(T);
    }
    
    public void estadoOcupado(){
        NumeroAtencion na = puesto.getNumeroActual();
        IAtencion.setEnabled(true);
        description.setEnabled(false);
        FAtencion.setEnabled(false);
        FS.setEnabled(false);
        Salir.setEnabled(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        description.setText("");
        NumAtencion.setText(String.valueOf(na.getValor()));
        NomCliente.setText(na.getCliente().getNombreCompleto());
        NumFecha.setText(String.valueOf(na.getFechaSacado()));
        CantNum.setText(String.valueOf(puesto.numerosProcesados()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NPuesto = new javax.swing.JLabel();
        NArea = new javax.swing.JLabel();
        CantNum = new javax.swing.JLabel();
        Tprom = new javax.swing.JLabel();
        IAtencion = new javax.swing.JButton();
        FAtencion = new javax.swing.JButton();
        FS = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        NSector = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        NumAtencion = new javax.swing.JLabel();
        LNumAtencion = new javax.swing.JLabel();
        NomCliente = new javax.swing.JLabel();
        LNumAtencion1 = new javax.swing.JLabel();
        LNumAtencion2 = new javax.swing.JLabel();
        NumFecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Área");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Número de puesto");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Números asignados");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Tiempo promedio");

        NPuesto.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        NPuesto.setText("0");

        NArea.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        NArea.setText("Nombre");

        CantNum.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        CantNum.setText("0");

        Tprom.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Tprom.setText("0");

        IAtencion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        IAtencion.setText("Iniciar atención");
        IAtencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IAtencionActionPerformed(evt);
            }
        });

        FAtencion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        FAtencion.setText("Finalizar atención");
        FAtencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FAtencionActionPerformed(evt);
            }
        });

        FS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        FS.setText("Finalizar y salir");
        FS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FSActionPerformed(evt);
            }
        });

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        NSector.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        NSector.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("Sector");

        Salir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        NumAtencion.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        NumAtencion.setText("Vacio");

        LNumAtencion.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        LNumAtencion.setText("Número actual:");

        NomCliente.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        NomCliente.setText("Cliente sin asignar");

        LNumAtencion1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        LNumAtencion1.setText("Nombre cliente:");

        LNumAtencion2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        LNumAtencion2.setText("Fecha y hora número");

        NumFecha.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        NumFecha.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(NPuesto))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(CantNum))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(NArea))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(NSector))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(Tprom)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(498, 498, 498)
                                .addComponent(Salir)
                                .addGap(0, 3, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LNumAtencion)
                                .addGap(18, 18, 18)
                                .addComponent(NumAtencion))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LNumAtencion1)
                                .addGap(18, 18, 18)
                                .addComponent(NomCliente))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LNumAtencion2)
                                .addGap(18, 18, 18)
                                .addComponent(NumFecha))
                            .addComponent(IAtencion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FAtencion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(FS, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NPuesto)
                    .addComponent(Salir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(NSector))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(NArea))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(CantNum))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Tprom)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(FAtencion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FS)
                        .addContainerGap(150, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LNumAtencion)
                            .addComponent(NumAtencion))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LNumAtencion1)
                            .addComponent(NomCliente))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LNumAtencion2)
                            .addComponent(NumFecha))
                        .addGap(18, 18, 18)
                        .addComponent(IAtencion)
                        .addGap(33, 33, 33))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IAtencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IAtencionActionPerformed
        con.IniciarAtencion();
        IAtencion.setEnabled(false);
        description.setEnabled(true);
        FAtencion.setEnabled(true);
        FS.setEnabled(true);
        Salir.setEnabled(false);
        
        
    }//GEN-LAST:event_IAtencionActionPerformed

    private void FAtencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FAtencionActionPerformed
        con.FinalizarAtencion(description.getText());
    }//GEN-LAST:event_FAtencionActionPerformed

    private void FSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FSActionPerformed
       con.FinalizarSalir(description.getText());
       dispose();
    }//GEN-LAST:event_FSActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        dispose();
    }//GEN-LAST:event_SalirActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CantNum;
    private javax.swing.JButton FAtencion;
    private javax.swing.JButton FS;
    private javax.swing.JButton IAtencion;
    private javax.swing.JLabel LNumAtencion;
    private javax.swing.JLabel LNumAtencion1;
    private javax.swing.JLabel LNumAtencion2;
    private javax.swing.JLabel NArea;
    public javax.swing.JLabel NPuesto;
    private javax.swing.JLabel NSector;
    private javax.swing.JLabel NomCliente;
    private javax.swing.JLabel NumAtencion;
    private javax.swing.JLabel NumFecha;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel Tprom;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarMensaje(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    @Override
    public void dispose() {
        this.setVisible(false);
        con.Salir();
    }
}
