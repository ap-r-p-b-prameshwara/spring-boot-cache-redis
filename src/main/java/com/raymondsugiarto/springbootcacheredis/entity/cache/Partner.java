package com.raymondsugiarto.springbootcacheredis.entity.cache;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

/**
 * @author r.pb on 02/03/23
 */

@RedisHash("partner")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Partner {

    @Id
    private String key;

    private String name;
    
    private long cost;

    @TimeToLive
    private int ttl;
    
    private static final String PREFIX = "data";
    
    public Partner setKey(String code){
        this.key = PREFIX + ":" + code;
        return this;
    }
}
