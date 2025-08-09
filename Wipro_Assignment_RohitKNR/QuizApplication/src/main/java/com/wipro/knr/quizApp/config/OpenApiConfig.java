package com.wipro.knr.quizApp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        contact = @Contact(
            name = "KNR-Wipro",
            email = "contact@knr-wipro.com",
            url = "https://www.wipro.com"
        ),
        description = "OpenAPI documentation for the Quiz Application API. This API allows users to create, take, and manage quizzes.",
        title = "Quiz Application API",
        version = "1.0",
        license = @License(
            name = "License Name",
            url = "https://some-url.com"
        ),
        termsOfService = "Terms of service"
    ),
    servers = {
        @Server(
            description = "Local ENV",
            url = "http://localhost:8080"
        ),
        @Server(
            description = "PROD ENV",
            url = "https://prod.knr-wipro.com"
        )
    }
)
public class OpenApiConfig {
}