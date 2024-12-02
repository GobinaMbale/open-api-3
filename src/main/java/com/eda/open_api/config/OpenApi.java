package com.eda.open_api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApi {

    /**
     * Bearer constant
     */
    private static final String OAUTH2_SCHEME = "oauth2";
    private static final String HTTP_SCHEME = "http";

    private final PropertiesConfig config;

    public OpenApi(PropertiesConfig config) {
        this.config = config;
    }

    /**
     * Create a swagger group api
     *
     * @Return GroupedOpenApi
     */
    @Bean
    public GroupedOpenApi templateApi() {
        return GroupedOpenApi.builder().group("Api_Template").pathsToMatch("/**").build();
    }

    /**
     * api info
     *
     * @Return OpenAPI
     */
    @Bean
    OpenAPI apiInfo() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement()
                        .addList(HTTP_SCHEME)
                        .addList(OAUTH2_SCHEME)
                )
                .addServersItem(new Server().url(config.getServerUrl()))
                .components(new Components()
                        .addSecuritySchemes(HTTP_SCHEME, createHttpScheme())
                        .addSecuritySchemes(OAUTH2_SCHEME, createOauth2Scheme())
                )
                .info(new Info()
                        .title(config.getTitle())
                        .description(config.getDescription())
                        .version(config.getAppVersion())
                        .contact(new Contact()
                                .name(config.getContactName())
                                .email(config.getContactEmail())
                                .url(config.getContactUrl())
                        )
                );
    }

    /**
     * @Return SecurityScheme Oauth2
     */
    private SecurityScheme createOauth2Scheme() {
        SecurityScheme securityScheme = new SecurityScheme()
                .name(OAUTH2_SCHEME)
                .type(SecurityScheme.Type.OAUTH2)
                .scheme("bearer")
                .in(SecurityScheme.In.HEADER)
                .bearerFormat("JWT");
        OAuthFlow flow = new OAuthFlow()
                .tokenUrl(config.getOauthTokenUrl());
        securityScheme.setFlows(new OAuthFlows().authorizationCode(flow));
        return securityScheme;
    }

    /**
     * @Return SecurityScheme HTTP
     */
    private SecurityScheme createHttpScheme() {
        return new SecurityScheme()
                .name(HTTP_SCHEME)
                .type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
}
