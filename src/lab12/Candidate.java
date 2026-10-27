package lab12;

import java.util.Scanner;

public class Candidate {
    private String surname;
    private String birthDate;
    private int votes;

    private static Candidate[] candidates;
    private static int totalVoters;

    static {
        candidates = new Candidate[] {
                new Candidate("Иванов И.И.", "12.05.1980", 120),
                new Candidate("Петров П.П.", "23.08.1975", 95),
                new Candidate("Сидоров С.С.", "01.01.1990", 60)
        };
        totalVoters = 300;
    }

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

    public static int getTotalVoters() { return totalVoters; }

    public static void setTotalVoters(int totalVoters) {
        if (totalVoters <= 0) System.out.println("Недопустимое значение !");
        else Candidate.totalVoters = totalVoters;
    }

    public static void fillCandidates() {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Введите общее количество избирателей=> ");
        totalVoters = sc.nextInt();
        System.out.println("Введите количество кандидатов=> ");
        int n = sc.nextInt();
        candidates = new Candidate[n];
        System.out.println("Введите информацию о кандидатах: ");
        for (int i = 0; i < candidates.length; i++) {
            System.out.println("Кандидат " + (i + 1) + "=>");
            candidates[i] = new Candidate();
        }
    }

    public static void printCandidates() {
        System.out.println("\nХарактеристики кандидатов:");
        for (int i = 0; i < candidates.length; i++) {
            System.out.println(candidates[i]);
        }
    }
    public static void checkViolations() {
        int sumVotes = 0;
        for (int i = 0; i < candidates.length; i++) {
            sumVotes += candidates[i].getVotes();
        }
        System.out.println("\nСумма голосов всех кандидатов = " + sumVotes);
        System.out.println("Общее количество избирателей = " + totalVoters);
        if (sumVotes > totalVoters)
            System.out.println(">>> Обнаружены нарушения в ходе выборов !");
        else
            System.out.println(">>> Нарушений не выявлено.");
    }
}