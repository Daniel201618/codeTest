package com.example.codetest.controller;

import com.example.codetest.entity.StringArtifact;
import com.example.codetest.service.IStringArtifact;
import com.example.codetest.utils.Order;
import com.example.codetest.response.OutputResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/StringArtifact")
public class StringArtifactController {
    @Autowired
    private ApplicationContext applicationContext;


    @PostMapping(path = "/resolvedStr")
   public OutputResultResponse resolveStr(@RequestBody StringArtifact strArtifact){
        /* 根据策略模式，处理不同需求类型的字符串*/
        Order order = new Order();
        order.setRequireType(strArtifact.getRequireType());
        IStringArtifact stringArtifact = applicationContext.getBean(order.getRequireType(),IStringArtifact.class);
        OutputResultResponse outputResult =  stringArtifact.resolveStr(order,strArtifact.getInput());
        return outputResult;
   }


}
