package com.Group13.BookstoreProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.apache.commons.logging.LogFactory;


@SpringBootApplication
public class BookstoreProjectApplication implements CommandLineRunner {

	@Autowired
	private static final org.apache.commons.logging.Log log = LogFactory.getLog(BookstoreProjectApplication.class);
	public static final Logger Log = LoggerFactory.getLogger(BookstoreProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreProjectApplication.class, args);
	}

	public void run(String... arg0) throws Exception {
	}
}