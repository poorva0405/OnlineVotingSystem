package com.voting;

import java.util.Scanner;

public class VotingApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Online Voting System ===");
            System.out.println("1. Add Candidate");
            System.out.println("2. Cast Vote");
            System.out.println("3. View Results");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Candidate ID: ");
                    int id = sc.nextInt();
                    System.out.print("Name: ");
                    String name = sc.next();
                    AddCandidate.addCandidate(id, name);
                    break;

                case 2:
                    System.out.print("Voter ID: ");
                    int voterId = sc.nextInt();
                    System.out.print("Candidate ID: ");
                    int cid = sc.nextInt();
                    CastVote.castVote(voterId, cid);
                    break;

                case 3:
                    CountVotes.displayResults();
                    System.out.println("Winner: " + CountVotes.declareWinner());
                    break;
            }
        } while (choice != 4);

        sc.close();
    }
}