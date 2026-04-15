package com.ub.motshelocontributionstracker.services;

import com.ub.motshelocontributionstracker.profile.Member;
import java.util.List;

public class Report 
{
    private List<Member> members;
    private List<Payout> payouts;

    public Report(List<Member> members, List<Payout> payouts) 
    {
        this.members = members;
        this.payouts = payouts;
    }

    public void showAllMembers() 
    {
        System.out.println("\n=== MEMBERS LIST ===");
        for (Member m : members) 
        {
            System.out.println(m);
        }
    }

    public void showMemberContributions() 
    {
        System.out.println("\n=== MEMBER CONTRIBUTIONS ===");
        for (Member m : members) 
        {
            System.out.println(m.getName() + ": P" + m.getTotalContributions());
        }
    }

    public double calculateTotalContributions() 
    {
        double total = 0;

        for (Member m : members) 
        {
            total += m.getTotalContributions();
        }

        return total;
    }

    public void showTotalContributions() 
    {
        System.out.println("\n=== TOTAL CONTRIBUTIONS ===");
        System.out.println("Total: P" + calculateTotalContributions());
    }

    public void showPayouts() 
    {
        System.out.println("\n=== PAYOUT HISTORY ===");

        if (payouts.isEmpty()) 
        {
            System.out.println("No payouts yet.");
            return;
        }

        for (Payout p : payouts) 
        {
            System.out.println(p);
        }
    }

    (simple rotation logic)
    public void showNextRecipient() 
    {
        System.out.println("\n=== NEXT RECIPIENT ===");

        if (members.isEmpty()) 
        {
            System.out.println("No members available.");
            return;
        }

        int index = payouts.size() % members.size();
        Member next = members.get(index);

        System.out.println("Next: " + next.getName() + " (ID: " + next.getMemberId() + ")");
    }
}