package com.voting;

import java.util.Scanner;

public class VotingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("        ONLINE VOTING SYSTEM     ");
            System.out.println("=================================");
            System.out.println("1. Add Candidate");
            System.out.println("2. View Candidates");
            System.out.println("3. Cast Vote");
            System.out.println("4. View Results");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("❌ Please enter a valid number.");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Add Candidate ---");

                    System.out.print("Enter Candidate ID: ");
                    int id = sc.nextInt();

                    sc.nextLine(); // consume leftover newline

                    System.out.print("Enter Candidate Name: ");
                    String name = sc.nextLine();

                    boolean added = AddCandidate.addCandidate(id, name);

                    if (added) {
                        System.out.println("✅ Candidate added successfully!");
                    } else {
                        System.out.println("❌ Failed! ID already exists or name is invalid.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Candidate List ---");
                    AddCandidate.displayCandidates(); // Move method inside AddCandidate
                    break;

                case 3:
                    System.out.println("\n--- Cast Vote ---");

                    // Show candidates before voting
                    AddCandidate.displayCandidates();

                    if (AddCandidate.getCandidates().isEmpty()) {
                        break;
                    }

                    System.out.print("Enter Voter ID: ");
                    int voterId = sc.nextInt();

                    System.out.print("Enter Candidate ID: ");
                    int cid = sc.nextInt();

                    boolean voteCast = CastVote.castVote(voterId, cid);

                    if (voteCast) {
                        System.out.println("✅ Vote cast successfully!");
                    } else {
                        System.out.println("❌ Vote failed! Either voter already voted or candidate does not exist.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Voting Results ---");
                    CountVotes.displayResults();
                    System.out.println("---------------------------------");
                    System.out.println("🏆 Winner: " + CountVotes.declareWinner());
                    break;

                case 5:
                    System.out.println("\nThank you for using the Online Voting System!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}