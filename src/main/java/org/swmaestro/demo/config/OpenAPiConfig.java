//package org.swmaestro.demo.config;
//
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * OpenAPi Config
// *
// * @since	2023-07-11
// * @author	ywkim
// */
//// @Profile({ "dev", "local" })
//@Configuration
//public class OpenAPiConfig {
//
//    @Bean
//    public OpenAPI openAPI(@Value("${springdoc.version})") String springdocVersion) {
//        Info info = new Info()
//            .title("SpringBoot3GradleTemplate 프로젝트")
//            .version(springdocVersion)
//            .description("RESTful API Sample");
////            .license(new License().name("Apache 2.0").url("http://springdoc.org"))
//
//        return new OpenAPI()
//                .components(new Components())
//                .info(info);
//    }
//
//}