package com.imya;

import com.imya.rpc.service.DepotService;
import com.imya.rpc.service.SendMail;
import com.imya.rpc.vo.UserAddress;
import com.imya.server.service.impl.DepotServiceImpl;
import com.imya.server.service.impl.SendMailImpl;

/**
 * Created by LL on 2018/5/31 0031.
 */
public class Normal {
    public static void main(String[] args) {
        DepotService depotService = new DepotServiceImpl();
        depotService.inDepot("001", 1000);
        depotService.outDepot("002", 50);


        SendMail sendMail = new SendMailImpl();

        UserAddress userAddress = new UserAddress("Tony", "Tony@163.com");

        System.out.println("Send mail : " + sendMail.sendMail(userAddress));

    }
}
