/*
 * 진법 변환
 * https://www.acmicpc.net/problem/2745
 */

import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        int b = sc.nextInt();

        int answer = 0;

        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            int r = 0;
            if (c >= 'A' && c <= 'Z') {
                r += (c - 'A' + 10);
            } else {
                r += (c - '0');
            }
            answer += r * Math.pow(b, n.length() - 1 - i);
        }

        System.out.println(answer);
        sc.close();
    }
}