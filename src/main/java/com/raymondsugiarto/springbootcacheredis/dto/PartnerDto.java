package com.raymondsugiarto.springbootcacheredis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author r.pb on 02/03/23
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartnerDto {
    private String code;
    private String name;
    private long cost;
}
