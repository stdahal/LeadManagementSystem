/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lead.controller;

import com.lead.manager.AdminManager;
import com.lead.manager.CounsellorManager;
import com.lead.manager.ReportManager;
import com.lead.model.AdminModel;
import com.lead.model.CounselorReport;
import com.lead.model.LeadModel;
import com.lead.model.SemesterModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Controls all the activities related to the Report User.
 */
public class ReportController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = null;
        response.setContentType("text/html;charset=UTF-8");
        String redirectPage = "index.jsp";
        try {
            ReportManager manager = new ReportManager();
            LeadModel leadModel = new LeadModel();
            CounsellorManager counsManager = new CounsellorManager();
            String servletPath = request.getServletPath();
            System.out.println("servlet path is::" + servletPath);
            switch (servletPath) {
                case ("/swreport-fill"):
                    ReportManager newSemesterDao = new ReportManager();
                    //Get All Semesters from the Semester and prepares a list and sends as a request in semesters for listing
                    List<SemesterModel> listAllSemesters = newSemesterDao.getAllSemesters();
                    request.setAttribute("semesters", listAllSemesters);
                    redirectPage = "view/swreport-frm.jsp";
                    break;
                case ("/cwreport-fill"):
                    ReportManager newCounselorDao = new ReportManager();
                    //Get All COunselors from the Counselor and prepares a list and sends as a request in counselors for listing
                    List<AdminModel> listAllCounselors = newCounselorDao.getAllCounselors();
                    request.setAttribute("counselors", listAllCounselors);
                    redirectPage = "view/cwreport-frm.jsp";
                    break;
                case ("/activeLeadReport.html"):
                    System.out.println("i am lead");
                    //Get All leads from the leads and prepares a list and sends as a request in leads for listing
                    List<LeadModel> listLead = manager.listActiveLeads();
                    request.setAttribute("leads", listLead);
                    redirectPage = "view/activeLeads.jsp";
                    break;

                case ("/dwreport.html"):
                    ReportManager newReportDao = new ReportManager();
                    String fromDate = new String();
                    String toDate = new String();
                    
                    //Takes the from date and to date as paramters and generate reports according
                    if (request.getParameter("fromDate") != null) {
                        fromDate = request.getParameter("fromDate");
                    }
                    if (request.getParameter("toDate") != null) {
                        toDate = request.getParameter("toDate");
                    }
                    
                    //Get all the reports from the report manager and sends in as a request parameter
                    List<LeadModel> listAll = newReportDao.getDWReport(fromDate, toDate);
                    request.setAttribute("leads", listAll);
                    redirectPage = "view/dwReport.jsp";
                    break;
                case ("/cwreport.html"):
                    ReportManager newReportDao3 = new ReportManager();
                    String counselorId = new String();
                    if (request.getParameter("selectedCounselor") != "none") {
                        counselorId = request.getParameter("selectedCounselor");
                    }
                    System.out.println("id is" + counselorId);
                    //Get all the reports from the report manager and sends in as a request parameter
                    List<LeadModel> listAllCw = newReportDao3.getCWReport(counselorId);
                    request.setAttribute("leads", listAllCw);
                    redirectPage = "view/cwreport.jsp";
                    break;
                case ("/swreport.html"):
                    ReportManager newReportDao2 = new ReportManager();
                    String semId = new String();
                    if (request.getParameter("selectedSemester") != "none") {
                        semId = request.getParameter("selectedSemester");
                    }
                    //Get all the reports from the report manager and sends in as a request parameter
                    List<LeadModel> listAllSw = newReportDao2.getSWReport(semId);
                    request.setAttribute("leads", listAllSw);
                    redirectPage = "view/swreport.jsp";
                    break;
                case ("/statusReport.html"):
                    String statusId = request.getParameter("status");
                    List<LeadModel> listLeadStatus = manager.listLeadStatus(statusId);
                    request.setAttribute("leads", listLeadStatus);
                    redirectPage = "view/LeadsStatusReport.jsp";
                    break;
                case ("/counselorReport.html"):
                    List<CounselorReport> listCounselorReport= manager.listCounselorReport();
                    request.setAttribute("counselorReport", listCounselorReport);
                    redirectPage = "view/counselorReport.jsp";
                    break; 

            }

        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rd = request.getRequestDispatcher(redirectPage);
            rd.forward(request, response);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
