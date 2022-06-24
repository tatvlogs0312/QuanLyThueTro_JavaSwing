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
public class ThongKeController {
    
    ConnectDB connectDB = new ConnectDB();
    
    public List<HoaDon> getAll(){
        List<HoaDon> lst = new ArrayList<>();
        
        String sql = "SELECT * FROM HoaDon";
        
        Connection cn = connectDB.getConnection();
        
        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            cn.commit();
            cn.setAutoCommit(true);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                HoaDon hdon = new HoaDon();
                hdon.setHopDong(rs.getString("id_HopDong"));
                hdon.setThang(rs.getString("thang"));
                hdon.setTongTien(rs.getString("tongTien"));
                lst.add(hdon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lst;
    }
    
    public List<HoaDon> getByThang(String thang){
        List<HoaDon> lst = new ArrayList<>();
        
        String sql = "select * from HoaDon where thang = ?";
        
        Connection cn = connectDB.getConnection();
        
        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1,thang);
            cn.commit();
            cn.setAutoCommit(true);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                HoaDon hdon = new HoaDon();
                hdon.setHopDong(rs.getString("id_HopDong"));
                hdon.setThang(rs.getString("thang"));
                hdon.setTongTien(rs.getString("tongTien"));
                lst.add(hdon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lst;
    }
    
    public String getTong(){
        String tong = "";
        
        String sql = "select sum(tongTien) as tong from HoaDon";
        
        Connection cn = connectDB.getConnection();
        
        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            cn.commit();
            cn.setAutoCommit(true);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                tong = rs.getString("tong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tong;
    }
    
    public String getTongByThang(String thang){
        String tong = "";
        
        String sql = "select sum(tongTien) as tong from HoaDon where thang = ?";
        
        Connection cn = connectDB.getConnection();
        
        try {
            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1,thang );
            cn.commit();
            cn.setAutoCommit(true);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                tong = rs.getString("tong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tong;
    }
}
