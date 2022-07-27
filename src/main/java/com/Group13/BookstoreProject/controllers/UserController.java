package com.Group13.BookstoreProject.controllers;

import com.Group13.BookstoreProject.Service.UserService;
import com.Group13.BookstoreProject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userRep;

    @PutMapping("/create")
    public void createUser(@RequestBody User user) {
        if (userRep.findUserByUsername(user.getUsername()) == null) {
            userRep.createUser(user);
        }
    }

    @GetMapping("/")
    public List<User> getAll() {
        return userRep.findAllUsers();
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userRep.findUserByUsername(username);
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody User user) {
        userRep.updateUser(user);
    }

    @DeleteMapping("/{username}/delete")
    public void deleteUser(@PathVariable String username) {
        userRep.deleteUser(username);
    }

    @PostMapping("/{username}/create-card")
    public void createCard(@PathVariable String username, @RequestBody String card) {
        userRep.createUserCard(card,username);
    }

    @GetMapping("/{username}/card-list")
    public List<String> getAllUserCards(@PathVariable String username) {
        return userRep.getUserCreditCards(username);
    }

}
