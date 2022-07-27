package com.Group13.BookstoreProject.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    @Field("username")
    private String username;
    @Field("password")
    private String password;
    @Field("name")
    private String name;
    @Field("emailAddress")
    private String emailAddress;
    @Field("homeAddress")
    private String homeAddress;
    @Field("creditCards")
    private ArrayList<String> creditCards;

    public User(String id,String username, String password, String name, String emailAddress, String homeAddress) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name != null ? name: "John doe";
        this.emailAddress = emailAddress != null ? emailAddress: "user@domain";;
        this.homeAddress = homeAddress != null ? homeAddress: "1234 example 12 example, 12345";
        this.creditCards = new ArrayList<String>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getHomeAddress(){
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public ArrayList<String> getCreditCards() {
        return creditCards;
    }

    public void addCreditCard(String card) {
        this.creditCards.add(card);
    }

    public void addCreditCards(ArrayList<String> newCreditCard) {
        this.creditCards = newCreditCard;
    }
}
