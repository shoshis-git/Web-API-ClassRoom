package com.example.projectshoshifruchter.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * הגדרת המידע הכללי שמופיע בראש דף ה-Swagger UI.
 * נגיש בכתובת: http://localhost:8080/swagger-ui/index.html
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI classRoomOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ClassRoom API")
                        .description("API לניהול כיתות בית ספר — יצירה, עדכון, מחיקה וחיפוש")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Shoshi Fruchter")
                                .email("shoshi@example.com")));
    }
}
