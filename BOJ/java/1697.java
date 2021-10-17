/*
 * 숨바꼭질
 * https://www.acmicpc.net/problem/1697
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        final int MAX = 100002;

        Queue<Integer> queue = new LinkedList<>();
        int[] visit = new int[MAX];
        Arrays.fill(visit, -1);
        queue.offer(n);
        visit[n] = 0;

        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int i = 0; i < 3; i++) {
                int px = p;
                if (i == 0) px += 1;
                if (i == 1) px -= 1;
                if (i == 2) px *= 2;

                if (px < 0 || px >= MAX) continue;
                if (visit[px] != -1) continue;
                if (i == 0) queue.offer(p + 1);
                if (i == 1) queue.offer(p - 1);
                if (i == 2) queue.offer(p * 2);
                visit[px] = visit[p] + 1;
            }
        }
        System.out.println(visit[k]);
    }
}