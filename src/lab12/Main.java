package lab12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        cycle: while (true) {
            System.out.println("1. Заполнить массив");
            System.out.println("2. Распечатать");
            System.out.println("6. Выход");
            System.out.println("Выберете пункт меню (1..6)");
            int c = (new Scanner(System.in)).nextInt();
            switch (c) {
                case 1: Candidate.fillCandidates(); break;
                case 2: Candidate.printCandidates(); break;
                default: break cycle;
            }
        }
    }
}