package project.bank.service;

import project.bank.entity.User;
import project.bank.repository.UserRepository;

public class UserService {

    private UserRepository userRepository = new UserRepository(); //we created a object of userRepository to use the method printuser.

    
    public void printUsers(){
        userRepository.printUsers();
    }

    public User login(String username, String password){
       return userRepository.login(username,password);
    }

    public boolean addNewCustomer(String username, String password , String contact){
        return userRepository.addNewCustomer(username, password,contact);
    }



    }


