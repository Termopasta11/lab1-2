package lab12;

public class CandidateService {
    public static void printCandidates() {
        System.out.println("\nХарактеристики кандидатов:");
        for (Candidate c : Candidate.getCandidates()) System.out.println(c);
    }
    public static void checkViolations() {
        int sumVotes = 0;
        for (Candidate c : Candidate.getCandidates()) sumVotes += c.getVotes();
        System.out.println("\nСумма голосов всех кандидатов = " + sumVotes);
        System.out.println("Общее количество избирателей = " + Candidate.getTotalVoters());
        if (sumVotes > Candidate.getTotalVoters())
            System.out.println(">>> Обнаружены нарушения в ходе выборов !");
        else
            System.out.println(">>> Нарушений не выявлено.");
    }
}
