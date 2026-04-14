package com.ub.motshelocontributionstracker.profile;

public class Person
{
    private String name;
    private String phoneNumber;
    private double totalContributions;

        public Person(String name, String phoneNumber, double totalContributions)
        { 
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.totalContributions = totalContributions;
        }

            public String getName()
            {
                return name;
            }
        
            public String getPhoneNumber()
            {
                return phoneNumber;
            }
        
            public double getTotalContributions()
            {
                return totalContributions;
            }
    
        public void contribute(double amount)
        {
            if (amount > 0)
            {
                totalContributions += amount;
            }
        }
}
