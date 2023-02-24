/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lead.model;
/**
 Model for User
 */
public class UserModel {
    private int id;
    private String userName;
    private String password;
    
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
    
}
