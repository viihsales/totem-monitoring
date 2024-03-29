/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.totemmonitoring;

import monitoramento.Totem;

/**
 *
 * @author Aluno
 */
public class TelaProcessos extends javax.swing.JFrame {

    /**
     * Creates new form TelaProcessos
     */
    public TelaProcessos() {
        initComponents();
    }
    
    Totem totem = new Totem();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbProcessos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textProcessos = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        lblPid = new javax.swing.JLabel();
        lblPid1 = new javax.swing.JLabel();
        lblPid2 = new javax.swing.JLabel();
        lblPid3 = new javax.swing.JLabel();
        lblPid4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lbProcessos.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbProcessos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProcessos.setText("Processos");
        lbProcessos.setToolTipText("");

        textProcessos.setColumns(20);
        textProcessos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        textProcessos.setRows(5);
        textProcessos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textProcessos.setEnabled(false);
        jScrollPane1.setViewportView(textProcessos);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblPid.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblPid.setText("PID");

        lblPid1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblPid1.setText("%CPU");

        lblPid2.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblPid2.setText("%MEM");

        lblPid3.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblPid3.setText("VSZ");

        lblPid4.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblPid4.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(335, Short.MAX_VALUE)
                .addComponent(lbProcessos)
                .addGap(335, 335, 335))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(lblPid)
                        .addGap(82, 82, 82)
                        .addComponent(lblPid1)
                        .addGap(98, 98, 98)
                        .addComponent(lblPid2)
                        .addGap(95, 95, 95)
                        .addComponent(lblPid3)
                        .addGap(96, 96, 96)
                        .addComponent(lblPid4)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPid)
                        .addComponent(lblPid1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPid2)
                        .addComponent(lblPid3)
                        .addComponent(lblPid4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        totem.capturarDados();
        
        textProcessos.setText(totem.getProcessos());
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaProcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProcessos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbProcessos;
    private javax.swing.JLabel lblPid;
    private javax.swing.JLabel lblPid1;
    private javax.swing.JLabel lblPid2;
    private javax.swing.JLabel lblPid3;
    private javax.swing.JLabel lblPid4;
    private javax.swing.JTextArea textProcessos;
    // End of variables declaration//GEN-END:variables
}
