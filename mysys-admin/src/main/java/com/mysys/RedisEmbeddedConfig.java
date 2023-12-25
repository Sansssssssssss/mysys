package com.mysys;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

@Configuration
public class RedisEmbeddedConfig {

    private final RedisServer redisServer;

    public RedisEmbeddedConfig() {
        redisServer = RedisServer.builder()
                .port(6379)
                .setting("bind 127.0.0.1")
                .setting("daemonize no")
                .setting("appendonly no")
                .setting("maxmemory 128M")
                .build();
    }

    @PostConstruct
    public void postConstruct() {
        redisServer.start();
    }

    @PreDestroy
    public void preDestroy() {
        redisServer.stop();
    }

}
