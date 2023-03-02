package com.raymondsugiarto.springbootcacheredis.validator;

import com.raymondsugiarto.springbootcacheredis.dto.PartnerRequestDto;
import com.raymondsugiarto.springbootcacheredis.entity.cache.Partner;
import com.raymondsugiarto.springbootcacheredis.repository.cache.PartnerCacheRepository;
import com.raymondsugiarto.springbootcacheredis.validator.constraints.PartnerNotExists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class PartnerNotExistsValidator implements ConstraintValidator<PartnerNotExists, PartnerRequestDto> {

  @Autowired
  private PartnerCacheRepository partnerCacheRepository;

  @Override
  public boolean isValid(PartnerRequestDto request, ConstraintValidatorContext context) {
    Partner partner = Partner.builder().build();
    partner.setKey(request.getCode());

    return !partnerCacheRepository.existsById(partner.getKey());
  }
}
