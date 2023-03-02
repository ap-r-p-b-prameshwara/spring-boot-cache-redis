package com.raymondsugiarto.springbootcacheredis.repository.cache;

import com.raymondsugiarto.springbootcacheredis.entity.cache.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author raymond on 26/02/23
 */
@Repository
public interface EmployeeCacheRepository extends JpaRepository<Employee, String> {
}
