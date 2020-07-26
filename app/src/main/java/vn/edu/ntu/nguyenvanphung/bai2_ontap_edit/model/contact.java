package vn.edu.ntu.nguyenvanphung.bai2_ontap_edit.model;

public class contact {
    int id;
    String ten;
    String ngaySinh;
    String sodienthoai,diaChi;

    public contact(int id, String ten, String ngaySinh, String sodienthoai, String diaChi) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.sodienthoai = sodienthoai;
        this.diaChi = diaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
