/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baocao.entity;

/**
 *
 * @author Tran Anh Tuan
 */
public class HoaDon {
    private String id;
    private String HopDong;
    private String thang;
    private String trangThai;
    private String tongTien;

    public HoaDon(String id, String HopDong, String thang, String trangThai, String tongTien) {
        this.id = id;
        this.HopDong = HopDong;
        this.thang = thang;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
    }

    public HoaDon() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHopDong() {
        return HopDong;
    }

    public void setHopDong(String HopDong) {
        this.HopDong = HopDong;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }
    
    
}
