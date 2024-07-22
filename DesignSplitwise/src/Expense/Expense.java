package Expense;

import java.util.ArrayList;
import java.util.List;

import Split.Split;
import User.User;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidByUser;  
    ExpenseSplitType splitType;
    List<Split> splitDetails = new ArrayList<>();

    // create expense from splitwise app
    public Expense(String expenseId, double expenseAmount, String description,
                   User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails) {

        this.expenseId = expenseId;
        this.expenseAmount = expenseAmount;
        this.description = description;
        this.paidByUser = paidByUser;
        this.splitType = splitType;
        this.splitDetails.addAll(splitDetails);

    }
}

