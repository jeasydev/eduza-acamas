/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduza.member.config.hibernate_netbeans_helper;

//import org.hibernate.cfg.AnnotationConfiguration; // duplicated in hibernate 5
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * คลาสนี้ ทำให้ netbeans สามารถสร้างไฟล์ revers-hibernate ได้
 * ทำให้เราสามารถสร้าง POJO Entity ได้จากตารางใน MySQL ได้เลยจาก Netbeans
 * object.
 *
 * @author jeasydev
 */
public class Hibernate43Util {

    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
