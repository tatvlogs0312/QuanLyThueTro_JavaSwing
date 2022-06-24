/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baocao.entity;

/**
 *
 * @author Tran Anh Tuan
 */
public class DonGiaDV {
    private String id;
    private String HopDong;
    private String DichVu;
    private int gia;

    public DonGiaDV() {
    }

    public DonGiaDV(String id, String HopDong, String DichVu, int gia) {
        this.id = id;
        this.HopDong = HopDong;
        this.DichVu = DichVu;
        this.gia = gia;
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

    public String getDichVu() {
        return DichVu;
    }

    public void setDichVu(String DichVu) {
        this.DichVu = DichVu;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
    
}
