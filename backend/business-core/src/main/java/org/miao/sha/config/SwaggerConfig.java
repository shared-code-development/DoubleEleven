package org.miao.sha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * swagger相关配置
 * @author heshiyuan
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("localhost")
                .apiInfo(apiInfo())
                // 禁用掉默认的返回code，以系统自定义为主
                .useDefaultResponseMessages(false)
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("org.miao.sha.controller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .enable(true);
    }

    /**
     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("双11秒杀 RESTful API")
                //版本号
                .version("1.0")
                //描述
                .description("秒杀相关接口")
                .build();
    }
}
