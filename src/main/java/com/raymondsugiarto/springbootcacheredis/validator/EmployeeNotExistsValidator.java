package com.raymondsugiarto.springbootcacheredis.validator;

import com.raymondsugiarto.springbootcacheredis.dto.EmployeeRequestDto;
import com.raymondsugiarto.springbootcacheredis.entity.cache.Employee;
import com.raymondsugiarto.springbootcacheredis.repository.cache.EmployeeCacheRepository;
import com.raymondsugiarto.springbootcacheredis.validator.constraints.EmployeeNotExists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class EmployeeNotExistsValidator implements ConstraintValidator<EmployeeNotExists, EmployeeRequestDto> {

  @Autowired
  private EmployeeCacheRepository employeeCacheRepository;

  @Override
  public boolean isValid(EmployeeRequestDto request, ConstraintValidatorContext context) {
    Employee employee = Employee.builder().build();
    employee.setKey(request.getNpk());

    return !employeeCacheRepository.existsById(employee.getKey());
  }
}
