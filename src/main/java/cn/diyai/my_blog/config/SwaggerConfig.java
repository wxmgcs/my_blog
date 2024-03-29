package cn.diyai.my_blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
//                .globalResponseMessage(RequestMethod.GET, newArrayList(
//                        new ResponseMessageBuilder()
//                                .code(500)
//                                .message("服务器发生异常")
//                                .responseModel(new ModelRef("Error"))
//                                .build(),
//                        new ResponseMessageBuilder()
//                                .code(403)
//                                .message("资源不可用")
//                                .build()
//                ));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "博客接口文档",
                "",
                "API V1.0",
                "Terms of service",
                new Contact("Patrick", "", "wxmgcs@gmail.com"),
                "Apache", "http://www.apache.org/", Collections.emptyList());
    }

}