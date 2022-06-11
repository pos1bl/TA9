public class Main {
    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        ShortestCommonSubsequence shortestCommonSubsequence = new ShortestCommonSubsequence();
        LevenshteinDistanceDP levenshteinDistanceDP = new LevenshteinDistanceDP();
        Corruption corruption = new Corruption();
        String s = "blueberry";
        String t = "blackberry";
        int m = s.length() - 1;
        int n = t.length() - 1;
        System.out.println("Sequence1: " + s + ", Sequence2: " + t);
        System.out.println("1) The longest common subsequence: " + longestCommonSubsequence.commonSubsequence(s, t, m, n));
        System.out.println("2) The shortest common subsequence: " + shortestCommonSubsequence.commonSubsequence(s, t, m, n));
        System.out.println("3) Levenshtein distance: " + levenshteinDistanceDP.compute_Levenshtein_distanceDP(s, t));
        System.out.println("Money, left on the account : " + corruption.corruption(100, 2));

    }
}
