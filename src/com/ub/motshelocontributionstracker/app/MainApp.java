package com.ub.motshelocontributionstracker;

import com.ub.motshelocontributionstracker.services.MotsheloGroup;
import com.ub.motshelocontributionstracker.services.MotsheloService;
import com.ub.motshelocontributionstracker.services.Report;

import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        MotsheloService service = new MotsheloService();
        MotsheloGroup   group   = new MotsheloGroup("My Motshelo");

        // Report holds the LIVE service — members added later still appear
        Report report = new Report(service, group);

        boolean running = true;

        while (running)
        {
            System.out.println("\n========== MOTSHELO MENU ==========");
            System.out.println("1. Add member");
            System.out.println("2. Record contribution");
            System.out.println("3. Show all members");
            System.out.println("4. Show member contributions");
            System.out.println("5. Show total contributions");
            System.out.println("6. Show payout history");
            System.out.println("7. Show next recipient");
            System.out.println("8. Process payout");
            System.out.println("9. Group summary");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice)
            {
                case 1:
                    System.out.print("Enter member ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    report.addMember(id, name, phone);
                    break;

                case 2:
                    System.out.print("Enter member name: ");
                    String cName = scanner.nextLine();
                    System.out.print("Enter amount (P): ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    report.recordContribution(cName, amount);
                    break;

                case 3:
                    report.showAllMembers();
                    break;

                case 4:
                    report.showMemberContributions();
                    break;

                case 5:
                    report.showTotalContributions();
                    break;

                case 6:
                    report.showPayouts();
                    break;

                case 7:
                    report.showNextRecipient();
                    break;

                case 8:
                    report.processPayout();
                    break;

                case 9:
                    report.showGroupSummary();
                    break;

                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
