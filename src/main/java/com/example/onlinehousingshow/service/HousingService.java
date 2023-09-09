package com.example.onlinehousingshow.service;

import com.example.onlinehousingshow.dto.HousingDTO;
import com.example.onlinehousingshow.model.Housing;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public interface HousingService {
    Housing create(Housing housing);

    Page<Housing> findWithPagination(int pageNo, int pageSize);

    Page<Housing> listHousingWithPaginationAndFilter(int pageNo, int pageSize, String field, String val,
            LocalDate dt);

    Page<Housing> listHousingWithPaginationByOwner(Long ownerId, int pageNo, int pageSize);

    Page<Housing> findByHousingLikeWithOwnerId(Long ownerId, String housingName, String address, String numberOfFloors,
    String numberOfMasterRoom, String numberOfSingleRoom, String amount, LocalDate createdDate, int pageNo, int pageSize);

    HousingDTO updateHousing(Long ownerId, Long houseId, HousingDTO housingDTO);
}
