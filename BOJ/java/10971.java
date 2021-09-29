/*
 * 외판원 순회 2
 * https://www.acmicpc.net/problem/10971
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int[] d = new int[n];
        for (int i = 0; i < n; i++) d[i] = i;

        int result = Integer.MAX_VALUE;

        do {
            boolean ok = true;
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                if (a[d[i]][d[i + 1]] == 0) {
                    ok = false;
                } else {
                    sum += a[d[i]][d[i + 1]];
                }
            }
            if (ok && a[d[n - 1]][d[0]] != 0) {
                sum += a[d[n - 1]][d[0]];
                if (result > sum) {
                    result = sum;
                }
            }
        } while (nextPermutation(d));
        System.out.println(result);
    }

    static boolean nextPermutation(int[] a) {
        int lastIndex = a.length - 1;
        int i = lastIndex;
        while (i > 0 && a[i] < a[i - 1]) {
            i--;
        }
        if (i == 0) return false;

        int j = lastIndex;
        while (j >= i && a[j] < a[i - 1]) {
            j--;
        }
        swap(a, i - 1, j);

        j = lastIndex;
        while (i < j) swap(a, i++, j--);
        return true;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}