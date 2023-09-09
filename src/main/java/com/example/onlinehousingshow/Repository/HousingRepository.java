package com.example.onlinehousingshow.Repository;

import com.example.onlinehousingshow.model.Housing;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface HousingRepository extends JpaRepository<Housing, Long>, JpaSpecificationExecutor<Housing> {
    // List<Housing> findByOwnerId(Long ownerId);
    Page<Housing> findByOwnerId(Long ownerId, Pageable pageable);

    // String FILTER_HOUSE_ON_NAME_WITH_OWNERID = "select h from Housing h join
    // h.owner where upper(b.housingName) like concat('%',upper(?1),'%') and
    // b.owner=?2";
    String FILTER_HOUSE_ON_NAME_WITH_OWNERID = "select h from Housing h join h.owner o where o.id like %?1% and (h.housingName like %?2% or h.address like %?3% or concat(h.numberOfFloors) like %?4% or concat(h.numberOfMasterRoom) like %?5% or concat(h.numberOfSingleRoom) like %?6% or concat(h.amount) like %?7% or h.createdDate like %?8%)";

    @Query(FILTER_HOUSE_ON_NAME_WITH_OWNERID)
    Page<Housing> findByHousingLikeWithOwnerId(Long ownerId, String housingName, String address, String numberOfFloors,
            String numberOfMasterRoom, String numberOfSingleRoom, String amount, LocalDate createdDate,
            Pageable pageable);
}
