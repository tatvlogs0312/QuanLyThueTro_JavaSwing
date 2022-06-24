/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

import com.mycompany.baocao.database.ConnectDB;
import com.mycompany.baocao.entity.DichVu;
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
public class DichVuController {
    ConnectDB connect = new ConnectDB();

    public List<DichVu> getAll() {
        List<DichVu> lst = new ArrayList<>();
        Connection cn = connect.getConnection();
        String sql = "SELECT * FROM dichVu";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String ten = rs.getString("tenDV");
                DichVu kt = new DichVu(id, ten);
                lst.add(kt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachThueController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }
    public boolean insertData(DichVu kt) throws SQLException {

        Connection cn = connect.getConnection();

        String sql = "insert into dichVu(id, tenDV) VALUES "
                + "('" + kt.getId() + "',N'" + kt.getTen() + "');";
        Statement st = cn.createStatement();
        int kq = st.executeUpdate(sql);

        return kq > 0;
    }
}
