package com.ub.motshelocontributionstracker.profile;

public class Member extends Person

{
    private int memberId;

    public Member(int memberId, String name, String phoneNumber, totalContribution)
    {
        super(name, phoneNumber, totalContributions);

        this.memberId = memberId;
    }

    public int getMemberId()
    {
        return memberId;
    }

    @Override
    public String toString()
    {
        return "ID: " + getMemberId() + " | Name: " + getName() + " | Total: P" + getTotalContributions();
    }
}
