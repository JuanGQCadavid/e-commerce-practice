package com.ecommercepractice.carservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
    }

    @Bean
    public Docket athApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api-info")
                .directModelSubstitute(LocalDateTime.class, Data.class)
                .useDefaultResponseMessages(true)
                .select()
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiInfo());
    }

    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("CarService - REST API")
                .description("Endpoints used to access CarService information")
                .termsOfServiceUrl("https://en.wikipedia.org/wiki/Terms_of_service")
                .contact(new Contact("Juan Gonzalo Quiroz","https://github.com/JuanGQCadavid","jquiro12@eafit.edu.co"))
                .license("Apache License Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0")
                .build();
    }


}
