package model.score;

import model.account.Account;
import model.constants.Constants;
import model.money.Money;

public class DebetScore extends Score{
    private CreditScore creditScore;
    public DebetScore(Money balance, Account owner, Integer
            number, CreditScore creditScore) {
        super(balance, owner, number);
        this.creditScore = creditScore;
    }

    @Override
    protected boolean checkBefore(Money money) {
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
