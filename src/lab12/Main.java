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