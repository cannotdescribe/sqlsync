package com.insigma.sqlsync;

import com.insigma.sqlsync.entity.realtime.RealTimeBean;
import com.insigma.sqlsync.repository.RealTimeRepository;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.DefaultNamingStrategy;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@EnableAutoConfiguration
@SpringBootApplication

@ImportResource(locations={"classpath:application-bean.xml"})
@ComponentScan(basePackages={
        "com.insigma.sqlsync.repository",
        "com.insigma.sqlsync.config",
        "com.insigma.sqlsync.spring"
})
//@EntityScan("com.insigma.sqlsync.entity")
//@EnableJpaRepositories(basePackages={"com.insigma.sqlsync.repository"})
public class Application implements CommandLineRunner {

    @Autowired
    private RealTimeRepository realTimeRepository;

    @Override
    public void run(String... args) {
        RealTimeBean r = new RealTimeBean();
        r.setTableName("tbrealtimedata");
//        realTimeRepository.save(r);
//        DefaultNamingStrategy
        List<RealTimeBean> realTimeBeans = realTimeRepository.query(r);
        System.out.println(realTimeBeans.size());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
