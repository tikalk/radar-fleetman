package com.tikal.workshop.fleetman.springstaffservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringStaffServiceApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringStaffServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringStaffServiceApplication.class, args);
	}

}

