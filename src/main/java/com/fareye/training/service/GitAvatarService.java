package com.fareye.training.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.net.MalformedURLException;
import java.util.LinkedHashMap;

// we can have to ways to get avatar_url from github
// 1. using a avatar class and
// 2. using a LinkedHashMap type casting we use second method.

@RestController
public class GitAvatarService {

    @GetMapping("/avatar")
    public String avatar(@RequestParam String userName) throws MalformedURLException {
        String url = "https://api.github.com/users/"+userName;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Avatar> responseEntity =  restTemplate.getForEntity(url, Avatar.class);
        Avatar avatar = responseEntity.getBody();
        return avatar.avatar_url;
    }

    @GetMapping("/avatarUrl")
    public String avatarUrl(@RequestParam String userName) throws MalformedURLException {
        String url = "https://api.github.com/users/" + userName;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity =restTemplate.getForEntity(url,Object.class);
        Object objects = responseEntity.getBody();
        LinkedHashMap<String,String> h = (LinkedHashMap<String, String>) objects;
        return h.get("avatar_url");
    }

}
