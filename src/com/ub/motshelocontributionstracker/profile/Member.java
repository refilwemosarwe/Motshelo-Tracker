package com.ub.motshelocontributionstracker.profile;

public class Member extends Person

{
    private int memberId;
    private double totalContributions = 0;

    public Member(int memberId, String name, String phoneNumber, double totalContributions)
    {
        super(name, phoneNumber, totalContributions);

        this.memberId = memberId;
    }

    public int getMemberId(){
        return memberId;
    }
    public void addContribution(double amount)
    {
        totalContributions += amount;
    }
    public double getTotalContributions()
    {
        return totalContributions;
    }

    @Override
    public String toString()
    {
        return "ID: " + getMemberId() + " | Name: " + getName() + " | Total: P" + getTotalContributions();
    }
}
