package com.WebFluxReactive;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.ViewResolverRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.thymeleaf.spring5.SpringWebFluxTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.reactive.ThymeleafReactiveViewResolver;

@Configuration
@EnableWebFlux
@ComponentScan
public class WebFluxConfig implements WebFluxConfigurer, ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    private ApplicationContext applicationContext;
    @Bean
     public SpringResourceTemplateResolver springResourceTemplateResolver(){
     SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
     templateResolver.setApplicationContext(applicationContext);
     //设置字符集
     templateResolver.setCharacterEncoding("UTF-8");
     //设置前缀
     templateResolver.setPrefix("classpath:/templates/");
     //设置后缀
     templateResolver.setSuffix(".html");
     //设置缓存
     templateResolver.setCacheable(false);
     return  templateResolver;
     }

    /**
     * webFlux的模板殷勤
     * @return
     */
     @Bean
    public SpringWebFluxTemplateEngine springWebFluxTemplateEngine(){
            SpringWebFluxTemplateEngine springWebFluxTemplateEngine = new SpringWebFluxTemplateEngine();
         springWebFluxTemplateEngine.setTemplateResolver(springResourceTemplateResolver());
         return  springWebFluxTemplateEngine;
     }
     @Bean
    public ThymeleafReactiveViewResolver thymeleafReactiveViewResolver(){
        ThymeleafReactiveViewResolver thymeleafReactiveViewResolver = new ThymeleafReactiveViewResolver();
        thymeleafReactiveViewResolver.setTemplateEngine(springWebFluxTemplateEngine());
        return  thymeleafReactiveViewResolver;
     }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
         registry.viewResolver(thymeleafReactiveViewResolver());
    }
}
