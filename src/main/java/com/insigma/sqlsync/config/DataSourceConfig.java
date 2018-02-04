package com.insigma.sqlsync.config;

import com.insigma.sqlsync.datasource.DataSourceInfoUtils;
import com.insigma.sqlsync.datasource.DynamicDataSource;
import com.insigma.sqlsync.hibernate.MyInterceptor;
import org.dom4j.Element;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class DataSourceConfig {

//    @Bean(name="dataSource")
    public DynamicDataSource getDynamicDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        List<Element> dataSourceElements = DataSourceInfoUtils.getDataSources();
        Map<Object, Object> targetDataSources = new LinkedHashMap<Object, Object>();
        for(int i=0;i<dataSourceElements.size();i++){
            Element dataSourceElement = dataSourceElements.get(i);
            String keyName = DataSourceInfoUtils.getStation(dataSourceElement);
            DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
            driverManagerDataSource.setUrl(DataSourceInfoUtils.getUrl(dataSourceElement));
            driverManagerDataSource.setDriverClassName(DataSourceInfoUtils.DRIVER_CLASS_NAME);
            driverManagerDataSource.setUsername(DataSourceInfoUtils.getUsername(dataSourceElement));
            driverManagerDataSource.setPassword(DataSourceInfoUtils.getPassword(dataSourceElement));
            targetDataSources.put(keyName, driverManagerDataSource);
            if(i==0){
                dataSource.setDefaultTargetDataSource(driverManagerDataSource, keyName);
            }
        }
        dataSource.setTargetDataSources(targetDataSources);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setEntityInterceptor(new MyInterceptor());
        return localSessionFactoryBean;
    }

}
