/*
 * 일곱 난쟁이
 * https://www.acmicpc.net/problem/2309
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        Arrays.sort(a);

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if ((sum - a[i] - a[j]) == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            System.out.println(a[k]);
                        }
                    }
                    sc.close();
                    System.exit(0);
                }
            }
        }
    }
}