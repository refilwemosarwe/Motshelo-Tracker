package com.ub.motshelocontributionstracker.profile;

public class Member extends Person

{
    private int memberId;

    public Member(int memberId)
    {
        super(name, phoneNumber, totalContributions);

        this.memberId = memberId;
    }
    public void contribute(double amount)
    {
        if (amount > 0)
        {
            totalContributions += amount;
        }
    }

    public double getTotalContributions()
    {
        return totalContributions;
    }

    public int getMemberId()
    {
        return memberId;
    }

    @Override
    public String toString()
    {
        return "ID: " + getMemberId + " | Name: " + getName + " | Total: P" + getTotalContributions;
    }
}
