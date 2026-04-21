package com.ub.motshelocontributionstracker.services;

import java.util.ArrayList;
import java.util.List;

public class ContributionLog {
    private List<Contribution> contributions;

    public ContributionLog() {
        this.contributions = new ArrayList<>();
    }

    
    public void addContribution(Contribution contribution) {
        contributions.add(contribution);
    }

    
    public List<Contribution> getContributions() {
        return contributions;
    }

    
    public double getTotalAmount() {
        return contributions.stream()
                            .mapToDouble(Contribution::getAmount)
                            .sum();
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Contribution Log:\n");
        for (Contribution c : contributions) {
            sb.append(c).append("\n");
        }
        sb.append("Total: ").append(getTotalAmount());
        return sb.toString();
    }
}
