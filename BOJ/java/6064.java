/*
 * 카잉 달력
 * https://www.acmicpc.net/problem/6064
 */

import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            boolean isFind = false;
            for (int i = x; i <= (n * m); i += m) {
                if (i % m == x && i % n == y) {
                    isFind = true;
                    System.out.println(i + 1);
                    break;
                }
            }
            if (!isFind) {
                System.out.println(-1);
            }
        }
        sc.close();
    }
}