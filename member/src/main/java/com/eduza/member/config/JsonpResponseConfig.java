/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduza.member.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;//spring 4.3.13

/**
 *
 * @author jeasydev
 */
@ControllerAdvice
public class JsonpResponseConfig extends AbstractJsonpResponseBodyAdvice {

    public JsonpResponseConfig() {
        super("callback");//ชื่อ ตัวแปร queryString เพื่อดึง jsonP
    }




}
