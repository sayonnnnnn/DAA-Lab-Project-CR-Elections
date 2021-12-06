import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.LinkedList;

class Candidate{
    long regNo;
    String name, branch;
    int age;
    Candidate(long regNo, String name, String branch, int age){
        this.regNo = regNo;
        this.name = name;
        this.branch = branch;
        this.age = age;
    }
}

class Voter{
    long voterId;
    String name;
    Voter(long voterId, String name){
        this.voterId = voterId;
        this.name = name;
    }
}

class CRElection {

    HashMap<Voter, Candidate> election = new HashMap<Voter, Candidate>();
    ArrayList<Voter> voters = new ArrayList<Voter>();
    ArrayList<Candidate> candidates = new ArrayList<Candidate>(3);
    LinkedList<Voter> candidateOne = new LinkedList<Voter>();
    LinkedList<Voter> candidateTwo = new LinkedList<Voter>();
    LinkedList<Voter> candidateThree = new LinkedList<Voter>();

    private void printElectionStats(){
        election.forEach((voter, candidate) -> {
            System.out.println(voter.name+" with Voter ID of "+voter.voterId+" voted for "+candidate.name+" of branch "+candidate.branch);
        });
    }

    public void listOfVoters(){
        Voter voter1 = new Voter(199302079, "Tarang Shivraj Jaiswal");
        Voter voter2 = new Voter(199302080, "Suhas Deshpande");
        Voter voter3 = new Voter(199302081, "Rachit Mittal");
        Voter voter4 = new Voter(199302082, "Jatin Garg");
        Voter voter5 = new Voter(199302083, "Ankita Kashyap");
        Voter voter6 = new Voter(199302084, "Koyel Roy");
        Voter voter7 = new Voter(199302085, "Doyel Roy");
        Voter voter8 = new Voter(199302086, "Aravind Kanamarlapudi");
        Voter voter9 = new Voter(199302087, "Zaheen Munshi");
        Voter voter10 = new Voter(199302089, "Kavisha Mehta");
        voters.add(voter1);
        voters.add(voter2);
        voters.add(voter3);
        voters.add(voter4);
        voters.add(voter5);
        voters.add(voter6);
        voters.add(voter7);
        voters.add(voter8);
        voters.add(voter9);
        voters.add(voter10);
    }

    Candidate candidate1 = new Candidate(199303111, "Sayon Sai Dutta", "CCE", 20);
    Candidate candidate2 = new Candidate(199301117, "Mann Bajpai", "CSE", 20);
    Candidate candidate3 = new Candidate(199301009, "Shubham Tripathi", "CSE", 22);

    public void voteForCandidate(){
        // listOfVoters();
        Scanner scan = new Scanner(System.in);
        String voterName; long voterID, candidateID;
        System.out.println("What is your Name: ");
        voterName = scan.nextLine();
        System.out.println("Please enter your voter ID: ");
        voterID = scan.nextLong();
        System.out.println("Assigning voter to the list of voters . . .");
        Voter newVoter = new Voter(voterID, voterName);
        voters.add(newVoter);
        System.out.println("Whom do you wanna vote for??");
        candidateID = scan.nextLong();
        if (candidateID == 199303111){
            election.put(newVoter, candidate1);
        }else if(candidateID == 199301117){
            election.put(newVoter, candidate2);
        }else if(candidateID == 199301009){
            election.put(newVoter, candidate3);
        }else{
            System.out.println("INVALID VOTER ID ENTERED!!");
        }
    }

    public void staticAssigningOfVotes(){
        listOfVoters();
        election.put(voters.get(0), candidate1);
        election.put(voters.get(1), candidate1);
        election.put(voters.get(2), candidate2);
        election.put(voters.get(3), candidate3);
        election.put(voters.get(4), candidate3);
        election.put(voters.get(5), candidate2);
        election.put(voters.get(6), candidate2);
        election.put(voters.get(7), candidate2);
        election.put(voters.get(8), candidate3);
        election.put(voters.get(9), candidate2);
    }
    // The following function traverses through the HashMap and then creates a LinkedList for each and every candidate
    // and finds the winner candidate based upon the maximum length of the LinkedList
    public int winnerCandidate(){
        election.forEach((voter, candidate) -> {
            if(candidate == candidate1){
                candidateOne.addLast(voter);
            }else if(candidate == candidate2){
                candidateTwo.addLast(voter);
            }else if(candidate == candidate3){
                candidateThree.addLast(voter);
            }
        });

        if(candidateOne.size() > candidateTwo.size()){
            if(candidateOne.size() > candidateThree.size()){
                return 1;
            }else{
                return 3;
            }
        }else {
            if(candidateTwo.size() > candidateThree.size()){
                return 2;
            }else {
                return 3;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Test ...");
        Scanner scan = new Scanner(System.in);
        CRElection electionBegins = new CRElection();
        electionBegins.staticAssigningOfVotes();
        int choice;
        do{
            System.out.println("Press-1 to get the Election Stats");
            System.out.println("Press-2 to vote for a candidate");
            System.out.println("Press-3 to check the winner candidate");
            System.out.println("Press any other number to exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            if(choice==1){
                electionBegins.printElectionStats();
            }else if(choice==2){
                electionBegins.voteForCandidate();
            }else if(choice==3){
                int winner = electionBegins.winnerCandidate();
                if (winner == 1){
                    System.out.println("Sayon Sai Dutta won the election!!");
                }else if(winner == 2){
                    System.out.println("Mann Bajpai won the election!!");
                }else if(winner == 3){
                    System.out.println("Shubham Tripathi won the election!!");
                }else{
                    System.out.println("YOU HAVE COMMITTED SOME KIND OF ERROR!!!");
                }
            }else{
                System.out.println("Exiting . . . . . . Thank you!");
            }
        }while(choice<4);
    }
}
