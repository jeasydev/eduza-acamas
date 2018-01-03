/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduza.member.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * คลาสนี้ ใช้แทน web.xml ฉะนั้น ไม่จำเป็นต้องมี web.xml แต่ยังคงต้องมีไฟล์
 * dispatcher-servlet.xml
 *
 * @author jeasydev
 */
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocation("/WEB-INF/dispatcher-config.xml");//ยังคงใช้ไฟล์ dispatcher-config.xml

        ServletRegistration.Dynamic dispatcher = container
                .addServlet("dispatcher", new DispatcherServlet(context));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

    /**
     * *
     * กรณีต้องการกำจัดไฟล์ dispatcher-servlet.xml ให้ใช้อันนี้
     */
//       @Override
//    public void onStartup(ServletContext container) {
//        AnnotationConfigWebApplicationContext context
//          = new AnnotationConfigWebApplicationContext();
//        context.setConfigLocation("com.example.app.config");
// 
//        container.addListener(new ContextLoaderListener(context));
// 
//        ServletRegistration.Dynamic dispatcher = container
//          .addServlet("dispatcher", new DispatcherServlet(context));
//         
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//    }
}
