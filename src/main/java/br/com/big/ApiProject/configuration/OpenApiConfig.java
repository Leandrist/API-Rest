package br.com.big.ApiProject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {
	
		@Bean
		public OpenAPI customOpenApi() {
			return new OpenAPI()
					.components(
							new Components().addSecuritySchemes("basicScheme",
									new SecurityScheme().type(SecurityScheme.Type.HTTP)
										.scheme("basic")
									)
							)
					.info(
							new Info()
								.title("Cadastro de Pessoas e Contatos")
								.description("Este App foi criado para treinar nossos conhecimentos com Java!")
								.contact(new Contact()
											.name("Leandro Fabrício")
											.email("goesleandro15@gmail.com")
											.url("http://localhost:8585")
										)
								.version("Versão 0.0.1-SNAPSHOT")
							);	
		}
	
}
