/*
 * N과 M(1)
 * https://www.acmicpc.net/problem/15649
 */

import java.io.IOException;
import java.util.Scanner;

class Main {
    static boolean[] c = new boolean[9];
    static int[] a = new int[9];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        go(0, n, m);
    }

    static void go(int index, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (c[i]) continue;

            c[i] = true;
            a[index] = i;
            go(index + 1, n, m);
            c[i] = false;
        }
    }
}