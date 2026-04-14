package com.ub.motshelocontributionstracker.services;
import com.ub.motshelocontributionstracker.profile.Member;
public class Payout
{
    private double amount;
    private Member member;

    public Payout(Member member, double amount)
    {
        if (member == null)
        {
            throw new IllegalArgumentException("Member cannot be null");
        }

        if (amount <= 0)
        {
            throw new IllegalArgumentException("Amount cannot be negative");
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

    @Override
    public String toString()
    {
        return "Payout (Member:" + member.getMemberId() + ", Amount:" + amount + ")";
    }
}