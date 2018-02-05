package com.insigma.sqlsync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class RealTimeService {
    @Autowired
    private EntityManager em;
}
