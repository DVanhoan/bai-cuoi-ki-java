package Model;

public class LoTrinh_model {
    private String maLoTrinh;
    private String loTrinh;
    private int soLuong;
    private String ngayKhoiHanh;
    private String loaiXe;

    public LoTrinh_model(String maLoTrinh, String loTrinh, int soLuong, String ngayKhoiHanh, String loaiXe) {
        this.maLoTrinh = maLoTrinh;
        this.loTrinh = loTrinh;
        this.soLuong = soLuong;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.loaiXe = loaiXe;
    }

    public String getMaLoTrinh() {
        return maLoTrinh;
    }

    public void setMaLoTrinh(String maLoTrinh) {
        this.maLoTrinh = maLoTrinh;
    }

    public String getLoTrinh() {
        return loTrinh;
    }

    public void setLoTrinh(String loTrinh) {
        this.loTrinh = loTrinh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

}

