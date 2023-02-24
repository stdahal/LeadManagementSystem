/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lead.manager;

import com.lead.dbConnection.DBConnection;
import com.lead.model.AdminModel;
import com.lead.model.LeadModel;
import com.lead.model.SemesterModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class AdminManager {

    private final Connection con;
    DBConnection connection = new DBConnection();

    public AdminManager() throws SQLException {
        Connection con = connection.getConnection();
        this.con = con;
    }

    public void addNewCounselor(AdminModel adminModel) {
        try {
            //queries and adds counselor to the database
            String sql = "INSERT INTO login(userName,password,role) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, adminModel.getEmail());
            ps.setString(2, adminModel.getPassword());
            ps.setString(3, "Staff");
            ps.executeUpdate();
            ResultSet rsGetId = ps.getGeneratedKeys();
            if (rsGetId.next()) {
                adminModel.setCounselorId(rsGetId.getInt(1));

            }
            String query = "INSERT INTO counselor(counselorName,counselorAdd,contNo,email,userId)VALUES(?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, adminModel.getCounselorName());
            pstmt.setString(2, adminModel.getCounselorAdd());
            pstmt.setString(3, adminModel.getContact());
            pstmt.setString(4, adminModel.getEmail());
            pstmt.setInt(5,adminModel.getCounselorId());
            
            System.out.println("inserted!!!");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<AdminModel> listCounselors() {
        //queries and list counselors selecting records from the database.
        List<AdminModel> counselors = new ArrayList<AdminModel>();
        String query = "SELECT *FROM counselor";
        try {

            Statement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                AdminModel counselor = new AdminModel();
                counselor.setCounselorId(rs.getInt("counselorId"));
                counselor.setCounselorName(rs.getString("counselorName"));
                counselor.setCounselorAdd(rs.getString("counselorAdd"));
                counselor.setContact(rs.getString("contNo"));
                counselor.setEmail(rs.getString("email"));

                counselors.add(counselor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CounsellorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return counselors;

    }

    public AdminModel editCounselor(int id1) {
        //queries and gets records to edit the counselor using the id passed as a paramater
        AdminModel adminModel = new AdminModel();
        String sql = "SELECT * FROM counselor Where "
                + "counselorId=" + id1;
        PreparedStatement pstmt;

        try {
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(sql);
            while (rs.next()) {
                adminModel.setCounselorId(rs.getInt("counselorId"));
                adminModel.setCounselorName(rs.getString("counselorName"));
                adminModel.setCounselorAdd(rs.getString("counselorAdd"));
                adminModel.setContact(rs.getString("contNo"));
                adminModel.setEmail(rs.getString("email"));
                System.out.println("email id is" + rs.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CounsellorManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return adminModel;
    }

    public String updateCounselorDetails(AdminModel adminModel) {
        //queries and updates counselor details
        String sql = "UPDATE counselor SET counselorId=?,counselorName=?,counselorAdd=?,contNo=?,email=? WHERE counselorId=" + adminModel.getCounselorId();
        System.out.println("your id is::" + adminModel.getCounselorId());

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            System.out.println("?????");
            pstmt.setInt(1, adminModel.getCounselorId());
            pstmt.setString(2, adminModel.getCounselorName());
            pstmt.setString(3, adminModel.getCounselorAdd());
            pstmt.setString(4, adminModel.getContact());
            pstmt.setString(5, adminModel.getEmail());
            System.out.println("hope this goes well");

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CounsellorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public void deleteCounselor(int counsParsedId) {
        //queries and deletes the counselor from the database using the counselor Id
        String sql = "DELETE FROM counselor WHERE counselorId=" + counsParsedId;
        try {
            System.out.println("counselor id is" + counsParsedId);
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delCounselor(int id2) {
        //queries and deletes the counselor from the database using the counselor Id
        String sql = "DELETE FROM counselor WHERE counselorId=" + id2;
        try {
            System.out.println("counselor id is" + id2);
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<SemesterModel> getAllSemesters() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
