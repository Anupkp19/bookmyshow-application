package com.example.bookMyShowApplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CacheServiceImpl implements CacheService{

    private final RedisTemplate<String, Object> redisTemplate;
    private final RedisConnectionFactory redisConnectionFactory;
    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key,value,10, TimeUnit.MINUTES);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void delete(String key) {
        redisTemplate.opsForValue().getAndDelete(key);
    }

    @Override
    public void getAllKeysAndValues() {
        Set<String> keys = redisTemplate.keys("*");
        if(keys==null || keys.isEmpty()){
            return;
        }
        keys.forEach(t-> System.out.println(redisTemplate.opsForValue().get(t)));

    }

    @Override
    public void deleteAll() {
        Set<String> keys = redisTemplate.keys("*");
        if(keys==null || keys.isEmpty()){
            return;
        }
keys.forEach(t-> redisTemplate.opsForValue().getAndDelete(t));
    }
}
