package com.insigma.sqlsync.repository.custom;


import com.insigma.sqlsync.entity.realtime.RealTimeDataBean;
import com.insigma.sqlsync.repository.util.TableNameUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RequiredArgsConstructor
public class CustomRealTimeRepositoryImpl implements CustomRealTimeRepository {
    final @NonNull
    EntityManager entityManager;

    public List<RealTimeDataBean> find(RealTimeDataBean realTimeDataBean){
        //select tagIsid, codeValue, alarmFlag, updateTime, alarmLevel
        Query query = entityManager.createQuery("from RealTimeDataBean");
        List<RealTimeDataBean> rs = query.getResultList();
        return rs;
    }

}