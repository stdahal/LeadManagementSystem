/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lead.controller;

import com.lead.manager.UserManager;
import com.lead.model.LeadModel;
import com.lead.model.UserModel;
import com.mysql.jdbc.StringUtils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
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
 * Controls all the activities related to the User.
 */
public class UserController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String redirectPage = "index.jsp";
        RequestDispatcher rd = null;

        try {
            Map<String, String> message = new HashMap<String, String>();
            request.setAttribute("msg", message);
            request.setAttribute("message", message);
            LeadModel registerLead = new LeadModel();
            String servletPath = request.getServletPath();
            System.out.println("servlet Path is:::" + servletPath);
            UserManager userManager = new UserManager();

            switch (servletPath) {
                case ("/login.html"):
                   //Checks the username and password and if incorrect gives errors.
                    UserModel userModel = new UserModel();
                    String userName = request.getParameter("userName");

                    if (userName == null || userName.trim().isEmpty()) {
                        message.put("user_name", "Username Field Empty. Please Enter Username!!");
                    }
                    String pass = request.getParameter("password");
                    if (pass == null || pass.trim().isEmpty()) {
                        message.put("password", "Password Field Empty. Please Enter Password!!");
                    }
                    System.out.println(userName);
                    System.out.println(pass);
                    if (message.isEmpty()) {
                        userModel.setUserName(userName);
                        userModel.setPassword(pass);

                        String logIn = userManager.logInUser(userModel);
                        if (!StringUtils.isNullOrEmpty(logIn)) {
                            HttpSession session = request.getSession();
                            session.setAttribute("role", logIn);
                            session.setAttribute("id", userModel.getId());
                            System.out.println("id is" + userModel.getId());
                            String role = (String) session.getAttribute("role");

                            System.out.println("session is" + role);

                            System.out.println("role is" + logIn);
                            //checks the role and redirects to their respective dashboards
                            if (logIn.equalsIgnoreCase("Admin")) {
                                redirectPage = "view/adminProfile.jsp";
                                rd = request.getRequestDispatcher(redirectPage);
                                rd.forward(request, response);
                            } else if (logIn.equalsIgnoreCase("Staff")) {
                                redirectPage = "view/counselorProfile.jsp";
                                rd = request.getRequestDispatcher(redirectPage);
                                rd.forward(request, response);
                            } else if (logIn.equalsIgnoreCase("Manager")) {
                                redirectPage = "view/topManagerProfile.jsp";
                                rd = request.getRequestDispatcher(redirectPage);
                                rd.forward(request, response);
                            } else {
                                redirectPage = "view/index.jsp";
                            }
                        } else {
                            message.put("server", "Username & password doesn't match!!");
                            System.out.println("Username password doesn't match!!");
                        }
                    }
                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                    break;
                case ("/view/addLead.jsp"):
                    System.out.println("path is" + servletPath);
                    UserManager manager = new UserManager();
                    List<LeadModel> listSemester = manager.listSemester();
                    request.setAttribute("semester", listSemester);

                    List<LeadModel> listStatus = manager.listStatus();
                    request.setAttribute("status", listStatus);

                    response.sendRedirect("view/addLead.jsp");
                    break;
                case ("/registerLead.html"):
                    System.out.println(servletPath);
                    String name = request.getParameter("leadName");
                    String add = request.getParameter("add");
                    String email = request.getParameter("email");
                    String contact = request.getParameter("contact");
                    String status = request.getParameter("status");
                    String semester = request.getParameter("semester");
                    System.out.println("ok" + semester);
                    
                    //get a session from the request
                    HttpSession newSession = request.getSession();
                    int CounserlorId = (int) newSession.getAttribute("id");
                    Date currentDate = new Date();//create date object
                    System.out.println("current date is" + currentDate);
                    
                    //a lead is added to an id getiing the counselor id and setting it to the model of the lead
                    registerLead.setName(name);
                    registerLead.setAdd(add);
                    registerLead.setEmail(email);
                    registerLead.setContact(contact);
                    registerLead.setStatus(status);
                    registerLead.setSemester(semester);
                    registerLead.setCounselorId(CounserlorId);
                    registerLead.setRegisterDate(currentDate);
                    userManager.registerNewLead(registerLead);
                    message.put("successMsg", "successfully added!!");
                    System.out.println("Successfully added!!");
                    //redirectPage = "view/addLead.jsp";
                    rd = request.getRequestDispatcher("view/success.jsp");
                    rd.forward(request, response);
                    break;
                case ("/logout.html"):
                    HttpSession destroySession = request.getSession(false);
                    if (destroySession != null) {
                        destroySession.invalidate();
                    }
                    System.out.println("Session is destroyed!!!! ");
                    redirectPage = "index.jsp";

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }// finally {
        //  rd = request.getRequestDispatcher(redirectPage);
        //  rd.forward(request, response);
        //    }

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
