package project.bank.main;


import java.util.Scanner;
import project.bank.entity.User;
import project.bank.service.UserService;

public class Main {
    private static Scanner scanner = new Scanner (System.in);
    static Main main = new Main();
     static UserService userService = new UserService();

    public static void main(String[] args) {

        while(true){

        System.out.print("Enter Your Username: ");
        String userName = scanner.next();

        System.out.print("Enter your password: ");
        String passWord = scanner.next();

        System.out.println("Username: " + userName + " Password: " + passWord);

        User user = userService.login(userName , passWord);
        if (user != null && user.getRole().equals("admin")) {
            System.out.println("You are logged in successfully");
            main.initAdmin();
        }else if(user != null && user.getRole().equals("user")){
            main.initCustomer(user);
        }else{
            System.out.println("Login Failed");
        }
        }

    }

    private void initAdmin(){

        boolean flag = true;

        while(flag){
        System.out.println("1. Exit / Logout");
        System.out.println("2. Create a customer account");

        int selectedOption = scanner.nextInt();

        switch (selectedOption) {
            case 1:
                flag = false;
                System.out.println("You Have successfully logged out....");
                break;
        
            case 2:
                main.addNewCustomer();
                break;

            default:
                System.out.println("Wrong Choice");
                break;
        }//end braces of switch case

        } //end braces of while loop
    }


    private void addNewCustomer(){
        System.out.print("Enter user name: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        System.out.print("Enter Contact Number: ");
        String contact = scanner.next();

        boolean result = userService.addNewCustomer(username, password, contact);

        if(result){
            System.out.println("Customer account is created......");
        }else{
            System.out.println("Customer account creation failed..");
        }
    }

    private void initCustomer(User user){
        boolean flag = true;

        while (flag) {
            System.out.println("1. Exit / logout");
            System.out.println("2. Check Bank balance");
            System.out.println("3. Fund Transfer");

            int selectedOption = scanner.nextInt();

                switch (selectedOption) {
            case 1:
                flag = false;
                System.out.println("You Have successfully logged out");
                break;
            case 2:
                   Double balance= main.checkBankBalance(user.getUsername());
                   if (balance != null){
                    System.out.println("Your bank balance is: " + balance);
                   } else{
                    System.out.println("Check your username....");
                   }
                break; 
             case 3:
                main.fundTransfer(user);
             break;
            default:
                System.out.println("Wrong Choice");
                break;
        }//end braces of switch case
        }
    }

    private void fundTransfer(User userDetails){
        System.out.println("Enter payeee account user id");
        String payeeAccountId = scanner.next();

        User user = getUser(payeeAccountId);

        if (user != null) {
            System.out.print("Enter amount to Transfer: ");
            Double amount = scanner.nextDouble();

            Double usersAccountBalance = checkBankBalance(userDetails.getUsername());

            if (usersAccountBalance >= amount){
               boolean result = userService.transferAmount(userDetails.getUsername(), payeeAccountId, amount);

               if (result) {
                System.out.println("Amount Transfered Successfully.");
               }else{
                System.out.println("Transfer Failed....");
               }
               
            }else{
                System.out.println("Insufficient Balance!! \n Current account Balance: " + usersAccountBalance);
            }

        }else{
            System.out.println("Please enter valied username....");
        }

    }

    private User getUser(String userId){  //validation of payee's acount

        return userService.getUser(userId);
    }


    private Double checkBankBalance(String userId){  //returns the current bank balance
       return userService.checkBankBalance(userId);

    }

}