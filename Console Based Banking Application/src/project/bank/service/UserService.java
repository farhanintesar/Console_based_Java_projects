package project.bank.service;

import project.bank.entity.User;
import project.bank.repository.UserRepository;

public class UserService {

    private UserRepository UserRepository = new UserRepository(); //we created a object of userRepository to use the method printuser.

    
    public void printUsers(){
        UserRepository.printUsers();
    }

    public User login(String username, String password){
       return UserRepository.login(username,password);
    }

    }


