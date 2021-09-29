/*
 * 카드 구매하기
 * https://www.acmicpc.net/problem/11052
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n + 1];
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                d[i] = Math.max(d[i], d[i - j] + p[j]);
            }
        }
        System.out.println(d[n]);
        sc.close();
    }
}
