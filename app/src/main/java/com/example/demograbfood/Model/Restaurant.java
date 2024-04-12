package com.example.demograbfood.Model;

public class Restaurant {
    private byte[] hinh;
    private String tensp;
    private  String luotdanhgia;

    public Restaurant() {
    }

    public Restaurant(byte[] hinh, String tensp, String luotdanhgia) {
        this.hinh = hinh;
        this.tensp = tensp;
        this.luotdanhgia = luotdanhgia;
    }

    public byte[] getHinh() {
        return hinh;
    }

    public void setHinh(byte[] hinh) {
        this.hinh = hinh;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getLuotdanhgia() {
        return luotdanhgia;
    }

    public void setLuotdanhgia(String luotdanhgia) {
        this.luotdanhgia = luotdanhgia;
    }
}
