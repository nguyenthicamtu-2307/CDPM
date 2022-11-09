package com.example.myapplication.Model;
import java.io.Serializable;
public class User implements Serializable {
    private  int Id;
    private String taiKhoan;
    private String MatKhau;
    private  String TenUser;
    private  String Dob;
    private  String GioiTinh;
    private String DiaChi;
    private int SDT;
    private String Quyen;
    private  String AnhDaidien;
    private  int ChieuCao;
    private  int CanNang;

public User(String TaiKhoan,String MatKhau,String TenUser){
    this.taiKhoan=TaiKhoan;
    this.MatKhau=MatKhau;
    this.TenUser=TenUser;
}

    public User() {
    }

    @Override
    public String toString() {
        return "tbluser{" +
                "Id=" + Id +
                ", TaiKhoan='" + taiKhoan + '\'' +
                ", MatKhau='" + MatKhau + '\'' +
                ", TenUser='" + TenUser + '\'' +
                ", Dob=" + Dob +
                ", GioiTinh='" + GioiTinh + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", SDT='" + SDT + '\'' +
                ", Quyen='" + Quyen + '\'' +
                ", AnhDaiDien'" + AnhDaidien + '\'' +
                '}';
    }

    public int getChieuCao() {
        return ChieuCao;
    }

    public void setChieuCao(int chieuCao) {
        ChieuCao = chieuCao;
    }

    public int getCanNang() {
        return CanNang;
    }

    public void setCanNang(int canNang) {
        CanNang = canNang;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getTenUser() {
        return TenUser;
    }

    public void setTenUser(String tenUser) {
        TenUser = tenUser;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String quyen) {
        Quyen = quyen;
    }

    public String getAnhDaidien() {
        return AnhDaidien;
    }

    public void setAnhDaidien(String anhDaidien) {
        AnhDaidien = anhDaidien;
    }
}
