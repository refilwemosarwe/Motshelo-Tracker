package com.ub.motshelocontributionstracker.app;

import com.ub.motshelocontributionstracker.profile.Member;
import com.ub.motshelocontributionstracker.profile.Person;
import com.ub.motshelocontributionstracker.services.Contribution;
import com.ub.motshelocontributionstracker.services.ContributionLog;
import com.ub.motshelocontributionstracker.services.Payout;
import com.ub.motshelocontributionstracker.services.MotsheloGroup;
import com.ub.motshelocontributionstracker.services.Report;
    
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp
{

    private static List<Member> members = new ArrayList<>();
    private static double totalSavings = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("== Motshelo Savings Group Tracker ==");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Member");
            System.out.println("2. Record Contribution");
            System.out.println("3. View Total Savings");
            System.out.println("4. View Member Contributions");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // nextline

            switch (choice) {
                case 1:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter phone number: ");
                    String phone = scanner.nextLine();
                    Member newMember = new Member(name, phone);
                    group.addMember(newMember);
                    members.add(new Member(1, name, "default", 0.0));
                    System.out.println(name + " added successfully.");
                    break;

                case 2:
                    System.out.print("Enter member name: ");
                    String contributor = scanner.nextLine();
                    System.out.print("Enter contribution amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    Member member = findMember(contributor);
                    if (member != null) {
                        member.contribute(amount);
                        totalSavings += amount;
                        System.out.println("Contribution recorded for " + contributor);
                    } else {
                        System.out.println("Error,member not found.");
                    }
                    break;

                case 3:
                    System.out.println("Total Savings: P" + totalSavings);
                    break;

                case 4:
                    for (Member m : members) {
                        System.out.println(m.getName() + " contributed: P" + m.getTotalContributions());
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("You're now exiting Motshelo Tracker. Thank you for passing by!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    private static Member findMember(String name) {
        for (Member m : members) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }
}
