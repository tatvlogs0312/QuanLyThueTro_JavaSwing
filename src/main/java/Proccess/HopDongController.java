/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

import com.mycompany.baocao.entity.HopDong;
import com.mycompany.baocao.database.ConnectDB;
import com.mycompany.baocao.entity.KhachThue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tran Anh Tuan
 */
public class HopDongController {

    ConnectDB connectDB = new ConnectDB();

    public List<KhachThue> getKhachThue() {
        List<KhachThue> lst = new ArrayList<>();
        String sql = "SELECT * FROM KhachThue";

        Connection cn = connectDB.getConnection();

        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                KhachThue kt = new KhachThue();
                kt.setCmnd(rs.getString("cmnd"));
                kt.setTen(rs.getString("ten"));
                lst.add(kt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HopDongController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }

    public List<KhachThue> searchKhachThue(String cmnd, String ten) {
        List<KhachThue> lst = new ArrayList<>();
        String sql = "SELECT * FROM KhachThue WHERE ten like N'%" + ten + "%' and cmnd like '%" + cmnd + "%';";

        Connection cn = connectDB.getConnection();

        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                KhachThue kt = new KhachThue();
                kt.setCmnd(rs.getString("cmnd"));
                kt.setTen(rs.getString("ten"));
                lst.add(kt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HopDongController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }

    public List<HopDong> getHopDong() {
        List<HopDong> lst = new ArrayList<>();

        String sql = "SELECT * FROM HopDong where trangThai = N'có hiệu lực'";

        Connection cn = connectDB.getConnection();

        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                HopDong hd = new HopDong();
                hd.setCmnd(rs.getString("cmnd"));
                hd.setId(rs.getString("id"));
                hd.setPhong(rs.getString("id_phong"));
                hd.setGiaPhong(rs.getInt("giaPhong"));
                hd.setNgayVaoO(rs.getString("ngayVaoO"));
                hd.setTrangThai(rs.getString("trangThai"));
                lst.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HopDongController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }

    public HopDong getHDByPhong(String phong) throws SQLException {
        String sql = "SELECT * FROM HopDong where id_phong = ? and trangThai = N'có hiệu lực'";

        Connection cn = connectDB.getConnection();

        HopDong hd = new HopDong();

        PreparedStatement st = cn.prepareStatement(sql);

        cn.setAutoCommit(false);
        st.setString(1, phong);
        cn.commit();
        cn.setAutoCommit(true);

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            hd.setCmnd(rs.getString("cmnd"));
            hd.setId(rs.getString("id"));
            hd.setPhong(rs.getString("id_phong"));
            hd.setGiaPhong(rs.getInt("giaPhong"));
            hd.setNgayVaoO(rs.getString("ngayVaoO"));
        }

        return hd;
    }

    public boolean insertHD(HopDong hd) throws SQLException {

        String sql = "insert into HopDong(id,cmnd,id_phong,giaPhong,ngayVaoO,trangThai) values (?,?,?,?,?,N'có hiệu lực')";

        Connection cn = connectDB.getConnection();

        PreparedStatement st = cn.prepareStatement(sql);

        cn.setAutoCommit(false);

        st.setString(1, hd.getId());
        st.setString(2, hd.getCmnd());
        st.setString(3, hd.getPhong());
        st.setInt(4, hd.getGiaPhong());
        st.setString(5, hd.getNgayVaoO());

        cn.commit();
        cn.setAutoCommit(true);

        int kt = st.executeUpdate();

        return kt > 0;
    }

    public boolean updateHD(String hd) throws SQLException {

        String sql = "update HopDong set trangThai = N'hết hạn' where id = ?";

        Connection cn = connectDB.getConnection();

        PreparedStatement st = cn.prepareStatement(sql);

        cn.setAutoCommit(false);

        st.setString(1, hd);

        cn.commit();
        cn.setAutoCommit(true);

        int kt = st.executeUpdate();

        return kt > 0;
    }

    public boolean updatePhongChoThue(String phong) throws SQLException {
        String sql = "update Phong set trangThai = N'đã cho thuê' where id = ?";

        Connection cn = connectDB.getConnection();

        PreparedStatement st = cn.prepareStatement(sql);

        cn.setAutoCommit(false);

        st.setString(1, phong);

        cn.commit();
        cn.setAutoCommit(true);

        int kt = st.executeUpdate();

        return kt > 0;
    }

    public boolean updatePhongConTrong(String phong) throws SQLException {
        String sql = "update Phong set trangThai = N'còn trống' where id = ?";

        Connection cn = connectDB.getConnection();

        PreparedStatement st = cn.prepareStatement(sql);

        cn.setAutoCommit(false);

        st.setString(1, phong);

        cn.commit();
        cn.setAutoCommit(true);

        int kt = st.executeUpdate();

        return kt > 0;
    }

    public String CheckStatus_Phong(String MaPhong) {

        try {
            Connection conn = connectDB.getConnection();

            String SqlQuery = "select trangThai from Phong Where id = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaPhong);
            ResultSet rs = preparedStatement.executeQuery();
            conn.commit();
            conn.setAutoCommit(true);
            String status = "";
            while (rs.next()) {
                status = rs.getString("trangThai");
            }

            rs.close();
            conn.close();

            return status;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }
}
