package model.score;

import model.account.Account;
import model.money.Money;

public class DebetScore extends Score{
    private CreditScore creditScore;
    public DebetScore(Money balance, Account owner, Integer
            number, CreditScore creditScore) {
        super(balance, owner, number);
        this.creditScore = creditScore;
    }
}
