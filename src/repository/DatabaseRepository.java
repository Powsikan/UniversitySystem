
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
    public void userPost(String query, String stu_No, String username, String password,String stu_Name) {
        try {
            DbConnection con = new DbConnection();
            Connection connector = con.getConnection();
            PreparedStatement ps = connector.prepareStatement(query);
            ps.setString(1, stu_No);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, stu_Name);
            System.out.println(ps);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "record added");
        } catch (SQLException ex) {
            ex.getMessage();
        }

    }

    @Override
    public ResultSet getCourse(String query, String stu_no) {
        ResultSet rsc=null;
          try {
            DbConnection con = new DbConnection();
            Connection connector = con.getConnection();
            PreparedStatement ps = connector.prepareStatement(query);
            ps.setString(1, stu_no);
            rsc = ps.executeQuery();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return rsc;
    }

    @Override
    public void addCourse(String query,String student_no, String courses, String status) {
        
         try {
            DbConnection con = new DbConnection();
            Connection connector = con.getConnection();
            PreparedStatement ps = connector.prepareStatement(query);
            ps.setString(1, student_no);
            ps.setString(2, courses);
            ps.setString(3, status);
            System.out.println(ps);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "record added");
        } catch (SQLException ex) {
            ex.getMessage();
        }

        
    }

}
