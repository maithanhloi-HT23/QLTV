/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.model.Sach;
import GUI.model.SinhVien;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Loi
 */
public class TraSach extends javax.swing.JFrame {

    private JFrame jframe = new JFrame();
    int selectedRowIndex;//Vi tri click chuot tren table
    private String sql;
    private Connection conn;
    private KetNoi ketnoiDB = new KetNoi();
    private Statement stmt;
    private ResultSet re;
    private PreparedStatement ps;

    private List<SinhVien> listSV = new ArrayList<>();
    private SinhVien svHienTai;
    private String masv;
    private String masach;
    private String sophieu;

    private List<Sach> listSachMuon = new ArrayList<>();
    private DefaultTableModel modelTablePhieu;
    private DefaultTableModel modelTableCTPhieu;

    /**
     * Creates new form TraSach
     */
    public TraSach() {
        initComponents();
        setLocationRelativeTo(null);
        dsSinhVien();
        searchReadTime();
        setJDate();
        txtHoTen.setEditable(false);
        txtNguoiLap.setEditable(false);
        txtSoPhieu.setEditable(false);
        txtTenSach.setEditable(false);
        DateHenTra.setEditable(false);
        DateMuon.setEditable(false);

        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Menu.isOpenFrmPhieuTraSach = false;
            }

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Menu.isOpenFrmPhieuTraSach = false;
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbThonBao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListMaSV = new javax.swing.JList<>();
        lblThongBao = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSoPhieu = new javax.swing.JTextField();
        txtNguoiLap = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbCTPhieu = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        cmdGhiTra = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        DateMuon = new javax.swing.JTextField();
        DateHenTra = new javax.swing.JTextField();
        dateTra = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPhieu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Trả sách");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbThonBao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm sinh viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        tbThonBao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Mã sinh viên :");
        tbThonBao.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 33, -1, -1));

        txtMaSV.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tbThonBao.add(txtMaSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 30, 261, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Họ tên :");
        tbThonBao.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 190, -1, -1));

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbThonBao.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 184, 261, 32));

        jListMaSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMaSVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListMaSV);

        tbThonBao.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 60, 261, 90));

        lblThongBao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblThongBao.setText(".");
        tbThonBao.add(lblThongBao, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 362, -1));

        getContentPane().add(tbThonBao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 270));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết phiếu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Số phiếu:");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 35, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Ngày lập:");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 83, -1, 32));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Người lập:");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 35, -1, -1));
        jPanel3.add(txtSoPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 30, 152, 33));
        jPanel3.add(txtNguoiLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 28, 155, 37));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Ngày hẹn trả:");
        jLabel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 83, -1, 32));

        tbCTPhieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên Sách", "Ngày trả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCTPhieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCTPhieuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbCTPhieu);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 490, 160));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tên sách: ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Ghi chú trả:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, 20));

        txtTenSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(txtTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 280, 35));

        txtGhiChu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(txtGhiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 280, 35));

        cmdGhiTra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdGhiTra.setText("Ghi trả sách");
        cmdGhiTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGhiTraActionPerformed(evt);
            }
        });
        jPanel3.add(cmdGhiTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 360, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Ngày trả:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, -1, -1));
        jPanel3.add(DateMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 150, 40));
        jPanel3.add(DateHenTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 150, 40));
        jPanel3.add(dateTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 280, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1110, 330));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu Mượn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbPhieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số phiếu", "Ngày lập", "Người lập", "Mã Sinh Viên", "Ngay hẹn trả", "Ngày kết thúc", "Đã kết thúc"
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 640, 220));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 670, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void dsSinhVien() {
        try {
            conn = ketnoiDB.ConnectDB();
            stmt = conn.createStatement();
            sql = "select * from SinhVien";
            re = stmt.executeQuery(sql);
            while (re.next()) {
                listSV.add(new SinhVien(re.getString(1), re.getString(2), re.getString(3), re.getString(4)));
            }
            re.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TraSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TraSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clickTim() {
        masv = txtMaSV.getText().toString().trim();
        if (!masv.isEmpty()) {
            for (int i = 0; i < listSV.size(); i++) {
                SinhVien sv = listSV.get(i);
                if (sv.getMaSV().equals(masv)) {
                    txtHoTen.setText(sv.getHoTen());
                    svHienTai = sv;
                }
            }
        }
    }

    public double demSachMuon() throws ClassNotFoundException, SQLException {
        double soSach = 0;
        if (masv == "") {
            return 0;
        }
        conn = ketnoiDB.ConnectDB();
        stmt = conn.createStatement();
        sql = "Select * from Phieu inner join CTPhieu on Phieu.SoPhieu=CTPhieu.SoPhieu where MaSV = N'" + masv + "' and (NgayTra IS NULL)";
        re = stmt.executeQuery(sql);
        while (re.next()) {
            soSach++;
        }
        re.close();
        stmt.close();
        conn.close();
        return soSach;
    }

    private void jListMaSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMaSVMouseClicked
        int index = jListMaSV.locationToIndex(evt.getPoint());
        if (index >= 0) {
            String s = (String) jListMaSV.getModel().getElementAt(index);
            txtMaSV.setText(s);
            clickTim();
            jListMaSV.setVisible(false);
        }
        try {
            if (demSachMuon() == 0) {
                lblThongBao.setText("");
            } else {
                lblThongBao.setText("Sinh viên đang mượn " + demSachMuon() + " cuốn sách.");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TraSach.class.getName()).log(Level.SEVERE, null, ex);
        }
        lapDataTbPhieu();
    }//GEN-LAST:event_jListMaSVMouseClicked

    private void tbCTPhieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTPhieuMouseClicked
        selectedRowIndex = tbCTPhieu.getSelectedRow();
        if (tbCTPhieu.getValueAt(selectedRowIndex, 2) == null) {
            masach = tbCTPhieu.getValueAt(selectedRowIndex, 0).toString();
            txtTenSach.setText(tbCTPhieu.getValueAt(selectedRowIndex, 1).toString());
        } else {
            txtTenSach.setText("");
            txtGhiChu.setText("");
        }
    }//GEN-LAST:event_tbCTPhieuMouseClicked

    private void cmdGhiTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGhiTraActionPerformed
        if (txtTenSach.getText().equals("")) {
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
                sql = "UPDATE CTPhieu SET NgayTra='" + dateTra.getText() + "',GhiChuTra =N'" + txtGhiChu.getText()
                        + "' WHERE SoPhieu=N'" + sophieu + "' And MaSach=N'" + masach + "'";
                conn = ketnoiDB.ConnectDB();
                ps = conn.prepareStatement(sql);
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(jframe, "Bạn ghi trả sách thành công.");
                txtTenSach.setText("");
                txtGhiChu.setText("");
                kiemtraketthucphieu();
                capNhatSoLuongSach();
                if (demSachMuon() == 0) {
                    lblThongBao.setText("");
                } else {
                    lblThongBao.setText("Sinh viên đang mượn " + demSachMuon() + " cuốn sách.");
                }
                if (tbPhieu.getRowCount() <= 0) {
                    modelTableCTPhieu.setRowCount(0);
                } else {
                    layDaTaCTPhieu();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TraSach.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(TraSach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmdGhiTraActionPerformed

    private void tbPhieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhieuMouseClicked
        selectedRowIndex = tbPhieu.getSelectedRow();

        txtNguoiLap.setText(tbPhieu.getValueAt(selectedRowIndex, 2).toString());
        txtSoPhieu.setText(tbPhieu.getValueAt(selectedRowIndex, 0).toString());
        DateHenTra.setText((String) tbPhieu.getValueAt(selectedRowIndex, 4));
        DateMuon.setText((String) tbPhieu.getValueAt(selectedRowIndex, 1));
        layDaTaCTPhieu();
        sophieu = txtSoPhieu.getText();
    }//GEN-LAST:event_tbPhieuMouseClicked

    private void kiemtraketthucphieu() {
        try {
            int row = 0;
            sql = "Select * From CTPhieu Where SoPhieu='" + sophieu + "' and (NgayTra IS NULL)";
            conn = ketnoiDB.ConnectDB();
            stmt = conn.createStatement();
            re = stmt.executeQuery(sql);
            while (re.next()) {
                row++;
            }
            re.close();
            stmt.close();
            if (row <= 0) {
                sql = "UPDATE Phieu SET NgayKetThuc='" + dateTra.getText() + "',DaKetThuc=1"
                        + " WHERE SoPhieu = N'" + sophieu + "'";
                ps = conn.prepareStatement(sql);
                ps.executeUpdate();
                ps.close();
                lapDataTbPhieu();
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TraSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TraSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void capNhatSoLuongSach() {
        try {
            int SoLuong = 1;
            sql = "Select soluong from sach where maSach=N'" + masach + "'";
            conn = ketnoiDB.ConnectDB();
            stmt = conn.createStatement();
            re = stmt.executeQuery(sql);
            while (re.next()) {
                SoLuong += re.getInt(1);
            }
            re.close();
            stmt.close();

            sql = "update sach set soluong=" + SoLuong + " where masach=N'" + masach + "'";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TraSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TraSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setJDate() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String dateString = df.format(date);
        dateTra.setText(dateString);
        dateTra.setEditable(false);
    }

    private void searchReadTime() {
        txtMaSV.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!txtMaSV.getText().toString().trim().isEmpty()) {
                    updateChange();
                } else {
                    jListMaSV.setVisible(false);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!txtMaSV.getText().toString().trim().isEmpty()) {
                    updateChange();
                } else {
                    jListMaSV.setVisible(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (!txtMaSV.getText().toString().trim().isEmpty()) {
                    updateChange();
                } else {
                    jListMaSV.setVisible(false);
                }
            }

            protected void updateChange() {
                Vector<String> vector = new Vector<>();
                String text = txtMaSV.getText().toString().trim();
                for (int i = 0; i < listSV.size(); i++) {
                    SinhVien sv = listSV.get(i);
                    if (sv.getMaSV().startsWith(text)) {
                        vector.add(sv.getMaSV());
                    }
                }
                vector.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
                if (vector.size() > 0) {
                    jListMaSV.setListData(vector);
                    jListMaSV.setVisible(true);
                } else {
                    jListMaSV.setVisible(false);
                }
            }
        });
    }

    private void lapDataTbPhieu() {
        modelTablePhieu = (DefaultTableModel) tbPhieu.getModel();
        if (tbPhieu.getRowCount() > 0) {
            modelTablePhieu.setRowCount(0);
        }
        try {
            conn = ketnoiDB.ConnectDB();
            stmt = conn.createStatement();
            sql = "Select * From Phieu Where MaSV='" + masv + "' and SoPhieu in (select SoPhieu from CTPhieu where (NgayTra IS NULL))";
            re = stmt.executeQuery(sql);
            while (re.next()) {
                modelTablePhieu.addRow(new Object[]{re.getString(1), re.getString(2), re.getString(3), re.getString(4), re.getString(5), re.getString(6), re.getString(7)});
            }
            conn.close();
            stmt.close();
            re.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TraSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TraSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void layDaTaCTPhieu() {
        String sophieu = txtSoPhieu.getText();
        try {
            modelTableCTPhieu = (DefaultTableModel) tbCTPhieu.getModel();
            if (tbCTPhieu.getRowCount() > 0) {
                modelTableCTPhieu.setRowCount(0);
            }
            conn = ketnoiDB.ConnectDB();
            stmt = conn.createStatement();
            sql = "Select Sach.MaSach,TenSach,NgayTra From CTPhieu inner join Sach On CTPhieu.MaSach=Sach.MaSach "
                    + " Where SoPhieu='" + sophieu + "'";
            re = stmt.executeQuery(sql);
            while (re.next()) {
                modelTableCTPhieu.addRow(new Object[]{re.getString(1), re.getString(2), re.getString(3)});
            }
            conn.close();
            stmt.close();
            re.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TraSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TraSach.class.getName()).log(Level.SEVERE, null, ex);
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TraSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TraSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TraSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TraSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TraSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DateHenTra;
    private javax.swing.JTextField DateMuon;
    private javax.swing.JButton cmdGhiTra;
    private javax.swing.JTextField dateTra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListMaSV;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JTable tbCTPhieu;
    private javax.swing.JTable tbPhieu;
    private javax.swing.JPanel tbThonBao;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtNguoiLap;
    private javax.swing.JTextField txtSoPhieu;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}
