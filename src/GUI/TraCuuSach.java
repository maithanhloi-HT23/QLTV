/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author botru
 */
public class TraCuuSach extends javax.swing.JPanel {
//    private fromSach formSach;
//    private fromPhieuMuon formPhieumuon;

    private KetNoi ketnoiDB = new KetNoi();
    private Menu menu = new Menu();

    /**
     * Creates new form panelTimSach
     */
    public TraCuuSach() {
        initComponents();
    }

    public void showCSDL() {
        try {
            tblSach.removeAll();
            String[] arr = {"Tên Sách", "Mã Sách", "Tác Giả", "Nhà xuất bản", "Số Lượng"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);

            Connection connection = ketnoiDB.ConnectDB();
            String sql = "SELECT TenSach,MaSach,TacGia,NXB,SoLuong FROM Sach";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Vector dataSv = new Vector();
                dataSv.add(rs.getString("TenSach"));
                dataSv.add(rs.getString("MaSach"));
                dataSv.add(rs.getString("TacGia"));
                dataSv.add(rs.getString("NXB"));
                dataSv.add(rs.getString("SoLuong"));
                model.addRow(dataSv);
            }
            tblSach.setModel(model);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TraCuuSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showCSDLPhieu(String MaSach) {
        try {
            tblPhieu.removeAll();
            String[] arr = {"Mã Sách", "Số Phiếu", "Ghi Chú Mượn", "Ngày Lập"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);

            Connection connection = ketnoiDB.ConnectDB();
            String sql = "Select * from Phieu inner join CTPhieu on Phieu.SoPhieu=CTPhieu.SoPhieu where MaSach= N'" + MaSach + "' and (NgayTra IS NULL)";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Vector dataSv = new Vector();
                dataSv.add(rs.getString("MaSach"));
                dataSv.add(rs.getString("SoPhieu"));
                dataSv.add(rs.getString("GhiChuMuon"));
                dataSv.add(rs.getString("NgayLap"));
                model.addRow(dataSv);
            }
            tblPhieu.setModel(model);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TraCuuSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showCSDLSinhVienMuon(String MaS) {
        try {
            tblSVmuon.removeAll();
            String[] arr = {"Mã SV", "Họ Tên", "Lớp"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);

            Connection connection = ketnoiDB.ConnectDB();
            String sql = "SELECT Phieu.SoPhieu,Phieu.MaSV,SinhVien.HoTen,SinhVien.Lop FROM Phieu,SinhVien Where Phieu.MaSV=SinhVien.MaSV and SoPhieu='" + MaS + "'";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Vector dataSv = new Vector();
                dataSv.add(rs.getString("MaSV"));
                dataSv.add(rs.getString("HoTen"));
                dataSv.add(rs.getString("Lop"));
                model.addRow(dataSv);
            }
            tblSVmuon.setModel(model);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TraCuuSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTensach = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPhieu = new javax.swing.JTable();
        lblPhieu = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSVmuon = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 153, 153));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setText("Tìm Kiếm Sách");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 276, 45));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 0));
        jLabel2.setText("Nhập Tên Sách  Cần Tìm :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, -1, 26));

        txtTensach.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTensachCaretUpdate(evt);
            }
        });
        jPanel1.add(txtTensach, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 26, 248, -1));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setText("Tìm Kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 59, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 59, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 900, 100));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sách"));
        jPanel2.setToolTipText("Thông tim sách");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jScrollPane1ComponentShown(evt);
            }
        });

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên sách", "Mã sách", "Tác Giả", "NXB", "Số Lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachMouseClicked(evt);
            }
        });
        tblSach.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tblSachComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(tblSach);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, 868, 216));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 126, 900, 260));
        jPanel2.getAccessibleContext().setAccessibleDescription("");
        jPanel2.getAccessibleContext().setAccessibleParent(jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sách đã được mượn"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPhieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Số Phiếu", "Ghi Chú Mượn", "Ngày Lập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPhieu);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, 463, 167));

        lblPhieu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhieu.setText(".");
        jPanel4.add(lblPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 320, 20));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 421, 500, 230));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Sinh Viên mượn"));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSVmuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã SV", "Họ Tên", "Lớp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblSVmuon);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 360, 180));

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 380, 230));
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jScrollPane1ComponentShown

    }//GEN-LAST:event_jScrollPane1ComponentShown

    private void tblSachComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblSachComponentShown

    }//GEN-LAST:event_tblSachComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        showCSDL();
    }//GEN-LAST:event_formComponentShown

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtTensach.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Không được rỗng! ");
            txtTensach.requestFocus();
        } else {
            tblSach.removeAll();
            String[] arr = {"Tên Sách", "Mã Sách", "Tác Giả", "Nhà xuất bản", "Số Lượng"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            ResultSet rs = null;
            try {
                Connection connection = ketnoiDB.ConnectDB();
                String sql = "SELECT TenSach,MaSach,TacGia,NXB,SoLuong FROM Sach Where TenSach like '%" + txtTensach.getText() + "%'";
                PreparedStatement st = connection.prepareStatement(sql);
                rs = st.executeQuery();
                while (rs.next()) {
                    Vector dataS = new Vector();
                    dataS.add(rs.getString("TenSach"));
                    dataS.add(rs.getString("MaSach"));
                    dataS.add(rs.getString("TacGia"));
                    dataS.add(rs.getString("NXB"));
                    dataS.add(rs.getString("SoLuong"));
                    model.addRow(dataS);
                }
                tblSach.setModel(model);
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Sách không tồn tại trong thư viện! ");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TraCuuSach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showCSDL();
        txtTensach.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTensachCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTensachCaretUpdate
        txtTensach.requestFocus();
        tblSach.removeAll();
        String[] arr = {"Tên Sách", "Mã Sách", "Tác Giả", "Nhà xuất bản", "Số Lượng"};
        DefaultTableModel model = new DefaultTableModel(arr, 0);
        ResultSet rs = null;
        try {
            Connection connection = ketnoiDB.ConnectDB();
            String sql = "SELECT TenSach,MaSach,TacGia,NXB,SoLuong FROM Sach Where TenSach like '%" + txtTensach.getText() + "%'";
            PreparedStatement st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Vector dataS = new Vector();
                dataS.add(rs.getString("TenSach"));
                dataS.add(rs.getString("MaSach"));
                dataS.add(rs.getString("TacGia"));
                dataS.add(rs.getString("NXB"));
                dataS.add(rs.getString("SoLuong"));
                model.addRow(dataS);
            }
            tblSach.setModel(model);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TraCuuSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTensachCaretUpdate

    private void tblSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblSach.getModel();
        String MaSach = (String) model.getValueAt(tblSach.getSelectedRow(), 1);
        showCSDLPhieu(MaSach);
        lblPhieu.setText("Có " + tblPhieu.getRowCount() + " phiếu mượn quyển này. ");
    }//GEN-LAST:event_tblSachMouseClicked

    private void tblPhieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblPhieu.getModel();
        String MaS = (String) model.getValueAt(tblPhieu.getSelectedRow(), 1);
        showCSDLSinhVienMuon(MaS);

    }//GEN-LAST:event_tblPhieuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblPhieu;
    private javax.swing.JTable tblPhieu;
    private javax.swing.JTable tblSVmuon;
    private javax.swing.JTable tblSach;
    private javax.swing.JTextField txtTensach;
    // End of variables declaration//GEN-END:variables
}
