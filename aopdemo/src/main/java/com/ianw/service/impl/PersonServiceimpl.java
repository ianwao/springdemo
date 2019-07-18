package com.ianw.service.impl;

import com.ianw.pojo.Person;
import com.ianw.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceimpl implements PersonService {


    public int addPerson(int a) {
        System.out.println("添加成功");
        return 123;
    }
}
