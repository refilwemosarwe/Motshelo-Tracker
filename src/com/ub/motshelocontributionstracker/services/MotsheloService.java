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

    // Find member by ID (more reliable than name search)
    public Member findMemberById(int id)
    {
        for (Member m : members)
        {
            if (m.getMemberId() == id)
            {
                return m;
            }
        }
        return null;
    }

    // Find member by name (case-insensitive)
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

    /**
     * Records a contribution for a member found by name.
     * FIX: now calls m.addContribution() which delegates to Person.contribute(),
     * so getTotalContributions() always returns the correct running total.
     * Previously called m.contribute() directly but Member overrides getTotalContributions()
     * from Person, causing the displayed value to always be 0.
     */
    public void recordContribution(String name, double amount)
    {
        Member m = findMember(name);

        if (m == null)
        {
            throw new IllegalArgumentException("Member not found: " + name);
        }

        m.addContribution(amount); // FIX: was m.contribute(amount) — wrong method
        totalSavings += amount;
    }

    // Overload: record contribution by member ID
    public void recordContribution(int memberId, double amount)
    {
        Member m = findMemberById(memberId);

        if (m == null)
        {
            throw new IllegalArgumentException("Member not found with ID: " + memberId);
        }

        m.addContribution(amount);
        totalSavings += amount;
    }

    public double getTotalSavings()
    {
        return totalSavings;
    }

    /**
     * Returns the LIVE list — not a copy.
     * Report must hold a reference to this same list so it always reflects
     * current members and never shows a stale snapshot.
     */
    public List<Member> getMembers()
    {
        return members;
    }

    public List<Payout> getPayouts()
    {
        return payouts;
    }

    public Payout makePayout()
    {
        if (members.isEmpty())
        {
            throw new IllegalStateException("No members available");
        }

        if (totalSavings <= 0)
        {
            throw new IllegalStateException("No savings available to pay out");
        }

        int index = payouts.size() % members.size();
        Member receiver = members.get(index);

        Payout payout = new Payout(receiver, totalSavings);
        payouts.add(payout);

        totalSavings = 0; // reset after payout
        return payout;
    }
}
