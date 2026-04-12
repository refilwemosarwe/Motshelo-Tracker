

public class Member {
    private String memberId;
    private double totalContributions;

    public Member(String memberId) {
        this.memberId = memberId;
        this.totalContributions = 0.0;
    }

    public String getMemberId() {
        return memberId;
    }

    public double getTotalContributions() {
        return totalContributions;
    }

    public void contribute(double amount) {
        if (amount > 0) {
            totalContributions = amount;
        }
    }
}
