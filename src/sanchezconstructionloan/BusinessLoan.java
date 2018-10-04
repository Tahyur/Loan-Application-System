package sanchezconstructionloan;

/**
 *
 * @author Omotayo
 */

    /*
        The business loan class which inherits the abstract class loan and sets the interest rate independently
    */
public class BusinessLoan extends Loan{
    
    public BusinessLoan(int loanNumber, String lastName, double amountOfLoan, int termOfLoan,double interestRate) {
         super(loanNumber, lastName, amountOfLoan, termOfLoan);
         super.interestRate = 0.01 / (interestRate/100);
    }
    
}
