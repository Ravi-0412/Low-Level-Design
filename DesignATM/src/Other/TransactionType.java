package Other;

public enum TransactionType {
	// for now only keeping two thing
    CASH_WITHDRAWAL,
    BALANCE_CHECK;

    public static void showAllTransactionTypes(){

        for(TransactionType type: TransactionType.values()){
            System.out.println(type.name());
        }
    }
}