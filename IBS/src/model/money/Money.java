package model.money;

public class Money {
    public Money(Currency currency, double value) {
        this.currency = currency;
        this.value = value;
    }

    private Currency currency;
    private double value;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
