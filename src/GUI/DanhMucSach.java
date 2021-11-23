/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.model.ChuyenMuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class DanhMucSach extends javax.swing.JPanel {

    /**
     * Creates new form DanhMucSach
     */
    private JFrame jframe = new JFrame();
    int selectedRowIndex;//Vi tri click chuot tren table
    private String macu, mamuc;
    private String sql;
    boolean ktThem;

    private Connection conn;
    private KetNoi ketnoiDB = new KetNoi();
    private Statement stmt;
    private ResultSet re;
    private PreparedStatement ps;

    private DanhMucTheLoai dmTL = new DanhMucTheLoai();
    private List<ChuyenMuc> cm;

    public DanhMucSach() {
        initComponents();
        cm = dmTL.getCm();
        layDataCombo();
        KhoaMo(false);
        mamuc = "";
        layDataTbale();
    }

    public void KhoaMo(boolean b) {
        txtMaSach.setEditable(b);
        txtNhaXB.setEditable(b);
        txtTacGia.setEditable(b);
        txtTenSach.setEditable(b);
        txtSoLuong.setEditable(b);
        cboTheLoai.setEnabled(b);

        cmdThem.setEnabled(!b);
        cmdSua.setEnabled(!b);
        cmdXoa.setEnabled(!b);

        cmdGhi.setEnabled(b);
        cmdKhong.setEnabled(b);

        tbDanhMuc.setEnabled(!b);
    }

    public void XoaTrang() {
        txtMaSach.setText("");
        txtNhaXB.setText("");
        txtTacGia.setText("");
        txtTenSach.setText("");
        txtSoLuong.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbDanhMuc = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        combTim = new javax.swing.JComboBox<>();
        lbThongBao = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTacGia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboTheLoai = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtNhaXB = new javax.swing.JTextField();
        cmdThem = new javax.swing.JButton();
        cmdGhi = new javax.swing.JButton();
        cmdSua = new javax.swing.JButton();
        cmdKhong = new javax.swing.JButton();
        cmdXoa = new javax.swing.JButton();
        cmdAll = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 102, 102));
        setAutoscrolls(true);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbDanhMuc.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        tbDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Chuyên mục", "Tên sách", "Tác giả", "Nhà XB", "Số Lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDanhMuc.setRowHeight(25);
        tbDanhMuc.setShowGrid(true);
        tbDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDanhMucMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDanhMuc);
        if (tbDanhMuc.getColumnModel().getColumnCount() > 0) {
            tbDanhMuc.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbDanhMuc.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 790, 240));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("Chuyên mục :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        combTim.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        combTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combTimActionPerformed(evt);
            }
        });
        add(combTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 261, 45));

        lbThongBao.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbThongBao.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add(lbThongBao, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 179, 28));

        txtSoLuong.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 180, 30));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setText("Tác Giả :");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, -1, -1));

        txtTacGia.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        add(txtTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, 180, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Mã sách :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        cboTheLoai.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        add(cboTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 180, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Tên sách :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Chuyên mục :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Nhà XB :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, -1, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setText("Số lượng");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, -1, -1));

        txtMaSach.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        add(txtMaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 180, 30));

        txtTenSach.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        add(txtTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 180, 30));

        txtNhaXB.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        add(txtNhaXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 460, 180, 30));

        cmdThem.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cmdThem.setText("Thêm");
        cmdThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdThemActionPerformed(evt);
            }
        });
        add(cmdThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, -1, 40));

        cmdGhi.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cmdGhi.setText("Ghi");
        cmdGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGhiActionPerformed(evt);
            }
        });
        add(cmdGhi, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 580, 84, 40));

        cmdSua.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cmdSua.setText("Sửa");
        cmdSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSuaActionPerformed(evt);
            }
        });
        add(cmdSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 580, 86, 40));

        cmdKhong.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cmdKhong.setText("Không");
        cmdKhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKhongActionPerformed(evt);
            }
        });
        add(cmdKhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 580, -1, 42));

        cmdXoa.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cmdXoa.setText("Xóa");
        cmdXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdXoaActionPerformed(evt);
            }
        });
        add(cmdXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 580, 85, 40));

        cmdAll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmdAll.setText("Toàn bộ");
        cmdAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAllActionPerformed(evt);
            }
        });
        add(cmdAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, -1, -1));

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel1.setText("DANH MỤC QUẢN LÝ SÁCH");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, 29));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 810, 50));
    }// </editor-fold>//GEN-END:initComponents

    private DefaultComboBoxModel modelCombTim;
    private DefaultComboBoxModel modelCobTheLoai;

    private void layDataCombo() {
        modelCombTim = new DefaultComboBoxModel();
        modelCobTheLoai = new DefaultComboBoxModel();
        for (ChuyenMuc item : cm) {
            modelCombTim.addElement(item);
            modelCobTheLoai.addElement(item);
        }
        combTim.setModel(modelCombTim);
        cboTheLoai.setModel(modelCobTheLoai);
    }

    private void layValueCbo(String str) {
        int i;
        ChuyenMuc chuyenmuc;
        for (i = 0; i < cboTheLoai.getItemCount(); i++) {
            chuyenmuc = (ChuyenMuc) modelCobTheLoai.getElementAt(i);
            if (str.equals(chuyenmuc.getMaMuc())) {
                cboTheLoai.setSelectedIndex(i);
            }
        }
    }

    private void layDataTbale() {
        DefaultTableModel modelTable = (DefaultTableModel) tbDanhMuc.getModel();
        if (modelTable.getRowCount() > 0) {
            modelTable.setRowCount(0);
        }
        try {
            conn = ketnoiDB.ConnectDB();
            stmt = conn.createStatement();
            if ("".equals(mamuc)) {
                sql = "select * from Sach";
            } else {
                sql = "select * from Sach where mamuc = N'" + mamuc + "'";
            }
            re = stmt.executeQuery(sql);
            while (re.next()) {
                modelTable.addRow(new Object[]{re.getString(1), re.getString(2), re.getString(3), re.getString(4), re.getString(5), re.getString(6)});
            }
            re.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DanhMucSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSach.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbThongBao.setText("Có " + tbDanhMuc.getRowCount() + " đầu sách.");
    }

    private void tbDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDanhMucMouseClicked
        selectedRowIndex = tbDanhMuc.getSelectedRow();

        txtMaSach.setText(tbDanhMuc.getValueAt(selectedRowIndex, 0).toString());
        layValueCbo(tbDanhMuc.getValueAt(selectedRowIndex, 1).toString());
        txtTenSach.setText(tbDanhMuc.getValueAt(selectedRowIndex, 2).toString());
        txtTacGia.setText(tbDanhMuc.getValueAt(selectedRowIndex, 3).toString());
        txtNhaXB.setText(tbDanhMuc.getValueAt(selectedRowIndex, 4).toString());
        txtSoLuong.setText(tbDanhMuc.getValueAt(selectedRowIndex, 5).toString());
    }//GEN-LAST:event_tbDanhMucMouseClicked

    private void combTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combTimActionPerformed
        XoaTrang();
        mamuc = ((ChuyenMuc) combTim.getSelectedItem()).getMaMuc();
        layValueCbo(mamuc);
        layDataTbale();
    }//GEN-LAST:event_combTimActionPerformed

    private void cmdThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdThemActionPerformed
        KhoaMo(true);
        XoaTrang();
        ktThem = true;
    }//GEN-LAST:event_cmdThemActionPerformed

    public boolean ktTrungThem(String manhap) throws ClassNotFoundException, SQLException {
        int row = 0;
        conn = ketnoiDB.ConnectDB();
        sql = "Select * from Sach where masach=N'" + manhap + "'";
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
        sql = "Select * from Sach where MaSach =N'" + manhap + "' and MaSach <> N'" + macu + "'";
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
        if (txtMaSach.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(jframe, "Chưa nhập mã sách.");
            return;
        }
        if (txtTenSach.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(jframe, "Chưa nhập tên sách.");
            return;
        }
        txtMaSach.setText(txtMaSach.getText().toUpperCase());
        if (txtMaSach.getText().trim().length() > 10) {
            JOptionPane.showMessageDialog(jframe, "Độ dài mã sách quá lớn. Chỉ được tối đa 10 ký tự.");
            return;
        }
        if (txtSoLuong.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(jframe, "Chưa nhập số lượng sách sách.");
            return;
        }
        if (ktThem == true) {
            try {
                if (ktTrungThem(txtMaSach.getText()) == true) {
                    JOptionPane.showMessageDialog(jframe, "Trùng sách có mã: " + txtMaSach.getText().trim() + " !", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DanhMucSach.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DanhMucSach.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                if (ktTrungSua(txtMaSach.getText()) == true) {
                    JOptionPane.showMessageDialog(jframe, "Trùng sách có mã: " + txtMaSach.getText().trim() + " !", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DanhMucSach.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DanhMucSach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            conn = ketnoiDB.ConnectDB();
            if (ktThem == true) {
                sql = "insert into Sach(masach,mamuc,tensach,tacgia,nxb,soluong) "
                        + "values(N'" + txtMaSach.getText()
                        + "',N'" + ((ChuyenMuc) cboTheLoai.getSelectedItem()).getMaMuc()
                        + "',N'" + txtTenSach.getText() + "',N'" + txtTacGia.getText()
                        + "',N'" + txtNhaXB.getText() + "'," + txtSoLuong.getText() + ")";
            } else {
                sql = "update Sach set masach=N'" + txtMaSach.getText()
                        + "',mamuc=N'" + ((ChuyenMuc) cboTheLoai.getSelectedItem()).getMaMuc()
                        + "',tensach=N'" + txtTenSach.getText()
                        + "',tacgia='" + txtTacGia.getText() + "',nxb=N'" + txtNhaXB.getText()
                        + "',soluong=" + txtSoLuong.getText()
                        + " where masach=N'" + macu + "'";
            }
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DanhMucSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSach.class.getName()).log(Level.SEVERE, null, ex);
        }
        mamuc = ((ChuyenMuc) cboTheLoai.getSelectedItem()).getMaMuc();
        layValueCbo(mamuc);
        combTim.setSelectedItem(((ChuyenMuc) cboTheLoai.getSelectedItem()));
        KhoaMo(false);
        layDataTbale();
    }//GEN-LAST:event_cmdGhiActionPerformed

    private void cmdSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSuaActionPerformed
        if (txtMaSach.getText().equals("")) {
            return;
        }
        KhoaMo(true);
        macu = txtMaSach.getText();
        ktThem = false;
    }//GEN-LAST:event_cmdSuaActionPerformed

    private void cmdKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKhongActionPerformed
        KhoaMo(false);
        txtMaSach.setText(tbDanhMuc.getValueAt(selectedRowIndex, 0).toString());
        txtTenSach.setText(tbDanhMuc.getValueAt(selectedRowIndex, 2).toString());
        cboTheLoai.setSelectedIndex(combTim.getSelectedIndex());
        txtTacGia.setText(tbDanhMuc.getValueAt(selectedRowIndex, 3).toString());
        txtNhaXB.setText(tbDanhMuc.getValueAt(selectedRowIndex, 4).toString());
        txtSoLuong.setText(tbDanhMuc.getValueAt(selectedRowIndex, 5).toString());
    }//GEN-LAST:event_cmdKhongActionPerformed

    private void cmdXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdXoaActionPerformed
        if (txtMaSach.getText().equals("")) {
            return;
        }
        //tùy chỉnh văn bản cho nút lệnh
        Object[] options = {"Yes", "No"};
        int n = JOptionPane.showOptionDialog(jframe, "Bạn có muốn xóa quển sách nay không ?",
                "MESSAGE",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[1]);
        if (n == 0) {
            try {
                conn = ketnoiDB.ConnectDB();
                sql = "Delete from Sach where MaSach = N'" + txtMaSach.getText() + "'";
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DanhMucSach.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DanhMucSach.class.getName()).log(Level.SEVERE, null, ex);
            }
            layDataTbale();
            XoaTrang();
        }
    }//GEN-LAST:event_cmdXoaActionPerformed

    private void cmdAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAllActionPerformed
        XoaTrang();
        mamuc = "";
        layDataTbale();
    }//GEN-LAST:event_cmdAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboTheLoai;
    private javax.swing.JButton cmdAll;
    private javax.swing.JButton cmdGhi;
    private javax.swing.JButton cmdKhong;
    private javax.swing.JButton cmdSua;
    private javax.swing.JButton cmdThem;
    private javax.swing.JButton cmdXoa;
    private javax.swing.JComboBox<String> combTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JTable tbDanhMuc;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNhaXB;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}
