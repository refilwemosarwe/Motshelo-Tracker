package com.ub.motshelocontributionstracker.services;
import com.ub.motshelocontributionstracker.profile.Member;

/**
 * Represents a financial payout distributed to a specific Motshelo member.
 */
public class Payout
{
    private double amount;
    private Member member;
    /**
     * Initializes a payout with validation for existence of member and positive funds.
     */
    public Payout(Member member, double amount)
    {
        // Ensures a valid member is assigned to the payout
        if (member == null)
        {
            throw new IllegalArgumentException("Member cannot be null");
        }

        // Ensures that the payout value is a non-zero positive number
        if (amount <= 0)
        {
            throw new IllegalArgumentException("Amount must be positive");
        }

        this.member = member;
        this.amount = amount;
    }

    public double getAmount()
    {
        return amount;
    }

    public Member getMember()
    {
        return member;
    }

    /**
     * Returns a formatted summary of the payout, including Member ID and currency (Pula).
     */
    @Override
    public String toString()
    {
        return "Payout (Member:" + member.getMemberId() + "-" + member.getName() + ", Amount: P" + amount + ")";
    }
}
