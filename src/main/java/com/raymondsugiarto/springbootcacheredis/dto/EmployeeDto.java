package com.raymondsugiarto.springbootcacheredis.dto;

import lombok.*;

/**
 * @author r.pb on 02/03/23
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private String npk;
    private String name;
    private long salary;
}
