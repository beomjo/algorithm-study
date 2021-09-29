/*
 * 차이를 최대로
 * https://www.acmicpc.net/problem/10819
 */

import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        do {
            int temp = 0;
            for (int i = 0; i < n - 1; i++) {
                temp += Math.abs(a[i] - a[i + 1]);
            }
            if (result < temp) {
                result = temp;
            }
        } while (nextPermutation(a));

        System.out.println(result);
    }

    static boolean nextPermutation(int[] a) {
        int lastIndex = a.length - 1;
        int i = lastIndex;
        while (i > 0 && a[i] <= a[i - 1]) {
            i--;
        }
        if (i == 0) return false;

        int j = lastIndex;
        while (j >= i && a[j] <= a[i - 1]) {
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