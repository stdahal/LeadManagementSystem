/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lead.controller;

import com.lead.manager.AdminManager;
import com.lead.manager.CounsellorManager;
import com.lead.model.AdminModel;
import com.lead.model.LeadModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Controls all the activities related to the Admin User.
 */
public class AdminController extends HttpServlet {

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
        RequestDispatcher rd = null;
        response.setContentType("text/html;charset=UTF-8");
        String redirectPage = "index.jsp";
        AdminModel adminModel = new AdminModel();
        //A HashMap created to store the message of errors and success
        Map<String, String> message = new HashMap<String, String>();
        request.setAttribute("message", message);
        try {

            AdminManager adminManager = new AdminManager();
            String servletPath = request.getServletPath();
            System.out.println("servlet path is::" + servletPath);
            
            //Checks the servlet path contained by the request and controls the flow accordingly use the switch..case
            switch (servletPath) {
                case ("/AddCounselor.html"):
                    //Gets all the entered counselor details and stores them in variables
                    String counselorName = request.getParameter("counselorName");
                    String contact = request.getParameter("contact");
                    String address = request.getParameter("add");
                    String email = request.getParameter("email");
                    String password = request.getParameter("pass");
                    
                    //Sets the same value onto the admin's model using setters
                    adminModel.setCounselorName(counselorName);
                    adminModel.setContact(contact);
                    adminModel.setCounselorAdd(address);
                    adminModel.setEmail(email);
                    adminModel.setPassword(password);
                    
                    //Calls the method to add counselor from the admin manager and sends the model as a parameter
                    adminManager.addNewCounselor(adminModel);
                    message.put("success", "successfully added!!");
                    System.out.println("Successfully added!!");
                    redirectPage = "view/addCounselor.jsp";
                    break;
                case ("/listCounsellors.html"):
                    System.out.println("i am counselor");
                    //Calls a method from admin manager to list all counselors, stores it in an array and sends it as a parameter in request
                    List<AdminModel> listCounselor = adminManager.listCounselors();
                    request.setAttribute("counselors", listCounselor);
                    redirectPage = "view/listCounselors.jsp";
                    break;
                case ("/editCounselor.html"):                   
                    //Calls the method to edit the counselor and sends the model with the values set to it.
                    System.out.println("i edit counselor");
                    String counselorId = request.getParameter("id");
                    System.out.println("counselor" + counselorId);
                    int id1 = Integer.parseInt(counselorId);
                    System.out.println("counselor id is" + id1);
                    //The id of the admin obtained while user clicks the edit button and is sent as a parameter for editing
                    AdminModel getCounselor = adminManager.editCounselor(id1);
                    request.setAttribute("counselor", getCounselor);
                    redirectPage = "view/editCounselor.jsp";
                    break;

                case ("/updateCounselor.html"):
                    System.out.println(" check update");
                    String councelorName = request.getParameter("name");
                    String counselorAddress = request.getParameter("add");
                    String counselorContact = request.getParameter("contact");
                    String counselorEmail = request.getParameter("email");

                    adminModel.setCounselorId(Integer.parseInt(request.getParameter("id")));
                    adminModel.setCounselorName(councelorName);
                    adminModel.setCounselorAdd(counselorAddress);
                    adminModel.setContact(counselorContact);
                    adminModel.setEmail(counselorEmail);
                    adminManager.updateCounselorDetails(adminModel);
                    //A list of counselors is prepared by calling the method from admin manager and sent as a request parameter to listConselors.jsp for listing
                    List<AdminModel> updateCounselor = adminManager.listCounselors();
                    request.setAttribute("counselors", updateCounselor);
                    redirectPage = "view/listCounselors.jsp";
                    break;
                case ("/deleteCounselor.html"):
                    //Deletes the counselor calling a method from admin manager
                    System.out.println("ok");
                    String counsId = request.getParameter("id");
                    System.out.println("counselor" + counsId);
                    int id2 = Integer.parseInt(counsId);
                    System.out.println("counselor id is" + id2);
                    //The id of the admin obtained while user clicks the delete button and is sent as a parameter for deletion
                    adminManager.delCounselor(id2);
                    redirectPage = "/listCounsellors.html";
                    break;

            }
        } catch (SQLException ex) {
            //Catches any exceptions and throws errors if any
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //eitherways it redirects to the page as set by the methods
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
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
