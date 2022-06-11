package com.Group13.BookstoreProject;

import com.Group13.BookstoreProject.models.Customer;
import com.Group13.BookstoreProject.repositories.CustomerRepository;
import com.mongodb.ConnectionString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Example
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

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

	public static void main(String[] args) {
		SpringApplication.run(BookstoreProjectApplication.class, args);


//		ConnectionString connectionString = new ConnectionString(System.getenv("mongo"));

		MongoOperations mongoOps = new MongoTemplate(
				new SimpleMongoClientDatabaseFactory(MongoClients.create(), "ProjectDB")
		);


		Customer newCustomer = new Customer("Christian", "Roque");
		log.info("Insert: " + newCustomer);

		System.out.println("it does run");
		mongoOps.save(newCustomer);

		System.out.println(System.getenv("name"));
	}

}