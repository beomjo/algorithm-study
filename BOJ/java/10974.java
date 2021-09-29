/*
 * 모든 순열
 * https://www.acmicpc.net/problem/10974
 */

import java.io.IOException;
import java.util.Scanner;

class Main {
    static int n;
    static int[] a;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        sc.close();
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }

        do {
            for (int i : a) sb.append(i).append(" ");
            sb.append("\n");
        } while (nextPermutation());
        System.out.println(sb.toString());
    }

    static boolean nextPermutation() {
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
        swap(i - 1, j);

        j = lastIndex;
        while (i < j) swap(i++, j--);
        return true;
    }

    static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}