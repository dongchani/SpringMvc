package com.Web.WebSecurity;

import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationFailureHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //构建一个用户名为admin 密码123 角色admin  withDefaultPasswordEncoder：使用默认密码的编码器

        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("123").authorities("ADMIN").build();
        UserDetails tomcat = User.withDefaultPasswordEncoder().username("tomcat").password("123").authorities("TOMCAT").build();
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("123").authorities("USER").build();
        //在内容当中保存一个用户
        auth.inMemoryAuthentication().withUser(admin);
        auth.inMemoryAuthentication().withUser(tomcat);
        auth.inMemoryAuthentication().withUser(user);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    /**
     * http安全性
     * authorizeRequests：授权请求
     * antMatchers：设置路径的匹配
     * usr:请求路径中带有usr的都需要登录
     * authenticated：需要授权认证（登录才能访问）
     * anyRequest：任意的请求
     * permitAll：允许执行
     * formLogin:匿名进行登录
     * .loginPage("/test"):get请求跳转页面  post是验证信息
     * and().formLogin().permitAll();(加上formLogin就不会出现403的拒绝访问)
     *successForwardUrl:登录成功后跳转的地址
     *
     * http.csrf().disable()：加上之后不安全
     *安全的在表单里加上隐藏表单域：在关键位置添加：  <input type="hidden" name="_csrf" value="${_csrf.token}">
     *     作用：1.防止表单进行重复提交
     *           2.防止跨域请求伪造
     * 查：请求伪造
     * failureHandler()：自定义失败处理实现 AuthenticationFailureHandler接口
     *  if (exception instanceof BadCredentialsException){
     *http.cros()...跨域
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
  /*    http.authorizeRequests().antMatchers("/usr/**").authenticated()
              .and().authorizeRequests().anyRequest().permitAll()
              .and().formLogin().permitAll()
              .and().authorizeRequests().antMatchers("/Toindex1").permitAll();*/
      http.authorizeRequests().anyRequest().authenticated()
                .and().authorizeRequests().antMatchers("/static/**").permitAll()
                .and().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
                .and().formLogin().loginPage("/login").successForwardUrl("/Toindex1").usernameParameter("userName").passwordParameter("userPassword").failureHandler(new ForwardAuthenticationFailureHandler("/errorlogin"){
          @Override
          public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
              if (exception instanceof BadCredentialsException){
                  request.setAttribute("errorMsg","用户名或密码错误");
                  }else if (exception instanceof UsernameNotFoundException){
                  request.setAttribute("errorMsg","用户不存在");
              }else  if (exception instanceof AccountStatusException){
                   request.setAttribute("errorMsg","用户被锁定");
              }
              super.onAuthenticationFailure(request, response, exception);
          }
      }).successHandler(new ForwardAuthenticationSuccessHandler("/Toindex1") {
          @Override
          public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
            httpServletRequest.setAttribute("success","成功的页面");
            super.onAuthenticationSuccess(httpServletRequest,httpServletResponse,authentication);
          }
      }).permitAll();
    }
     /*   http.authorizeRequests().antMatchers("Toindex1","/static/**").permitAll().antMatchers("/admin/**").access("hasRole('ADMIN')").anyRequest().authenticated().and().formLogin().permitAll();
*/
    }


