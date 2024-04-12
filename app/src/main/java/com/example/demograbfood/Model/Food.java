package com.example.demograbfood.Model;

import java.io.Serializable;

public class Food  implements Serializable {
     private byte[] hinh;
     private String tensp;
     private String giasp;

    public Food(byte[] hinh, String tensp, String giasp) {
        this.hinh = hinh;
        this.tensp = tensp;
        this.giasp = giasp;
    }

    public Food() {
    }

    public Food(byte[] hinh, String tensp) {
        this.hinh = hinh;
        this.tensp = tensp;
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

    public String getGiasp() {
        return giasp;
    }

    public void setGiasp(String giasp) {
        this.giasp = giasp;
    }
}
