package com.example.demo;

import java.util.logging.Logger;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ZipkinController {
	
	@Autowired
    RestTemplate restTemplate;
 
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
 
    @Bean
    public AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }
 
    private static final Logger LOG = Logger.getLogger(ZipkinController.class.getName());
     
    @GetMapping(value="/zipkin")
    public String zipkinService1()
    {
        LOG.info("Inside zipkinService 1..");
         
         String response = (String) restTemplate.exchange("http://localhost:8062/zipkin2",
                        HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();
         String response1 = (String) restTemplate.exchange("http://localhost:8063/zipkin3",
                 HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();
        return "Hi..."+response+"         "+response1;
    }

    @GetMapping(value="/zipkin01")
    public String zipkinService2()
    {
        LOG.info("Inside zipkinService 1..");
         
         String response = (String) restTemplate.exchange("http://localhost:8062/zipkin2",
                        HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();
        return "Hi..."+response;
    }
}
