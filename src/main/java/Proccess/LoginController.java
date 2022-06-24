/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

import com.mycompany.baocao.database.ConnectDB;
import com.mycompany.baocao.entity.UserLogin;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tran Anh Tuan
 */
public class LoginController {

    ConnectDB connect = new ConnectDB();

    public boolean login(UserLogin obj) {
        Connection cn = connect.getConnection();

        String query = "SELECT * FROM UserLogin WHERE taiKhoan = ? AND matKhau = ?";

        try {

            PreparedStatement st = cn.prepareStatement(query);
            st.setNString(1, obj.getTk());
            st.setNString(2, obj.getMk());

            ResultSet rs = st.executeQuery();

            if (obj.getTk().equals("") || obj.getMk().equals("")) {
                JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu trống");
                return false;
            } else if (rs.next()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Tài khoan hoặc mật khẩu không đúng");
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean ChangPassword(String TK , String NewMK) {
        int kt = 0;

        Connection cn = connect.getConnection();

        String SqlQuery = "UPDATE UserLogin SET matKhau = ?  WHERE taiKhoan = ?";

        try {
            cn.setAutoCommit(false);
            PreparedStatement preparedStatement = cn.prepareStatement(SqlQuery);

            preparedStatement.setString(1, NewMK);
            preparedStatement.setString(2, TK);

            kt = preparedStatement.executeUpdate();

            cn.commit();
            cn.setAutoCommit(true);
            cn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        
        return kt == 1;
    }
}
