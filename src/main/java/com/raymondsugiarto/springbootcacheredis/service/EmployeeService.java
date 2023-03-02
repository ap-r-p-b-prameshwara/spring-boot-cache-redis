package com.raymondsugiarto.springbootcacheredis.service;

import com.raymondsugiarto.springbootcacheredis.dto.EmployeeDto;
import com.raymondsugiarto.springbootcacheredis.dto.EmployeeRequestDto;
import com.raymondsugiarto.springbootcacheredis.entity.cache.Employee;
import com.raymondsugiarto.springbootcacheredis.repository.cache.EmployeeCacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author raymond on 26/02/23
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {
  private final EmployeeCacheRepository employeeCacheRepository;

  public EmployeeDto createEmployee(EmployeeRequestDto employeeRequestDto){
    Employee employeeRequest = Employee
            .builder()
            .name(employeeRequestDto.getName())
            .salary(employeeRequestDto.getSalary())
            .ttl(8600)
            .build();

    Employee employeeCache = employeeCacheRepository.save(employeeRequest.setKey(employeeRequestDto.getNpk()));
    EmployeeDto employeeDto = EmployeeDto
            .builder()
            .name(employeeCache.getName())
            .salary(employeeCache.getSalary())
            .npk(employeeRequestDto.getNpk())
            .build();

    return employeeDto;
  }

  public EmployeeDto getEmployee(String npk){
    Employee employeeRequest = Employee.builder().build();
    employeeRequest.setKey(npk);
    Employee employeeCache = employeeCacheRepository.findById(employeeRequest.getKey()).orElseThrow();

    EmployeeDto employeeDto = EmployeeDto
            .builder()
            .name(employeeCache.getName())
            .salary(employeeCache.getSalary())
            .npk(npk)
            .build();
    return employeeDto;
  }
}
