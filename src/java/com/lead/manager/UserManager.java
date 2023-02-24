/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lead.manager;

import com.lead.dbConnection.DBConnection;
import com.lead.model.LeadModel;
import com.lead.model.UserModel;
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
public class UserManager {

    private final Connection con;
    DBConnection connection = new DBConnection();

    public UserManager() throws SQLException {
        Connection con = connection.getConnection();
        this.con = con;
    }

    public String logInUser(UserModel userModel) {
        String role = null;
        try {
            String sql = "SELECT * FROM login WHERE userName=? && password=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userModel.getUserName());
            pstmt.setString(2, userModel.getPassword());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                role = rs.getString("role");
                userModel.setId(rs.getInt("userId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }

    public void registerNewLead(LeadModel registerLead) {
        try {
            String query = "INSERT INTO lead(leadName,contactNo,leadAdd,email,statusId,counselorId,semesterId,dateAdded)VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, registerLead.getName());
            pstmt.setString(2, registerLead.getContact());
            pstmt.setString(3, registerLead.getAdd());
            pstmt.setString(4, registerLead.getEmail());
            pstmt.setString(5, registerLead.getStatus());
            pstmt.setInt(6, registerLead.getCounselorId());
            pstmt.setString(7, registerLead.getSemesterName());
            java.sql.Date dateAdded = new java.sql.Date(registerLead.getRegisterDate().getTime());
            pstmt.setDate(8, dateAdded);
            

            System.out.println("ok......");
            int check = pstmt.executeUpdate();
            ResultSet rsGetId = pstmt.getGeneratedKeys();
            if (rsGetId.next()) {
                registerLead.setLeadId(rsGetId.getInt(1));

            }

            String sql = "INSERT INTO followup(leadId,followUpNo,statusId)VALUES(?,?,?)";
            PreparedStatement pstmt1 = con.prepareStatement(sql);
            pstmt1.setInt(1, registerLead.getLeadId());
            pstmt1.setInt(2, 1);
            pstmt1.setInt(3, 1);
            int check1 = pstmt1.executeUpdate();
            if (check1 == 1) {
                System.out.println("inserted");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
        

    public List<LeadModel> listSemester() {
        System.out.println("ok");

        List<LeadModel> semesterList = new ArrayList<>();
        String sql = "Select semesterId,semesterName From semester";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LeadModel model = new LeadModel();
                model.setSemesterId(rs.getInt("semesterId"));
                System.out.println(rs.getInt("semesterId"));
                model.setSemester(rs.getString("semesterName"));
                System.out.println(rs.getString("semesterName"));
                semesterList.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return semesterList;

    }

    public List<LeadModel> listStatus() {
        System.out.println("ok");

        List<LeadModel> statusList = new ArrayList<>();
        String sql = "Select statusId,status From status";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LeadModel model = new LeadModel();
                model.setStatusId(rs.getInt("statusId"));
                System.out.println(rs.getInt("statusId"));
                model.setStatus(rs.getString("status"));
                System.out.println(rs.getString("status"));
                statusList.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statusList;

    }

}
