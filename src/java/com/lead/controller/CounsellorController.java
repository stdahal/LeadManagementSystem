/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lead.controller;

import com.lead.manager.CounsellorManager;
import com.lead.model.LeadModel;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

import java.sql.SQLException;
import java.util.Date;
//import java.sql.SQLException;
import java.text.ParseException;
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
import javax.servlet.http.HttpSession;

/**
 *
 * Controls all the activities related to the Controller User.
 */
public class CounsellorController extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        String redirectPage = "index.jsp";
        RequestDispatcher rd = null;
        LeadModel leadModel = new LeadModel();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mmm-dd");
        //Hashmap to store the message of success and errors
        Map<String, String> message = new HashMap<String, String>();
        request.setAttribute("message", message);

        try {
            CounsellorManager counsManager = new CounsellorManager();
            response.setContentType("text/html;charset=UTF-8");
            String servletPath = request.getServletPath();
            System.out.println("servlet path is::" + servletPath);
            
            //Checks the servlet path obtained from the request and directs to the respective case statements.
            switch (servletPath) {
                case ("/ListLeads.html"):
                    System.out.println("i am lead");
                    //HttpSession session = request.getSession();
                    //String xyz = (String) session.getAttribute("id");                //
                    List<LeadModel> listLead = counsManager.listLeads();
                    request.setAttribute("leads", listLead);
                    redirectPage = "view/listLeads.jsp";
                    break;
                case ("/followUp.html"):
                    System.out.println("i am lead");
                    List<LeadModel> listFollowUp = counsManager.listLeads();
                    request.setAttribute("followUp", listFollowUp);
                    redirectPage = "view/followUp.jsp";
                    break;
                case ("/editFollowUp.html"):
                    String id = request.getParameter("id");
                    int id1 = Integer.parseInt(id);
                    System.out.println("id is::" + id);
                    LeadModel getFollowUp = counsManager.addFollow(id1);
                    request.setAttribute("followUp", getFollowUp);
                    redirectPage = "view/editFollowUp.jsp";
                    break;
                case ("/updateFollowUp.html"):
                    System.out.println(" check update");
                    String followUpDateUpdate = request.getParameter("date");

                    String newFollowUpNo = request.getParameter("followUpNo");
                    int followNoUpdate = Integer.parseInt(newFollowUpNo);
                    
                    //increases the follow-up number unless it is less than 8, if great changes the status to expired 
                    if (followNoUpdate < 8) {
                        System.out.println("the follow-up no" + followNoUpdate);
//                        String followNoUpdate = request.getParameter("followUpNo");
                        System.out.println(" check update" + followNoUpdate);
                        String statusId = request.getParameter("status");
                        System.out.println(" check update" + statusId);
                        System.out.println(" check update" + request.getParameter("id"));
                        String feedback = request.getParameter("feedback");
                        System.out.println("feedback" + feedback);

                        System.out.println("date" + followUpDateUpdate);
                        java.util.Date updateDate = dateFormat.parse(followUpDateUpdate);
                        leadModel.setDate(updateDate);

                        leadModel.setFollowUpId(Integer.parseInt(request.getParameter("id")));
                        leadModel.setFollowUpNo(followNoUpdate + 1);
                        leadModel.setStatusId(Integer.parseInt((statusId)));
                        leadModel.setLeadId(Integer.parseInt(request.getParameter("leadId")));
                        leadModel.setFeedback(feedback);
                        CounsellorManager updateLeadFollow = new CounsellorManager();
                        updateLeadFollow.updateFollowUp(leadModel);
                        
                        //Prepares a list getting the values from the listleads method of the counselor manager.
                        //Sends the list as a request parameter for listing.
                        List<LeadModel> UpdatedFollowUp = counsManager.listLeads();
                        request.setAttribute("followUp", UpdatedFollowUp);
                        redirectPage = "view/followUp.jsp";
                    } else {
                        leadModel.setStatusId(3);
                        leadModel.setLeadId(Integer.parseInt(request.getParameter("leadId")));
                        counsManager.makeLeadExpired(leadModel);
                        
                        //Prepares a list getting the values from the listleads method of the counselor manager.
                        //Sends the list as a request parameter for listing.
                        List<LeadModel> updateLead = counsManager.listLeads();
                        request.setAttribute("followUp", updateLead);
                        redirectPage = "view/followUp.jsp";
                    }
                    break;
                case ("/editLead.html"):
                    String leadId = request.getParameter("id");
                    int id2 = Integer.parseInt(leadId);
                    System.out.println("id is::" + id2);
                    //Get the id for leads to edit and send it as a paramter to the method to edit lead.
                    LeadModel getLead = counsManager.editLead(id2);
                    request.setAttribute("lead", getLead);
                    redirectPage = "view/editLead.jsp";
                    break;
                case ("/updateLead.html"):
                    System.out.println(" check update");
                    String leadName = request.getParameter("name");
                    String contact = request.getParameter("contact");
                    String address = request.getParameter("address");
                    String email = request.getParameter("email");
                    String leadStatusId = request.getParameter("status");
                    String leadSemesterId = request.getParameter("semester");
                    
                    //Sets the attributes of the lead model to the values obtained from the user
                    leadModel.setLeadId(Integer.parseInt(request.getParameter("id")));
                    leadModel.setName(leadName);
                    leadModel.setContact(contact);
                    leadModel.setAdd(address);
                    leadModel.setEmail(email);
                    leadModel.setStatusId(Integer.parseInt(leadStatusId));
                    leadModel.setSemesterId(Integer.parseInt(leadSemesterId));
                    counsManager.updateLeadDetails(leadModel);
                    
                    //Prepares a list getting the values from the listleads method of the counselor manager.
                    //Sends the list as a request parameter for listing.
                    List<LeadModel> updateLead = counsManager.listLeads();
                    request.setAttribute("leads", updateLead);

                    redirectPage = "/ListLeads.html";

                    break;

            }

        } catch (SQLException ex) {
            Logger.getLogger(CounsellorController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CounsellorController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CounsellorController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
