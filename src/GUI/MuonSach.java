/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.model.ChuyenMuc;
import GUI.model.Sach;
import GUI.model.SinhVien;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Loi
 */
public class MuonSach extends javax.swing.JFrame {

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
    private DanhMucTheLoai dmTL = new DanhMucTheLoai();
    private List<ChuyenMuc> cm;
    private List<Sach> listSachDaThem = new ArrayList<>();
    private List<Sach> listSach = new ArrayList<>();

    private String mamuc;
    private DefaultTableModel modelTableSach;
    private DefaultTableModel modelTableSachMuon;

    private int soPH;
    private String masv;

    /**
     * Creates new form MuonSach
     */
    public MuonSach() {
        initComponents();
        setLocationRelativeTo(null);
        cm = dmTL.getCm();
        dsSinhVien();
        searchReadTime();
        mamuc = "";
        layDataTbaleSach();
        layDataCombo();
        layListSach();
        modelTableSachMuon = (DefaultTableModel) tbSachMuon.getModel();
        setJDate();
        DateMuon.setEnabled(false);
        txtTenSach.setEnabled(false);
        txtSoPhieu.setEnabled(false);

        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Menu.isOpenFrmPhieuMuonSach = false;
            }

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Menu.isOpenFrmPhieuMuonSach = false;
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSach = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        combTim = new javax.swing.JComboBox<>();
        cmdAll = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSoPhieu = new javax.swing.JTextField();
        DateMuon = new com.toedter.calendar.JDateChooser();
        txtNguoiLap = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        DateTra = new com.toedter.calendar.JDateChooser();
        cmdXoaSach = new javax.swing.JButton();
        cmdXoaTrang = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSachMuon = new javax.swing.JTable();
        cmdTaoPhieu = new javax.swing.JButton();
        cmdSoPhieu = new javax.swing.JButton();
        cmdThemSach = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mượn Sách");
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
        tbThonBao.add(lblThongBao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 362, -1));

        getContentPane().add(tbThonBao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 520, 270));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbSach.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        tbSach.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSach.setRowHeight(25);
        tbSach.setShowGrid(true);
        tbSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbSach);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 480, 250));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Chuyên mục :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 36, -1, -1));

        combTim.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        combTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combTimActionPerformed(evt);
            }
        });
        jPanel2.add(combTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 180, 37));

        cmdAll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdAll.setText("Toàn bộ");
        cmdAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAllActionPerformed(evt);
            }
        });
        jPanel2.add(cmdAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 520, 370));

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
        jPanel3.add(DateMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 83, 152, 32));
        jPanel3.add(txtNguoiLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 28, 155, 37));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Ngày hẹn trả:");
        jLabel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 83, -1, 32));
        jPanel3.add(DateTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 83, 155, 32));

        cmdXoaSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdXoaSach.setText("Bỏ Sách");
        cmdXoaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdXoaSachActionPerformed(evt);
            }
        });
        jPanel3.add(cmdXoaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 262, -1, 37));

        cmdXoaTrang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdXoaTrang.setText("Xóa Trắng");
        cmdXoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdXoaTrangActionPerformed(evt);
            }
        });
        jPanel3.add(cmdXoaTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 262, -1, 37));

        tbSachMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên Sách", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbSachMuon);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 318, -1, 257));

        cmdTaoPhieu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cmdTaoPhieu.setText("Tạo Phiếu");
        cmdTaoPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTaoPhieuActionPerformed(evt);
            }
        });
        jPanel3.add(cmdTaoPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 593, 147, 32));

        cmdSoPhieu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cmdSoPhieu.setText("Tạo số phiếu");
        cmdSoPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSoPhieuActionPerformed(evt);
            }
        });
        jPanel3.add(cmdSoPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 594, -1, -1));

        cmdThemSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdThemSach.setText("Thêm Sách");
        cmdThemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdThemSachActionPerformed(evt);
            }
        });
        jPanel3.add(cmdThemSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 260, -1, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tên sách: ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 152, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Ghi chú:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 210, -1, -1));

        txtTenSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(txtTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 143, 410, 35));

        txtGhiChu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(txtGhiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 207, 409, 35));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 550, 640));

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
            Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListMaSVMouseClicked

    private void tbSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSachMouseClicked
        txtTenSach.setText((String) modelTableSach.getValueAt(tbSach.getSelectedRow(), 0));
    }//GEN-LAST:event_tbSachMouseClicked

    private DefaultComboBoxModel modelCombTim;

    private void layDataCombo() {
        modelCombTim = new DefaultComboBoxModel();
        for (ChuyenMuc item : cm) {
            modelCombTim.addElement(item);
        }
        combTim.setModel(modelCombTim);
    }

    private void layListSach() {
        if (listSach.size() > 0) {
            listSach.clear();
        }
        try {
            conn = ketnoiDB.ConnectDB();
            stmt = conn.createStatement();
            sql = "select * from Sach";
            re = stmt.executeQuery(sql);
            while (re.next()) {
                listSach.add(new Sach(re.getString(1), re.getString(2), re.getString(3), re.getString(4), re.getString(5), re.getInt("SoLuong")));
            }
            re.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void layDataTbaleSach() {
        modelTableSach = (DefaultTableModel) tbSach.getModel();
        Sach sach;
        int i;
        if (modelTableSach.getRowCount() > 0) {
            modelTableSach.setRowCount(0);
        }
        if ("".equals(mamuc)) {
            for (i = 0; i < listSach.size(); i++) {
                sach = listSach.get(i);
                modelTableSach.addRow(new Object[]{sach.getMaSach(), sach.getMaMuc(), sach.getTenSach(), sach.getTacGia(), sach.getNhaXB(), sach.getSoLuong()});
            }
        } else {
            for (i = 0; i < listSach.size(); i++) {
                sach = listSach.get(i);
                if (sach.getMaMuc().equals(mamuc)) {
                    modelTableSach.addRow(new Object[]{sach.getMaSach(), sach.getMaMuc(), sach.getTenSach(), sach.getTacGia(), sach.getNhaXB(), sach.getSoLuong()});
                }
            }
        }
    }

    private void capNhatSoLuongSach(int SoLuong, String maSach) {
        sql = "update sach set soluong=" + SoLuong + " where masach=N'" + maSach + "'";
        try {
            conn = ketnoiDB.ConnectDB();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiSachDaThem() {
        DefaultTableModel model = (DefaultTableModel) tbSachMuon.getModel();
        while (model.getRowCount() > 0) // xóa hiện tại 
        {
            model.removeRow(0);
        }
        for (int i = 0; i < listSachDaThem.size(); i++) {
            Sach book = listSachDaThem.get(i);
            Vector<String> vector = new Vector<>();
            vector.add(book.getMaSach());
            vector.add(book.getTenSach());
            model.addRow(vector);
        }
    }

    public String laySoPhieuMoi() throws ClassNotFoundException, SQLException {
        conn = ketnoiDB.ConnectDB();
        stmt = conn.createStatement();
        sql = "Select TOP 1 SoPhieu From Phieu Order By SoPhieu Desc";
        re = stmt.executeQuery(sql);
        while (re.next()) {
            soPH = Integer.parseInt(re.getString(1)) + 1;
        }
        re.close();
        stmt.close();
        conn.close();
        String str = "00000000" + Integer.toString(soPH);
        return str;
    }

    private void xoaTrang() {
        txtMaSV.setText("");
        txtHoTen.setText("");
        txtSoPhieu.setText("");
        txtGhiChu.setText("");
        txtTenSach.setText("");
        txtNguoiLap.setText("");
    }

    private void combTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combTimActionPerformed
        mamuc = ((ChuyenMuc) combTim.getSelectedItem()).getMaMuc();
        layDataTbaleSach();
    }//GEN-LAST:event_combTimActionPerformed

    private void cmdAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAllActionPerformed
        mamuc = "";
        layDataTbaleSach();
    }//GEN-LAST:event_cmdAllActionPerformed

    private void cmdXoaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdXoaSachActionPerformed
        if (listSachDaThem.isEmpty()) {
            return;
        }
        if (tbSachMuon.getSelectedRow() == 0) {
            return;
        }
        int j;
        String maSach = (String) tbSachMuon.getValueAt(tbSachMuon.getSelectedRow(), 0);
        for (j = 0; j < listSachDaThem.size(); j++) {
            Sach b = listSachDaThem.get(j);
            if (b.getMaSach().equals(maSach)) {
                mamuc = listSachDaThem.get(j).getMaMuc();
                listSachDaThem.remove(j);
                break;
            }
        }
        for (j = 0; j < listSach.size(); j++) {
            Sach b = listSach.get(j);
            if (b.getMaSach().equals(maSach)) {
                capNhatSoLuongSach((b.getSoLuong() + 1), maSach);
                break;
            }
        }
        hienThiSachDaThem();
        layListSach();
        layDataTbaleSach();
    }//GEN-LAST:event_cmdXoaSachActionPerformed

    private void cmdXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdXoaTrangActionPerformed
        for (int i = 0; i < listSachDaThem.size(); i++) {
            String maSach = listSachDaThem.get(i).getMaSach();
            for (int j = 0; j < listSach.size(); j++) {
                Sach b = listSach.get(j);
                if (b.getMaSach().equals(maSach)) {
                    listSach.get(j).setSoLuong(b.getSoLuong() + 1);
                }
            }
        }
        listSachDaThem.clear();
        mamuc = "";
        hienThiSachDaThem();
        layListSach();
        layDataTbaleSach();
        xoaTrang();
    }//GEN-LAST:event_cmdXoaTrangActionPerformed

    private boolean checkLapPhieu() {
        if (txtSoPhieu.getText().toString().isEmpty()) {
            try {
                txtSoPhieu.setText(laySoPhieuMoi());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtSoPhieu.setEditable(false);
            return false;
        }
        if (txtNguoiLap.getText().toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Người lập không được bỏ trống");
            return false;
        }
        Calendar dateNgayMuon = DateMuon.getCalendar();
        Calendar dateNgayTra = DateTra.getCalendar();
        if (dateNgayTra.before(dateNgayMuon)) {
            DateTra.setDate(Date.from(LocalDate.now().plusMonths(3).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            JOptionPane.showMessageDialog(this, "Ngày trả không được trước ngày mượn (Đã đưa về mặc định)");
            return false;
        }
        if ((dateNgayMuon.get(Calendar.MONTH) == dateNgayTra.get(Calendar.MONTH)) && (dateNgayMuon.get(Calendar.DAY_OF_MONTH) == dateNgayTra.get(Calendar.DAY_OF_MONTH)) && (dateNgayMuon.get(Calendar.YEAR) == dateNgayTra.get(Calendar.YEAR))) {
            DateTra.setDate(Date.from(LocalDate.now().plusMonths(3).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            JOptionPane.showMessageDialog(this, "Ngày trả không được trùng ngày mượn (Đã đưa về mặc định)");
            return false;
        }
        if (listSachDaThem.size() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa thêm cuốn sách nào");
            return false;
        }
        if (svHienTai == null) {
            JOptionPane.showMessageDialog(this, "Chưa xác định được sinh viên mượn sách");
            return false;
        }
        return true;
    }

    private void cmdTaoPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTaoPhieuActionPerformed
        if (checkLapPhieu() == true) {
            //tùy chỉnh văn bản cho nút lệnh
            Object[] options = {"Ghi phiếu", "Hủy"};
            int n = JOptionPane.showOptionDialog(jframe, "Bạn có muốn ghi lại phiếu mượn sách không?",
                    "MESSAGE",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, options, options[1]);
            if (n == 0) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    String ngayMuon = sdf.format(new Date());
                    String ngayTra = sdf.format(DateTra.getDate());
                    //Ghi phiếu
                    sql = "INSERT INTO Phieu(SoPhieu,NgayLap,NguoiLap,MaSV,NgayHenTra,NgayKetThuc,DaKetThuc) VALUES(N'"
                            + txtSoPhieu.getText() + "','" + ngayMuon + "',N'" + txtNguoiLap.getText()
                            + "',N'" + masv + "','" + ngayTra + "',NULL,0)";
                    conn = ketnoiDB.ConnectDB();
                    stmt = conn.createStatement();
                    stmt.executeUpdate(sql);
                    stmt.close();
                    //ghi chi tiết
                    int i;
                    for (i = 0; i < modelTableSachMuon.getRowCount(); i++) {
                        sql = "INSERT INTO CTPhieu(SoPhieu,MaSach,GhiChuMuon,NgayTra,GhiChuTra) VALUES (N'" + txtSoPhieu.getText()
                                + "',N'" + modelTableSachMuon.getValueAt(i, 0) + "',N'" + txtGhiChu.getText() + "',NULL,'')";
                        stmt = conn.createStatement();
                        stmt.executeUpdate(sql);
                        stmt.close();
                    }
                    JOptionPane.showMessageDialog(this, "Ghi phiếu thành công");
                    xoaTrang();
                    svHienTai = null;
                    DateTra.setDate(Date.from(LocalDate.now().plusMonths(3).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                    listSachDaThem.clear();
                    modelTableSachMuon.setRowCount(0);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_cmdTaoPhieuActionPerformed

    private void cmdSoPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSoPhieuActionPerformed
        try {
            txtSoPhieu.setText(laySoPhieuMoi());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MuonSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdSoPhieuActionPerformed

    private void cmdThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdThemSachActionPerformed
        masv = txtMaSV.getText().toString().trim();
        int dem = 0;
        for (int i = 0; i < listSV.size(); i++) {
            SinhVien sv = listSV.get(i);
            if (sv.getMaSV().equals(masv)) {
                break;
            } else {
                dem++;
            }
        }
        if (dem == listSV.size()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên có mã " + masv);
        }
        boolean check = true;
        int solgSach = (int) tbSach.getValueAt(tbSach.getSelectedRow(), 5);
        String maSach = (String) tbSach.getValueAt(tbSach.getSelectedRow(), 0);
        if (tbSach.getSelectedRow() == 0) {
            return;
        }
        if (solgSach == 0) {
            JOptionPane.showMessageDialog(this, "Cuốn sách mã " + maSach + " đã được mượn hết.");
        } else if (listSachDaThem.isEmpty() && solgSach > 0) {
            listSachDaThem.add(new Sach(
                    (String) tbSach.getValueAt(tbSach.getSelectedRow(), 0),
                    (String) tbSach.getValueAt(tbSach.getSelectedRow(), 1),
                    (String) tbSach.getValueAt(tbSach.getSelectedRow(), 2),
                    (String) tbSach.getValueAt(tbSach.getSelectedRow(), 3),
                    (String) tbSach.getValueAt(tbSach.getSelectedRow(), 4),
                    1
            ));
            capNhatSoLuongSach((solgSach - 1), maSach);
        } else if (listSachDaThem.size() > 10) {
            JOptionPane.showMessageDialog(this, "Sinh viên đã mượn quá 10 cuốn sách.");
        } else {
            for (int j = 0; j < listSachDaThem.size(); j++) {
                Sach b = listSachDaThem.get(j);
                if (b.getMaSach().equals(maSach)) {
                    JOptionPane.showMessageDialog(this, "Cuốn sách mã " + maSach + " đã được thêm.");
                    check = false;
                    break;
                }
            }
            if (check == true) {
                for (int j = 0; j < listSach.size(); j++) {
                    if (maSach.equals(listSach.get(j).getMaSach())) {
                        listSachDaThem.add(listSach.get(j));
                        mamuc = listSach.get(j).getMaMuc();
                        capNhatSoLuongSach((listSach.get(j).getSoLuong() - 1), maSach);
                    }
                }
            }
        }
        hienThiSachDaThem();
        layListSach();
        layDataTbaleSach();
    }//GEN-LAST:event_cmdThemSachActionPerformed

    private void setJDate() {
        DateMuon.setDate(new Date());
        DateMuon.setDateFormatString("dd/MM/yyyy");
        DateMuon.setEnabled(false);

        DateTra.setDate(Date.from(LocalDate.now().plusMonths(3).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        DateTra.setDateFormatString("dd/MM/yyyy");
        JTextFieldDateEditor editorNgayTra = (JTextFieldDateEditor) DateTra.getDateEditor();
        editorNgayTra.setEditable(false);
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
            java.util.logging.Logger.getLogger(MuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MuonSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateMuon;
    private com.toedter.calendar.JDateChooser DateTra;
    private javax.swing.JButton cmdAll;
    private javax.swing.JButton cmdSoPhieu;
    private javax.swing.JButton cmdTaoPhieu;
    private javax.swing.JButton cmdThemSach;
    private javax.swing.JButton cmdXoaSach;
    private javax.swing.JButton cmdXoaTrang;
    private javax.swing.JComboBox<String> combTim;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JTable tbSach;
    private javax.swing.JTable tbSachMuon;
    private javax.swing.JPanel tbThonBao;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtNguoiLap;
    private javax.swing.JTextField txtSoPhieu;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}
