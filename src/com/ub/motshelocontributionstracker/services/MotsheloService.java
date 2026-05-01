package com.ub.motshelocontributionstracker.services;

import com.ub.motshelocontributionstracker.profile.Member;
import java.util.ArrayList;
import java.util.List;

public class MotsheloService 
{
    private List<Member> members;
    private List<Payout> payouts;
    private double totalSavings;

    public MotsheloService() 
    {
        members = new ArrayList<>();
        payouts = new ArrayList<>();
        totalSavings = 0.0;
    }

    public void addMember(Member member) 
    {
        if (member == null) 
        {
            throw new IllegalArgumentException("Member cannot be null");
        }
        members.add(member);
    }

    // Find member
    public Member findMember(String name) 
    {
        for (Member m : members) 
        {
            if (m.getName().equalsIgnoreCase(name)) 
            {
                return m;
            }
        }
        return null;
    }

    // Record contribution
    public void recordContribution(String name, double amount) 
    {
        Member m = findMember(name);

        if (m == null) 
        {
            throw new IllegalArgumentException("Member not found");
        }

        m.contribute(amount);
        totalSavings += amount;
    }

    // Get total savings
    public double getTotalSavings() 
    {
        return totalSavings;
    }

    // Get members
    public List<Member> getMembers() 
    {
        return members;
    }

    // Handle payout
    public Payout makePayout() 
    {
        if (members.isEmpty()) 
        {
            throw new IllegalStateException("No members available");
        }

        int index = payouts.size() % members.size();
        Member receiver = members.get(index);

        Payout payout = new Payout(receiver, totalSavings);
        payouts.add(payout);

        totalSavings = 0; // reset after payout
        return payout;
    }

    public List<Payout> getPayouts() 
    {
        return payouts;
    }
}
