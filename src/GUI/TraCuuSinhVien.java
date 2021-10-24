/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.model.Sach;
import GUI.model.SinhVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Loi
 */
public class TraCuuSinhVien extends javax.swing.JPanel {

    private int STT;
    private JFrame jframe = new JFrame();
    private String sql;
    private Connection conn;
    private KetNoi ketnoiDB = new KetNoi();
    private Statement stmt;
    private ResultSet re;
    private PreparedStatement ps;

    private List<SinhVien> listSV = new ArrayList<>();
    private String masv;
    private String masach;
    private String sophieu;

    private DefaultTableModel modelTablePhieu;
    private DefaultTableModel modelTableCTPhieu;
    private DefaultTableModel modelTableSinhVien;

    public TraCuuSinhVien() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTenSV = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSinhVien = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbCTPhieu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPhieu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sin viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Sinh Viên :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 26));

        txtTenSV.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtTenSV.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTenSVCaretUpdate(evt);
            }
        });
        jPanel1.add(txtTenSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 340, 30));

        tbSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Lớp", "SDT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSinhVien);
        if (tbSinhVien.getColumnModel().getColumnCount() > 0) {
            tbSinhVien.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbSinhVien.getColumnModel().getColumn(1).setPreferredWidth(180);
            tbSinhVien.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 450, 180));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 480, 280));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết phiếu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbCTPhieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Số phiếu", "Mã sách", "Ngày trả", "Ghi chú trả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbCTPhieu);
        if (tbCTPhieu.getColumnModel().getColumnCount() > 0) {
            tbCTPhieu.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbCTPhieu.getColumnModel().getColumn(1).setPreferredWidth(20);
            tbCTPhieu.getColumnModel().getColumn(2).setPreferredWidth(20);
            tbCTPhieu.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 550, 280));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu Mượn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbPhieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Số phiếu", "Ngày lập", "Người lập", "Mã sinh viên", "Ngay hẹn trả", "Ngày kết thúc", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPhieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhieuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbPhieu);
        if (tbPhieu.getColumnModel().getColumnCount() > 0) {
            tbPhieu.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbPhieu.getColumnModel().getColumn(1).setPreferredWidth(30);
            tbPhieu.getColumnModel().getColumn(2).setMinWidth(50);
            tbPhieu.getColumnModel().getColumn(2).setPreferredWidth(50);
            tbPhieu.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbPhieu.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbPhieu.getColumnModel().getColumn(5).setPreferredWidth(50);
            tbPhieu.getColumnModel().getColumn(6).setPreferredWidth(50);
            tbPhieu.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1010, 220));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 1040, 270));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setText("Tra Cứu Thông Tin Sinh Viên");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, 45));
    }// </editor-fold>//GEN-END:initComponents
    public void showCSDL() {
        int i;
        if (tbSinhVien.getRowCount() > 0) {
            modelTableSinhVien.setRowCount(0);
        }
        modelTableSinhVien = (DefaultTableModel) tbSinhVien.getModel();
        for (i = 0; i < listSV.size(); i++) {
            SinhVien sv = listSV.get(i);
            modelTableSinhVien.addRow(new Object[]{sv.getMaSV(), sv.getHoTen(), sv.getMaLop(), sv.getSDT()});
        }
    }

    public void dsSinhVien() {
        try {
            if (listSV.size() > 0) {
                listSV.clear();
            }
            conn = ketnoiDB.ConnectDB();
            stmt = conn.createStatement();
            sql = "select * from SinhVien Where HoTen like '%" + txtTenSV.getText() + "%' Order by Lop";
            re = stmt.executeQuery(sql);
            while (re.next()) {
                listSV.add(new SinhVien(re.getString(1), re.getString(2), re.getString(3), re.getString(4)));
            }
            re.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TraCuuSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void tbPhieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhieuMouseClicked
        sophieu = (String) tbPhieu.getValueAt(tbPhieu.getSelectedRow(), 1);
        DaTaCTPhieu(sophieu);
    }//GEN-LAST:event_tbPhieuMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        dsSinhVien();
        showCSDL();
    }//GEN-LAST:event_formComponentShown

    private void tbSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSinhVienMouseClicked
        masv = (String) tbSinhVien.getValueAt(tbSinhVien.getSelectedRow(), 0);
        DataTbPhieu(masv);
    }//GEN-LAST:event_tbSinhVienMouseClicked

    private void txtTenSVCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTenSVCaretUpdate
        txtTenSV.requestFocus();
        dsSinhVien();
        showCSDL();
    }//GEN-LAST:event_txtTenSVCaretUpdate

    private void DaTaCTPhieu(String soPhieu) {
        try {
            STT = 0;
            modelTableCTPhieu = (DefaultTableModel) tbCTPhieu.getModel();
            if (tbCTPhieu.getRowCount() > 0) {
                modelTableCTPhieu.setRowCount(0);
            }
            conn = ketnoiDB.ConnectDB();
            stmt = conn.createStatement();
            sql = "Select * From CTPhieu inner join Phieu On CTPhieu.SoPhieu=Phieu.SoPhieu where CTPhieu.SoPhieu =N'" + soPhieu + "'";
            re = stmt.executeQuery(sql);
            while (re.next()) {
                modelTableCTPhieu.addRow(new Object[]{++STT, re.getString("SoPhieu"), re.getString("MaSach"), re.getString("NgayTra"), re.getString("GhiChuTra")});
            }
            conn.close();
            stmt.close();
            re.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TraCuuSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String ktrTrangThai(String a) {
        if (a.equals("1")) {
            return "Đã trả xong";
        } else {
            return "Chưa trả xong";
        }
    }

    private void DataTbPhieu(String maSV) {
        modelTablePhieu = (DefaultTableModel) tbPhieu.getModel();
        if (tbPhieu.getRowCount() > 0) {
            modelTablePhieu.setRowCount(0);
        }
        try {
            STT = 0;
            conn = ketnoiDB.ConnectDB();
            stmt = conn.createStatement();
            sql = "Select * From Phieu Where MaSV=N'" + maSV + "'";
            re = stmt.executeQuery(sql);
            while (re.next()) {
                modelTablePhieu.addRow(new Object[]{++STT, re.getString(1), re.getString(2), re.getString(3), re.getString(4), re.getString(5), re.getString(6), ktrTrangThai(re.getString(7))});
            }
            conn.close();
            stmt.close();
            re.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TraCuuSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbCTPhieu;
    private javax.swing.JTable tbPhieu;
    private javax.swing.JTable tbSinhVien;
    private javax.swing.JTextField txtTenSV;
    // End of variables declaration//GEN-END:variables
}
