package project.bank.service;

import java.util.Map;

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

    public Double checkBankBalance(String userId){
        
        return userRepository.checkBankBalance(userId);
    }

    public User getUser(String userId){
        return userRepository.getUser(userId);

    }

    public boolean transferAmount(String userId, String payeeUserId , double amount){

       return userRepository.transferAmount(userId, payeeUserId, amount);
    }

    public void printTransactions(String userId){
        userRepository.printTransactions(userId);
    }

    public void raiseChequeBookRequest(String userId){
        userRepository.raiseChequeBookRequest(userId);
    }



    public Map<String, Boolean> getAllChequeBookRequest(){
        return userRepository.getAllChequeBookRequest();
    }
    
    }


