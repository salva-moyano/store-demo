package com.store.persistence.repository;

import com.store.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceEntityRepository extends JpaRepository<PriceEntity, Integer> {
}
