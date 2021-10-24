/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.Menu.isOpenFrmPhieuTraSach;
import GUI.model.Sach;
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

    List<Sach> listSach;
    private KetNoi ketnoiDB = new KetNoi();
    private Menu menu = new Menu();

    /**
     * Creates new form panelTimSach
     */
    public TraCuuSach() {
        initComponents();

    }

    private int getSoLuongSachMuon(String maSach) throws ClassNotFoundException, SQLException {
        int soLuong = 0;
        Connection connection = ketnoiDB.ConnectDB();
        String sql = "select MaSach, count(*) as SoLuong from CTPhieu where MaSach=N'" + maSach + "' and (NgayTra IS NULL) group by MaSach";
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            soLuong += rs.getInt("SoLuong");
        }
        return soLuong;
    }

    private void layListSach() {
        listSach = new ArrayList<>();
        if (listSach.size() > 0) {
            listSach.clear();
        }
        try {
            Connection connection = ketnoiDB.ConnectDB();
            if (txtTensach.getText().equals("")) {
                String sql = "SELECT * FROM Sach";
            }
            String sql = "SELECT * FROM Sach Where TenSach like '%" + txtTensach.getText() + "%'";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listSach.add(new Sach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt("SoLuong")));
            }
            rs.close();
            st.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TraCuuSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showCSDL() {
        DefaultTableModel modelTableSach = (DefaultTableModel) tblSach.getModel();
        Sach sach;
        int i;
        if (modelTableSach.getRowCount() > 0) {
            modelTableSach.setRowCount(0);
        }
        for (i = 0; i < listSach.size(); i++) {
            try {
                sach = listSach.get(i);
                modelTableSach.addRow(new Object[]{sach.getTenSach(), sach.getMaSach(), sach.getMaMuc(), sach.getTacGia(), sach.getNhaXB(), (sach.getSoLuong() - getSoLuongSachMuon(sach.getMaSach())), getSoLuongSachMuon(sach.getMaSach())});
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TraCuuSach.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(TraCuuSach.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        cmdReset = new javax.swing.JButton();
        cmdPhieuMuon = new javax.swing.JButton();
        cmdPhieuTra = new javax.swing.JButton();
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setText("Tra Cứu Thông Tin Sách");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 360, 45));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Nhập Tên Sách  Cần Tìm :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 26));

        txtTensach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTensach.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTensachCaretUpdate(evt);
            }
        });
        jPanel1.add(txtTensach, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 270, 30));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearch.setText("Tìm Kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        cmdReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdReset.setText("Reset");
        cmdReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdResetActionPerformed(evt);
            }
        });
        jPanel1.add(cmdReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        cmdPhieuMuon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdPhieuMuon.setText("Lập phiếu mượn");
        cmdPhieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPhieuMuonActionPerformed(evt);
            }
        });
        jPanel1.add(cmdPhieuMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));

        cmdPhieuTra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdPhieuTra.setText("Lập phiếu trả");
        cmdPhieuTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPhieuTraActionPerformed(evt);
            }
        });
        jPanel1.add(cmdPhieuTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 150, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 930, 140));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sách"));
        jPanel2.setToolTipText("Thông tim sách");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSach.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sách", "Mã sách", "Chuyên mục", "Tác Giả", "NXB", "Số Lượng trong kho", "Số lượng sách đang mượn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jScrollPane1.setViewportView(tblSach);
        if (tblSach.getColumnModel().getColumnCount() > 0) {
            tblSach.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblSach.getColumnModel().getColumn(1).setPreferredWidth(10);
            tblSach.getColumnModel().getColumn(2).setPreferredWidth(20);
            tblSach.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblSach.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblSach.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblSach.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, 900, 216));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 930, 260));
        jPanel2.getAccessibleContext().setAccessibleDescription("");
        jPanel2.getAccessibleContext().setAccessibleParent(jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sách đã được mượn"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPhieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Số Phiếu", "Ghi Chú Mượn", "Ngày Lập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, 463, 190));

        lblPhieu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhieu.setText(".");
        jPanel4.add(lblPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 320, 20));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 500, 240));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Sinh Viên mượn"));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSVmuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        if (tblSVmuon.getColumnModel().getColumnCount() > 0) {
            tblSVmuon.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblSVmuon.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblSVmuon.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 370, 190));

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 410, 240));
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        layListSach();
        showCSDL();
    }//GEN-LAST:event_formComponentShown

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtTensach.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Không được rỗng! ");
            txtTensach.requestFocus();
        } else {
            layListSach();
            showCSDL();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cmdResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdResetActionPerformed
        txtTensach.setText("");
        layListSach();
        showCSDL();
    }//GEN-LAST:event_cmdResetActionPerformed

    private void txtTensachCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTensachCaretUpdate
        txtTensach.requestFocus();
        tblSach.removeAll();
        layListSach();
        showCSDL();
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

    private MuonSach muonSach;
    private TraSach traSach;

    private void cmdPhieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPhieuMuonActionPerformed
        //menu.addTab("Mượn Sách", new QuanLyMuonSach());       
        if (Menu.isOpenFrmPhieuMuonSach == false) {
            muonSach = new MuonSach();
            muonSach.setVisible(true);
            Menu.isOpenFrmPhieuMuonSach = true;
        } else {
            JOptionPane.showMessageDialog(this, "Mục Mượn Sách đã được mở !");
            muonSach.setVisible(true);
        }
    }//GEN-LAST:event_cmdPhieuMuonActionPerformed

    private void cmdPhieuTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPhieuTraActionPerformed
        //menu.addTab("Trả Sách", new QuanLyTraSach());
        if (Menu.isOpenFrmPhieuTraSach == false) {
            traSach = new TraSach();
            traSach.setVisible(true);
            Menu.isOpenFrmPhieuTraSach = true;
        } else {
            JOptionPane.showMessageDialog(this, "Mục Trả Sách đã được mở !");
            traSach.setVisible(true);
        }
    }//GEN-LAST:event_cmdPhieuTraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton cmdPhieuMuon;
    private javax.swing.JButton cmdPhieuTra;
    private javax.swing.JButton cmdReset;
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
