package com.fareye.training.controller;

import com.fareye.training.utility.FetchApplicationPropery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Properties;

@RestController
public class ApplicationPropertyController {
    @Autowired
    FetchApplicationPropery c;
    @GetMapping("/application-properties")
    public Properties hello() throws IOException {
        return c.getPropValues();
    }

    @GetMapping("/application-property")
    public String property(@RequestParam String key) throws IOException{
          return c.getPropValue(key);
    }
}