package com.Group13.BookstoreProject;

import com.Group13.BookstoreProject.models.Customer;
import com.Group13.BookstoreProject.repositories.CustomerRepository;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import com.mongodb.client.MongoClients;


@SpringBootApplication
public class BookstoreProjectApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;
	private static final org.apache.commons.logging.Log log = LogFactory.getLog(BookstoreProjectApplication.class);
	public static final Logger Log = LoggerFactory.getLogger(BookstoreProjectApplication.class);
	@Value("${mongo_uri}")
	private String uri;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreProjectApplication.class, args);
	}

	public void run(String... arg0) throws Exception {

		ConnectionString connectionString = new ConnectionString(uri);
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();

		MongoOperations mongoOps = new MongoTemplate(
				new SimpleMongoClientDatabaseFactory(MongoClients.create(mongoClientSettings), "ProjectDB")
		);

		mongoOps.getCollection("customer").drop();

		Customer newCustomer = new Customer("Christian", "Roque");
		log.info("Insert: " + newCustomer);

		mongoOps.save(newCustomer);
	}
}