package project.bank.main;

import java.util.Scanner;

import project.bank.entity.User;
import project.bank.service.UserService;

public class Main {
    private static Scanner scanner = new Scanner (System.in);

    public static void main(String[] args) {

        UserService userService = new UserService();


        System.out.print("Enter Your Username: ");
        String userName = scanner.next();

        System.out.print("Enter your password: ");
        String passWord = scanner.next();

        System.out.println("Username: " + userName + " Password: " + passWord);

        User user = userService.login(userName , passWord);
        if (user != null) {
            System.out.println("You are logged in successfully");
        }else {
            System.out.println("Login Failed");
        }

    }

}