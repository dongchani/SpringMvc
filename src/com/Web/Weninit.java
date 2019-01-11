package com.Web;

import com.Web.WebSecurity.WebSecurityConfig;
import com.app.Appconfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 前端控制器
 */
public class Weninit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     *
     * @return
     */
    @Override
    protected Class <?>[] getRootConfigClasses() { return new Class[]{Appconfig.class,WebSecurityConfig.class};
    }

    /**
     * 配置webconfig
     * @return
     */
    @Override
    protected Class <?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * 配置servlet映射
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
