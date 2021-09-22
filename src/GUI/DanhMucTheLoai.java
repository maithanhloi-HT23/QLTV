/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Loi
 */
public class DanhMucTheLoai extends javax.swing.JPanel {

    private DefaultTableModel modelTable;
    private JFrame jframe = new JFrame();
    int selectedRowIndex;//Vi tri click chuot tren table
    private String macu;
    private String sql;
    boolean ktThem;

    private Connection conn;
    private KetNoi ketnoiDB = new KetNoi();
    private Statement stmt;
    private ResultSet re;
    private PreparedStatement ps;

    /**
     * Creates new form DanhMucTheLoai
     */
    public DanhMucTheLoai() {
        initComponents();
        modelTable = (DefaultTableModel) tbChuyenMuc.getModel();
        layDataTbale();
        KhoaMo(false);
    }

    private void layDataTbale() {
        try {
            if (modelTable.getRowCount() > 0) {
                modelTable.setRowCount(0);
            }
            conn = ketnoiDB.ConnectDB();
            stmt = conn.createStatement();
            sql = "select * from ChuyenMuc";
            re = stmt.executeQuery(sql);
            while (re.next()) {
                modelTable.addRow(new Object[]{re.getString(1), re.getString(2)});
            }
            re.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucTheLoai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DanhMucTheLoai.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbThongBao.setText("Có " + tbChuyenMuc.getRowCount() + " thể loại.");
    }

    private void KhoaMo(boolean b) {
        txtMaMuc.setEditable(b);
        txtTenMuc.setEditable(b);

        cmdThem.setEnabled(!b);
        cmdSua.setEnabled(!b);
        cmdXoa.setEnabled(!b);

        cmdGhi.setEnabled(b);
        cmdKhong.setEnabled(b);

        tbChuyenMuc.setEnabled(!b);

    }

    private void XoaTrang() {
        txtMaMuc.setText("");
        txtTenMuc.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdThem = new javax.swing.JButton();
        cmdSua = new javax.swing.JButton();
        lbThongBao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbChuyenMuc = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaMuc = new javax.swing.JTextField();
        txtTenMuc = new javax.swing.JTextField();
        cmdXoa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmdGhi = new javax.swing.JButton();
        cmdKhong = new javax.swing.JButton();

        setAutoscrolls(true);

        cmdThem.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cmdThem.setText("Thêm");
        cmdThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdThemActionPerformed(evt);
            }
        });

        cmdSua.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cmdSua.setText("Sửa");
        cmdSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSuaActionPerformed(evt);
            }
        });

        lbThongBao.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbThongBao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbThongBao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbThongBao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tbChuyenMuc.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        tbChuyenMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Mục", "Tên mục"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbChuyenMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbChuyenMucMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbChuyenMuc);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("Mã mục :");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("Tên mục :");

        cmdXoa.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cmdXoa.setText("Xóa");
        cmdXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdXoaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel1.setText("Thể Loại");

        cmdGhi.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cmdGhi.setText("Ghi");
        cmdGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGhiActionPerformed(evt);
            }
        });

        cmdKhong.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cmdKhong.setText("Không");
        cmdKhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(cmdGhi, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdKhong)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(cmdThem)
                                .addGap(32, 32, 32)
                                .addComponent(cmdSua, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(cmdXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaMuc, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(txtTenMuc))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdSua)
                            .addComponent(cmdXoa))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdGhi)
                            .addComponent(cmdKhong)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean ktTrungThem(String manhap) throws ClassNotFoundException, SQLException {
        int row = 0;
        conn = ketnoiDB.ConnectDB();
        sql = "Select * from chuyenmuc where mamuc=N'" + manhap + "'";
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
        sql = "Select * from chuyenmuc where mamuc =N'" + manhap + "' and mamuc<> N'" + macu + "'";
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

    private void cmdThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdThemActionPerformed
        KhoaMo(true);
        XoaTrang();
        ktThem = true;
    }//GEN-LAST:event_cmdThemActionPerformed

    private void cmdSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSuaActionPerformed
        if (txtMaMuc.getText().equals("")) {
            return;
        }
        KhoaMo(true);
        macu = txtMaMuc.getText();
        ktThem = false;
    }//GEN-LAST:event_cmdSuaActionPerformed

    private void tbChuyenMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChuyenMucMouseClicked
        selectedRowIndex = tbChuyenMuc.getSelectedRow();

        txtMaMuc.setText(tbChuyenMuc.getValueAt(selectedRowIndex, 0).toString());
        txtTenMuc.setText(tbChuyenMuc.getValueAt(selectedRowIndex, 1).toString());
    }//GEN-LAST:event_tbChuyenMucMouseClicked

    private void cmdXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdXoaActionPerformed
        if (txtMaMuc.getText().equals("")) {
            return;
        }
        //tùy chỉnh văn bản cho nút lệnh
        Object[] options = {"Yes", "No"};
        int n = JOptionPane.showOptionDialog(jframe, "Bạn có muốn xóa chuyên mục nay không ?",
                "MESSAGE",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[1]);
        if (n == 0) {
            try {
                conn = ketnoiDB.ConnectDB();
                sql = "Delete from chuyenmuc where mamuc = N'" + txtMaMuc.getText() + "'";
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DanhMucTheLoai.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DanhMucTheLoai.class.getName()).log(Level.SEVERE, null, ex);
            }
            XoaTrang();
            layDataTbale();
        }
    }//GEN-LAST:event_cmdXoaActionPerformed

    private void cmdKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKhongActionPerformed
        KhoaMo(false);
        txtMaMuc.setText(tbChuyenMuc.getValueAt(selectedRowIndex, 0).toString());
        txtTenMuc.setText(tbChuyenMuc.getValueAt(selectedRowIndex, 1).toString());
    }//GEN-LAST:event_cmdKhongActionPerformed

    private void cmdGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGhiActionPerformed
        if (txtMaMuc.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(jframe, "Chưa nhập mã chuyên mục.");
            return;
        }
        if (txtTenMuc.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(jframe, "Chưa nhập chuyên mục.");
            return;
        }
        txtMaMuc.setText(txtMaMuc.getText().toUpperCase());
        if (txtMaMuc.getText().trim().length() > 100 || txtTenMuc.getText().trim().length() > 100) {
            JOptionPane.showMessageDialog(jframe, "Độ dài quá lớn. Chỉ được tối đa 100 ký tự.");
            return;
        }
        if (ktThem == true) {
            try {
                if (ktTrungThem(txtMaMuc.getText()) == true) {
                    JOptionPane.showMessageDialog(jframe, "Trùng chuyên mục có mã: " + txtMaMuc.getText().trim() + " !", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DanhMucTheLoai.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DanhMucTheLoai.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                if (ktTrungSua(txtMaMuc.getText()) == true) {
                    JOptionPane.showMessageDialog(jframe, "Trùng chuyên mục có mã: " + txtMaMuc.getText().trim() + " !", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DanhMucTheLoai.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DanhMucTheLoai.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            conn = ketnoiDB.ConnectDB();
            if (ktThem == true) {
                sql = "insert into chuyenmuc(mamuc,tenmuc) "
                        + "values(N'" + txtMaMuc.getText() + "',N'" + txtTenMuc.getText() + "')";
            } else {
                sql = "update chuyenmuc set mamuc= N'" + txtMaMuc.getText()
                        + "', tenmuc= N'" + txtTenMuc.getText() + "' "
                        + "where mamuc= N'" + macu + "'";
            }
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DanhMucTheLoai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucTheLoai.class.getName()).log(Level.SEVERE, null, ex);
        }
        KhoaMo(false);
        layDataTbale();
    }//GEN-LAST:event_cmdGhiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdGhi;
    private javax.swing.JButton cmdKhong;
    private javax.swing.JButton cmdSua;
    private javax.swing.JButton cmdThem;
    private javax.swing.JButton cmdXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JTable tbChuyenMuc;
    private javax.swing.JTextField txtMaMuc;
    private javax.swing.JTextField txtTenMuc;
    // End of variables declaration//GEN-END:variables
}