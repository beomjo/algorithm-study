import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] d = new long[n + 1][10];
        long mod = 1_000_000_000L;

        for (int i = 1; i <= 9; i++) d[1][i] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    d[i][j] = (d[i - 1][j + 1]) % mod;
                } else if (j == 9) {
                    d[i][j] = (d[i - 1][j - 1]) % mod;
                } else {
                    d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % mod;
                }
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) result += d[n][i];
        System.out.println(result % mod);
    }
}
