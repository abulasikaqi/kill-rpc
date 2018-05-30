package com.imya.prepare.proxy.dynaproxy;

import com.imya.prepare.proxy.Actor;

import java.lang.reflect.Proxy;

/**
 * Created by LL on 2018/5/30 0030.
 */
public class Test {
    public static void main(String[] args) {
        FreshMan xiaoXianRou = new FreshMan();

        Actor proxySubject = (Actor) Proxy.newProxyInstance(
                Actor.class.getClassLoader(),
                new Class[]{Actor.class},
                new ActorProxy(xiaoXianRou));

        proxySubject.act();
    }
}
