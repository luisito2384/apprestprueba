package com.genesys.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApiRestApplication {
	private static final Logger logger = LogManager.getLogger(ApiRestApplication.class);
	public static void main(String[] args) {
		logger.info("Info log");
		ThreadContext.put("Prueba", "123456789");
		logger.info("Info log2");
		SpringApplication.run(ApiRestApplication.class, args);
	}
	public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Hey, This is a warning!");
        logger.error("Oops! We have an Error. OK");
        logger.fatal("Damn! Fatal error. Please fix me.");
    }

}
