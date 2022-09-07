package com.nb.cjz.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author 34082
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired(required = false)
    private RedisTemplate redisTemplate;

    @GetMapping("/val")
    public void redisValue() {
        redisTemplate.opsForValue().set("key", "cjz", 10, TimeUnit.SECONDS);
        String key1 = (String) redisTemplate.opsForValue().get("key1");
    }

    @GetMapping("/set")
    public void redisSet() {
        redisTemplate.opsForSet().add("key", "v1", "v2", "v3");
        redisTemplate.expire("key", 10, TimeUnit.SECONDS);
    }

    @GetMapping("/list")
    public void redisList() {
        redisTemplate.opsForList().leftPush("key", "123456");
        redisTemplate.expire("key", 10, TimeUnit.SECONDS);
    }

    @GetMapping("/hash")
    public void redisHash() {
        ArrayList<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");
        redisTemplate.opsForHash().put("HashKey", "k","本少爷真帅");
        redisTemplate.expire("HashKey", 10, TimeUnit.SECONDS);
    }
}
