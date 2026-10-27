package lab12;

public class CandidateService {
    public static void printCandidates() {
        System.out.println("\nХарактеристики кандидатов:");
        for (Candidate c : Candidate.getCandidates()) System.out.println(c);
    }
}
