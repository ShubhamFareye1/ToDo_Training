package com.fareye.training.service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.LinkedHashMap;

// we can have to ways to get avatar_url from github
// 1. using a avatar class and
// 2. using a LinkedHashMap type casting we use second method.

public class GitAvatarService {
    public String avatarUrl(String userName){
        String url = "https://api.github.com/users/"+userName;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Avatar> responseEntity =  restTemplate.getForEntity(url, Avatar.class);
        Avatar avatar = responseEntity.getBody();
        return avatar.avatar_url;
    }

    public String avatar(String userName)throws Exception{
        String url = "https://api.github.com/users/" + userName;
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Object> responseEntity = restTemplate.getForEntity(url, Object.class);
            Object objects = responseEntity.getBody();
            LinkedHashMap<String,String> h = (LinkedHashMap<String, String>) objects;
            return h.get("avatar_url");
        }catch (Exception e) {
            throw new Exception("403 rate limit exceeded");
        }

    }

}
