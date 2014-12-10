/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

import br.com.model.Aviso;
import br.com.model.Relatorio;
import br.com.util.Retorno;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Israel Araújo
 */
public class MainFrame extends javax.swing.JFrame {

    private Relatorio relatorio;
    private final DefaultListModel<Float> valoresRelatorio = new DefaultListModel<>();
    private final DefaultListModel<Aviso> avisos = new DefaultListModel<>();
    private final DefaultListModel<Float> valoresDetalhamento = new DefaultListModel<>();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.valoresList.setModel(valoresRelatorio);
        this.avisosList.setModel(avisos);
        this.detalhamentoList.setModel(valoresDetalhamento);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        relatorioInternalFrame = new javax.swing.JInternalFrame();
        dataLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        valoresList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        avisosList = new javax.swing.JList();
        restanteLabel = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        avisoList = new javax.swing.JInternalFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        detalhamentoList = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        relatorioInternalFrame.setClosable(true);
        relatorioInternalFrame.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        relatorioInternalFrame.setMaximizable(true);
        relatorioInternalFrame.setResizable(true);
        relatorioInternalFrame.setTitle("Arquivo retorno");
        relatorioInternalFrame.setVisible(true);

        dataLabel.setText("Data");

        totalLabel.setText("Total");

        valoresList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        valoresList.setToolTipText("");
        jScrollPane1.setViewportView(valoresList);

        avisosList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        avisosList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avisosListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(avisosList);

        restanteLabel.setText("Restante");

        jMenu2.setText("Arquivo");
        jMenu2.setEnabled(true);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Buscar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Limpar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar2.add(jMenu2);

        jMenu3.setText("Exibir");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Relatório de retorno");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar2.add(jMenu3);

        relatorioInternalFrame.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout relatorioInternalFrameLayout = new javax.swing.GroupLayout(relatorioInternalFrame.getContentPane());
        relatorioInternalFrame.getContentPane().setLayout(relatorioInternalFrameLayout);
        relatorioInternalFrameLayout.setHorizontalGroup(
            relatorioInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(relatorioInternalFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(relatorioInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(restanteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(relatorioInternalFrameLayout.createSequentialGroup()
                        .addGroup(relatorioInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(relatorioInternalFrameLayout.createSequentialGroup()
                                .addComponent(totalLabel)
                                .addGap(0, 133, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
                .addContainerGap())
        );
        relatorioInternalFrameLayout.setVerticalGroup(
            relatorioInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(relatorioInternalFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(restanteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(relatorioInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        desktopPane.add(relatorioInternalFrame);
        relatorioInternalFrame.setBounds(10, 11, 360, 340);

        avisoList.setClosable(true);
        avisoList.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        avisoList.setMaximizable(true);
        avisoList.setResizable(true);
        avisoList.setTitle("Detalhamento");
        avisoList.setVisible(false);

        detalhamentoList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(detalhamentoList);

        javax.swing.GroupLayout avisoListLayout = new javax.swing.GroupLayout(avisoList.getContentPane());
        avisoList.getContentPane().setLayout(avisoListLayout);
        avisoListLayout.setHorizontalGroup(
            avisoListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(avisoListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addContainerGap())
        );
        avisoListLayout.setVerticalGroup(
            avisoListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(avisoListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        desktopPane.add(avisoList);
        avisoList.setBounds(400, 10, 270, 340);

        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 21));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 21));
        jPanel1.setPreferredSize(new java.awt.Dimension(690, 21));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Arquivo retorno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = file.showOpenDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {
            try {
                this.relatorio = Retorno.getRetorno(file.getSelectedFile().toString());
                update();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Data do arquivo inválida");
            } catch (UnsupportedOperationException ex) {
                JOptionPane.showMessageDialog(null, "Erro ocorrido ao adicionar valores no arquivo\n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Find f = new Find(this, true, this.relatorio);
        f.setVisible(true);
        update();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void avisosListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avisosListMouseClicked
        // TODO add your handling code here:
        int index = avisosList.getSelectedIndex();
        if (index != -1) {
            this.avisoList.updateUI();
            this.detalhamentoList.updateUI();
            this.valoresList.updateUI();
            valoresDetalhamento.clear();
            for (Float f : avisos.get(index).getValores()) {
                valoresDetalhamento.addElement(f);
            }
            this.avisoList.setVisible(true);
        }
    }//GEN-LAST:event_avisosListMouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        relatorio = new Relatorio((float)0, new Date());
        update();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        relatorioInternalFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void update() {
        this.dataLabel.setText("Data: " + this.relatorio.getData());
        this.totalLabel.setText("Total: " + this.relatorio.getValorTotal());
        this.restanteLabel.setText("Restante: " + this.relatorio.valorRestante());
        this.valoresRelatorio.clear();
        this.avisos.clear();
        for (Float f : this.relatorio.getValores()) {
            this.valoresRelatorio.addElement(f);
        }
        for (Aviso a : this.relatorio.getRemovidos()) {
            this.avisos.addElement(a);
        }
    }

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
                if ("metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame avisoList;
    private javax.swing.JList avisosList;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JList detalhamentoList;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JInternalFrame relatorioInternalFrame;
    private javax.swing.JLabel restanteLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JList valoresList;
    // End of variables declaration//GEN-END:variables
}
