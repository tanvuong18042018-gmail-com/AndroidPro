package com.nhphuc.giaicaudo;

public class LichSuNguoiChoi {
    private String Ngay;
    private String SoDiem;
    private String SoCau;

    public LichSuNguoiChoi(String ngay, String soCau , String soDiem) {
        Ngay = ngay;
        SoDiem = soDiem;
        SoCau = soCau;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }

    public String getSoDiem() {
        return SoDiem;
    }

    public void setSoDiem(String soDiem) {
        SoDiem = soDiem;
    }

    public String getSoCau() {
        return SoCau;
    }

    public void setSoCau(String soCau) {
        SoCau = soCau;
    }
}
