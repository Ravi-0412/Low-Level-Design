package AmountWithdrawal;

import Other.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor{
	
	public FiveHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
		super(nextCashWithdrawProcessor) ;
	}
	
	@Override
	public void withdraw(ATM atm, int remainingAmount) {
		 	int required =  remainingAmount/500;
	        int balance = remainingAmount % 500;

	        if(required <= atm.getNoOfFiveHundredNotes()) {
	        	System.out.println("no of five hundred notes1: " + atm.getNoOfFiveHundredNotes() + "remaining amount: "+ balance);
	            atm.deductFiveHundredNotes(required);
	        }
	        else if(required > atm.getNoOfFiveHundredNotes()) {
	        	balance = balance + (required-atm.getNoOfFiveHundredNotes()) * 500;
	            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
	            
	        }

	        if(balance != 0){
	            super.withdraw(atm, balance);
	        }
	    }
}
