package com.Group13.BookstoreProject.repositories;

import java.util.List;

import com.Group13.BookstoreProject.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

}