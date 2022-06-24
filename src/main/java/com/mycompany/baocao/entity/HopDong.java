package com.mycompany.baocao.entity;


import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tran Anh Tuan
 */
public class HopDong {
    private String id;
    private String cmnd;
    private String phong;
    private int giaPhong;
    private String ngayVaoO;
    private String trangThai;

    public HopDong(String id, String cmnd, String phong, int giaPhong, String ngayVaoO, String trangThai) {
        this.id = id;
        this.cmnd = cmnd;
        this.phong = phong;
        this.giaPhong = giaPhong;
        this.ngayVaoO = ngayVaoO;
        this.trangThai = trangThai;
    }

    public HopDong() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public int getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(int giaPhong) {
        this.giaPhong = giaPhong;
    }

    public String getNgayVaoO() {
        return ngayVaoO;
    }

    public void setNgayVaoO(String ngayVaoO) {
        this.ngayVaoO = ngayVaoO;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
