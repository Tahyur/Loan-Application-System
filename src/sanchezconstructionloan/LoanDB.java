package sanchezconstructionloan;

import java.util.ArrayList;

/**
 *
 * @author Omotayo 
 * LoanDB acts as the database for storing the loan objects
 */
public class LoanDB {

    private final int size = 50;
    private int count;
    //Array of loan with size set to 50
    private final Loan[] loanList = new Loan[size];

    /*
        Method to save a loan object
     */
    public boolean saveLoan(Loan loan) {
        boolean saveLoan = false;
        if (count < size) {
            loanList[count++] = loan;
            saveLoan = true;
        }
        return saveLoan;
    }

    /*
        Method to find a loan object
     */
    public ArrayList<Integer> findLoan(Loan loan) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int location = 0; location < count; location++) {
            if (loanList[location].equals(loan)) {
                temp.add(location);
            }
        }
        return temp;
    }

    /*
        Method to print a loan object based on position
     */
    public void printLoanDetails(int position) {
        loanList[position].display();
    }

    /*
        Method to print all loan object(s)
     */
    public void printAllLoans() {
        for (int i = 0; i < count; i++) {
            System.out.println(loanList[i]);
        }
    }
}
