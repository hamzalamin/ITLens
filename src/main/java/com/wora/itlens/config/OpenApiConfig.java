package com.wora.itlens.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI defineApi(){
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development server");

        Contact contact = new Contact();
        contact.setName("Hamza LAMIN");
        contact.setEmail("hamzalamin80@gmail.com");
        contact.setUrl("https://www.linkedin.com/in/hamza-lamin-a0440a296/");

        Info info = new Info()
                .title("API REST Survey IT")
                .version("1.0")
                .description("ITLens est une application qui permet de réaliser des surveys dans le domaine de l’IT. Le projet\n" +
                        "repose sur la création et la gestion d’un survey structuré en chapitres et sous-chapitres\n" +
                        "contenant diverses questions. L’application sera développée en Spring Boot avec une\n" +
                        "architecture RESTful.\n")
                .contact(contact);
        return new OpenAPI().info(info).servers(List.of(server));
    }

}
