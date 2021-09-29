/*
 * 수 이어 쓰기
 * https://www.acmicpc.net/problem/1748
 */

import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        int len = 1;
        for (int start = 1; start <= n; start *= 10) {
            int end = start * 10 - 1;
            if (end > n) end = n;
            answer += len * (end - start + 1);
            len++;
        }
        System.out.println(answer);
        sc.close();
    }
}