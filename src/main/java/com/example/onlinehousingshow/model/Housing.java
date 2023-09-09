package com.example.onlinehousingshow.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
public class Housing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id")
    private Long id;
    @Column(nullable = false)
    private String housingName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Integer numberOfFloors;
    @Column(nullable = false)
    private Integer numberOfMasterRoom;
    @Column(nullable = false)
    private Integer numberOfSingleRoom;
    @Column(nullable = false)
    private Double amount;
    @CreationTimestamp
    private LocalDate createdDate;
    @UpdateTimestamp
    private LocalDate updatedDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    @JsonBackReference(value = "owner-house")
    private Owner owner;

    public Housing() {
    }

    public Housing(String housingName, String address, Integer numberOfFloors, Integer numberOfMasterRoom,
            Integer numberOfSingleRoom, Double amount, Owner owner) {
        this.housingName = housingName;
        this.address = address;
        this.numberOfFloors = numberOfFloors;
        this.numberOfMasterRoom = numberOfMasterRoom;
        this.numberOfSingleRoom = numberOfSingleRoom;
        this.amount = amount;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHousingName() {
        return housingName;
    }

    public void setHousingName(String housingName) {
        this.housingName = housingName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Integer getNumberOfMasterRoom() {
        return numberOfMasterRoom;
    }

    public void setNumberOfMasterRoom(Integer numberOfMasterRoom) {
        this.numberOfMasterRoom = numberOfMasterRoom;
    }

    public Integer getNumberOfSingleRoom() {
        return numberOfSingleRoom;
    }

    public void setNumberOfSingleRoom(Integer numberOfSingleRoom) {
        this.numberOfSingleRoom = numberOfSingleRoom;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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
