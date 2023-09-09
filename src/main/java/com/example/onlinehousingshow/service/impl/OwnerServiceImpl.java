package com.example.onlinehousingshow.service.impl;

import com.example.onlinehousingshow.Repository.OwnerRepository;
import com.example.onlinehousingshow.model.Owner;
import com.example.onlinehousingshow.service.OwnerService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements UserDetailsService, OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ownerRepository.findByOwnerUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("USER NOT FOUND"));
    }

    public Owner getOwner(Long id) throws UsernameNotFoundException {
        return ownerRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("USER NOT FOUND"));
    }
}
