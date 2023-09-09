package com.example.onlinehousingshow.specification;

import com.example.onlinehousingshow.model.Housing;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class HousingSpecification {
    public static Specification<Housing> housingName(String housingName) {
        return (((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("housingName"), housingName);
        }));
    }

    public static Specification<Housing> address(String address) {
        return (((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("address"), address);
        }));
    }
    public static Specification<Housing> numberOfFloors(String numberOfFloors) {
        return (((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("numberOfFloors"), numberOfFloors);
        }));
    }
    public static Specification<Housing> numberOfMasterRoom(String numberOfMasterRoom) {
        return (((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("numberOfMasterRoom"), numberOfMasterRoom);
        }));
    }
    public static Specification<Housing> numberOfSingleRoom(String numberOfSingleRoom) {
        return (((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("numberOfSingleRoom"), numberOfSingleRoom);
        }));
    }

    public static Specification<Housing> amount(String amount) {
        return (((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("amount"), amount);
        }));
    }

    public static Specification<Housing> createdDate(LocalDate createdDate) {
        return (((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("createdDate"), createdDate);
        }));
    }
}
