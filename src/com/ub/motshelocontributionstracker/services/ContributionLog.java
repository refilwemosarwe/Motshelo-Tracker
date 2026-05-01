package com.ub.motshelocontributionstracker.services;

import java.util.ArrayList;
import java.util.List;

// Keeps a running record of all contributions made in the group
public class ContributionLog
{
    
    private List<Contribution> contributions; // the list that stores every contribution recorded

        public ContributionLog()
        {
            this.contributions = new ArrayList<>();
        }
    
        
        public void addContribution(Contribution contribution)
        {
            if (contribution == null)
            {
                throw new IllegalArgumentException("Contribution cannot be null");  // Rejects invalid entries being recorded
            }
            contributions.add(contribution); // Adds a contribution to the log
        }
    
        
        public List<Contribution> getContributions()
        {
            return contributions; // Returns the full list of contributions recorded so far
        }
    
        // Adds up all contribution amounts and returns the grand total
        public double getTotalAmount()
        {
            return contributions.stream()
                                .mapToDouble(Contribution::getAmount) 
                                .sum();
        }
    
        
        @Override
        public String toString()
        {
            StringBuilder sb = new StringBuilder("Contribution Log:\n");
            for (Contribution c : contributions)
            {
                sb.append(c).append("\n");
            }
            sb.append("Total: ").append(getTotalAmount());
            return sb.toString(); // Returns a summary of all contributions and the total
        }
}
