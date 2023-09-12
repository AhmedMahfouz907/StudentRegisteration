/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import connect.connect;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author asdd
 */
public class student {
    
    private int id;
      private String fname;
      private String course;
      private int fee;
    

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getCourse() {
        return course;
    }

    public int getFee() {
        return fee;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
      public void save(student student) {
 
         try {
            Connection con =  connect.getConnection();
            String sql = "INSERT INTO students (name) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getFname());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
    /**
     *
     * @return
     */

    public List<student> list() {
      
          List<student> list = new ArrayList<student>();
        try {
            Connection con = connect.getConnection();
            String sql = "SELECT name FROM students ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                student st = new student();
                
                st.setFname(rs.getString("name"));
                
 
                list.add(st);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
  
    }
       
       
}
