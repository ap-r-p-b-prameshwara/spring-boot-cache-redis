package com.raymondsugiarto.springbootcacheredis.controller;

import com.raymondsugiarto.springbootcacheredis.dto.EmployeeDto;
import com.raymondsugiarto.springbootcacheredis.dto.EmployeeRequestDto;
import com.raymondsugiarto.springbootcacheredis.dto.PartnerDto;
import com.raymondsugiarto.springbootcacheredis.dto.PartnerRequestDto;
import com.raymondsugiarto.springbootcacheredis.entity.cache.Employee;
import com.raymondsugiarto.springbootcacheredis.service.DemoService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author r.pb on 02/03/23
 */

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/employee")
    public EmployeeDto getEmployee(@RequestHeader(name = "x-npk") String npk) throws ChangeSetPersister.NotFoundException, NotFoundException {
        return demoService.getEmployee(npk);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() throws NotFoundException {
        return demoService.getEmployees();
    }

    @PostMapping("/employee")
    public EmployeeDto createEmployee(@Validated @RequestBody EmployeeRequestDto employeeRequestDto) {
        return demoService.createEmployee(employeeRequestDto);
    }

    @GetMapping("/partner")
    public PartnerDto getPartner(@RequestHeader(name = "x-code") String code) throws ChangeSetPersister.NotFoundException, NotFoundException {
        return demoService.getPartner(code);
    }

    @PostMapping("/partner")
    public PartnerDto createPartner(@Validated @RequestBody PartnerRequestDto partnerRequestDto) {
        return demoService.createPartner(partnerRequestDto);
    }


}
