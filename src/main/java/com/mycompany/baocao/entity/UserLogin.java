/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baocao.entity;

/**
 *
 * @author Tran Anh Tuan
 */
public class UserLogin {
    private String tk;
    private String mk;

    public UserLogin(String tk, String mk) {
        this.tk = tk;
        this.mk = mk;
    }

    public UserLogin() {
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }
    
    
}
