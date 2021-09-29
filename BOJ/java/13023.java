/*
 * ABCDE
 * https://www.acmicpc.net/problem/13023
 */

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visit;

    public static boolean dfs(int now, int depth) {
        if (depth == 5)
            return true;

        visit[now] = true;
        for (int i = 0; i < list.get(now).size(); i++) {
            int next = list.get(now).get(i);
            if (visit[next])
                continue;
            if (dfs(next, depth + 1))
                return true;
        }
        visit[now] = false;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<Integer>());

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            visit = new boolean[n];
            if (dfs(i, 1)) {
                System.out.println("1");
                return;
            }
        }
        System.out.println("0");
    }
}