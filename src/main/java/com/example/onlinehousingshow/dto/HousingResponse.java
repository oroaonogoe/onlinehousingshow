package com.example.onlinehousingshow.dto;

public class HousingResponse<T> {
    int recordCount;
    T response;

    public HousingResponse() {
    }

    public HousingResponse(int recordCount, T response) {
        this.recordCount = recordCount;
        this.response = response;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
