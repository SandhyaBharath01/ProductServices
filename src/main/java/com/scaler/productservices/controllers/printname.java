package com.scaler.productservices.controllers;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import  org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
//public class printname {
//    @GetMapping("/hello/{name}")
//    public String sayhello(@PathVariable("name") String name){
////        return "Hello";
//        String str = "";
//        for(int i=0; i<5; i++){
//            str += "sandhya" + name + "!\n";
//        }
//        return str;
//    }
//}

public class printname {
    @GetMapping("/hello/{name}/{times}")
    public String sayhello(@PathVariable("name") String name,
                           @PathVariable("times") int times){
//        return "Hello";
        String str = "";
        for(int i=0; i<times; i++){
            str += "sandhya" + name + "!\n";
        }
        return str;
    }
}
