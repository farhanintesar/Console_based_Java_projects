package project.bank.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import project.bank.entity.User;

public class UserRepository {
                                         //we will store user data here (list,set,map)
                                        //we don't wand dublicate element's here so we are using sets;as sets doesn't allow duplicate valuse

   private static Set<User> users = new HashSet<>();     //## We don't want incertion order so we are using hashSet()
                                         //## We made it static because we are going to store all the user data here and only one copy of it will be
                                        //used throughout the program.

                                        //static block is used to initialize the static members of the class {we will be initializing 'users' here}
                                       //it will be called only once unlike constructor that is called everytime a object is created.

   static {
    User user1 = new User("admin" , "admin" , "1234567" , "admin" , 0.0);
    User user2 = new User("user2" , "user2" , "12345678" , "user" , 1000.0);
    User user3 = new User("user3" , "user3" , "123456789" , "user" , 2000.0);
    User user4 = new User("user4" , "user4" , "1234567890" , "user" , 2000.0);

    users.add(user1);
    users.add(user2);
    users.add(user3);
    users.add(user4);
   }

   public void printUsers(){
    System.out.println(users);  //now it will show the ref of the object; to get the actual data we need to Override toString method
   }

   //login method
   public User login(String username , String password){  //we can use for each loop to compare or use stream API
   List<User> finalList = users.stream().filter(user -> user.getUsername().equals(username) && user.getPassword()
                                                                .equals(password)).collect(Collectors.toList());     //lambda expression
                                               //inside the filter we need to pass a pradicate
      
    if (!finalList.isEmpty()) {
        return finalList.get(0);
    } else {
        return null;
    }
   }


   
    public boolean addNewCustomer(String username, String password , String contact){
        User user = new User(username,password,contact, "user" , 500.0);
        return users.add(user);
    }



}
