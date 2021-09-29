/*
 * 1로만들기
 * https://www.acmicpc.net/problem/1463
 */

import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] d = new int[10000001];
        int n = sc.nextInt();

        d[1] = 0;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
                d[i] = d[i / 2] + 1;
            }
            if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
                d[i] = d[i / 3] + 1;
            }
        }
        System.out.println(d[n]);
        sc.close();
    }
}