public class Deposit {
    private int amount;
    private int period;
    private int action;

    public Deposit(int amount, int period, int action) {
        this.amount = amount;
        this.period = period;
        this.action = action;
    }

    public int getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    public int getAction() {
        return action;
    }
}
