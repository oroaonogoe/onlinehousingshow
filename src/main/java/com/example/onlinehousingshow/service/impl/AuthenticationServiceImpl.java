package com.example.onlinehousingshow.service.impl;

import com.example.onlinehousingshow.Repository.OwnerRepository;
import com.example.onlinehousingshow.Repository.RoleRepository;
import com.example.onlinehousingshow.dto.LoginDTO;
import com.example.onlinehousingshow.model.Owner;
import com.example.onlinehousingshow.model.Role;
import com.example.onlinehousingshow.service.AuthenticationService;
import com.example.onlinehousingshow.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    private final OwnerRepository ownerRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationServiceImpl(OwnerRepository ownerRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.ownerRepository = ownerRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @Override
    public Owner registerOwner(Owner owner) {
        String encodedPassword = passwordEncoder.encode(owner.getPassword());
        Role ownerRole = roleRepository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(ownerRole);
        return ownerRepository.save(new Owner(
                owner.getUsername(), owner.getOwnerName(), owner.getOwnerEmail(), encodedPassword, authorities
        ));
    }

    @Override
    public LoginDTO loginOwner(String ownerUserName, String password) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(ownerUserName, password)
            );
            String token = tokenService.generateJwt(auth);
            return new LoginDTO(ownerRepository.findByOwnerUserName(ownerUserName).get(), token);
        } catch (AuthenticationException e) {
            return new LoginDTO(null, "");
        }
    }
}
