/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author 608787
 */
public class AccountService {

    private final ArrayList<User> USERS;

    public AccountService() {
        USERS = new ArrayList<>();
        USERS.add(new User("abe", "password"));
        USERS.add(new User("barb", "password"));
    }

    public User login(String username, String password) {
        User authUser = null;
        
        for (User user : USERS) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                authUser = new User(username, null);
            }
        }
        return authUser;
    }

}
