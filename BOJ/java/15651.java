/*
 * N과 M(3)
 * https://www.acmicpc.net/problem/15651
 */

import java.io.IOException;
import java.util.Scanner;

class Main {
    static int[] a = new int[9];
    static int n, m;
    static  StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.close();

        go(0);
        System.out.println(sb.toString());
    }

    static void go(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            a[depth] = i;
            go(depth + 1);
        }
    }
}