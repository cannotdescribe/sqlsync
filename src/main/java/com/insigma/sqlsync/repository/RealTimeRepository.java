package com.insigma.sqlsync.repository;


import com.insigma.sqlsync.entity.realtime.RealTimeBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RealTimeRepository extends CrudRepository<RealTimeBean, Long> {

//    @Query("select tagIsid, codeValue, alarmFlag, updateTime, alarmLevel " +
//            "from #{#realTimeBean.tableName}")
    @Query("select tagIsid, codeValue, alarmFlag, updateTime, alarmLevel from RealTimeBean u")
    List<RealTimeBean> query(@Param("startDate")RealTimeBean realTimeBean);
}
