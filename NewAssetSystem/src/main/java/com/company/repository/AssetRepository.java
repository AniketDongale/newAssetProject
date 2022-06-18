package com.company.repository;

import com.company.entity.Assets;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AssetRepository extends JpaRepository<Assets,Long> {
}
