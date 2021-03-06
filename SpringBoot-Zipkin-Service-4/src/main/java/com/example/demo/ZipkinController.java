package com.example.demo;

import java.util.logging.Logger;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
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
     
    @GetMapping(value="/zipkin4")
    public String zipkinService1()
    {
        LOG.info("Inside zipkinService 4..");
        
       /* String response1 = (String) restTemplate.exchange("http://localhost:8061/zipkin",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();*/
         
         String response = "Welcome to Cloud";
        return "Hi..."+response;
    }

}
