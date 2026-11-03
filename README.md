package lab12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        cycle: while (true) {
            System.out.println("1. Заполнить массив");
            System.out.println("2. Распечатать");
            System.out.println("3. Проверить нарушения в ходе выборов");
            System.out.println("4. Проверить необходимость повторных выборов");
            System.out.println("5. Упорядочить кандидатов по убыванию голосов");
            System.out.println("6. Выход");
            System.out.println("Выберете пункт меню (1-6)");
            int c = (new Scanner(System.in)).nextInt();
            switch (c) {
                case 1: CandidateService.fillCandidates(); break;
                case 2: CandidateService.printCandidates(); break;
                case 3: CandidateService.checkViolations(); break;
                case 4: CandidateService.checkRepeatElection(); break;
                case 5: CandidateService.sortByVotesDesc(); break;
                default: break cycle;
            }
        }
    }
}



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
    public static Candidate searchBySurname(String surname) {
        System.out.println("Поиск кандидата: " + surname);
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i].getSurname().equals(surname)) {
                return candidates[i];
            }
        }
        return null;
    }
    public static boolean removeBySurname(String surname) {
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i].getSurname().equalsIgnoreCase(surname)) {
                Candidate[] n = new Candidate[candidates.length - 1];
                for (int j = 0, k = 0; j < candidates.length; j++)
                    if (j != i) n[k++] = candidates[j];
                candidates = n;
                return true;
            }
        }
        return false;
    }
    public static int count() {
        return candidates.length;
    }
}



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
        else if (value.matches("[аzA-Za-яА-Я-]+")) System.out.println("НЕдопустимое значение!");
        else this.surname = value;
    }

    public String getBirthDate() { return birthDate; }

    public void setBirthDate(String birthDate) {
        if (birthDate.isEmpty() || !birthDate.matches("[0-9]{2}\\[0-9]{2}\\[0-9]{4}")) System.out.println("Недопустимое значение !");
        else this.birthDate = birthDate;
    }


    public int getVotes() { return votes; }

    public void setVotes(int votes) {
        if (votes < 0 || votes > 1000000) System.out.println("Недопустимое значение !");
        else this.votes = votes;
    }

}
