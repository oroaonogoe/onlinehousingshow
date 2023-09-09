package com.example.onlinehousingshow.dto;

import com.example.onlinehousingshow.model.Owner;

public class LoginDTO {
    private Owner owner;
    private String jwt;

    public LoginDTO() {
    }

    public LoginDTO(Owner owner, String jwt) {
        this.owner = owner;
        this.jwt = jwt;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
