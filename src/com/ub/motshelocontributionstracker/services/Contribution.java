package com.ub.motshelocontributionstracker.contribution;
public class Contribution {
    private double amount;

    public Contribution(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Contribution [amount=" + amount + "]";
    }
}
