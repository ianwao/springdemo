package com.ianw.springwebfirstdemo.comtroller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    private final static Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){

       // try {
            //LOGGER.info("接口，hello,进");
            //LOGGER.debug("接口，hello，调试");
            String name="hello world";
            return name;
       // }catch (Exception e){
           // LOGGER.error("接口，hello，异常");
       // }finally {
        //    LOGGER.info("接口，hello,出");
       // }
       //return null;
    }
}
