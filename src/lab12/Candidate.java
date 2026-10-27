package lab12;

import java.util.Scanner;

public class Candidate {
    private String surname;
    private String birthDate;
    private int votes;

    private static Candidate[] candidates;
    private static int totalVoters;



    public Candidate(String surname, String birthDate, int votes) {
        this.surname = surname;
        this.birthDate = birthDate;
        this.votes = votes;
    }

    public Candidate() {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Фамилия : ");
        this.setSurname(sc.nextLine());
        System.out.print("\tДата рождения : ");
        this.setBirthDate(sc.nextLine());
        System.out.print("\tКоличество голосов : ");
        this.setVotes(sc.nextInt());
    }

    public String toString() {
        return String.format(" Кандидат: %s ==> дата рождения: %s \t голосов = %d ",
                surname, birthDate, votes);
    }

    public String getSurname() { return this.surname; }

    public void setSurname(String value) {
        if (value.isEmpty()) System.out.println("Недопустимое значение !");
        else this.surname = value;
    }

    public String getBirthDate() { return birthDate; }

    public void setBirthDate(String birthDate) {
        if (birthDate.isEmpty()) System.out.println("Недопустимое значение !");
        else this.birthDate = birthDate;
    }

    public int getVotes() { return votes; }

    public void setVotes(int votes) {
        if (votes < 0) System.out.println("Недопустимое значение !");
        else this.votes = votes;
    }

    public static void fillCandidates() {
        CandidateService.fillCandidates();
    }

    public static void printCandidates() {
        CandidateService.printCandidates();
    }
    public static void checkViolations() {
        CandidateService.checkViolations();
    }

    public static void checkRepeatElection() {
        CandidateService.checkRepeatElection();
    }
    public static void sortByVotesDesc() {
        CandidateService.sortByVotesDesc();
    }
}