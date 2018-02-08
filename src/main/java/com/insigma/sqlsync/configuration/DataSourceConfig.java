package com.insigma.sqlsync.configuration;

import com.insigma.sqlsync.config.DataSourceInfoUtils;
import com.insigma.sqlsync.datasource.DynamicDataSource;
import org.dom4j.Element;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Order(1)
@Configuration
public class DataSourceConfig {

    @Bean(name="dataSource")
    public DynamicDataSource getDynamicDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        List<Element> dataSourceElements = DataSourceInfoUtils.getDataSources();
        Map<Object, Object> targetDataSources = new LinkedHashMap<Object, Object>();
        for(int i=0;i<dataSourceElements.size();i++){
            Element dataSourceElement = dataSourceElements.get(i);
            String keyName = DataSourceInfoUtils.getKey(dataSourceElement);
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

    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setPackagesToScan(
                "com.insigma.sqlsync.entity",
                "com.insigma.sqlsync.entity.realtime"
        );
        try {
            localContainerEntityManagerFactoryBean.setJpaProperties(PropertiesLoaderUtils.loadProperties(new ClassPathResource("jpa.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return localContainerEntityManagerFactoryBean;
    }
}
