package com.insigma.sqlsync.repository;

import com.insigma.sqlsync.entity.realtime.RealTimeDataBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
@ComponentScan(basePackages={
        "com.insigma.sqlsync"
})
public class RepositorTest {
    @Autowired
    private RealTimeRepository realTimeRepository;
    @Test
    public void save(){
//        realTimeRepository.save(new RealTimeDataBean());
    }
}
