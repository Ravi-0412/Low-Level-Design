package AmountWithdrawal;

import Other.ATM;

public abstract class CashWithdrawProcessor {
	
	CashWithdrawProcessor nextCashWithdrawProcessor;
	
	CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
		this.nextCashWithdrawProcessor = cashWithdrawProcessor ;
	}
	
	// kitna amount atm me h and kitna remaining amount hmko nikalna h
	public void withdraw(ATM atm, int remainingAmount) {
		if(nextCashWithdrawProcessor != null) {
			nextCashWithdrawProcessor.withdraw(atm, remainingAmount);
		}
	}

}
