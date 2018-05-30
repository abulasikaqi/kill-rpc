package com.imya.rpc.service;

import com.imya.rpc.vo.UserAddress;

/**
 * Created by LL on 2018/5/30 0030.
 */
public interface SendMail {
    boolean sendMail(UserAddress userAddress);
}
