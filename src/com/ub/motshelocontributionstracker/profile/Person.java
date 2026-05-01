package com.ub.motshelocontributionstracker.profile;

public class Person
{
    private String name;  // the person's full name
    private String phoneNumber; // contact number
    private double totalContributions; // total amount contributed so far

        public Person(String name, String phoneNumber, double totalContributions) // Creates a new Person
        { 
            if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be blank."); //rejects blank names
            if (phoneNumber == null || phoneNumber.isBlank()) throw new IllegalArgumentException("Phone number is cannot be blank."); // rejects blank phone numbers
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.totalContributions = totalContributions;
        }

            public String getName()
            {
                return name; // Returns the person's name
            }
        
            public String getPhoneNumber()
            {
                return phoneNumber; // Returns the person's phone number
            }
        
            public double getTotalContributions()
            {
                return totalContributions; // Returns the total amount this person has contributed
            }
    
        public void contribute(double amount)
        {
            if (amount > 0)
            {
                totalContributions += amount; // Adds a contribution amount to the total
            }
        }
}
