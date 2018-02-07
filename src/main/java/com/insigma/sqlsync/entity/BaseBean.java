package com.insigma.sqlsync.entity;

public class BaseBean {
    private Pager pager = new Pager();

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}
