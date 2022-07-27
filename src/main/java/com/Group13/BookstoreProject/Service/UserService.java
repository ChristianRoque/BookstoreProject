package com.Group13.BookstoreProject.Service;

import com.Group13.BookstoreProject.models.User;
import com.Group13.BookstoreProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRep;

    public void createUser(User user) {
        userRep.insert(user);
    }

    public List<User> findAllUsers() {
        return userRep.findAll();
    }

    public User findUserByUsername(String username) {
        return userRep.findByUsername(username);
    }

    public void updateUser(User user) {
        User dbUser = userRep.findByUsername(user.getUsername());
        if (dbUser != null) {
            user.setEmailAddress(dbUser.getEmailAddress());
            user.setId(dbUser.getId());
            userRep.save(user);
        }
    }

    public void deleteUser(String userName) {
        userRep.deleteById(userRep.findByUsername(userName).getId());
    }

    public void createUserCard(String creditCardInfo,String userName) {
        User dbUser = userRep.findByUsername(userName);
        if (dbUser != null) {
            dbUser.addCreditCard(creditCardInfo);
            userRep.save(dbUser);
        }
    }

    public List<String> getUserCreditCards(String userName) {
        return userRep.findByUsername(userName).getCreditCards();
    }
}
