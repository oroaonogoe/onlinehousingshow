package com.example.onlinehousingshow.Repository;

import com.example.onlinehousingshow.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByOwnerUserName(String ownerUserName);
}
