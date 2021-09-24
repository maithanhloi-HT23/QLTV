/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.model.Lop;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Loi
 */
public class DanhMucLop extends javax.swing.JPanel {

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

    private List<Lop> lop;

    /**
     * Creates new form DanhMucLop
     */
    public DanhMucLop() {
        initComponents();
        lop = new ArrayList<>();
        KhoaMo(false);
        layDataTbale();
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
        cmdXoa = new javax.swing.JButton();
        txtMa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        lbThongBao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLop = new javax.swing.JTable();
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

        cmdXoa.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cmdXoa.setText("Xóa");
        cmdXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdXoaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("Mã lớp :");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ LỚP");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("Tên lớp:");

        lbThongBao.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbThongBao.setText(".");

        tbLop.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        tbLop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã lớp", "Tên lớp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLopMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLop);

        cmdGhi.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cmdGhi.setText("Ghi");
        cmdGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGhiActionPerformed(evt);
            }
        });

        cmdKhong.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(txtTen)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdThem, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(cmdSua, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(cmdXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdGhi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(cmdKhong)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmdSua)
                                .addComponent(cmdXoa))
                            .addComponent(cmdThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmdKhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdGhi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public List<Lop> getLop() {
        return lop;
    }

    private void KhoaMo(boolean b) {
        txtMa.setEditable(b);
        txtTen.setEditable(b);

        cmdThem.setEnabled(!b);
        cmdSua.setEnabled(!b);
        cmdXoa.setEnabled(!b);

        cmdGhi.setEnabled(b);
        cmdKhong.setEnabled(b);

        tbLop.setEnabled(!b);

    }

    private void XoaTrang() {
        txtMa.setText("");
        txtTen.setText("");
    }

    private void layDataTbale() {
        DefaultTableModel modelTable = (DefaultTableModel) tbLop.getModel();
        if (lop.isEmpty() == false) {
            lop.clear();
        }
        if (modelTable.getRowCount() > 0) {
            modelTable.setRowCount(0);
        }
        try {
            conn = ketnoiDB.ConnectDB();
            stmt = conn.createStatement();
            sql = "select * from lop";
            re = stmt.executeQuery(sql);
            while (re.next()) {
                lop.add(new Lop(re.getString(1), re.getString(2)));
            }
            re.close();
            stmt.close();
            conn.close();
            for (Lop item : lop) {
                modelTable.addRow(new Object[]{item.getMaLop(), item.getTenLop()});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DanhMucLop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucLop.class.getName()).log(Level.SEVERE, null, ex);
        }

        lbThongBao.setText("Có " + tbLop.getRowCount() + " lớp.");
    }

    private void cmdThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdThemActionPerformed
        KhoaMo(true);
        XoaTrang();
        ktThem = true;
    }//GEN-LAST:event_cmdThemActionPerformed

    private void cmdSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSuaActionPerformed
        if (txtMa.getText().equals("")) {
            return;
        }
        KhoaMo(true);
        macu = txtMa.getText();
        ktThem = false;
    }//GEN-LAST:event_cmdSuaActionPerformed

    private void cmdXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdXoaActionPerformed
        if (txtMa.getText().equals("")) {
            return;
        }
        //tùy chỉnh văn bản cho nút lệnh
        Object[] options = {"Yes", "No"};
        int n = JOptionPane.showOptionDialog(jframe, "Bạn có muốn xóa lớp nay không ?",
                "MESSAGE",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[1]);
        if (n == 0) {
            try {
                conn = ketnoiDB.ConnectDB();
                sql = "Delete from lop where malop = N'" + txtMa.getText() + "'";
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DanhMucLop.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DanhMucLop.class.getName()).log(Level.SEVERE, null, ex);
            }

            layDataTbale();
            XoaTrang();
        }
    }//GEN-LAST:event_cmdXoaActionPerformed

    private void tbLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLopMouseClicked
        selectedRowIndex = tbLop.getSelectedRow();

        txtMa.setText(tbLop.getValueAt(selectedRowIndex, 0).toString());
        txtTen.setText(tbLop.getValueAt(selectedRowIndex, 1).toString());
    }//GEN-LAST:event_tbLopMouseClicked

    public boolean ktTrungThem(String manhap) throws ClassNotFoundException, SQLException {
        int row = 0;
        conn = ketnoiDB.ConnectDB();
        sql = "Select * from lop where malop=N'" + manhap + "'";
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
        sql = "Select * from lop where MaLop =N'" + manhap + "' and MaLop <> N'" + macu + "'";
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
            JOptionPane.showMessageDialog(jframe, "Chưa nhập mã Lớp.");
            return;
        }
        if (txtTen.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(jframe, "Chưa nhập Lớp.");
            return;
        }
        txtMa.setText(txtMa.getText().toUpperCase());
        if (txtMa.getText().trim().length() > 10) {
            JOptionPane.showMessageDialog(jframe, "Độ dài mã lớp quá lớn. Chỉ được tối đa 10 ký tự.");
            return;
        }
        if (ktThem == true) {
            try {
                if (ktTrungThem(txtMa.getText()) == true) {
                    JOptionPane.showMessageDialog(jframe, "Trùng lớp có mã: " + txtMa.getText().trim() + " !", "Error", JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(jframe, "Trùng lớp có mã: " + txtMa.getText().trim() + " !", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DanhMucLop.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DanhMucLop.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            conn = ketnoiDB.ConnectDB();
            if (ktThem == true) {
                sql = "insert into lop(MaLop,TenLop) "
                        + "values(N'" + txtMa.getText() + "',N'" + txtTen.getText() + "')";
            } else {
                sql = "update lop set MaLop= N'" + txtMa.getText()
                        + "', TenLop= N'" + txtTen.getText() + "' "
                        + "where MaLop= N'" + macu + "'";
            }
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DanhMucLop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucLop.class.getName()).log(Level.SEVERE, null, ex);
        }
        KhoaMo(false);
        layDataTbale();
    }//GEN-LAST:event_cmdGhiActionPerformed

    private void cmdKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKhongActionPerformed
        KhoaMo(false);

        txtMa.setText(tbLop.getValueAt(selectedRowIndex, 0).toString());
        txtTen.setText(tbLop.getValueAt(selectedRowIndex, 1).toString());
    }//GEN-LAST:event_cmdKhongActionPerformed


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
    private javax.swing.JTable tbLop;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
