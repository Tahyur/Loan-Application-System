package sanchezconstructionloan;

import static sanchezconstructionloan.MainMenu.input;

/**
 *
 * @author Omotayo
 *  Abstract class Loan 
 */
public abstract class Loan implements LoanConstants {
    
    private int loanNumber;
    private String lastName;
    private double loanAmount;
    protected double interestRate;
    private int termOfLoan;

    public Loan(int loanNumber, String lastName, double loanAmount, int termOfLoan) {
        this.setLoanNumber(loanNumber); // Sets the loan number
        this.setLastName(lastName); // Sets the last name
        this.setLoanAmount(loanAmount); //sets the loan amount
        this.setTermOfLoan(termOfLoan); //sets the loan term
    }

    /*
        Accessor Methods for all the fields defined in this class
    */
    public int getLoanNumber() {
        return loanNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTermOfLoan() {
        return termOfLoan;
    }

    public double getTotalAmountOwed() {
         return this.getLoanAmount() + (this.getLoanAmount() * this.getInterestRate());
    }
    
      /*
        Mutator methods for all the fields defined in this class
    */
    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setTermOfLoan(int termOfLoan) {
        if (termOfLoan != LoanConstants.SHORT_TERM && termOfLoan != LoanConstants.MEDIUM_TERM
                && termOfLoan != LoanConstants.VERY_LONG_TERM) {
            this.termOfLoan = LoanConstants.SHORT_TERM;
        } else {
            this.termOfLoan = termOfLoan;
        }
    }

     /*
        Validates last name
    */
    public static String validateLastName() {
        String lastName;
        System.out.print("Enter your last name: ");
        lastName = input.nextLine();
        for (int i = 0; i < lastName.length(); i++) {
            if (Character.isDigit(lastName.charAt(i)) || !(Character.isLetterOrDigit(lastName.charAt(i)))) {
                System.out.println("Invalid, last name cannot contain symbols or digit");
                return validateLastName();
            }
        }
        return lastName;
    }
    /*
        toString method to display the loan details in string format
    */           
            
    @Override
    public String toString() {
        return "\nLoan Number : " + this.getLoanNumber() + "\nLast Name : " + this.getLastName()
                + "\nAmount of Loan : " +this.getLoanAmount() + "\nInterest Rate : " + this.getInterestRate()
                + "\nTerm of Loan : " + this.getTermOfLoan() + "\nTotal Amount Owed : " + this.getTotalAmountOwed() + "\n";
    }

    /*
        Method to display the loan information
    */
    public void display() {
        System.out.println("\n***********************************************");
        System.out.println("\t\tloan details".toUpperCase());
        System.out.println("***********************************************");
        System.out.println("Company Name: " + LoanConstants.COMPANY_NAME);
        System.out.println("Loan Number: " + this.getLoanNumber());
        System.out.println("Last Name: " + this.getLastName());
        System.out.println("Loan Amount: " + this.getLoanAmount());
        System.out.println("Term of Loan: " + this.getTermOfLoan());
        System.out.println("Interest Rate: " + this.getInterestRate());
        System.out.println("Total Amount due: " + this.getTotalAmountOwed());
    }

    /*
        Method to create a loan object
    */
    public static Loan createLoan() {
         System.out.print("\nNote: Enter the first character only\n"
                 + "What kind of loan do you want to apply for \"Personal Loan(P)\" or \"Business Loan(B)\" : ");
        Character c = input.nextLine().toUpperCase().charAt(0);

        while (c != 'P' && c != 'B') {
            System.err.println("\nInvalid character spotted");
            System.out.print("What kind of loan do you want to apply for \"Personal Loan(P)\" or \"Business Loan(B)\" :");
            c = input.nextLine().toUpperCase().charAt(0);
        }

        System.out.print("Enter your loan Number: ");
        int loanNumber = Integer.parseInt(input.nextLine());

        String lastName = validateLastName(); // validates last name

        System.out.print("Enter loan amount: ");
        double loanAmount = Double.parseDouble(input.nextLine());

        while (loanAmount < 1 || loanAmount > LoanConstants.MAXIMUM_LOAN_AMOUNT) {
            System.out.println("Loan amount cannot be greater than " + LoanConstants.MAXIMUM_LOAN_AMOUNT);
            System.out.print("Enter loan Amount: ");
            loanAmount = Double.parseDouble(input.nextLine());
        }

        System.out.print("Enter the loan term: ");
        int loanTerm = Integer.parseInt(input.nextLine());
        System.out.print("Enter the prime interest Rate: ");
        double primeInterestRate = Double.parseDouble(input.nextLine());

        // Creates a loan object based on the character chosen
        if (c == 'P') {
            return new PersonalLoan(loanNumber, lastName, loanAmount, loanTerm, primeInterestRate);
        } else if (c == 'B') {
            return new BusinessLoan(loanNumber, lastName, loanAmount, loanTerm, primeInterestRate);
        } else {
            return null;
        }
    }    

    /*
        the equals method compares if two objects are identical and returns true if they are
    */
    @Override
    public boolean equals(Object obj) {
        boolean objectSame = false;
        Loan l = null;
        if (obj instanceof Loan) {
            l = (Loan) obj;
        }
        if (l.getLoanAmount() == this.loanAmount && l.getLastName().equals(this.lastName)) {
            objectSame = true;
        }
        return objectSame;
    }
}
