package com.Group13.BookstoreProject;

import com.Group13.BookstoreProject.models.Customer;
import com.Group13.BookstoreProject.repositories.CustomerRepository;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import com.mongodb.client.MongoClients;

@SpringBootApplication
public class BookstoreProjectApplication {

	@Autowired
	private CustomerRepository repository;
	private static final Log log = LogFactory.getLog(BookstoreProjectApplication.class);
	static private String uri = "mongodb+srv://croquevaldes:i5vD1aIoTWHWCcpO@cluster0.1fow7.mongodb.net/?retryWrites=true&w=majority";

	public static void main(String[] args) {
		SpringApplication.run(BookstoreProjectApplication.class, args);

		ConnectionString connectionString = new ConnectionString(uri);
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();

		MongoOperations mongoOps = new MongoTemplate(
				new SimpleMongoClientDatabaseFactory(MongoClients.create(mongoClientSettings), "ProjectDB")
		);

		Customer newCustomer = new Customer("Christian", "Roque");
		log.info("Insert: " + newCustomer);

		mongoOps.save(newCustomer);
	}
}