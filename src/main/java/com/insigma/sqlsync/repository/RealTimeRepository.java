package com.insigma.sqlsync.repository;


import com.insigma.sqlsync.entity.realtime.RealTimeBean;
import org.springframework.data.repository.CrudRepository;

public interface RealTimeRepository extends CrudRepository<RealTimeBean, Long> {

}
