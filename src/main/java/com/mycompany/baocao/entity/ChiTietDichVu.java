/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baocao.entity;

/**
 *
 * @author Tran Anh Tuan
 */
public class ChiTietDichVu {
    private String id;
    private String id_DichVu;
    private int slsd;
    private String hdon;

    public ChiTietDichVu(String id, String id_DichVu, int slsd, String hdon) {
        this.id = id;
        this.id_DichVu = id_DichVu;
        this.slsd = slsd;
        this.hdon = hdon;
    }

    public ChiTietDichVu() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_DichVu() {
        return id_DichVu;
    }

    public void setId_DichVu(String id_DichVu) {
        this.id_DichVu = id_DichVu;
    }

    public int getSlsd() {
        return slsd;
    }

    public void setSlsd(int slsd) {
        this.slsd = slsd;
    }

    public String getHdon() {
        return hdon;
    }

    public void setHdon(String hdon) {
        this.hdon = hdon;
    }
    
    
}
