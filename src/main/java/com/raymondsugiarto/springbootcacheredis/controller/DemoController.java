package com.raymondsugiarto.springbootcacheredis.controller;

import com.raymondsugiarto.springbootcacheredis.dto.EmployeeDto;
import com.raymondsugiarto.springbootcacheredis.dto.EmployeeRequestDto;
import com.raymondsugiarto.springbootcacheredis.entity.cache.Employee;
import com.raymondsugiarto.springbootcacheredis.service.EmployeeService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author r.pb on 02/03/23
 */

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final EmployeeService employeeService;

    @GetMapping("/employee")
    public EmployeeDto getEmployee(@RequestHeader(name = "x-npk") String npk) {
        return employeeService.getEmployee(npk);
    }

    @PostMapping("/employee")
    public EmployeeDto createEmployee(@Validated @RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeService.createEmployee(employeeRequestDto);
    }


}
