package com.imya.server.service.impl;

import com.imya.rpc.service.SendMail;
import com.imya.rpc.vo.UserAddress;

/**
 * Created by LL on 2018/5/30 0030.
 */
public class SendMailImpl implements SendMail {
    @Override
    public boolean sendMail(UserAddress userAddress) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("已发达邮件给：" + userAddress.getName() + "到：[" + userAddress.getUserAddress() + "]");

        return true;
    }
}
