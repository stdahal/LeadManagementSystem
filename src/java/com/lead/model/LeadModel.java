/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lead.model;

import java.util.Date;

/**
 *
 * Model for Lead
 */
public class LeadModel {

    private int followUpId;
    private int counselorId;
    private int statusId;
    private String semesterName;
    private int leadId;
    private int semesterId;
    private String name;
    private String add;
    private String email;
    private String contact;
    private String status;
    private int followUpNo;
    private String feedback;
    private Date date;
    private Date registerDate;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
   

 

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getFollowUpNo() {
        return followUpNo;
    }

    public void setFollowUpNo(int followUpNo) {
        this.followUpNo = followUpNo;
    }

    public int getFollowUpId() {
        return followUpId;
    }

    public void setFollowUpId(int followUpId) {
        this.followUpId = followUpId;
    }

    public int getLeadId() {
        return leadId;
    }

    public void setLeadId(int leadId) {
        this.leadId = leadId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemester(String semesterName) {
        this.semesterName = semesterName;
    }

    public int getCounselorId() {
        return counselorId;
    }

    public void setCounselorId(int counselorId) {
        this.counselorId = counselorId;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
