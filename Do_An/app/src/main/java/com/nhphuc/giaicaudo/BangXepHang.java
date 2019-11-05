package com.nhphuc.giaicaudo;

public class BangXepHang {
    private int Hinh;
    private String Ten;
    private String Diem;

    public BangXepHang(int hinh, String ten, String diem) {
        Hinh = hinh;
        Ten = ten;
        Diem = diem;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getDiem() {
        return Diem;
    }

    public void setDiem(String diem) {
        Diem = diem;
    }
}
