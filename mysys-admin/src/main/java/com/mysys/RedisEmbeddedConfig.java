package com.mysys;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import redis.embedded.RedisServer;

/**
 * 嵌入式Redis; 用于本地测试，不建议生产使用
 */
@Component
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
