package com.property.landlordapp;

import com.property.landlordapp.models.Property;
import com.property.landlordapp.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LandlordappApplication {

    public static void main(String[] args) {
        SpringApplication.run(LandlordappApplication.class, args);
    }

    @Bean
    public SessionFactory sessionFactory(){
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Property.class)
                .buildSessionFactory();
    }
}
