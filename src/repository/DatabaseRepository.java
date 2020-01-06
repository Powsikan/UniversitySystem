
package repository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseRepository implements Repository {


    @Override
    public ResultSet userCheck(String query, String username, String password) {
        ResultSet rs = null;

        try {
            DbConnection con = new DbConnection();
            Connection connector = con.getConnection();
            PreparedStatement ps = connector.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return rs;
    }

    @Override
    public void userPost(String query, String username, String password) {
        try {
            DbConnection con = new DbConnection();
            Connection connector = con.getConnection();
            PreparedStatement ps = connector.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "record added");
        } catch (SQLException ex) {
            ex.getMessage();
        }

    }

}
