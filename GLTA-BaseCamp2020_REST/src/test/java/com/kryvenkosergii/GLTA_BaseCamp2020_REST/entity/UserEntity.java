package com.kryvenkosergii.GLTA_BaseCamp2020_REST.entity;

import java.util.List;

import com.kryvenkosergii.GLTA_BaseCamp2020_REST.data.SupportData;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.data.User;

/**
 * UserEntity class.
 */
public class UserEntity {

    private int id;
    private String name;
    private String job;
    private String createdAt;
    // single user
    private List<User> data;
    private List<SupportData> support;
    // list of users
    private int page;
    private int per_page;
    private int total;
    private int total_pages;

    /**
     * Default constructor.
     */
    public UserEntity() {
        this.id = 0;
        this.name = "";
        this.job = "";
        this.createdAt = "";
        this.data = null;
        this.support = null;
        this.page = 0;
        this.per_page = 0;
        this.total = 0;
        this.total_pages = 0;
    }

    // post user
    public UserEntity(int id, String name, String job, String createdAt) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.createdAt = createdAt;
        this.data = null;
        this.support = null;
        this.page = 0;
        this.per_page = 0;
        this.total = 0;
        this.total_pages = 0;
    }

    public UserEntity(List<User> data, List<SupportData> support, int page, int per_page, int total, int total_pages) {
        this.data = data;
        this.support = support;
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.id = 0;
        this.name = "";
        this.job = "";
        this.createdAt = "";
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

    public String getCreatedAt() {
        return createdAt;
    }

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    @Override
    public String toString() {
        return "UserEntity [id=" + id + ", name=" + name + ", job=" + job + "]";
    }

    public List<User> getData() {
        return data;
    }

    public List<SupportData> getSupport() {
        return support;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public void setSupport(List<SupportData> support) {
        this.support = support;
    }

}
