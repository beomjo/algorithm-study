/*
 * Z
 * https://www.acmicpc.net/problem/1074
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(solve(n, r, c));
    }

    private static int solve(int n, int r, int c) {
        if (n == 0) return 0;
        int half = 1 << (n - 1);
        if (r < half && c < half) return solve(n - 1, r, c);
        if (r < half && c >= half) return half * half + solve(n - 1, r, c - half);
        if (r >= half && c < half) return 2 * half * half + solve(n - 1, r - half, c);
        return 3 * half * half + solve(n - 1, r - half, c - half);
    }
}