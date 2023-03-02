package com.raymondsugiarto.springbootcacheredis.service;

import com.raymondsugiarto.springbootcacheredis.entity.cache.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author raymond on 26/02/23
 */
@Service
@RequiredArgsConstructor
public class RoomService {

  private final RedisLockRegistry redisLockRegistry;

  @Cacheable(value = "room", key = "#id")
  public Room getRoom(Long id) {
    return Room.builder().id(1L).name("Java").build();
  }

  public String startTransaction() {
    Lock lock = redisLockRegistry.obtain("my-lock");
    try {
      if (lock.tryLock(10, TimeUnit.SECONDS)) {
        // Do something with the lock
        throw new InterruptedException("test");
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    } finally {
      lock.unlock();
    }

    return "success";
  }
}
