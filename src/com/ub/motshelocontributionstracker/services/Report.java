package com.ub.motshelocontributionstracker.services;

import com.ub.motshelocontributionstracker.profile.Member;
import com.ub.motshelocontributionstracker.services.Payout;
import com.ub.motshelocontributionstracker.services.MotsheloGroup;

import java.util.List;

public class Report 
{
    private List<Member> members;
    private List<Payout> payouts;
    private MotsheloGroup group;
    
    public Report(List<Member> members, List<Payout> payouts, MotsheloGroup group) 
    {
        this.members = members;
        this.payouts = payouts;
        this.group = group;
    }

    public void showAllMembers() 
    {
        System.out.println("\n=== MEMBERS LIST ===");
        for (Member m : members) 
        {
            System.out.println(m); // Prints every member's summary
        }
    }

    public void showMemberContributions() 
    {
        System.out.println("\n=== MEMBER CONTRIBUTIONS ===");
        for (Member m : members) 
        {
            System.out.println(m.getName() + ": P" + m.getTotalContributions()); // Prints each member's name and how much they have contributed
        }
    }

    public double calculateTotalContributions() 
    {
        double total = 0;

        for (Member m : members) 
        {
            total += m.getTotalContributions(); // Adds up contributions from all members
        }

        return total; // Returns the grand total
    }

    public void showTotalContributions() 
    {
        System.out.println("\n=== TOTAL CONTRIBUTIONS ===");
        System.out.println("Total: P" + calculateTotalContributions()); // Prints the total of all contributions made across all members
    }

    public void showPayouts() 
    {
        System.out.println("\n=== PAYOUT HISTORY ===");

        if (payouts.isEmpty()) 
        {
            System.out.println("No payouts yet."); // Prints if no payouts have been made yet
            return;
        }

        for (Payout p : payouts) 
        {
            System.out.println(p); // Prints the full payout history
        }
    }

    public void showNextRecipient() 
    {
        System.out.println("\n=== NEXT RECIPIENT ===");

        if (members.isEmpty()) 
        {
            System.out.println("No members available.");
            return; // Shows who is next in line to receive a payout based on the group's rotation
        }
        
        Member next = group.getNextPayoutMember();

        System.out.println("Next: " + next.getName() + " (ID: " + next.getMemberId() + ")");
    }
}
