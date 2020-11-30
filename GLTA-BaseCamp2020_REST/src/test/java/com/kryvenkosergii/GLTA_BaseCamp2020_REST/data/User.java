package com.kryvenkosergii.GLTA_BaseCamp2020_REST.data;

public class User {

    private int id;
    private String name;
    private String job;
    //
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    //
    public User() {
        this.id = 0;
        this.name = "";
        this.job = "";
    }

    public User(int id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public User(String name, String job) {
        this.name = name;
        this.job = job;
        this.id = 0;
    }

    public User(int id) {
        this.id = id;
        this.name = "";
        this.job = "";
    }

    public User(int id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", job=" + job + "]";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
