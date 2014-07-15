package com.dietsodasoftware.carfinder.service.dao;

import com.dietsodasoftware.carfinder.model.VehicleStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User: wendel.schultz
 * Date: 7/14/14
 */
@Repository
public interface VehicleStyleDbRepository extends JpaRepository<VehicleStyle, Long> {
}
