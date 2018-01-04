/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduza.member.test;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jeasydev
 */
//@PropertySource(value = { "classpath:application.properties" })
@RestController  //ทำให้ทุกๆ method ถูกใส่ @ResponseBody อัตโนมัติ
@Secured("ROLE_USER")
public class RestSonController {

    @RequestMapping(value = "/api/a"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    //@ResponseBody
    //@GetMapping("/a")
    public ResponseEntity<Map<String, String>> getAllIssuers() {

//        logger.info("Inside getAllIssuers() method...");
        //return "Hi Respone";
        Map<String, String> m = new HashMap<>();
        m.put("a", "aaaaaaa");
        m.put("b", "bbbbbbbb");
        m.put("c", "ccccccccc");
        m.put("d", "ddddddddd");

        return ResponseEntity.accepted().body(m);

    }

    //@Value("#{security.user.name}")
    //@SuppressWarnings("FieldMayBeFinal")
    // private String prop = "";
    // @RequestMapping(value = "/", method = RequestMethod.GET)
    //@ResponseBody
//    @RequestMapping(value = "/")// ใช้ @GetMapping
//    //@GetMapping("/")
//    public String index() {
//
////        logger.info("Inside getAllIssuers() method...");
//        return "Hello World ";//''+ this.prop;
//
//    }

}
