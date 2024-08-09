package com.kitchenware.api.repository;

import com.kitchenware.api.entity.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISellRepository extends JpaRepository<Sell, Long> {
}
