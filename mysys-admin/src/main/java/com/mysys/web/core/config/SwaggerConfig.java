package com.mysys.web.core.config;

import com.mysys.common.config.AppConfig;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Swagger的接口配置
 */
@Configuration
public class SwaggerConfig {

    /**
     * 系统基础配置
     */
    @Autowired
    private AppConfig mysysConfig;

    @Bean
    public OpenAPI openAPI() {
        // 作者信息
        Contact contact = new Contact();
        contact.setName(mysysConfig.getName());

        // 安全模式信息
        SecurityScheme jwt = new SecurityScheme()
                .scheme("bearer")
                .type(SecurityScheme.Type.HTTP)
                .in(SecurityScheme.In.HEADER)
                .bearerFormat("JWT");

        // 接口文档信息
        Info info = new Info().title("标题：管理系统_接口文档")
                .description("描述：...")
                .version("v1.0.0")
                .contact(contact);

        return new OpenAPI()
                .info(info)
                .components(new Components().addSecuritySchemes("Authorization", jwt))
                .security(List.of(new SecurityRequirement().addList("Authorization")))
                ;
    }

}
