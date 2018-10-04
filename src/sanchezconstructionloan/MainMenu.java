package sanchezconstructionloan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Omotayo
 */
/*
    Main menu class which contains operations to perform on a loan object
*/
public class MainMenu {

    public static Scanner input = new Scanner(System.in);
    static Loan loan = null;

    /*
        Method to find a loan based on the customer last name and loan amount
     */
    public static void findLoan() {
        ArrayList<Integer> position; //Stores the index postion of all matching records found
        System.out.print("Enter your last Name: ");
        String lastName = input.nextLine();
        System.out.print("Enter the loan amount: ");
        double loanAmount = Double.parseDouble(input.nextLine());

        // Creating an object of Personal loan
        loan = new PersonalLoan(0, lastName, loanAmount, 0, 0);
        // or loan = new BusinessLoan(0,lastName,loanAmount,0,0);
        // or loan = new Loan(0,lastName,loanAmount,0){};

        // Casting it to an object of the abstract loan class
        Loan fl = (Loan) loan;
        position = LoanManager.findLoan(fl);
        if (position.isEmpty()) {
            System.out.println("\nNo loan record match(es)");
        } else {
            for (int i = position.get(0); i < position.size(); i++) {
                LoanManager.printLoanDetails(i);
            }
        }
        mainMenu();
    }

    /*
        Method to print all stored loan details
     */
    public static void displayLoan() {
        LoanManager.printAllLoans(loan);
        mainMenu();
    }

    /*
        Method to create and save a new loan to the loan database
     */
    public static void loan() {
        loan = Loan.createLoan(); // calls the create method from the loan class
        if (LoanManager.saveLoan(loan)) {
            System.out.println("Loan created and saved successfully");
        } else {
            System.out.println("Loan not created, list might probably be full");
        }
        mainMenu();
    }

    /*
        Method to perform a specific operation based on the user's choice
     */
    public static boolean choice(int selection) {
        boolean choice = true;
        switch (selection) {
            case 1:
                loan();
                break;
            case 2:
                findLoan();
                break;
            case 3:
                displayLoan();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice");
                choice = false;
                break;
        }
        return choice;
    }

    /*
        The main menu method 
     */
    public static void mainMenu() {
        int selection = -1;
        boolean valid = true, validOption = true;
        System.out.println("*************************************************");
        System.out.println("\t" + LoanConstants.COMPANY_NAME.toUpperCase());
        System.out.println("*************************************************");
        System.out.print("1. Apply for Loan\n2. Find and Display Loan\n3. Display all Loans\n0. Exit");
        System.out.print("\nSelection --> ");

        // To catch any wrong number format
        try {
            selection = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println("Invalid input, please try again".toUpperCase());
            validOption = false;
        }

        // if the selection value is acceptable, call the choice method else display the main menu again
        if (validOption) {
            valid = choice(selection);
        } else {
            mainMenu();
        }

        // while(false)
        while (!valid) {
            valid = true; //Re-assign the valid variable to true
            mainMenu(); //Display the Main Menu 
        }
    }
}
