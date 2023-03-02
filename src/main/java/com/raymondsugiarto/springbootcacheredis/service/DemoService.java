package com.raymondsugiarto.springbootcacheredis.service;

import com.raymondsugiarto.springbootcacheredis.dto.EmployeeDto;
import com.raymondsugiarto.springbootcacheredis.dto.EmployeeRequestDto;
import com.raymondsugiarto.springbootcacheredis.dto.PartnerDto;
import com.raymondsugiarto.springbootcacheredis.dto.PartnerRequestDto;
import com.raymondsugiarto.springbootcacheredis.entity.cache.Employee;
import com.raymondsugiarto.springbootcacheredis.entity.cache.Partner;
import com.raymondsugiarto.springbootcacheredis.repository.cache.EmployeeCacheRepository;
import com.raymondsugiarto.springbootcacheredis.repository.cache.PartnerCacheRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author raymond on 26/02/23
 */
@Service
@RequiredArgsConstructor
public class DemoService {
  private final EmployeeCacheRepository employeeCacheRepository;
  private final PartnerCacheRepository partnerCacheRepository;

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

  public EmployeeDto getEmployee(String npk) throws NotFoundException {
    Employee employeeRequest = Employee.builder().build();
    employeeRequest.setKey(npk);
    Employee employeeCache = employeeCacheRepository.findById(employeeRequest.getKey()).orElseThrow(()-> new NotFoundException(""));

    EmployeeDto employeeDto = EmployeeDto
            .builder()
            .name(employeeCache.getName())
            .salary(employeeCache.getSalary())
            .npk(npk)
            .build();
    return employeeDto;
  }

  public List<Employee> getEmployees() throws NotFoundException {
    var employees = employeeCacheRepository.findAll();

    if(Objects.isNull(employees)){
      throw new NotFoundException("");
    }
    return employees;
  }

  public PartnerDto createPartner(PartnerRequestDto partnerRequestDto){
    Partner partnerRequest = Partner
            .builder()
            .name(partnerRequestDto.getName())
            .cost(partnerRequestDto.getCost())
            .ttl(4300)
            .build();

    Partner partnerCache = partnerCacheRepository.save(partnerRequest.setKey(partnerRequestDto.getCode()));
    PartnerDto partnerDto = PartnerDto
            .builder()
            .name(partnerCache.getName())
            .cost(partnerCache.getCost())
            .code(partnerRequestDto.getCode())
            .build();

    return partnerDto;
  }

  public PartnerDto getPartner(String code) throws NotFoundException {
    Partner partnerRequest = Partner.builder().build();
    partnerRequest.setKey(code);
    Partner partnerCache = partnerCacheRepository.findById(partnerRequest.getKey()).orElseThrow(()-> new NotFoundException(""));

    PartnerDto partnerDto = PartnerDto
            .builder()
            .name(partnerCache.getName())
            .cost(partnerCache.getCost())
            .code(code)
            .build();
    return partnerDto;
  }
}
