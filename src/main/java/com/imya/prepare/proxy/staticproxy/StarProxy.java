package com.imya.prepare.proxy.staticproxy;

import com.imya.prepare.proxy.Actor;

/**
 * Created by LL on 2018/5/30 0030.
 */
public class StarProxy implements Actor {

    private Actor target;

    public StarProxy(Actor target) {
        this.target = target;
    }

    @Override
    public void act() {
        System.out.println("开始事务...");

        target.act();

        System.out.println("提交事务...");
    }
}
