package com.insigma.sqlsync.repository.custom;


import com.insigma.sqlsync.entity.realtime.RealTimeDataBean;
import com.insigma.sqlsync.repository.util.TableNameUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RequiredArgsConstructor
public class CustomRealTimeRepositoryImpl implements CustomRealTimeRepository {
    final @NonNull
    EntityManager entityManager;

    @Override
    public List<RealTimeDataBean> dynamicQuery(RealTimeDataBean realTimeBean) {
        Query query = entityManager.createNativeQuery("select tagIsid, codeValue, alarmFlag, updateTime, alarmLevel from "+ TableNameUtils.getTable(realTimeBean));
        return query.getResultList();
    }

    public List<RealTimeDataBean> dynamicQuery(String dvTypeCode){
        Query query = entityManager.createNativeQuery("select tagIsid, codeValue, alarmFlag, updateTime, alarmLevel from "+ TableNameUtils.getTable(dvTypeCode));
        return query.getResultList();
    }

}