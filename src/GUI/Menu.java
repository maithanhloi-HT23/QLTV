/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SingleSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Loi
 */
public class Menu extends javax.swing.JFrame {

    public static boolean isOpenFrmPhieuMuonSach = false;
    private MuonSach muonSach;
    public static boolean isOpenFrmPhieuTraSach = false;
    private TraSach traSach;
    private ImageIcon icon;
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        //setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpMenu = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cmdKetThuc = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        cmdTheLoai = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        cmdSach = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        cmdLop = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        cmdSV = new javax.swing.JMenuItem();
        cmdPhieu = new javax.swing.JMenu();
        cmdPhieuMuon = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        cmdPhieuTra = new javax.swing.JMenuItem();
        ad = new javax.swing.JMenu();
        cmdTimPhieu = new javax.swing.JMenuItem();
        cmdTimSach = new javax.swing.JMenuItem();
        cmdTimSV = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QU???N L?? TH?? VI??N");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(tbpMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 760));

        jMenu1.setText("H??? Th???ng");

        cmdKetThuc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        cmdKetThuc.setIcon(new javax.swing.ImageIcon("D:\\Tai_Lieu\\Java\\JavaSwing\\QLTV\\Pictures\\power-off.png")); // NOI18N
        cmdKetThuc.setText("K???t Th??c");
        cmdKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKetThucActionPerformed(evt);
            }
        });
        jMenu1.add(cmdKetThuc);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Danh M???c");

        cmdTheLoai.setIcon(new javax.swing.ImageIcon("D:\\Tai_Lieu\\Java\\JavaSwing\\QLTV\\Pictures\\book.png")); // NOI18N
        cmdTheLoai.setText("Danh M???c Chuy??n m???c");
        cmdTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTheLoaiActionPerformed(evt);
            }
        });
        jMenu2.add(cmdTheLoai);
        jMenu2.add(jSeparator1);

        cmdSach.setIcon(new javax.swing.ImageIcon("D:\\Tai_Lieu\\Java\\JavaSwing\\QLTV\\Pictures\\bookcase.png")); // NOI18N
        cmdSach.setText("Danh M???c S??ch");
        cmdSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSachActionPerformed(evt);
            }
        });
        jMenu2.add(cmdSach);
        jMenu2.add(jSeparator2);

        cmdLop.setIcon(new javax.swing.ImageIcon("D:\\Tai_Lieu\\Java\\JavaSwing\\QLTV\\Pictures\\classroom.png")); // NOI18N
        cmdLop.setText("Danh M???c L???p");
        cmdLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLopActionPerformed(evt);
            }
        });
        jMenu2.add(cmdLop);
        jMenu2.add(jSeparator3);

        cmdSV.setIcon(new javax.swing.ImageIcon("D:\\Tai_Lieu\\Java\\JavaSwing\\QLTV\\Pictures\\reading.png")); // NOI18N
        cmdSV.setText("Danh M???c Sinh Vi??n");
        cmdSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSVActionPerformed(evt);
            }
        });
        jMenu2.add(cmdSV);

        jMenuBar1.add(jMenu2);

        cmdPhieu.setText("Qu???n L?? Phi???u");

        cmdPhieuMuon.setIcon(new javax.swing.ImageIcon("D:\\Tai_Lieu\\Java\\JavaSwing\\QLTV\\Pictures\\read.png")); // NOI18N
        cmdPhieuMuon.setText("L???p Phi???u M?????n");
        cmdPhieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPhieuMuonActionPerformed(evt);
            }
        });
        cmdPhieu.add(cmdPhieuMuon);
        cmdPhieu.add(jSeparator4);

        cmdPhieuTra.setIcon(new javax.swing.ImageIcon("D:\\Tai_Lieu\\Java\\JavaSwing\\QLTV\\Pictures\\book-signing.png")); // NOI18N
        cmdPhieuTra.setText("L???p Phi???u Tr???");
        cmdPhieuTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPhieuTraActionPerformed(evt);
            }
        });
        cmdPhieu.add(cmdPhieuTra);

        jMenuBar1.add(cmdPhieu);

        ad.setText("Tra C???u");

        cmdTimPhieu.setIcon(new javax.swing.ImageIcon("D:\\Tai_Lieu\\Java\\JavaSwing\\QLTV\\Pictures\\documents.png")); // NOI18N
        cmdTimPhieu.setText("Tra c???u Th??ng tin Phi???u");
        cmdTimPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTimPhieuActionPerformed(evt);
            }
        });
        ad.add(cmdTimPhieu);

        cmdTimSach.setIcon(new javax.swing.ImageIcon("D:\\Tai_Lieu\\Java\\JavaSwing\\QLTV\\Pictures\\search.png")); // NOI18N
        cmdTimSach.setText("Tra c???u th??ng tin S??ch");
        cmdTimSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTimSachActionPerformed(evt);
            }
        });
        ad.add(cmdTimSach);

        cmdTimSV.setIcon(new javax.swing.ImageIcon("D:\\Tai_Lieu\\Java\\JavaSwing\\QLTV\\Pictures\\qualitative-research.png")); // NOI18N
        cmdTimSV.setText("Tra c???u th??ng tin Sinh vi??n");
        cmdTimSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTimSVActionPerformed(evt);
            }
        });
        ad.add(cmdTimSV);

        jMenuBar1.add(ad);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ButtonClose(String title) {
        int index = tbpMenu.indexOfTab(title);
        JPanel pnlTab = new JPanel(new GridBagLayout());
        pnlTab.setOpaque(false);
        JLabel lblTitle = new JLabel(title);
        JButton btnClose = new JButton("x");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;

        pnlTab.add(lblTitle, gbc);

        gbc.gridx++;
        gbc.weightx = 0;

        pnlTab.add(btnClose, gbc);

        tbpMenu.setTabComponentAt(index, pnlTab);
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component selected = tbpMenu.getSelectedComponent();
                if (selected != null) {
                    tbpMenu.remove(selected);
                }
            }
        });
    }

    public void addTab(String title, Component component) {
        if (tbpMenu.indexOfTab(title) <= -1) {
            tbpMenu.addTab(title, component);
            ButtonClose(title);
            tbpMenu.setSelectedIndex(tbpMenu.indexOfTab(title));
        } else {
            tbpMenu.setSelectedIndex(tbpMenu.indexOfTab(title));
            JOptionPane.showMessageDialog(this, "M???c " + title + " ???? ???????c m??? !");
        }
    }

    private void cmdSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSachActionPerformed
        addTab("S??ch",new DanhMucSach());
    }//GEN-LAST:event_cmdSachActionPerformed

    private void cmdPhieuTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPhieuTraActionPerformed
        //addTab("Tr??? S??ch", new QuanLyTraSach());
        if (isOpenFrmPhieuTraSach == false) {
            traSach = new TraSach();
            traSach.setVisible(true);
            isOpenFrmPhieuTraSach = true;
        } else {
            JOptionPane.showMessageDialog(this, "M???c Tr??? S??ch ???? ???????c m??? !");
            traSach.setVisible(true);
        }
    }//GEN-LAST:event_cmdPhieuTraActionPerformed

    private void cmdTimSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTimSVActionPerformed
        addTab("T??m Sinh Vi??n", new TraCuuSinhVien());
    }//GEN-LAST:event_cmdTimSVActionPerformed

    private void cmdTimPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTimPhieuActionPerformed
        addTab("T??m Phi???u", new TraCuuPhieu());
    }//GEN-LAST:event_cmdTimPhieuActionPerformed

    private void cmdKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKetThucActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cmdKetThucActionPerformed

    private void cmdTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTheLoaiActionPerformed
        addTab("Th??? Lo???i", new DanhMucTheLoai());
    }//GEN-LAST:event_cmdTheLoaiActionPerformed

    private void cmdLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLopActionPerformed
        addTab("L???p", new DanhMucLop());
    }//GEN-LAST:event_cmdLopActionPerformed

    private void cmdSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSVActionPerformed
        addTab("Sinh Vi??n", new DanhMucSinhVien());
    }//GEN-LAST:event_cmdSVActionPerformed

    private void cmdPhieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPhieuMuonActionPerformed
        //addTab("M?????n S??ch", new QuanLyMuonSach());      
        if (isOpenFrmPhieuMuonSach == false) {
            muonSach = new MuonSach();
            muonSach.setVisible(true);
            isOpenFrmPhieuMuonSach = true;
        } else {
            JOptionPane.showMessageDialog(this, "M???c M?????n S??ch ???? ???????c m??? !");
            muonSach.setVisible(true);
        }
    }//GEN-LAST:event_cmdPhieuMuonActionPerformed

    private void cmdTimSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTimSachActionPerformed
        addTab("T??m S??ch", new TraCuuSach());
    }//GEN-LAST:event_cmdTimSachActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ad;
    private javax.swing.JMenuItem cmdKetThuc;
    private javax.swing.JMenuItem cmdLop;
    private javax.swing.JMenu cmdPhieu;
    private javax.swing.JMenuItem cmdPhieuMuon;
    private javax.swing.JMenuItem cmdPhieuTra;
    private javax.swing.JMenuItem cmdSV;
    private javax.swing.JMenuItem cmdSach;
    private javax.swing.JMenuItem cmdTheLoai;
    private javax.swing.JMenuItem cmdTimPhieu;
    private javax.swing.JMenuItem cmdTimSV;
    private javax.swing.JMenuItem cmdTimSach;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JTabbedPane tbpMenu;
    // End of variables declaration//GEN-END:variables
}
