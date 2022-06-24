/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

import com.mycompany.baocao.database.ConnectDB;
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
public class HoaDonController {
    ConnectDB connectDB = new ConnectDB();
    
    public List<HoaDon> getAll(String hd){
        List<HoaDon> lst = new ArrayList<>();
        
        String sql = "SELECT * FROM HoaDon where trangThai = N'Chưa đóng' and id_HopDong = ?";
        
        Connection cn = connectDB.getConnection();
        
        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, hd);
            cn.commit();
            cn.setAutoCommit(true);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                HoaDon hdon = new HoaDon();
                hdon.setThang(rs.getString("thang"));
                hdon.setTongTien(rs.getString("tongTien"));
                hdon.setTrangThai(rs.getString("trangThai"));
                lst.add(hdon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lst;
    }
    
    public boolean insertHD(String id, String hd , String thang){
        String sql = "INSERT INTO HoaDon (id, id_HopDong, thang, trangThai, tongTien) VALUES(?, ?, ?, N'Chưa đóng', 0)";
        
        Connection cn = connectDB.getConnection();
        
        int kt = 0;
        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, hd);
            st.setString(3, thang);
            cn.commit();
            cn.setAutoCommit(true);
            kt = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return kt > 0;
    }
    
    public boolean updateHD(String id){
        String sql = "update HoaDon Set trangThai = N'Đã đóng' where id = ?";
        
        Connection cn = connectDB.getConnection();
        
        int kt = 0;
        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, id);
            cn.commit();
            cn.setAutoCommit(true);
            kt = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return kt > 0;
    }
    
    public String getId(String hd , String thang){
        String sql = "Select id from HoaDon where trangThai = N'Chưa đóng' and id_HopDong = ? and thang = ?";
        
        String id = "";
        
        Connection cn = connectDB.getConnection();
        
        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, hd);
            st.setString(2, thang);
            cn.commit();
            cn.setAutoCommit(true);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                id = rs.getString("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    public String getPhong(String hd){
        String sql = "Select id_phong from HopDong , HoaDon where HopDong.id = HoaDon.id_HopDong and  HoaDon.id_HopDong = ?";
        
        String id = "";
        
        Connection cn = connectDB.getConnection();
        
        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, hd);
            cn.commit();
            cn.setAutoCommit(true);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                id = rs.getString("id_phong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
}
