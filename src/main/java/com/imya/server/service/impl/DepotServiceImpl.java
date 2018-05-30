package com.imya.server.service.impl;

import com.imya.rpc.service.DepotService;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by LL on 2018/5/30 0030.
 */
public class DepotServiceImpl implements DepotService {

    private static ConcurrentHashMap<String, Integer> goodsData = new ConcurrentHashMap<>();

    // 初始化
    static {
        goodsData.put("001", 1000);
        goodsData.put("002", 2000);
        goodsData.put("003", 3000);
        goodsData.put("004", 4000);
    }

    @Override
    public synchronized void inDepot(String orderId, int amount) {
        System.out.println("++++++++++++++++++增加商品：" + orderId + "库存，数量为：" + amount);
        int count = goodsData.get(orderId) + amount;
        goodsData.put(orderId, count);
        System.out.println("++++++++++++++++++商品：" + orderId + "库存，数量变为：" + count);
    }

    @Override
    public void outDepot(String orderId, int amount) {
        System.out.println("------------------减少商品：" + orderId + "库存，数量为：" + amount);
        int count = goodsData.get(orderId) - amount;
        goodsData.put(orderId, count);
        System.out.println("------------------商品：" + orderId + "库存，数量变为：" + count);
    }
}
