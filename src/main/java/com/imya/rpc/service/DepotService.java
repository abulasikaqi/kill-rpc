package com.imya.rpc.service;

/**
 * Created by LL on 2018/5/30 0030.
 */
public interface DepotService {
    void inDepot(String orderId, int amount);
    void outDepot(String orderId, int amount);
}
