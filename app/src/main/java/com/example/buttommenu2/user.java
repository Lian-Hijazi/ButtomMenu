package com.example.buttommenu2;

public class user {
    private String name,userName,phone,email;
    public user(String name,String userName,String phone,String email){
        this.name=name;
        this.userName=userName;
        this.phone=phone;
        this.email=email;

    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }
}
