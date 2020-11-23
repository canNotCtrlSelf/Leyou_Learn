package com.cncs.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
//@EnableConfigurationProperties(JdbcProperties.class)
//@PropertySource("classpath:jdbcConfig.properties")
public class JdbcConfig {

    //@Value("${jdbc.driver}")
    //private String driverClassName;
    //@Value("${jdbc.url}")
    //private String url;
    //@Value("${jdbc.username}")
    //private String username;
    //@Value("${jdbc.password}")
    //private String password;

    //@Autowired
    //private JdbcProperties prop;
    //
    //public JdbcConfig(JdbcProperties prop) {
    //    this.prop=prop;
    //}



/*    @Bean
    public DataSource createDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }*/

/*    @Bean
    public DataSource createDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(prop.driverClassName);
        dataSource.setUrl(prop.url);
        dataSource.setUsername(prop.username);
        dataSource.setPassword(prop.password);
        return dataSource;
    }*/

    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource(){
        return new DruidDataSource();
    }
}
