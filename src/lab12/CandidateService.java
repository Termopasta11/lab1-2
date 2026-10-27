package lab12;
import java.util.Scanner;

public class CandidateService {
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

    public static int getTotalVoters() { return totalVoters; }

    public static void setTotalVoters(int value) {
        if (value <= 0) System.out.println("Недопустимое значение !");
        else totalVoters = value;
    }
    public static void printCandidates() {
        System.out.println("\nХарактеристики кандидатов:");
        for (Candidate c : candidates) System.out.println(c);
    }
    public static void checkViolations() {
        int sumVotes = 0;
        for (Candidate c : candidates) sumVotes += c.getVotes();
        System.out.println("\nСумма голосов всех кандидатов = " + sumVotes);
        System.out.println("Общее количество избирателей = " + totalVoters);
        if (sumVotes > totalVoters)
            System.out.println(">>> Обнаружены нарушения в ходе выборов !");
        else
            System.out.println(">>> Нарушений не выявлено.");
    }
    public static void checkRepeatElection() {
        double threshold = totalVoters / 3.0;
        boolean hasLeader = false;
        for (Candidate c : candidates) {
            if (c.getVotes() > threshold) {
                hasLeader = true;
                break;
            }
        }
        System.out.println("\nПорог для победы (1/3 от " + totalVoters + ") = " + threshold);
        if (!hasLeader)
            System.out.println(">>> Требуется проведение повторных выборов !");
        else
            System.out.println(">>> Повторные выборы не требуются.");
    }
    public static void sortByVotesDesc() {
        Candidate[] arr = candidates;
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - 1 - i; j++)
                if (arr[j].getVotes() < arr[j + 1].getVotes()) {
                    Candidate rab = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = rab;
                }
        System.out.println("\nОтсортированный список по убыванию голосов:");
        for (Candidate c : arr) System.out.println(c);
    }
    public static void fillCandidates() {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Введите общее количество избирателей=> ");
        setTotalVoters(sc.nextInt());
        System.out.println("Введите количество кандидатов=> ");
        int n = sc.nextInt();
        Candidate[] arr = new Candidate[n];
        System.out.println("Введите информацию о кандидатах: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Кандидат " + (i + 1) + "=>");
            arr[i] = new Candidate();
        }
        candidates = arr;
    }
    public static Candidate findBySurname(String surname) {
        for (Candidate c : candidates)
            if (c.getSurname().equalsIgnoreCase(surname)) return c;
        return null;
    }
}
