package com.ub.motshelocontributionstracker.services;

import com.ub.motshelocontributionstracker.profile.Member;

public class Contribution 
{
    private Member member;
    private double amount;

    public Contribution(Member member, double amount) 
    {
        if (member == null) 
        {
            throw new IllegalArgumentException("Member cannot be null");
        }

        if (amount <= 0) 
        {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        this.member = member;
        this.amount = amount;
    }

    public Member getMember() 
    {
        return member;
    }

    public double getAmount() 
    {
        return amount;
    }

    @Override
    public String toString() 
    {
        return member.getName() + " contributed P" + amount;
    }
}
