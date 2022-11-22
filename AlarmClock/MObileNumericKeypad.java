import java.util.Arrays;

public class MObileNumericKeypad {

    static long[][] dp;
    static int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { -1, 0, -1 } };

    public static long solve(int i, int j, int n) {
        if (n == 1)
            return 1;
        if (dp[mat[i][j]][n] != -1)
            return dp[mat[i][j]][n];
        long a = solve(i, j, n - 1);
        long b = 0, c = 0, d = 0, e = 0;
        if (j - 1 >= 0 && mat[i][j - 1] != -1)
            b = solve(i, j - 1, n - 1);
        if (j + 1 < 3 && mat[i][j + 1] != -1)
            c = solve(i, j + 1, n - 1);
        if (i - 1 >= 0 && mat[i - 1][j] != -1)
            d = solve(i - 1, j, n - 1);
        if (i + 1 < 4 && mat[i + 1][j] != -1)
            e = solve(i + 1, j, n - 1);
        return dp[mat[i][j]][n] = a + b + c + d + e;
    }

    public static long getCount(int N) {
        dp = new long[10][N + 1];
        for (long[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(mat.length + " " + mat[0].length);
        long ans = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (mat[i][j] != -1) {
                    ans += solve(i, j, N);
                }
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(getCount(4));
    }

}
