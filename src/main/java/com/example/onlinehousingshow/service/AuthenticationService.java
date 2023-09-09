package com.example.onlinehousingshow.service;

import com.example.onlinehousingshow.dto.LoginDTO;
import com.example.onlinehousingshow.model.Owner;

public interface AuthenticationService {
    public Owner registerOwner(Owner owner);

    public LoginDTO loginOwner(String ownerUserName, String password);

}
