package sanchezconstructionloan;

import java.util.ArrayList;

/**
 *
 * @author Omotayo
 * Loan manager class that acts as an intermediary between Main menu and the LoanDB
 */
public class LoanManager {

    private static LoanDB loanList = new LoanDB();
   /*
        Method to save a loan object
    */ 
    public static boolean saveLoan(Loan loan) {
        return loanList.saveLoan(loan);
    }

    /*
        Method to find a loan object
    */
    public static ArrayList<Integer> findLoan(Loan loan) {
        return loanList.findLoan(loan);
    }

    /*
        Method to print a loan object based on position
    */
    public static void printLoanDetails(int position) {
        loanList.printLoanDetails(position);
    }

    /*
        Method to print all loan object(s)
    */
    public static void printAllLoans(Loan loan) {
        loanList.printAllLoans();
    }
}
