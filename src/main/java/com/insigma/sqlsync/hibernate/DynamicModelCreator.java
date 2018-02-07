package com.insigma.sqlsync.hibernate;

import lombok.NonNull;
import org.hibernate.jpa.graph.internal.EntityGraphImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.metamodel.EntityType;
import java.util.List;
import java.util.Map;

public class DynamicModelCreator {

    public void create(String modelName, List<Map<String, Object>> table){


//        entityManagerFactory.addNamedEntityGraph(entityManager.get);
//        entityManagerFactory.addNamedEntityGraph("");
    }
}
