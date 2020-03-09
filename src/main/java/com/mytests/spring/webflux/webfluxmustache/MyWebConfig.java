package com.mytests.spring.webflux.webfluxmustache;

import com.samskivert.mustache.Mustache;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.mustache.MustacheResourceTemplateLoader;
import org.springframework.boot.web.reactive.result.view.MustacheViewResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.ViewResolverRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

/**
 * *******************************
 * Created by irina on 3/9/2020.
 * Project: webflux-freemarker-2
 * *******************************
 */
@Configuration
@EnableWebFlux
public class MyWebConfig implements ApplicationContextAware, WebFluxConfigurer {
    ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Bean
    public ViewResolver mustacheViewResolver1() {
        String prefix = "classpath:/alt_templates/";
        String suffix = ".hbs";
        Mustache.TemplateLoader mLoader = new MustacheResourceTemplateLoader(prefix, suffix);
        MustacheViewResolver resolver = new MustacheViewResolver(Mustache.compiler().withLoader(mLoader));

        resolver.setPrefix(prefix);
        resolver.setSuffix(suffix);
        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(mustacheViewResolver1());
    }
}
