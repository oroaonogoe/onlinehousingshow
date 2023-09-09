package com.example.onlinehousingshow.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class Owner implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Long id;
    @Column(nullable = false, unique = true)
    private String ownerUserName;
    @Column(nullable = false)
    private String ownerName;
    @Column(nullable = false)
    private String ownerEmail;
    @Column(nullable = false)
    private String password;
    @CreationTimestamp
    private LocalDate createdDate;
    @UpdateTimestamp
    private LocalDate updatedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", orphanRemoval = true)
    @JsonManagedReference(value = "owner-house")
    private List<Housing> housing;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "owner_role", joinColumns = { @JoinColumn(name = "owner_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    private Set<Role> authorities;

    public Owner() {
        super();
    }

    public Owner(String ownerUserName, String ownerName, String ownerEmail, String password, Set<Role> authorities) {
        this.ownerUserName = ownerUserName;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.password = password;
        this.authorities = authorities;
    }

    public List<Housing> getHousing() {
        return housing;
    }

    public void setHousing(List<Housing> housing) {
        this.housing = housing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwnerUserName(String ownerUserName) {
        this.ownerUserName = ownerUserName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return ownerUserName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getOwnerUserName() {
        return ownerUserName;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }
}
