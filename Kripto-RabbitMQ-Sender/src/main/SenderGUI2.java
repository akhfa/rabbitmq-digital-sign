/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author akhfa
 */
public class SenderGUI2 extends javax.swing.JFrame {

    private PrivateKey privKey;
    /**
     * Creates new form SenderGUI2
     */
    public SenderGUI2() {
        initComponents();
        this.setServerDefault();
    }
    
    private void setServerDefault()
    {
        textHost.setText("rabbitmq.akhfa.me");
        textUsername.setText("kripto");
        textPassword.setText("BuatKripto");
        textVhost.setText("kripto");
        textExchange.setText("kripto");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        buttonApply = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textHost = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textPassword = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textExchange = new javax.swing.JTextField();
        textVhost = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        buttonDefault = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        buttonGeneratePublicKey = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textModulus = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        textEksponen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textMessage = new javax.swing.JTextArea();
        buttonSend = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        buttonGenerateSignature = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textSignature = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonApply.setText("Apply");
        buttonApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonApplyActionPerformed(evt);
            }
        });

        jLabel4.setText("Host");

        jLabel5.setText("Username");

        jLabel6.setText("Password");

        jLabel7.setText("Exchange");

        jLabel3.setText("VirtualHost");

        buttonDefault.setText("Default");
        buttonDefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDefaultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textPassword)
                    .addComponent(textHost)
                    .addComponent(textUsername)
                    .addComponent(textExchange, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textVhost)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonDefault)
                                .addGap(18, 18, 18)
                                .addComponent(buttonApply)))
                        .addGap(0, 483, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textVhost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textExchange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonApply)
                    .addComponent(buttonDefault))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Server Setting", jPanel1);

        buttonGeneratePublicKey.setText("Generate Public Key");
        buttonGeneratePublicKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGeneratePublicKeyActionPerformed(evt);
            }
        });

        jLabel1.setText("Modulus");

        textModulus.setColumns(20);
        textModulus.setRows(5);
        jScrollPane1.setViewportView(textModulus);

        jLabel2.setText("Eksponen");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel8.setText("Nb: Copy this generated key to Receiver");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textEksponen, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonGeneratePublicKey)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonGeneratePublicKey)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textEksponen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Sender Key", jPanel2);

        textMessage.setColumns(20);
        textMessage.setRows(5);
        jScrollPane3.setViewportView(textMessage);

        buttonSend.setText("Send");
        buttonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendActionPerformed(evt);
            }
        });

        jLabel9.setText("Message");

        jLabel10.setText("Signature");

        buttonGenerateSignature.setText("Generate Signature");
        buttonGenerateSignature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateSignatureActionPerformed(evt);
            }
        });

        textSignature.setColumns(20);
        textSignature.setRows(5);
        jScrollPane2.setViewportView(textSignature);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonGenerateSignature, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonSend, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGenerateSignature)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonSend)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Message", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGeneratePublicKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGeneratePublicKeyActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(1024);
            KeyPair keyPair = kpg.genKeyPair();
            String pubKeyModulus = keyPair.getPublic().toString().split(" ")[8].replace("\n", "");
            
            textModulus.setText(pubKeyModulus);
            textModulus.setLineWrap(true);
            
            String pubKeyEkxponen = keyPair.getPublic().toString().split(" ")[12].replace("\n", "");
            textEksponen.setText(pubKeyEkxponen);
            this.privKey = keyPair.getPrivate();
            
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Error generate key");
        }
    }//GEN-LAST:event_buttonGeneratePublicKeyActionPerformed

    private void buttonDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDefaultActionPerformed
        // TODO add your handling code here:
        this.setServerDefault();
    }//GEN-LAST:event_buttonDefaultActionPerformed

    private void buttonApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApplyActionPerformed
        // TODO add your handling code here:
        tabbedPane.setSelectedIndex(1);
    }//GEN-LAST:event_buttonApplyActionPerformed

    private void buttonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendActionPerformed
        try {
            // TODO add your handling code here:
            Sender sender = new Sender(this.privKey, textHost.getText(), textUsername.getText(), textPassword.getText(), textVhost.getText(), textExchange.getText());
            sender.sendMessage(textMessage.getText(), textSignature.getText());
            System.out.println("after send: " + new String(Base64.getDecoder().decode(textSignature.getText())));
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error Sending Message");
        } catch (TimeoutException ex) {
            JOptionPane.showMessageDialog(null, "Connection Timeout");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SenderGUI2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Key");
        } catch (SignatureException ex) {
            JOptionPane.showMessageDialog(null, "Signature Error");
        }
    }//GEN-LAST:event_buttonSendActionPerformed

    private void buttonGenerateSignatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateSignatureActionPerformed
        try {
            // TODO add your handling code here:
            // generate signed
            Signature sig = Signature.getInstance("MD5WithRSA");
            sig.initSign(this.privKey);
            sig.update(textMessage.getText().getBytes());
            
            byte[] signatureBytes = sig.sign();
            
            String encodedSign = Base64.getEncoder().encodeToString(signatureBytes);
            
            textSignature.setText(encodedSign);
            System.err.println("gen sign: " + new String(Base64.getDecoder().decode(encodedSign)));
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SenderGUI2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Key");
        } catch (SignatureException ex) {
            JOptionPane.showMessageDialog(null, "Signature Error");
        }
    }//GEN-LAST:event_buttonGenerateSignatureActionPerformed

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
            java.util.logging.Logger.getLogger(SenderGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SenderGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SenderGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SenderGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SenderGUI2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonApply;
    private javax.swing.JButton buttonDefault;
    private javax.swing.JButton buttonGeneratePublicKey;
    private javax.swing.JButton buttonGenerateSignature;
    private javax.swing.JToggleButton buttonSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTextField textEksponen;
    private javax.swing.JTextField textExchange;
    private javax.swing.JTextField textHost;
    private javax.swing.JTextArea textMessage;
    private javax.swing.JTextArea textModulus;
    private javax.swing.JTextField textPassword;
    private javax.swing.JTextArea textSignature;
    private javax.swing.JTextField textUsername;
    private javax.swing.JTextField textVhost;
    // End of variables declaration//GEN-END:variables
}
