package com.example.onlinehousingshow.dto;

import java.time.LocalDate;

public class HousingDTO {
    private Long id;
    private String housingName;
    private String address;
    private int numberOfFloors;
    private int numberOfMasterRoom;
    private int numberOfSingleRoom;
    private double amount;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public HousingDTO() {
    }

    public HousingDTO(String housingName, String address, int numberOfFloors, int numberOfMasterRoom,
            int numberOfSingleRoom, double amount) {
        this.housingName = housingName;
        this.address = address;
        this.numberOfFloors = numberOfFloors;
        this.numberOfMasterRoom = numberOfMasterRoom;
        this.numberOfSingleRoom = numberOfSingleRoom;
        this.amount = amount;
    }

    public HousingDTO(Long id, String housingName, String address, int numberOfFloors, int numberOfMasterRoom,
            int numberOfSingleRoom, double amount, LocalDate createdDate, LocalDate updatedDate) {
        this.id = id;
        this.housingName = housingName;
        this.address = address;
        this.numberOfFloors = numberOfFloors;
        this.numberOfMasterRoom = numberOfMasterRoom;
        this.numberOfSingleRoom = numberOfSingleRoom;
        this.amount = amount;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
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

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfMasterRoom() {
        return numberOfMasterRoom;
    }

    public void setNumberOfMasterRoom(int numberOfMasterRoom) {
        this.numberOfMasterRoom = numberOfMasterRoom;
    }

    public int getNumberOfSingleRoom() {
        return numberOfSingleRoom;
    }

    public void setNumberOfSingleRoom(int numberOfSingleRoom) {
        this.numberOfSingleRoom = numberOfSingleRoom;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
