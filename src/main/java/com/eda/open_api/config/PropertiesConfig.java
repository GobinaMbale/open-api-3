package com.eda.open_api.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class PropertiesConfig {

    /**
     * app version
     */
    @Value("${info.app.version:unknown}")
    private String appVersion;

    /**
     * app title
     */
    @Value("${info.app.title:unknown}")
    private String title;

    /**
     * app description
     */
    @Value("${info.app.description:unknown}")
    private String description;

    /**
     * app contact name
     */
    @Value("${info.app.contact.name:unknown}")
    private String contactName;

    /**
     * app contact email
     */
    @Value("${info.app.contact.email:unknown}")
    private String contactEmail;

    /**
     * app contact url
     */
    @Value("${info.app.contact.url:unknown}")
    private String contactUrl;

    /**
     * app server url
     */
    @Value("${info.app.server.url:unknown}")
    private String serverUrl;

    /**
     *  oauth url
     */
    @Value("${springdoc.oauth.auth-url}")
    private String oauthAuthUrl;

    /**
     * oauth token url
     */
    @Value("${springdoc.oauth.token-url}")
    private String oauthTokenUrl;

    /**
     * frontend base url
     */
    @Value("${frontend.base-url}")
    private String frontendBaseUrl;

}
