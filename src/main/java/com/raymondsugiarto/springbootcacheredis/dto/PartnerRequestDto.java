package com.raymondsugiarto.springbootcacheredis.dto;

import com.raymondsugiarto.springbootcacheredis.validator.constraints.PartnerNotExists;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author r.pb on 02/03/23
 */

@Data
@PartnerNotExists
public class PartnerRequestDto {
    @NotNull
    private String code;
    @NotNull
    private String name;
    @NotNull
    private long cost;
}
