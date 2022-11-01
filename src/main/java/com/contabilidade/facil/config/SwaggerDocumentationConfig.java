package com.contabilidade.facil.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {

        return new OpenAPI()
                .info(new Info().title("Contabilidade Fácil")
                        .description("IFCE - Trabalho da disciplina Projeto de Sistemas da Informação.\n\n" +
                                "Professor:\n" +
                                "- Carlos Hairon Ribeiro Goncalves\n\n" +
                                "Alunos:\n" +
                                "- Luis Carlos\n" +
                                "- Raphael Otaviano\n" +
                                "- Luiz Henrique")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
