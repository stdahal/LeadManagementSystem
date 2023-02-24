/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lead.manager;

import com.lead.dbConnection.DBConnection;
import com.lead.model.AdminModel;
import com.lead.model.CounselorReport;
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
public class ReportManager {

    private final Connection con;
    DBConnection connection = new DBConnection();

    public ReportManager() throws SQLException {
        Connection con = connection.getConnection();
        this.con = con;
    }

    public List<LeadModel> listActiveLeads() {
        List<LeadModel> leads = new ArrayList<LeadModel>();

        String query = "SELECT * FROM lead,semester,status,followup WHERE lead.leadId=followup.leadId AND "
                + "followup.statusId=status.statusId AND "
                + "lead.semesterId=semester.semesterId AND "
                + "followUP.statusId=" + 1;
        //String query = "SELECT lead.leadId,lead.leadName,lead.contactNo,lead.leadAdd,lead.email,status.status,followup.feedback,followup.followUpNoFROM lead ,status,followup WHERE lead.statusId=status.statusId AND "
        //        + "lead.semesterId=semester.semesterId AND "
        //       + "lead.leadId=followup.leadId AND "
        //       + "followup.statusId=" + 1;

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

    public List<LeadModel> getDWReport(String fromDate, String toDate) {
        //get the list for the date wise report as per the from date and to date
        List<LeadModel> leads = new ArrayList<LeadModel>();
        String sql = "SELECT * FROM lead WHERE dateAdded>='" + fromDate + "' AND dateAdded<='" + toDate + "'";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LeadModel newLead = new LeadModel();
                newLead.setLeadId(rs.getInt("leadId"));
                newLead.setName(rs.getString("leadName"));
                newLead.setContact(rs.getString("contactNo"));
                newLead.setAdd(rs.getString("leadAdd"));
                newLead.setEmail(rs.getString("email"));
                newLead.setRegisterDate(rs.getDate("dateAdded"));
                leads.add(newLead);
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return leads;
    }

    public List<LeadModel> getCWReport(String counselorId) {
        //gets the counselors and returns a list of all the selected counselors.
        List<LeadModel> leads = new ArrayList<LeadModel>();
        String sql = "SELECT * FROM lead WHERE counselorId=" + counselorId;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LeadModel newLead = new LeadModel();
                newLead.setLeadId(rs.getInt("leadId"));
                newLead.setName(rs.getString("leadName"));
                System.out.println("hello");
                newLead.setContact(rs.getString("contactNo"));
                newLead.setAdd(rs.getString("leadAdd"));
                newLead.setEmail(rs.getString("email"));
                newLead.setRegisterDate(rs.getDate("dateAdded"));
                leads.add(newLead);
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return leads;
    }

    public List<LeadModel> getSWReport(String semId) {
        List<LeadModel> leads = new ArrayList<LeadModel>();
        String sql = "SELECT * FROM lead WHERE semesterid='" + semId + "'";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LeadModel newLead = new LeadModel();
                newLead.setLeadId(rs.getInt("leadId"));
                newLead.setName(rs.getString("leadName"));
                newLead.setContact(rs.getString("contactNo"));
                newLead.setAdd(rs.getString("leadAdd"));
                newLead.setEmail(rs.getString("email"));
                newLead.setRegisterDate(rs.getDate("dateAdded"));
                leads.add(newLead);
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return leads;
    }

    public List<SemesterModel> getAllSemesters() {
        //gets the semester and returns a list of all the selected semesters.
        List<SemesterModel> semesters = new ArrayList<SemesterModel>();
        String sql = "SELECT * FROM semester";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SemesterModel newSemester = new SemesterModel();
                newSemester.setSemesterId(rs.getInt("semesterId"));
                newSemester.setSession(rs.getString("session"));
                newSemester.setYear(rs.getString("year"));
                semesters.add(newSemester);
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return semesters;
    }

    public List<AdminModel> getAllCounselors() {
        //gets the counselors and returns a list of all the selected counselors.
        List<AdminModel> counselors = new ArrayList<AdminModel>();
        String sql = "SELECT * FROM counselor";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AdminModel newCounselor = new AdminModel();
                newCounselor.setCounselorId(rs.getInt("userId"));
                newCounselor.setCounselorName(rs.getString("counselorName"));
                counselors.add(newCounselor);
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return counselors;
    }

    public List<LeadModel> listLeadStatus(String statusId) {
        //gets the leads and returns a list of all the leads as per their statuses.
        List<LeadModel> leads = new ArrayList<LeadModel>();

        String query = "SELECT * FROM lead,semester,status,followup WHERE lead.leadId=followup.leadId AND "
                + "followup.statusId=status.statusId AND "
                + "lead.semesterId=semester.semesterId AND "
                + "followUP.statusId=" + statusId;
    

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
    public List<CounselorReport> listCounselorReport() {
        //selects the counselor and return a list of selected counselor
        List<CounselorReport> counselReport = new ArrayList<CounselorReport>();
        System.out.println();

        String query = "SELECT c.counselorId,c.counselorName,  l.leadName, s.status, f.followupNo, sem.semesterName FROM login log \n" +
            "JOIN counselor c ON log.userId = c.userId\n" +
            "JOIN lead l on log.userId = l.counselorId\n" +
            "JOIN followup f on l.leadId = f.leadId\n" +
            "JOIN status s on f.statusId = s.statusId\n" +
            "JOIN semester sem on l.semesterId = sem.semesterId";
    

        try {
            Statement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CounselorReport counReport = new CounselorReport();
                counReport.setCounselorName(rs.getString("counselorName"));
                counReport.setCounselorId(rs.getInt("counselorId"));
                counReport.setLeadName(rs.getString("leadName"));
                System.out.println(rs.getString("counselorName") + rs.getString("leadName"));
                counReport.setStatus(rs.getString("status"));
                counReport.setFollowNumber(rs.getInt("followupNo"));
                counReport.setSemester(rs.getString("semesterName"));
                
                
                counselReport.add(counReport);
            }
        

        } catch (SQLException ex) {
            Logger.getLogger(CounsellorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return counselReport;

    } 
}
