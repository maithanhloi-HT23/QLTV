/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.toedter.calendar.JTextFieldDateEditor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Loi
 */
public class TraCuuPhieu extends javax.swing.JPanel {

    private JFrame jframe = new JFrame();
    int selectedRowIndex;//Vi tri click chuot tren table
    private String sql;
    private Connection conn;
    private KetNoi ketnoiDB = new KetNoi();
    private Statement stmt;
    private ResultSet re;
    private DefaultTableModel modelTablePhieu;
    private DefaultTableModel modelTableCTPhieu;
    private String sophieu;

    /**
     * Creates new form TraCuuPhieu
     */
    public TraCuuPhieu() {
        initComponents();
        setJDate();
        rdoNgayLap.setSelected(true);
    }

    private void setJDate() {
        dateTuNgay.setDate(new Date());
        dateTuNgay.setDateFormatString("MM/dd/yyyy");

        dateDenNgay.setDate(new Date());
        dateDenNgay.setDateFormatString("MM/dd/yyyy");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmdTimKiem = new javax.swing.JButton();
        dateTuNgay = new com.toedter.calendar.JDateChooser();
        dateDenNgay = new com.toedter.calendar.JDateChooser();
        rdoNgayLap = new javax.swing.JRadioButton();
        rdoNgayHenTra = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        ckbChuaKetThuc = new javax.swing.JCheckBox();
        ckbDaKetThuc = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbCTPhieu = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPhieu = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Từ ngày:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Đến ngày:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        cmdTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdTimKiem.setText("Tìm kiếm");
        cmdTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTimKiemActionPerformed(evt);
            }
        });
        jPanel1.add(cmdTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, -1, -1));

        dateTuNgay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(dateTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, 30));

        dateDenNgay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(dateDenNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 160, 30));

        buttonGroup2.add(rdoNgayLap);
        rdoNgayLap.setText("Ngày Lập");
        jPanel1.add(rdoNgayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, -1));

        buttonGroup2.add(rdoNgayHenTra);
        rdoNgayHenTra.setText("Ngày Hẹn Trả");
        jPanel1.add(rdoNgayHenTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tình trạng :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, 20));

        ckbChuaKetThuc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckbChuaKetThuc.setText("Chưa kết thúc");
        jPanel1.add(ckbChuaKetThuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        ckbDaKetThuc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckbDaKetThuc.setText("Đã kết thúc");
        jPanel1.add(ckbDaKetThuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 840, 150));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết phiếu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbCTPhieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên Sách", "Ngày trả", "Ghi chú trả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbCTPhieu);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 800, 160));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 840, 210));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu Mượn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbPhieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số phiếu", "Ngày lập", "Người lập", "Ma SV", "Ngay hẹn trả", "Ngày kết thúc", "Đã kết thúc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jScrollPane2.setViewportView(tbPhieu);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 800, 220));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 840, 270));
    }// </editor-fold>//GEN-END:initComponents

    private boolean KiemTraTim() {
        LocalDate dateBatDau = dateTuNgay.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dateKetThuc = dateDenNgay.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (dateKetThuc.isBefore(dateBatDau)) {
            JOptionPane.showMessageDialog(this, "Thời gian tìm không hợp lệ");
            return false;
        }
        if (ckbChuaKetThuc.isSelected() == true && ckbDaKetThuc.isSelected() == true || ckbChuaKetThuc.isSelected() == false && ckbDaKetThuc.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Hãy chọn môt trang thái");
            return false;
        }
        return true;
    }

    private void cmdTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTimKiemActionPerformed
        modelTablePhieu = (DefaultTableModel) tbPhieu.getModel();
        if (modelTablePhieu.getRowCount() > 0) {
            modelTablePhieu.setRowCount(0);
        }
        String dieukien;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String TuNgay = sdf.format(dateTuNgay.getDate());
        String DenNgay = sdf.format(dateDenNgay.getDate());
        if (KiemTraTim() == true) {
            try {
                sql = "Select * from Phieu";
                if (rdoNgayLap.isSelected() == true) {
                    dieukien = " NgayLap >='" + TuNgay + "' and NgayLap <='" + DenNgay + "'";
                } else {
                    dieukien = " NgayHenTra >='" + TuNgay + "' and NgayHenTra <='" + DenNgay + "'";
                }

                if (ckbChuaKetThuc.isSelected() == true) {
                    dieukien = dieukien + " And DaKetThuc = 0";
                }
                if (ckbDaKetThuc.isSelected() == true) {
                    dieukien = dieukien + " And DaKetThuc = 1";
                }
                sql = sql + " Where " + dieukien;
                conn = ketnoiDB.ConnectDB();
                stmt = conn.createStatement();
                re = stmt.executeQuery(sql);
                while (re.next()) {
                    modelTablePhieu.addRow(new Object[]{re.getString(1), re.getString(2), re.getString(3), re.getString(4), re.getString(5), re.getString(6), re.getString(7)});
                }
                re.close();
                stmt.close();
                conn.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TraCuuPhieu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(TraCuuPhieu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmdTimKiemActionPerformed

    private void layDaTaCTPhieu() {
        try {
            modelTableCTPhieu = (DefaultTableModel) tbCTPhieu.getModel();
            if (tbCTPhieu.getRowCount() > 0) {
                modelTableCTPhieu.setRowCount(0);
            }
            conn = ketnoiDB.ConnectDB();
            stmt = conn.createStatement();
            sql = "Select Sach.MaSach,TenSach,NgayTra,GhiChuTra From CTPhieu inner join Sach On CTPhieu.MaSach=Sach.MaSach "
                    + " Where SoPhieu='" + sophieu + "'";
            re = stmt.executeQuery(sql);
            while (re.next()) {
                modelTableCTPhieu.addRow(new Object[]{re.getString(1), re.getString(2), re.getString(3),re.getString(4)});
            }
            conn.close();
            stmt.close();
            re.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TraCuuPhieu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuPhieu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void tbPhieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhieuMouseClicked
        sophieu = (String) tbPhieu.getValueAt(tbPhieu.getSelectedRow(), 0);
        layDaTaCTPhieu();
    }//GEN-LAST:event_tbPhieuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox ckbChuaKetThuc;
    private javax.swing.JCheckBox ckbDaKetThuc;
    private javax.swing.JButton cmdTimKiem;
    private com.toedter.calendar.JDateChooser dateDenNgay;
    private com.toedter.calendar.JDateChooser dateTuNgay;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdoNgayHenTra;
    private javax.swing.JRadioButton rdoNgayLap;
    private javax.swing.JTable tbCTPhieu;
    private javax.swing.JTable tbPhieu;
    // End of variables declaration//GEN-END:variables
}
