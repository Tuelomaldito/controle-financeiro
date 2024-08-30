package com.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("localhost:35729/api/exercicio1")
public class exercicio1 {
    
    @GetMapping("/hello")
    public String hellomundo(@RequestParam(required = false) String param) {
        return "Hello Mundo";
    }
}
