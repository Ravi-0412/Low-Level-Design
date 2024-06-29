package AmountWithdrawal;

import Other.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor{
	
	public OneHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
		super(nextCashWithdrawProcessor) ;
	}
	
	@Override
	public void withdraw(ATM atm, int remainingAmount) {
		 	int required =  remainingAmount / 100;
	        int balance = remainingAmount % 100;

	        if(required <= atm.getNoOfOneHundredNotes()) {
	        	
	            atm.deductOneHundredNotes(required);
	            System.out.println("no of one hundred notes1: " + atm.getNoOfOneHundredNotes()  + "remaining amount: "+ balance);
	        }
	        else if(required > atm.getNoOfOneHundredNotes()) {
	        	balance = balance + (required-atm.getNoOfOneHundredNotes()) * 100;
	            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
	        }

	        if(balance != 0){
	            super.withdraw(atm, balance);
	        }
	    }
}
