/*
 * 사탕 게임
 * https://www.acmicpc.net/problem/3085
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static Character[][] a;
    static int N;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        a = new Character[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                a[i][j] = input.charAt(j);
            }
        }
        br.close();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    check();
                    swap(i, j, i, j + 1);
                }

                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    check();
                    swap(i, j, i + 1, j);
                }
            }
        }
        
        System.out.println(ans);
    }

    static void swap(int startI, int startJ, int endI, int endJ) {
        char temp = a[startI][startJ];
        a[startI][startJ] = a[endI][endJ];
        a[endI][endJ] = temp;
    }

    static void check() {
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (a[i][j] == a[i][j + 1]) {
                    count++;
                } else {
                    ans = Math.max(ans, count);
                    count = 1;
                }
            }
            ans = Math.max(ans, count);
        }

        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 0; i < N - 1; i++) {
                if (a[i][j] == a[i + 1][j]) {
                    count++;
                } else {
                    ans = Math.max(ans, count);
                    count = 1;
                }
            }
            ans = Math.max(ans, count);
        }
    }
}