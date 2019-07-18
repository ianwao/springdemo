package com.ianw.controller;

import com.ianw.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PayController {

    @Autowired
    PayService payService;

    public boolean pay(int money){
        boolean pay =payService.pay(money);
        return pay;
    }
}
