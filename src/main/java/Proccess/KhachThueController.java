/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

import com.mycompany.baocao.database.ConnectDB;
import com.mycompany.baocao.entity.KhachThue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tran Anh Tuan
 */
public class KhachThueController {

    ConnectDB connect = new ConnectDB();

    public List<KhachThue> getAll() {
        List<KhachThue> lst = new ArrayList<>();

        Connection cn = connect.getConnection();

        String sql = "SELECT * FROM KhachThue";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String cmnd = rs.getString("cmnd");
                String ten = rs.getString("ten");
                String tuoi = rs.getString("tuoi");
                String gioiTinh = rs.getString("gioiTinh");
                String queQuan = rs.getString("queQuan");
                String sdt = rs.getString("sdt");
                KhachThue kt = new KhachThue(cmnd, ten, tuoi, queQuan, gioiTinh, sdt);
                lst.add(kt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachThueController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }

    public KhachThue getAllByCMND(String CMND) throws SQLException {

        Connection cn = connect.getConnection();

        String sql = "SELECT * FROM KhachThue";

        KhachThue kt = new KhachThue();

        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            kt.setCmnd(rs.getString("cmnd"));
            kt.setTen(rs.getString("ten"));
            kt.setTuoi(rs.getString("tuoi"));
            kt.setGioitinh(rs.getString("gioiTinh"));
            kt.setQuequan(rs.getString("queQuan"));
            kt.setSdt(rs.getString("sdt"));
        }

        return kt;
    }

    public boolean insertData(KhachThue kt) throws SQLException {

        Connection cn = connect.getConnection();

        String sql = "insert into KhachThue(cmnd,ten,tuoi,queQuan,gioiTinh,sdt) VALUES "
                + "('" + kt.getCmnd() + "',N'" + kt.getTen() + "','" + kt.getTuoi() + ""
                + "',N'" + kt.getQuequan() + "',N'" + kt.getGioitinh() + "','" + kt.getSdt() + "');";

        Statement st = cn.createStatement();
        int kq = st.executeUpdate(sql);

        return kq > 0;
    }

    public boolean updateData(KhachThue kt) throws SQLException {

        Connection cn = connect.getConnection();

        String sql = "Update KhachThue set ten=N'" + kt.getTen() + "',"
                + "tuoi='" + kt.getTuoi() + "',queQuan=N'" + kt.getQuequan() + "',gioiTinh=N'" + kt.getGioitinh() + "', "
                + "sdt = '" + kt.getSdt() + "'  WHERE cmnd='" + kt.getCmnd() + "';";

        Statement st = cn.createStatement();
        int kq = st.executeUpdate(sql);

        return kq > 0;
    }

    public boolean deleteData(String cmnd) throws SQLException {
        Connection cn = connect.getConnection();

        String sql = "delete from KhachThue where cmnd = '" + cmnd + "';";

        Statement st = cn.createStatement();
        int kq = st.executeUpdate(sql);

        return kq > 0;
    }

    public List<KhachThue> searchData(KhachThue kt) {

        Connection cn = connect.getConnection();

        String sql = "SELECT * FROM KhachThue "
                + "WHERE ten like N'%" + kt.getTen() + "%"
                + "' and tuoi like '%" + kt.getTuoi() + "%' "
                + "and queQuan like N'%" + kt.getQuequan() + "%' "
                + "and gioiTinh like N'%" + kt.getGioitinh() + "%' "
                + "and sdt like '%" + kt.getSdt() + "%' "
                + "and cmnd like '%" + kt.getCmnd() + "%';";

        List<KhachThue> lst = new ArrayList<>();
       
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                KhachThue obj = new KhachThue();
                obj.setCmnd(rs.getString("cmnd"));
                obj.setTen(rs.getString("ten"));
                obj.setTuoi(rs.getString("tuoi"));
                obj.setGioitinh(rs.getString("gioiTinh"));
                obj.setQuequan(rs.getString("queQuan"));
                obj.setSdt(rs.getString("sdt"));
                lst.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachThueController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }
}
