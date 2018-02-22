package com.insigma.sqlsync;

import com.insigma.sqlsync.repository.RealTimeRepository;
import com.insigma.sqlsync.service.RealTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableAutoConfiguration
@SpringBootApplication
//@ImportResource(locations={"classpath:application-bean.xml"})
@ComponentScan(basePackages={
        "com.insigma.sqlsync.repository",
        "com.insigma.sqlsync.configuration",
        "com.insigma.sqlsync.spring",
        "com.insigma.sqlsync.service"
})
@EnableJpaRepositories(
        basePackages = {"com.insigma.sqlsync.repository"},
        entityManagerFactoryRef = "entityManagerFactory"
//        includeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION, value=RealTimeRepository.class)}
)
//@EntityScan("com.insigma.sqlsync.entity")
public class Application implements CommandLineRunner {

    @Autowired
    private RealTimeService realTimeService;

    @Override
    public void run(String... args) {
        System.out.println("dsdsd");
//        realTimeService.initRealtime();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
