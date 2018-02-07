package com.insigma.sqlsync;

import com.insigma.sqlsync.entity.realtime.RealTimeDataBean;
import com.insigma.sqlsync.repository.RealTimeRepository;
import com.insigma.sqlsync.repository.custom.CustomRealTimeRepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class JpaTest {
//    CrudRepository
    @Autowired
    RealTimeRepository userRepository;

    EntityManager em;

    @Autowired
    EntityManagerFactory factory;

    /**
     * Sets up a {@link SimpleJpaRepository} instance.
     */
    @Before
    public void setUp() {

//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa.sample.plain");
        em = factory.createEntityManager();
//        userRepository = new SimpleJpaRepository<RealTimeBean, Long>(RealTimeBean.class, em);
        EntityTransaction ey = em.getTransaction();
        System.out.println(ey);
        em.getTransaction().begin();
    }

    @After
    public void tearDown() {
//        em.getTransaction().rollback();
        System.out.println("commmmmmmmit");
        em.getTransaction().commit();
    }

    @Test
    public void savingUsers() {
        RealTimeDataBean r = new RealTimeDataBean();
//        r.setId(1l);
        r.setTagIsid("dsadsadadsada");
        userRepository.save(r);
//        entityTransaction.commit();
//        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//        def.setTimeout(30);
////事务状态
//        TransactionStatus status = tm.getTransaction(def);
//        tm.commit(status);
    }

    @Test
    public void query() {
        RealTimeDataBean r = new RealTimeDataBean();
//        List<RealTimeBean> realTimeBeans = userRepository.query(r);
//        System.out.println(realTimeBeans.size());
    }
}
