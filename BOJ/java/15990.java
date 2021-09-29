/*
 * 1, 2, 3 더하기 5
 * https://www.acmicpc.net/problem/15990
 */

import java.util.Scanner;

class Main {
    static long[][] d = new long[100_001][4];
    static long mod = 1_000_000_009L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        d[1][1] = d[2][2] = d[3][3] = d[3][1] = d[3][2] = 1;

        while (t-- > 0) {
            int i = sc.nextInt();
            System.out.println((go(i, 1) + go(i, 2) + go(i, 3)) % mod);
        }
        sc.close();
    }

    static long go(int i, int num) {
        if (i <= 3 || d[i][num] != 0) {
            return d[i][num];
        }

        d[i][1] = (go(i - 1, 2) + go(i - 1, 3)) % mod;
        d[i][2] = (go(i - 2, 1) + go(i - 2, 3)) % mod;
        d[i][3] = (go(i - 3, 1) + go(i - 3, 2)) % mod;

        return d[i][num] % mod;
    }
}
