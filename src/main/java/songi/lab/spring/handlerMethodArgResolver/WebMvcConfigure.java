package songi.lab.spring.handlerMethodArgResolver;

import org.springframework.context.annotation.Bean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

public class WebMvcConfigure implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(fooBarHandlerMethodArgumentResolver());
    }

    @Bean
    public FooBarHandlerMethodArgumentResolver fooBarHandlerMethodArgumentResolver() {
        return new FooBarHandlerMethodArgumentResolver();
    }
}
