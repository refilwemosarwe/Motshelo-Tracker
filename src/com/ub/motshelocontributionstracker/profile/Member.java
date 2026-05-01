package com.ub.motshelocontributionstracker.profile;

public class Member extends Person
{
    private int memberId;

    public Member(int memberId, String name, String phoneNumber)
    {
        super(name, phoneNumber, 0.0);
        this.memberId = memberId;
    }

    public int getMemberId()
    {
        return memberId;
    }

    /**
     * Delegates to Person.contribute() — the single source of truth for contributions.
     * The old separate totalContributions field in Member has been removed to prevent
     * the split-field bug where addContribution() and contribute() updated different variables.
     */
    public void addContribution(double amount)
    {
        contribute(amount); // delegates to Person — no more duplicate field
    }

    @Override
    public String toString()
    {
        return "ID: " + getMemberId()
             + " | Name: " + getName()
             + " | Total: P" + getTotalContributions();
    }
}
