package hierarchy;

public class Stock {
    private long number;

    public Stock(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    private Emmitent emmitent;
    public Stock(long number, Emmitent emmitent) {
        this.number = number;
        this.emmitent = emmitent;
    }
    public Emmitent getEmmitent() {
        return emmitent;
    }
    public void setEmmitent(Emmitent emmitent) {
        this.emmitent = emmitent;
    }
}
