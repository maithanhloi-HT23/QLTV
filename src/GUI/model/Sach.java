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
public class Sach {

    private String maSach;
    private String maMuc;
    private String tenSach;
    private String tacGia;
    private String nhaXB;
    private String viTri;

    public Sach(String maSach, String maMuc, String tenSach, String tacGia, String nhaXB, String viTri) {
        this.maSach = maSach;
        this.maMuc = maMuc;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nhaXB = nhaXB;
        this.viTri = viTri;
    }

    public Sach() {
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaMuc() {
        return maMuc;
    }

    public void setMaMuc(String maMuc) {
        this.maMuc = maMuc;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNhaXB() {
        return nhaXB;
    }

    public void setNhaXB(String nhaXB) {
        this.nhaXB = nhaXB;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

}
