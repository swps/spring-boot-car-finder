package com.dietsodasoftware.carfinder.service.dao;

import com.dietsodasoftware.carfinder.model.VehicleMake;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: wendel.schultz
 * Date: 7/14/14
 */
public interface VehicleMakeDbRepository extends JpaRepository<VehicleMake, Long> {
}
