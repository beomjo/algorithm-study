/*
 * 카드 역배치
 * https://www.acmicpc.net/problem/10804
 */

import java.util.Scanner;

class Main {
    static int[] arr = new int[21];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 1; i <= 10; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            swap(start, end);
        }

        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int start, int end) {
        for (int i = 0; i <= (end - start) / 2; i++) {
            int temp = arr[start + i];
            arr[start + i] = arr[end - i];
            arr[end - i] = temp;
        }
    }
}
