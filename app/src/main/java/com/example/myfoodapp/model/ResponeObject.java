package com.example.myfoodapp.model;

import java.util.List;

public class ResponeObject {
   private String status;
   private List<User> data;

    public ResponeObject(String status, List<User> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
