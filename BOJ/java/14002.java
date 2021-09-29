
/*
 * 가장 긴 증가하는 부분 수열 4
 * https://www.acmicpc.net/problem/14002
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] d = new int[n]; // 길이를 담을 배열
        int[] v = new int[n]; // 경로를 추적할 인덱스를 담을 배열
        int max = -1;
        int index = -1;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            d[i] = 1;
            v[i] = -1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    v[i] = j;
                }
            }

            if (max < d[i]) {
                max = d[i];
                index = i;
            }
        }
        answer.append(max).append("\n");

        Stack<Integer> stack = new Stack<Integer>();
        while (index != -1) {
            stack.push(arr[index]);
            index = v[index];
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pop()).append(" ");
        }

        sc.close();
        System.out.println(answer);
    }
}