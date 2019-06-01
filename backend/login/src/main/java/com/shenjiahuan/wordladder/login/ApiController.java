package com.shenjiahuan.wordladder.login;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    WordLadderController wordLadderController;

    @RequestMapping("/wordladders")
    public Result callWordLadder(@RequestParam(value = "from", required = false) String from, @RequestParam(value = "to", required = false) String to) throws Exception {
        return wordLadderController.wordLadder(from, to);
    }
}
