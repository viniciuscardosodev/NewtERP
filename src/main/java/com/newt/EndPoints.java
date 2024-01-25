package com.newt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EndPoints {
    
    @GetMapping("/s")
    public String loginsc() {
        return "html/homepage.html";
    }

    @GetMapping("/adm")
    public String admsc(){
        return "html/menuAdmin.html";
    }
    
    

}
