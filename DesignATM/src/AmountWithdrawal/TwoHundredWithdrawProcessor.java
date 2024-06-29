package AmountWithdrawal;

import Other.ATM;


public class TwoHundredWithdrawProcessor extends CashWithdrawProcessor{
	
	public TwoHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
		super(nextCashWithdrawProcessor) ;
	}
	
	@Override
	public void withdraw(ATM atm, int remainingAmount) {
		 	int required =  remainingAmount / 200;
	        int balance = remainingAmount % 200;

	        if(required <= atm.getNoOfTwoHundredNotes()) {
	            atm.deductTwoHundredNotes(required);
	            System.out.println("no of two hundred notes1: " + atm.getNoOfTwoHundredNotes() + "remaining amount: "+ balance );
	        }
	        else if(required > atm.getNoOfTwoHundredNotes()) {
	        	balance = balance + (required-atm.getNoOfTwoHundredNotes()) * 200;
	            atm.deductTwoHundredNotes(atm.getNoOfTwoHundredNotes());
	            
	        }

	        if(balance != 0){
	            super.withdraw(atm, balance);
	        }
	    }
}