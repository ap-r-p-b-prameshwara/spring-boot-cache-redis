package com.raymondsugiarto.springbootcacheredis.entity.cache;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

/**
 * @author r.pb on 02/03/23
 */

@RedisHash("employee")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private String key;

    private String name;
    
    private long salary;

    @TimeToLive
    private int ttl;
    
    private static final String PREFIX = "data";
    
    public Employee setKey(String npk){
        this.key = PREFIX + ":" + npk;
        return this;
    }
}
