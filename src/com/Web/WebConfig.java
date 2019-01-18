package com.Web;

import com.Web.Interceptors.TestInterceptor;
import com.app.PropertiesConfig;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * springMVC配置
 *
 */
@EnableAsync//开启异步
@ComponentScan
@Configuration
@EnableWebMvc//开启webMvc的注解
public class WebConfig   implements WebMvcConfigurer {


    private  static  final  Integer MB =1024*1024;
    /**
     * 添加自定义异常处理类
     * @param resolvers
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
      //  resolvers.add(new CustomException());
    }

    /**
     * 配置视图解析器
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp();
        }

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/user/**");
    }

    /**
     * 配置bean上传文件
     * @param propertiesConfig
     * @return
     */
    @Bean
    public MultipartResolver multipartResolver(PropertiesConfig propertiesConfig){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        commonsMultipartResolver.setMaxUploadSize(propertiesConfig.getMaxFileUpload()*MB);
        return commonsMultipartResolver;
    }

    /**
     * spring静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    /**
     * 配置消息转换器
     * @param converters
     */

    @Override
    public void configureMessageConverters(List <HttpMessageConverter<?>> converters) {
        // converters.add(new CustomMessage());
    }

    /**
     *处理异步线程
     * @return
     */

    @Bean
    public TaskExecutor taskExecutor (){
        return new ConcurrentTaskExecutor(Executors.newSingleThreadExecutor());
    }

    /**
     * 方法的入参
     * @param resolvers
     */
    @Override
    public void addArgumentResolvers(List <HandlerMethodArgumentResolver> resolvers) {

    }
    /**
     * 方法的返回值
     */
    @Override
    public void addReturnValueHandlers(List <HandlerMethodReturnValueHandler> handlers) {

    }

    /**
     * 默认注册
     * @param registry
     */
/*
    @Override
    public void addFormatters(FormatterRegistry registry) {

    }
*/

    /**
     * 拦截器的思想：在关键的位置能织入我们相关的业务代码来提高我们的扩展性
     *    restTemplate.setInterceptors();设置拦截器
     * @return RestTemplate
     *预习security
     */
   @Bean
    public RestTemplate  restTemplate(){
       /* RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor>  interceptors= new ArrayList <>();
        interceptors.add(new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
                System.out.println(request.getMethod());
                return execution.execute(request,body);
            }
        });
        restTemplate.setInterceptors(interceptors);*/
        return  new RestTemplate();
    }

    /**
     * 安全配置
     * @param http
     * @throws Exception
     */
 /*   @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }*/


}
