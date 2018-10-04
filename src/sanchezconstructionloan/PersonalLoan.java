package sanchezconstructionloan;

/**
 *
 * @author Omotayo
 */

     /*
        The personal loan class which inherits the abstract class loan and sets the interest rate independently
    */
public class PersonalLoan extends Loan {

    public PersonalLoan(int loanNumber, String lastName, double amountOfLoan, int termOfLoan,double interestRate){
        super(loanNumber, lastName, amountOfLoan, termOfLoan);
        super.interestRate = 0.02 / (interestRate/100);
    }    
}
