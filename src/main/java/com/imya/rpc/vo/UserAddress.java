package com.imya.rpc.vo;

/**
 * Created by LL on 2018/5/30 0030.
 */
public class UserAddress {

    public UserAddress() {
    }

    public UserAddress(String name, String userAddress) {
        this.name = name;
        this.userAddress = userAddress;
    }

    private String name;

    private String userAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
