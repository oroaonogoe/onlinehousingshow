package com.example.onlinehousingshow.controller;

import com.example.onlinehousingshow.dto.HousingResponse;
import com.example.onlinehousingshow.model.Housing;
import com.example.onlinehousingshow.model.Owner;
import com.example.onlinehousingshow.service.HousingService;
import com.example.onlinehousingshow.service.impl.OwnerServiceImpl;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owner")
@CrossOrigin("*")
public class OwnerController {
    private final OwnerServiceImpl ownerServiceImpl;
    private final HousingService housingService;

    public OwnerController(OwnerServiceImpl ownerServiceImpl, HousingService housingService) {
        this.ownerServiceImpl = ownerServiceImpl;
        this.housingService = housingService;
    }

    @GetMapping("/{id}")
    public Owner getOwner(@PathVariable Long id) {
        return ownerServiceImpl.getOwner(id);
    }

    @GetMapping(value = "/{ownerId}/housing")
    public HousingResponse<Page<Housing>> findByHousingLikeWithOwnerId(
            @PathVariable Long ownerId,
            @RequestParam(required = false) String housingName,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String numberOfFloors,
            @RequestParam(required = false) String numberOfMasterRoom,
            @RequestParam(required = false) String numberOfSingleRoom,
            @RequestParam(required = false) String amount,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createdDate,
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        Page<Housing> all = housingService.findByHousingLikeWithOwnerId(ownerId, housingName, address, numberOfFloors,
                numberOfMasterRoom, numberOfSingleRoom, amount, createdDate, pageNo,
                pageSize);
        return new HousingResponse<>(all.getSize(), all);
    }
}
