/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bl.RadioModel;
import bl.Sender;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Alex
 */
public class RadioGUI extends javax.swing.JFrame {

    RadioModel rm = new RadioModel();
    DefaultTableColumnModel dtcm;
    int width = 0;

    /**
     * Creates new form RadioGUI
     */
    public RadioGUI() {
        initComponents();
        initTable();
    }

    public void initTable() {
        dtcm = new DefaultTableColumnModel();
        String[] colNames =
        {
            "Sender", "Frequenz", "Band"
        };
        int cnt = 0;
        for (String colName : colNames)
        {
            cnt++;
            TableColumn tc = new TableColumn(cnt);
            tc.setHeaderValue(colName);
            tc.setResizable(false);
            dtcm.addColumn(tc);
        }
        taTable.setModel(rm);
        taTable.setColumnModel(dtcm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        taTable = new javax.swing.JTable();

        jMenuItem1.setText("Add");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Hide ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onHide(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("Show");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onShow(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout());

        jScrollPane1.setComponentPopupMenu(jPopupMenu1);

        taTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(taTable);

        getContentPane().add(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onHide(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onHide
        // TODO add your handling code here:
        width = dtcm.getColumn(2).getWidth();
        System.out.println(width);
        dtcm.getColumn(2).setWidth(0);                                          //funktioniert noch nicht
    }//GEN-LAST:event_onHide

    private void onShow(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onShow
        // TODO add your handling code here:
        dtcm.getColumn(2).setWidth(0);
    }//GEN-LAST:event_onShow

    private void Add(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add
        // TODO add your handling code here:
        Sender s = new Sender("abc", 30., "bcm");
//        rm.addSender(s);

        RadiaDialog rd = new RadiaDialog(this, true);
        rd.setVisible(true);
        if(rd.isOk())
        {
            Sender sender = rd.getSender();
            rm.addSender(sender);
        }
        taTable.updateUI();
    }//GEN-LAST:event_Add

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(RadioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(RadioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(RadioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(RadioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RadioGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable taTable;
    // End of variables declaration//GEN-END:variables
}
