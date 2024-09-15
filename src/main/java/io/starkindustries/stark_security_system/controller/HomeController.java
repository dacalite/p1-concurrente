package io.starkindustries.stark_security_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path= "api/v1/home")
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

}
