package com.nhphuc.giaicaudo;

public class HinhAnhLuotChoi {
    private String Ten;
    private int Hinh;

    public HinhAnhLuotChoi(String ten, int hinh) {
        Ten = ten;
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
