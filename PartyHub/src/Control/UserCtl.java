package Control;

import java.util.ArrayList;

import Entity.*;

public class UserCtl {
    
    // Lista de Users
    private ArrayList<User> Users;

    public UserCtl() {
        Users = new ArrayList<>();
    }

    // Função p encontrar um User 
    public User findUser(String name) {
        for (User user : Users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    // Função p adicionar um User
    public void addUser(User user) {
        Users.add(user);
    }

    // Função p verificar login
    public boolean verifyLogin(User user,String password) {
        if (user.getPassword().equals(password)) {
            return true;
        }
        else {
            return false;
            } 
    }
} 