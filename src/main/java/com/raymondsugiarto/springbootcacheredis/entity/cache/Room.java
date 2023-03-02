package com.raymondsugiarto.springbootcacheredis.entity.cache;

import lombok.*;

/**
 * @author raymond on 26/02/23
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
  private Long id;
  private String name;
}
