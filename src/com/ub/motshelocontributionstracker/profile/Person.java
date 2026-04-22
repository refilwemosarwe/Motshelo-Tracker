package com.ub.motshelocontributionstracker.profile;

public class Person
{
    private String name;
    private String phoneNumber;
    private double totalContributions;

        public Person(String name, String phoneNumber, double totalContributions)
        { 
            if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be blank.");
            if (phoneNumber == null || phoneNumber.isBlank()) throw new IllegalArgumentException("Phone number is cannot be blank.");
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
