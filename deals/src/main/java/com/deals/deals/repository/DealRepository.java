package com.deals.deals.repository;

import com.deals.deals.model.Deals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DealRepository extends JpaRepository<Deals,Long> {

    Optional<Deals> findByIdAndActive(Long id, boolean active);
}
