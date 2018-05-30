package com.imya.prepare.proxy.staticproxy;

/**
 * Created by LL on 2018/5/30 0030.
 */
public class Test {

    public static void main(String[] args) {
        BigStar bigStar = new BigStar();

        StarProxy starProxy = new StarProxy(bigStar);

        starProxy.act();
    }
}
