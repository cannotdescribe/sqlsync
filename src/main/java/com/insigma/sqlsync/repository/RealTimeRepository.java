package com.insigma.sqlsync.repository;

import com.insigma.sqlsync.entity.realtime.RealTimeDataBean;
import com.insigma.sqlsync.repository.custom.CustomRealTimeRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RealTimeRepository extends CrudRepository<RealTimeDataBean, Long>, CustomRealTimeRepository {

//    List<RealTimeDataBean> save(RealTimeDataBean realTimeDataBean, Class<? extends RealTimeDataBean> clazz);
//
//    List<RealTimeDataBean> find(Class<? extends RealTimeDataBean> clazz);
}
