package com.ub.motshelocontributionstracker.profile;

public class Member extends Person

{
    private int memberId;
    private double totalContributions = 0;

    public Member(int memberId, String name, String phoneNumber)
    {
        super(name, phoneNumber);
        this.memberId = memberId;
    }

    public int getMemberId(){
        return memberId;
    }
    public void addContribution(double amount)
    {
        totalContributions += amount; // Adds an amount to this member's total contributions
    }
    public double getTotalContributions()
    {
        return totalContributions; // Returns the total amount this member has contributed so far
    }

    @Override
    public String toString()
    {
        return "ID: " + getMemberId() + " | Name: " + getName() + " | Total: P" + getTotalContributions(); // Shows summary ofthis member's details
    }
}
