package com.zrx.cofig;

//代码配置。不用xml
//配置类

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

@Configuration//指明这是配置类
@ComponentScan(basePackages = {"com.zrx"})//扫描
public class SpringConfig {
    @Bean("runner")//bean注解
    @Scope("prototype")
    public QueryRunner createRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource createDataRunner(){
        final ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setPassword("123456");
        dataSource.setUser("root");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/springb?serverTimezone=Asia/Shanghai&characterEncoding=utf8");
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
        }catch (Exception e){
            throw new Error(e.getMessage());
        }

        return dataSource;
    }
}
