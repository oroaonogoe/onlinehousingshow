package com.example.onlinehousingshow.service.impl;

import com.example.onlinehousingshow.Repository.HousingRepository;
import com.example.onlinehousingshow.Repository.OwnerRepository;
import com.example.onlinehousingshow.dto.HousingDTO;
import com.example.onlinehousingshow.model.Housing;
import com.example.onlinehousingshow.model.Owner;
import com.example.onlinehousingshow.service.HousingService;
import com.example.onlinehousingshow.specification.HousingSpecification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HousingServiceImpl implements HousingService {
    private final HousingRepository housingRepository;

    private final OwnerRepository ownerRepository;

    public HousingServiceImpl(HousingRepository housingRepository, OwnerRepository ownerRepository) {
        this.housingRepository = housingRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Housing create(Housing housing) {
        return housingRepository.save(housing);
    }

    @Override
    public Page<Housing> findWithPagination(int pageNo, int pageSize) {
        return housingRepository.findAll(PageRequest.of(pageNo, pageSize));
    }

    @Override
    public Page<Housing> listHousingWithPaginationAndFilter(int pageNo, int pageSize, String field, String val,
            LocalDate dt) {
        if (field.equals("housingName")) {
            Specification<Housing> specification = Specification.where(HousingSpecification.housingName(val));
            return housingRepository.findAll(specification, PageRequest.of(pageNo, pageSize));
        }
        if (field.equals("address")) {
            Specification<Housing> specification = Specification.where(HousingSpecification.address(val));
            return housingRepository.findAll(specification, PageRequest.of(pageNo, pageSize));
        }
        if (field.equals("numberOfFloors")) {
            Specification<Housing> specification = Specification.where(HousingSpecification.numberOfFloors(val));
            return housingRepository.findAll(specification, PageRequest.of(pageNo, pageSize));
        }
        if (field.equals("numberOfMasterRoom")) {
            Specification<Housing> specification = Specification.where(HousingSpecification.numberOfMasterRoom(val));
            return housingRepository.findAll(specification, PageRequest.of(pageNo, pageSize));
        }
        if (field.equals("numberOfSingleRoom")) {
            Specification<Housing> specification = Specification.where(HousingSpecification.numberOfSingleRoom(val));
            return housingRepository.findAll(specification, PageRequest.of(pageNo, pageSize));
        }
        if (field.equals("amount")) {
            Specification<Housing> specification = Specification.where(HousingSpecification.amount(val));
            return housingRepository.findAll(specification, PageRequest.of(pageNo, pageSize));
        }
        if (field.equals("createdDate")) {
            Specification<Housing> specification = Specification.where(HousingSpecification.createdDate(dt));
            return housingRepository.findAll(specification, PageRequest.of(pageNo, pageSize));
        }
        return null;
    }

    @Override
    public Page<Housing> listHousingWithPaginationByOwner(Long ownerId, int pageNo, int pageSize) {
        return housingRepository.findByOwnerId(ownerId, PageRequest.of(pageNo, pageSize));
    }

    @Override
    public HousingDTO updateHousing(Long ownerId, Long houseId, HousingDTO housingDTO) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(null);
        Housing housing = housingRepository.findById(houseId).orElseThrow(null);
        if (housing.getOwner().getId() != owner.getId()) {
            System.out.println("housing not belong to owner");
        }
        housing.setHousingName(housingDTO.getHousingName());
        housing.setAddress(housingDTO.getAddress());
        housing.setNumberOfFloors(housingDTO.getNumberOfFloors());
        housing.setNumberOfMasterRoom(housingDTO.getNumberOfMasterRoom());
        housing.setNumberOfSingleRoom(housingDTO.getNumberOfSingleRoom());
        housing.setAmount(housingDTO.getAmount());
        Housing updateHousing = housingRepository.save(housing);
        return mapHousingDTO(updateHousing);
    }

    private HousingDTO mapHousingDTO(Housing housing) {
        HousingDTO housingDTO = new HousingDTO();
        housingDTO.setId(housing.getId());
        housingDTO.setHousingName(housing.getHousingName());
        housingDTO.setAddress(housing.getAddress());
        housingDTO.setNumberOfFloors(housing.getNumberOfFloors());
        housingDTO.setNumberOfMasterRoom(housing.getNumberOfMasterRoom());
        housingDTO.setNumberOfSingleRoom(housing.getNumberOfSingleRoom());
        housingDTO.setAmount(housing.getAmount());
        housingDTO.setCreatedDate(housing.getCreatedDate());
        housingDTO.setUpdatedDate(housing.getUpdatedDate());
        return housingDTO;
    }

    @Override
    public Page<Housing> findByHousingLikeWithOwnerId(Long ownerId, String housingName, String address,
            String numberOfFloors,
            String numberOfMasterRoom, String numberOfSingleRoom, String amount, LocalDate createdDate, int pageNo,
            int pageSize) {
        return housingRepository.findByHousingLikeWithOwnerId(ownerId, housingName, address, numberOfFloors,
                numberOfMasterRoom, numberOfSingleRoom, amount, createdDate, PageRequest.of(pageNo, pageSize));
    }

}
