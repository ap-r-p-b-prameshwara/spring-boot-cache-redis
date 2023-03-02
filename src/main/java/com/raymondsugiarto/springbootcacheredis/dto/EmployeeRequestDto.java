package com.raymondsugiarto.springbootcacheredis.dto;

import com.raymondsugiarto.springbootcacheredis.validator.constraints.EmployeeNotExists;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author r.pb on 02/03/23
 */

@Data
@EmployeeNotExists
public class EmployeeRequestDto {
    @NotNull
    private String npk;
    @NotNull
    private String name;
    @NotNull
    private long salary;
}
