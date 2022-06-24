/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

import com.mycompany.baocao.database.ConnectDB;
import com.mycompany.baocao.entity.ChiTietDichVu;
import com.mycompany.baocao.entity.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tran Anh Tuan
 */
public class ChiTietDichVuController {
    ConnectDB connectDB = new ConnectDB();
    
    public boolean insertData(ChiTietDichVu ctdv){
        String sql = "insert into ChiTietDichVu(id,id_dv,soLuongSuDung,id_hoaDon) values (?,?,?,?)";
        
        Connection cn = connectDB.getConnection();
        
        int kt = 0;
        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, ctdv.getId());
            st.setString(2, ctdv.getId_DichVu());
            st.setInt(3, ctdv.getSlsd());
            st.setString(4, ctdv.getHdon());
            cn.commit();
            cn.setAutoCommit(true);
            kt = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return kt > 0;
    }
    
    public List<ChiTietDichVu> getAll(String hd){
        List<ChiTietDichVu> lst = new ArrayList<>();
        
        String sql = "select tenDV,soLuongSuDung from ChiTietDichVu,dichVu where ChiTietDichVu.id_dv = dichVu.id and id_hoaDon = ?";
        
        Connection cn = connectDB.getConnection();
        
        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, hd);
            cn.commit();
            cn.setAutoCommit(true);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                ChiTietDichVu ctdv = new ChiTietDichVu();
                ctdv.setId_DichVu(rs.getString("tenDV"));
                ctdv.setSlsd(rs.getInt("soLuongSuDung"));
                lst.add(ctdv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lst;
    }
    
    public String getMaDV(String dv) {
        String id = "";

        String sql = "select id FROM dichVu Where tenDV = ?";
        Connection cn = connectDB.getConnection();

        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, dv);
            cn.commit();
            cn.setAutoCommit(true);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getString("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonGiaDVController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    public List<String> getAllDV() {
        List<String> lst = new ArrayList<>();

        String sql = "SELECT tenDV FROM dichVu";

        Connection cn = connectDB.getConnection();

        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            cn.commit();
            cn.setAutoCommit(true);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String dv = rs.getString("tenDV");
                lst.add(dv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonGiaDVController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }
    
    public String getHopDong(String HoaDon){
        String sql = "select id_HopDong from HoaDon,ChiTietDichVu where ChiTietDichVu.id_hoaDon = HoaDon.id And id_hoaDon = ?";
        
        Connection cn = connectDB.getConnection();
        
        String id = "";

        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, HoaDon);
            cn.commit();
            cn.setAutoCommit(true);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getString("id_HopDong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonGiaDVController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }
}
