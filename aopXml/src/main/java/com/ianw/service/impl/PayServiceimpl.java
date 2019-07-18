package com.ianw.service.impl;

import com.ianw.service.PayService;
import org.springframework.stereotype.Service;

@Service
public class PayServiceimpl implements PayService {

    public boolean pay(int money) {
       //Integer.parseInt("sssssssss");
        System.out.println("支付"+money);
        return true;
    }
}
