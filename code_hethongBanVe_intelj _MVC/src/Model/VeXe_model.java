package Model;

public class VeXe_model {
    private String maDat;
    private String maLoTrinh;
    private String hoVaTen;
    private int soDienThoai;

    private int soVe;
    private int giaTien;
    private String ngayDat;
    private String ngayKhoiHanh;
    private String thanhToan;

    public VeXe_model(String maDat, String maLoTrinh, String hoVaTen, int soDienThoai, int soVe, int giaTien, String ngayDat, String ngayKhoiHanh, String thanhToan) {
        this.maDat = maDat;
        this.hoVaTen = hoVaTen;
        this.soDienThoai = soDienThoai;
        this.maLoTrinh = maLoTrinh;
        this.soVe = soVe;
        this.giaTien = giaTien;
        this.ngayDat = ngayDat;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.thanhToan = thanhToan;
    }

    public String getMaDat() {
        return maDat;
    }

    public void setMaDat(String maDat) {
        this.maDat = maDat;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMaLoTrinh() {
        return maLoTrinh;
    }

    public void setMaLoTrinh(String maLoTrinh) {
        this.maLoTrinh = maLoTrinh;
    }

    public int getSoVe() {
        return soVe;
    }

    public void setSoVe(int soVe) {
        this.soVe = soVe;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(String thanhToan) {
        this.thanhToan = thanhToan;
    }
}
