package com.dbproject.datagg.repository;

import com.dbproject.datagg.entity.ConvenienceStoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvenienceStoreRepository extends JpaRepository<ConvenienceStoreEntity, Long> {

}
