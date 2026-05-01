package com.ub.motshelocontributionstracker.services;

import com.ub.motshelocontributionstracker.profile.Member;

import java.util.List;

/**
 * Report acts as the single delegate between Main menu cases and the service layer.
 * It holds a reference to the LIVE MotsheloService so members and contributions
 * are never stale — adding a member after Report is constructed still shows up.
 */
public class Report
{
    private MotsheloService service;
    private MotsheloGroup group;

    /**
     * FIX: Report no longer stores its own copies of members/payouts lists.
     * It holds the service reference so it always reads live data.
     * Previously, Report stored List<Member> members at construction time,
     * so any member added afterward was invisible to the report.
     */
    public Report(MotsheloService service, MotsheloGroup group)
    {
        this.service = service;
        this.group = group;
    }

    // ----------------------------------------------------------------
    // MENU CASE 1 — Add a member
    // ----------------------------------------------------------------
    public void addMember(int id, String name, String phone)
    {
        Member m = new Member(id, name, phone);
        service.addMember(m);
        group.addMember(m);   // keep MotsheloGroup rotation in sync
        System.out.println("Member added: " + m);
    }

    // ----------------------------------------------------------------
    // MENU CASE 2 — Record a contribution
    // ----------------------------------------------------------------
    public void recordContribution(String name, double amount)
    {
        service.recordContribution(name, amount);
        System.out.println("Contribution of P" + amount + " recorded for " + name + ".");
    }

    // Overload: record by member ID
    public void recordContribution(int memberId, double amount)
    {
        service.recordContribution(memberId, amount);
        System.out.println("Contribution of P" + amount + " recorded for member ID " + memberId + ".");
    }

    // ----------------------------------------------------------------
    // MENU CASE 3 — Show all members
    // ----------------------------------------------------------------
    public void showAllMembers()
    {
        List<Member> members = service.getMembers(); // always live
        System.out.println("\n=== MEMBERS LIST ===");

        if (members.isEmpty())
        {
            System.out.println("No members registered yet.");
            return;
        }

        for (Member m : members)
        {
            System.out.println(m);
        }
    }

    // ----------------------------------------------------------------
    // MENU CASE 4 — Show each member's contribution total
    // ----------------------------------------------------------------
    public void showMemberContributions()
    {
        List<Member> members = service.getMembers();
        System.out.println("\n=== MEMBER CONTRIBUTIONS ===");

        if (members.isEmpty())
        {
            System.out.println("No members registered yet.");
            return;
        }

        for (Member m : members)
        {
            System.out.println(m.getName() + ": P" + m.getTotalContributions());
        }
    }

    // ----------------------------------------------------------------
    // MENU CASE 5 — Show group total savings
    // ----------------------------------------------------------------
    public void showTotalContributions()
    {
        System.out.println("\n=== TOTAL CONTRIBUTIONS ===");
        System.out.println("Group total savings: P" + service.getTotalSavings());
    }

    // ----------------------------------------------------------------
    // MENU CASE 6 — Show payout history
    // ----------------------------------------------------------------
    public void showPayouts()
    {
        List<Payout> payouts = service.getPayouts();
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

    // ----------------------------------------------------------------
    // MENU CASE 7 — Show who receives the next payout
    // ----------------------------------------------------------------
    public void showNextRecipient()
    {
        System.out.println("\n=== NEXT RECIPIENT ===");

        if (service.getMembers().isEmpty())
        {
            System.out.println("No members available.");
            return;
        }

        Member next = group.getNextPayoutMember();
        System.out.println("Next: " + next.getName() + " (ID: " + next.getMemberId() + ")");
    }

    // ----------------------------------------------------------------
    // MENU CASE 8 — Process a payout
    // ----------------------------------------------------------------
    public void processPayout()
    {
        try
        {
            Payout payout = service.makePayout();
            group.moveToNextMember(); // advance the rotation in MotsheloGroup
            System.out.println("\n=== PAYOUT PROCESSED ===");
            System.out.println(payout);
        }
        catch (IllegalStateException e)
        {
            System.out.println("Payout failed: " + e.getMessage());
        }
    }

    // ----------------------------------------------------------------
    // MENU CASE 9 — Full group summary
    // ----------------------------------------------------------------
    public void showGroupSummary()
    {
        System.out.println("\n=== GROUP SUMMARY ===");
        System.out.println(group);
        showTotalContributions();
        showNextRecipient();
    }
}
