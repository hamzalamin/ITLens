package com.wora.itlens.repositories;

import com.wora.itlens.models.entites.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
