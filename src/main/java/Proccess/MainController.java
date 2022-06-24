package Proccess;


import com.mycompany.baocao.database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tran Anh Tuan
 */
public class MainController {
    
    ConnectDB connectDB = new ConnectDB();
    
    public String CheckStatus_Phong(String MaPhong) {

        try {
            Connection conn = connectDB.getConnection();

            String SqlQuery = "select trangThai from Phong Where id = ?";

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.setString(1, MaPhong);
            ResultSet rs = preparedStatement.executeQuery();

            String status = "";
            while (rs.next()) {
                status = rs.getString("trangThai");
            }

            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            conn.close();
            return status;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
        return null;
    }
    
}
