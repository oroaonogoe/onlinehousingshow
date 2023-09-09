package com.example.onlinehousingshow.controller;

import com.example.onlinehousingshow.dto.HousingDTO;
import com.example.onlinehousingshow.dto.HousingResponse;
import com.example.onlinehousingshow.model.Housing;
import com.example.onlinehousingshow.service.HousingService;

import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/owner/housing")
@CrossOrigin("*")
public class HousingController {
    private final HousingService housingService;

    public HousingController(HousingService housingService) {
        this.housingService = housingService;
    }

    @PostMapping("/create")
    public Housing create(@RequestBody Housing housing) {
        return housingService.create(housing);
    }

    @GetMapping("/list")
    public HousingResponse<Page<Housing>> findWithPagination(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        Page<Housing> all = housingService.findWithPagination(pageNo, pageSize);
        return new HousingResponse<>(all.getSize(), all);
    }

    @GetMapping(value = "/list/{field}")
    public HousingResponse<Page<Housing>> listHousingWithPaginationAndFilter(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @PathVariable String field,
            @RequestParam(value = "val", required = false) String val,
            @RequestParam(value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dt) {
        Page<Housing> housings = housingService.listHousingWithPaginationAndFilter(pageNo, pageSize, field, val, dt);
        return new HousingResponse<>(housings.getSize(), housings);
    }

    @PutMapping(value = "/edit/{ownerId}/{houseId}")
    public HousingDTO updateHousing(@PathVariable Long ownerId, @PathVariable Long houseId,
            @RequestBody HousingDTO housingDTO) {
        return housingService.updateHousing(ownerId, houseId, housingDTO);
    }
}
