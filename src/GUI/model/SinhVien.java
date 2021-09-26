/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

/**
 *
 * @author Loi
 */
public class SinhVien {

    private String MaSV;
    private String HoTen;
    private String MaLop;
    private String SDT;

    public SinhVien() {
    }

    public SinhVien(String MaSV, String HoTen, String MaLop, String SDT) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.MaLop = MaLop;
        this.SDT = SDT;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "MaSV=" + MaSV + ", HoTen=" + HoTen + ", MaLop=" + MaLop + ", SDT=" + SDT + '}';
    }

}
