/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

import com.mycompany.baocao.database.ConnectDB;
import com.mycompany.baocao.entity.DonGiaDV;
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
public class DonGiaDVController {

    ConnectDB connectDB = new ConnectDB();

    public String check(String id, String dv) {
        String status = "";

        String sql = "SELECT donGia FROM DonGia Where id_HopDong = ? and id_dv = ?";
        Connection cn = connectDB.getConnection();

        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, dv);
            cn.commit();
            cn.setAutoCommit(true);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                status = rs.getString("donGia");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonGiaDVController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
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

    public List<DonGiaDV> getAll(String hd) {
        List<DonGiaDV> lst = new ArrayList<>();

        String sql = "SELECT tenDV,donGia FROM DonGia,DichVu Where DonGia.id_dv = DichVu.id and id_HopDong = ?";

        Connection cn = connectDB.getConnection();

        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, hd);
            cn.commit();
            cn.setAutoCommit(true);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                DonGiaDV dg = new DonGiaDV();
                dg.setDichVu(rs.getString("tenDV"));
                dg.setGia(rs.getInt("donGia"));
                lst.add(dg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonGiaDVController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }

    public boolean insertDonGia(DonGiaDV dg) {
        Connection cn = connectDB.getConnection();

        String sql = "insert into DonGia(id,id_HopDong,id_dv,donGia) values (?,?,?,?)";

        PreparedStatement st;

        int kt = 0;
        try {
            st = cn.prepareStatement(sql);
            cn.setAutoCommit(false);
            st.setString(1, dg.getId());
            st.setString(2, dg.getHopDong());
            st.setString(3, dg.getDichVu());
            st.setInt(4, dg.getGia());
            cn.commit();
            cn.setAutoCommit(true);

            kt = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DonGiaDVController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kt > 0;
    }

    public boolean updateDonGia(String id, int gia) {
        Connection cn = connectDB.getConnection();

        String sql = "update DonGia set donGia = ? where id = ?";

        PreparedStatement st;
        
        int kt = 0;
        try {
            st = cn.prepareStatement(sql);
            cn.setAutoCommit(false);
            st.setInt(1, gia);
            st.setString(2, id);
            cn.commit();
            cn.setAutoCommit(true);
            kt = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DonGiaDVController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kt > 0;
    }
    
    public String getMaDonGia(String id_hd , String id_dv){
        String id = "";

        String sql = "select id from DonGia where id_HopDong = ? and id_dv = ?";
        Connection cn = connectDB.getConnection();

        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, id_hd);
            st.setString(2, id_dv);
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
    
    public String getPhonng(String hd){
        String id = "";

        String sql = "select Phong.id from Phong,HopDong where Phong.id = HopDong.id_phong And HopDong.id = ?";
        Connection cn = connectDB.getConnection();

        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, hd);
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
}
