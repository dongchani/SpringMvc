package com.app;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@EnableTransactionManagement//开启事务管理
@PropertySource("classpath:Spring/application.properties")
@Configuration
@ComponentScan
@MapperScan("com.app.dao")/*完整的dao路径*/
public class Appconfig {
  /*配置数据源*/
    @Bean
    public DataSource dataSource(PropertiesConfig config){
        /*连接池*/
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(config.getUser());
        dataSource.setPassword(config.getPassword());
        dataSource.setJdbcUrl(config.getUrl());
        dataSource.setDriverClassName(config.getDriverClassName());
        return  dataSource;
    }
    /*sqlSessionFactoryBean配置的相当于mybatis核心文件的属性*/
    @Bean
    SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, PropertiesConfig config) throws  Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //配置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //设置别名
        sqlSessionFactoryBean.setTypeAliasesPackage(config.getMybatisTypeAliases());

        //设置环境
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType(config.getMybatisPlugins());
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{paginationInterceptor});


        //获取mapper.xml的路径 PathMatchingResourcePatternResolver是路径匹配   资源模式解析器
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources =resourcePatternResolver.getResources(config.getMapperlocation());

        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean;

    }
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return  new PropertySourcesPlaceholderConfigurer();

    }
/*PlatformTransactionManager相当于平台事务管理器*/
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        //数据源事务管理器
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return  dataSourceTransactionManager;
    }


/*TransactionTemplate事务模板*/
    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager){
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        //  设置要使用的事务管理策略。
        transactionTemplate.setTransactionManager(transactionManager);
        return transactionTemplate;
    }


}
