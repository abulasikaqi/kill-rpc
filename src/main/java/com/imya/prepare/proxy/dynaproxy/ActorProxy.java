package com.imya.prepare.proxy.dynaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by LL on 2018/5/30 0030.
 */
public class ActorProxy implements InvocationHandler {

    private Object actor;

    public ActorProxy(Object actor) {
        this.actor = actor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("替演员谈剧本和报酬");
        Object result = method.invoke(actor, args);
        System.out.println("替演员收报酬");
        System.out.println("收取一点佣金");
        return result;
    }
}
