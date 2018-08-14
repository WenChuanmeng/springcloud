package com.dd.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ClientController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/getProductMsg")
    public String getProductMsg() {

        //1.直接使用RestTemplate url写死的额
//        RestTemplate restTemplate = new RestTemplate();
//        String resp = restTemplate.getForObject("http://localhost:8080/msg", String.class);

        //2. 使用LoadBalancerClient通过应用名获取URL再使用RestTemplate
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        RestTemplate restTemplate = new RestTemplate();
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "msg";
//        String resp = restTemplate.getForObject(url, String.class);

        //3.第三种使用@LoadBalancer,在restTemplate使用应用的名字
        String resp = restTemplate.getForObject("http://PRODUCT/msg", String.class);

        log.info("resp={}", resp);
        return resp;
    }
}
