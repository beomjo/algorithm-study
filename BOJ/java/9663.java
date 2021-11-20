/*
 * N-Queen
 * https://www.acmicpc.net/problem/9663
 */

import java.util.Scanner;

class Main {
    static int n;
    static boolean[] visit1 = new boolean[40]; // Column을 차지하는지
    static boolean[] visit2 = new boolean[40]; // / 방향 대각선을 차지하고 있는지
    static boolean[] visit3 = new boolean[40]; // \ 방향 대각선을 차지하고 있는지
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        func(0);
        System.out.println(count);
    }

    private static void func(int cur) {
        if (cur == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit1[i] && !visit2[i + cur] && !visit3[cur - i + n - 1]) {
                visit1[i] = true;
                visit2[i + cur] = true;
                visit3[cur - i + n - 1] = true;
                func(cur + 1);
                visit1[i] = false;
                visit2[i + cur] = false;
                visit3[cur - i + n - 1] = false;
            }
        }
    }
}