/*
 * 제곱수의 합
 * https://www.acmicpc.net/problem/1699
 */

import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n + 1]; // 최소항의 개수

        for (int i = 1; i <= n; i++) {
            d[i] = i;
            for (int j = 1; j * j <= i; j++) {
                d[i] = Math.min(d[i], d[i - j * j] + 1);
            }
        }

        sc.close();
        System.out.println(d[n]);
    }
}