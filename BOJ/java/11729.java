/*
 * 하노이 탑 이동 순서
 * https://www.acmicpc.net/problem/11729
 */


import java.util.Scanner;

class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(1, 3, n);
        System.out.println((1 << n) - 1);
        System.out.println(sb.toString());
    }

    private static void solve(int a, int b, int n) {
        if (n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }
        solve(a, 6 - a - b, n - 1);
        sb.append(a).append(" ").append(b).append("\n");
        solve(6 - a - b, b, n - 1);
    }
}
