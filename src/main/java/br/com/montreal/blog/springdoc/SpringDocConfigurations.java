package br.com.montreal.blog.springdoc;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("BlogPessoal API")
                        .description("API Rest da aplicação BlogPessoal, contendo as funcionalidades de CRUD de usuários, temas e postagens, além de gerenciamento e autenticação através de token JWT")
                        .contact(new Contact()
                                .name("Montreal Team")
                                .email("teambackend@montreal.com"))
                        .license(new License()
                                .name("MIT")
                                .url("http://localhost/api/licence")));
    }
}
