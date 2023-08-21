package model.score;

import model.account.Account;
import model.constants.Constants;
import model.money.Money;

public class CreditScore extends Score {
    private Score creditScore;

    public CreditScore(Money balance, Account owner, Integer
            number) {
        super(balance, owner, number);
    }

    @Override
    protected boolean checkBefore (Money money) {
        return false;
    }

    @Override
    public Money getMoney(double balanceLess) {
        if (creditScore.getBalance().getValue() < Constants.MINIMAL_CREDIT) {
            throw new IllegalArgumentException("Credit limit is over, pay credit to continue.");

        }

        return creditScore.getMoney(balanceLess);  }

    @Override
    public Money getMoneyWithoutLess() {
        return null;
    }
}
