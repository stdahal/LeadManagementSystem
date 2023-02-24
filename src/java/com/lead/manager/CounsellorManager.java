/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lead.manager;

import com.lead.dbConnection.DBConnection;
import com.lead.model.LeadModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

/**
 *
 * @author HP
 */
public class CounsellorManager {

    private final Connection con;
    DBConnection connection = new DBConnection();

    public CounsellorManager() throws SQLException {
        Connection con = connection.getConnection();
        this.con = con;
    }

    public List<LeadModel> listLeads() {
        //queris and return the list of all the leads
        List<LeadModel> leads = new ArrayList<LeadModel>();
        String query = "SELECT lead.leadId,lead.leadName, lead.semesterId,lead.counselorId,lead.contactNo,lead.leadAdd,lead.email,status.status,semester.semesterName,followup.followId,followup.feedback,followup.followUpNo,followup.statusId FROM lead ,status,semester,followup WHERE lead.statusId=status.statusId AND "
                + "lead.semesterId=semester.semesterId AND "
                + "lead.leadId=followup.leadId";
        try {

            Statement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                LeadModel lead = new LeadModel();
                lead.setLeadId(rs.getInt("leadId"));
                lead.setName(rs.getString("leadName"));
                System.out.println("leadName" + rs.getString("leadName"));
                lead.setContact(rs.getString("contactNo"));
                System.out.println("contact" + rs.getString("contactNo"));
                lead.setAdd(rs.getString("leadAdd"));
                lead.setEmail(rs.getString("email"));
                lead.setStatus(rs.getString("status"));
                lead.setCounselorId(rs.getInt("counselorId"));
                lead.setSemester(rs.getString("semesterId"));
                lead.setSemester(rs.getString("semesterName"));
                lead.setFollowUpId(rs.getInt("followId"));
                lead.setFeedback(rs.getString("feedback"));
                lead.setFollowUpNo(rs.getInt("followUpNo"));
                leads.add(lead);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CounsellorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return leads;

    }

    public LeadModel addFollow(int id1) {
        //queries and selects the follow-up and returns it
        LeadModel model = new LeadModel();
        String sql = "SELECT * FROM followup,status,lead Where status.statusId = followup.statusId AND "
                + "followup.leadId = lead.leadId AND "
                + "followId=" + id1;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                model.setFollowUpId(rs.getInt("followId"));
                model.setLeadId(rs.getInt("leadId"));
                model.setFeedback(rs.getString("feedback"));
                model.setDate(rs.getDate("followDate"));
                model.setFollowUpNo(rs.getInt("followUpNo"));
                model.setStatusId(rs.getInt("lead.statusId"));
                model.setName(rs.getString("leadName"));
                System.out.println("lead name++" + rs.getString("leadName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CounsellorManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return model;
    }

    public String updateFollowUp(LeadModel leadModel) {
        //queries and updates the Follow-up
        String sql = "UPDATE followup SET leadId=?,feedback=?,followDate=?,followUpNo=?,statusId=? WHERE followId=" + leadModel.getFollowUpId();
        String sql2= "UPDATE lead SET statusId=? WHERE leadId=" + leadModel.getLeadId();
        System.out.println("your id is::" + leadModel.getFollowUpId());

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            System.out.println("?????");
            pstmt.setInt(1, leadModel.getLeadId());
            pstmt.setString(2, leadModel.getFeedback());
            System.out.println("?????hhhh");
            System.out.println("date us" + leadModel.getDate());
            java.sql.Date followDate1 = new java.sql.Date(leadModel.getDate().getTime());
            System.out.println("?????hhhhhhhhh");
            pstmt.setDate(3, followDate1);
            pstmt.setInt(4, leadModel.getFollowUpNo());
            System.out.println("?????hhhfghhhgfdfghh");
            pstmt.setInt(5, leadModel.getStatusId());
            pstmt.executeUpdate();
            
            PreparedStatement pstmt2 = con.prepareStatement(sql2);
            pstmt2.setInt(1, leadModel.getStatusId());
            pstmt2.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CounsellorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public LeadModel editLead(int id2) {
        //Queries and edit leads of the database
        LeadModel leadModel = new LeadModel();
        String sql = "SELECT * FROM status,lead,semester Where status.statusId = lead.statusId AND "
                + "lead.semesterId = semester.semesterId AND "
                + "leadId=" + id2;
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(sql);
            while (rs.next()) {
                leadModel.setLeadId(rs.getInt("leadId"));
                leadModel.setName(rs.getString("leadName"));
                leadModel.setContact(rs.getString("contactNo"));
                leadModel.setAdd(rs.getString("leadAdd"));
                leadModel.setEmail(rs.getString("email"));
                leadModel.setStatusId(rs.getInt("statusId"));
                leadModel.setSemesterId(rs.getInt("semesterId"));
                System.out.println("lead name++" + rs.getString("leadName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CounsellorManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return leadModel;
    }

    public String updateLeadDetails(LeadModel leadModel) {
        //Queries and update the lead details
        String sql = "UPDATE lead SET leadId=?,leadName=?,contactNo=?,leadAdd=?,email=?,statusId=?,semesterId=? WHERE leadId=" + leadModel.getLeadId();
        System.out.println("your id is::" + leadModel.getLeadId());

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            System.out.println("?????");
            pstmt.setInt(1, leadModel.getLeadId());
            pstmt.setString(2, leadModel.getName());
            pstmt.setString(3, leadModel.getContact());
            pstmt.setString(4, leadModel.getAdd());
            pstmt.setString(5, leadModel.getEmail());
            pstmt.setInt(6, leadModel.getStatusId());
            pstmt.setInt(7, leadModel.getSemesterId());
            System.out.println("hope this goes well");

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CounsellorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

        public String makeLeadExpired(LeadModel leadModel) {
            //Sets the leads status as expired
        String sql = "UPDATE lead SET statusId=? WHERE leadId=" + leadModel.getLeadId();
        System.out.println("your id is::" + leadModel.getLeadId());
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            System.out.println("?????");
            pstmt.setInt(1, leadModel.getStatusId());
            System.out.println("hope this goes well");

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CounsellorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
