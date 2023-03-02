package com.raymondsugiarto.springbootcacheredis.repository.cache;

import com.raymondsugiarto.springbootcacheredis.entity.cache.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author r.pb on 02/03/23
 */
@Repository
public interface PartnerCacheRepository extends JpaRepository<Partner, String> {
}