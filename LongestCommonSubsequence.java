import Interfaces.CommonSubsequence;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence implements CommonSubsequence {
    public List<String> commonSubsequence(String s, String t, int m, int n) {
        ArrayList<String> result = new ArrayList<>();
        int[][] table = new int[m + 2][n + 2];
        int tableMax = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    table[i + 1][j + 1] = table[i][j] + 1;
                    if (table[i + 1][j + 1] > tableMax) {
                        tableMax = table[i + 1][j + 1];
                    }
                }
            }

        }
        int index = tableMax;
        int temp = index;
        char[] lcs = new char[index];
        int i = m, j = n;
        StringBuilder longest = new StringBuilder();
        while (i >= 0 && j >= 0) {
            if (index > 0) {
                if (s.charAt(i) == t.charAt(j)) {
                    lcs[index - 1] = s.charAt(i);
                    i--;
                    j--;
                    index--;
                } else if (table[i][j + 1] >= table[i + 1][j])
                    i--;
                else
                    j--;
            } else {
                i = -1;
                j = -1;
            }
        }
        for (int k = 0; k < temp; k++) {
            if (lcs[k] != '\u0000')
                longest.append(lcs[k]);
        }
        result.add(longest.toString());
        result.add(String.valueOf(tableMax));
        return result;
    }
}

