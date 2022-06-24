/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baocao.entity;

/**
 *
 * @author Tran Anh Tuan
 */
public class KhachThue {

    private String cmnd;
    private String ten;
    private String tuoi;
    private String quequan;
    private String gioitinh;
    private String sdt;

    public KhachThue(String cmnd, String ten, String tuoi, String quequan, String gioitinh, String sdt) {
        this.cmnd = cmnd;
        this.ten = ten;
        this.tuoi = tuoi;
        this.quequan = quequan;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
    }

    public KhachThue() {
    }

    

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    
}
