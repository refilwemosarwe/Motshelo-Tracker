public class Contribution {
    private double amount;

    public Contribution(double amount) {
        if (amount > 0) {
            this.amount = amount;
        } else {
            System.out.println("Error: Contribution amount must be positive.");
        }
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "contribution [amount=" + amount + "]";
    }
}
