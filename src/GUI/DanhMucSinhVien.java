/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.model.Lop;
import GUI.model.SinhVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Loi
 */
public class DanhMucSinhVien extends javax.swing.JPanel {

    private JFrame jframe = new JFrame();
    int selectedRowIndex;//Vi tri click chuot tren table
    private String mamuc, macu;
    private String sql;
    boolean ktThem;

    private Connection conn;
    private KetNoi ketnoiDB = new KetNoi();
    private Statement stmt;
    private ResultSet re;
    private PreparedStatement ps;

    private DanhMucLop dmLop = new DanhMucLop();
    private Lop lop = new Lop();
    private List<Lop> listLop;
    private List<SinhVien> listSV;

    /**
     * Creates new form DanhMucSinhVien
     */
    public DanhMucSinhVien() {
        initComponents();
        listLop = dmLop.getLop();
        listSV = new ArrayList<>();
        layDataCombo();
        KhoaMo(false);   
        mamuc = ((Lop) combTim.getSelectedItem()).getMaLop();
        layDataTbale();
    }

    public List<SinhVien> getListSV() {
        return listSV;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combTim = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        lbThongBao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSinhVien = new javax.swing.JTable();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cobLop = new javax.swing.JComboBox<>();
        cmdThem = new javax.swing.JButton();
        cmdGhi = new javax.swing.JButton();
        cmdSua = new javax.swing.JButton();
        cmdKhong = new javax.swing.JButton();
        cmdXoa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 153, 153));
        setPreferredSize(new java.awt.Dimension(690, 390));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        combTim.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        combTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combTimActionPerformed(evt);
            }
        });
        add(combTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 263, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Lớp :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        lbThongBao.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbThongBao.setText(".");
        add(lbThongBao, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 181, -1));

        tbSinhVien.setAutoCreateRowSorter(true);
        tbSinhVien.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        tbSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã ", "Tên ", "Lớp", "SĐT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSinhVien.setRowHeight(30);
        tbSinhVien.setShowGrid(true);
        tbSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSinhVien);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 728, 250));

        txtMa.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        add(txtMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 189, -1));

        txtTen.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 189, -1));

        txtSDT.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, 290, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Mã :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Họ tên :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Lớp :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, -1, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setText("SĐT :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, -1, -1));

        cobLop.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        add(cobLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 288, -1));

        cmdThem.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        cmdThem.setText("Thêm");
        cmdThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdThemActionPerformed(evt);
            }
        });
        add(cmdThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, 45));

        cmdGhi.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        cmdGhi.setText("Ghi");
        cmdGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGhiActionPerformed(evt);
            }
        });
        add(cmdGhi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 70, 45));

        cmdSua.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        cmdSua.setText("Sửa");
        cmdSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSuaActionPerformed(evt);
            }
        });
        add(cmdSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 69, 45));

        cmdKhong.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        cmdKhong.setText("Không");
        cmdKhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKhongActionPerformed(evt);
            }
        });
        add(cmdKhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 500, -1, 47));

        cmdXoa.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        cmdXoa.setText("Xóa");
        cmdXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdXoaActionPerformed(evt);
            }
        });
        add(cmdXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 71, 43));

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("DANH MỤC QUẢN LÝ SINH VIÊN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 720, 50));
    }// </editor-fold>//GEN-END:initComponents

    public void KhoaMo(boolean b) {
        txtMa.setEditable(b);
        txtTen.setEditable(b);
        txtSDT.setEditable(b);
        cobLop.setEnabled(b);

        cmdThem.setEnabled(!b);
        cmdSua.setEnabled(!b);
        cmdXoa.setEnabled(!b);

        cmdGhi.setEnabled(b);
        cmdKhong.setEnabled(b);

        tbSinhVien.setEnabled(!b);
    }

    public void XoaTrang() {
        txtMa.setText("");
        txtTen.setText("");
        txtSDT.setText("");
    }

    private DefaultComboBoxModel modelCombTim;
    private DefaultComboBoxModel modelCobLop;
    
    private void layDataCombo() {
        modelCombTim = new DefaultComboBoxModel();
        modelCobLop = new DefaultComboBoxModel();
        for (Lop item : listLop) {
            modelCombTim.addElement(item);
            modelCobLop.addElement(item);
        }
        combTim.setModel(modelCombTim);
        cobLop.setModel(modelCobLop);
    }

    private void layValueCbo(String str) {
        int i;
        Lop lop;
        for (i = 0; i < cobLop.getItemCount(); i++) {
            lop = (Lop) modelCobLop.getElementAt(i);
            if(str.equals(lop.getMaLop()))
            cobLop.setSelectedIndex(i);
        }
    }

    private void layDataTbale() {
        DefaultTableModel modelTable = (DefaultTableModel) tbSinhVien.getModel();
        if (modelTable.getRowCount() > 0) {
            modelTable.setRowCount(0);
        }
        if (listSV.isEmpty() == false) {
           listSV.clear();
        }
        try {
            conn = ketnoiDB.ConnectDB();
            stmt = conn.createStatement();
            sql = "select * from SinhVien where lop = N'" + mamuc + "'";
            re = stmt.executeQuery(sql);
            while (re.next()) {
                listSV.add(new SinhVien(re.getString(1), re.getString(2), re.getString(3), re.getString(4)));
            }
            re.close();
            stmt.close();
            conn.close();
            for (SinhVien item : listSV) {
                modelTable.addRow(new Object[]{item.getMaSV(), item.getHoTen(),item.getMaLop(),item.getSDT()});
            }         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DanhMucSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbThongBao.setText("Có " + tbSinhVien.getRowCount() + " sinh viên.");
    }

    private void combTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combTimActionPerformed
        XoaTrang();
        mamuc = ((Lop) combTim.getSelectedItem()).getMaLop();
        layValueCbo(mamuc);
        layDataTbale();
    }//GEN-LAST:event_combTimActionPerformed

    private void tbSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSinhVienMouseClicked
        selectedRowIndex = tbSinhVien.getSelectedRow();

        txtMa.setText(tbSinhVien.getValueAt(selectedRowIndex, 0).toString());
        txtTen.setText(tbSinhVien.getValueAt(selectedRowIndex, 1).toString());
        layValueCbo(tbSinhVien.getValueAt(selectedRowIndex, 2).toString());
        txtSDT.setText(tbSinhVien.getValueAt(selectedRowIndex, 3).toString());
    }//GEN-LAST:event_tbSinhVienMouseClicked

    private void cmdThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdThemActionPerformed
        KhoaMo(true);
        XoaTrang();
        ktThem = true;
    }//GEN-LAST:event_cmdThemActionPerformed

    public boolean ktTrungThem(String manhap) throws ClassNotFoundException, SQLException {
        int row = 0;
        conn = ketnoiDB.ConnectDB();
        sql = "Select * from SinhVien where masv=N'" + manhap + "'";
        stmt = conn.createStatement();
        re = stmt.executeQuery(sql);
        while (re.next()) {
            row++;
        }
        if (row > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ktTrungSua(String manhap) throws ClassNotFoundException, SQLException {
        int row = 0;
        conn = ketnoiDB.ConnectDB();
        sql = "Select * from SinhVien where MaSV =N'" + manhap + "' and MaSV <> N'" + macu + "'";
        stmt = conn.createStatement();
        re = stmt.executeQuery(sql);
        while (re.next()) {
            row++;
        }
        if (row > 0) {
            return true;
        } else {
            return false;
        }
    }

    private void cmdGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGhiActionPerformed
        if (txtMa.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(jframe, "Chưa nhập mã sinh viên.");
            return;
        }
        if (txtTen.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(jframe, "Chưa nhập tên.");
            return;
        }
        txtMa.setText(txtMa.getText().toUpperCase());
        if (txtMa.getText().trim().length() > 10) {
            JOptionPane.showMessageDialog(jframe, "Độ dài mã sinh viên quá lớn. Chỉ được tối đa 10 ký tự.");
            return;
        }
        if (ktThem == true) {
            try {
                if (ktTrungThem(txtMa.getText()) == true) {
                    JOptionPane.showMessageDialog(jframe, "Trùng sinh viên có mã: " + txtMa.getText().trim() + " !", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DanhMucTheLoai.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DanhMucTheLoai.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                if (ktTrungSua(txtMa.getText()) == true) {
                    JOptionPane.showMessageDialog(jframe, "Trùng sinh viên có mã: " + txtMa.getText().trim() + " !", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DanhMucSinhVien.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DanhMucSinhVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            conn = ketnoiDB.ConnectDB();
            if (ktThem == true) {
                sql = "insert into sinhvien(masv,hoten,lop,sdt) values(N'" + txtMa.getText()
                        + "',N'" + txtTen.getText()
                        + "',N'" + ((Lop)cobLop.getSelectedItem()).getMaLop()
                        + "',N'" + txtSDT.getText() + "')";
            } else {
                sql = "update sinhvien set masv=N'" + txtMa.getText()
                        + "',hoten=N'" + txtTen.getText()
                        + "',lop=N'" + ((Lop)cobLop.getSelectedItem()).getMaLop()
                        + "',sdt=N'" + txtSDT.getText() + "' where masv=N'" + macu + "'";
            }
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DanhMucSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        mamuc = ((Lop) cobLop.getSelectedItem()).getMaLop();
        KhoaMo(false);
        layValueCbo(mamuc);
        layDataTbale();
    }//GEN-LAST:event_cmdGhiActionPerformed

    private void cmdSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSuaActionPerformed
        if (txtMa.getText().equals("")) {
            return;
        }
        KhoaMo(true);
        macu = txtMa.getText();
        ktThem = false;
    }//GEN-LAST:event_cmdSuaActionPerformed

    private void cmdKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKhongActionPerformed
        KhoaMo(false);

        txtMa.setText(tbSinhVien.getValueAt(selectedRowIndex, 0).toString());
        txtTen.setText(tbSinhVien.getValueAt(selectedRowIndex, 1).toString());
    }//GEN-LAST:event_cmdKhongActionPerformed

    private void cmdXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdXoaActionPerformed
        if (txtMa.getText().equals("")) {
            return;
        }
        //tùy chỉnh văn bản cho nút lệnh
        Object[] options = {"Yes", "No"};
        int n = JOptionPane.showOptionDialog(jframe, "Bạn có muốn xóa sinh viên nay không ?",
                "MESSAGE",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[1]);
        if (n == 0) {
            try {
                conn = ketnoiDB.ConnectDB();
                sql = "Delete from SinhVien where MaSV = N'" + txtMa.getText() + "'";
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DanhMucSinhVien.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DanhMucSinhVien.class.getName()).log(Level.SEVERE, null, ex);
            }

            layDataTbale();
            XoaTrang();
        }
    }//GEN-LAST:event_cmdXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdGhi;
    private javax.swing.JButton cmdKhong;
    private javax.swing.JButton cmdSua;
    private javax.swing.JButton cmdThem;
    private javax.swing.JButton cmdXoa;
    private javax.swing.JComboBox<String> cobLop;
    private javax.swing.JComboBox<String> combTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JTable tbSinhVien;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
