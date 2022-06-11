import Interfaces.CommonSubsequence;
import java.util.ArrayList;
import java.util.List;

public class ShortestCommonSubsequence implements CommonSubsequence {
    public List<String> commonSubsequence(String s, String t, int m, int n) {
        ArrayList<String> result = new ArrayList<>();
        int[][] table = new int[m + 2][n + 2];
        int tableMin = 10000;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    table[i + 1][j + 1] = table[i][j] + 1;
                    if (table[i + 1][j + 1] < tableMin) {
                        tableMin = table[i + 1][j + 1];
                    }
                }
            }

        }
        int index = tableMin;
        int temp = index;
        char[] scs = new char[index];
        int i = 0, j = 0;
        StringBuilder shortest = new StringBuilder();
        while(i <= m && j <= n){
            if(index > 0) {
                if (s.charAt(i) == t.charAt(j)) {
                    scs[index - 1] = s.charAt(i);
                    i = 10000;
                    j = 10000;
                    index--;
                } else if (table[i][j + 1] > table[i + 1][j])
                    i++;
                else
                    j++;
            }
            else{
                i = m+1;
                j= n +1;
            }
        }
        for(int k=0; k<temp; k++){
            if (scs[k] != '\u0000') {
                shortest.append(scs[k]);
            }
        }
        result.add(shortest.toString());
        result.add(String.valueOf(tableMin));

        return result;
    }
}
