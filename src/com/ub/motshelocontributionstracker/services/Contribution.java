package com.ub.motshelocontributionstracker.services;

import com.ub.motshelocontributionstracker.profile.Member;

public class Contribution 
{
    private Member member;
    private double amount;

    public Contribution(Member member, double amount) // Creates a new contribution made by a member
    {
        if (member == null) 
        {
            throw new IllegalArgumentException("Member cannot be null"); // rejects null members
        }

        if (amount <= 0) 
        {
            throw new IllegalArgumentException("Amount must be greater than 0"); // rejects zero and negative amounts
        }

        this.member = member;
        this.amount = amount;
    }

    public Member getMember() 
    {
        return member; // Returns the name of the member that made this contribution
    }

    public double getAmount() 
    {
        return amount; // Returns the amount that was contributed
    }

    @Override
    public String toString() 
    {
        return member.getName() + " contributed P" + amount; // Returns a summary of this contribution
    }
}
