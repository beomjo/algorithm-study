/*
 * 부등호
 * https://www.acmicpc.net/problem/2529
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    static String[] arr;
    static boolean[] number = new boolean[10];
    static List<String> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        arr = new String[n];
        answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        dfs(n, 0, "");
        System.out.println(answer.get(answer.size() - 1));
        System.out.println(answer.get(0));
    }

    private static void dfs(int n, int index, String s) {

        String result;

        if (index == n + 1) {
            if (check(n, s))
                answer.add(s);
            return;
        }

        for (int i = 0; i <= 9; i++) {

            if (number[i])
                continue;

            result = s + i;

            number[i] = true;
            dfs(n, index + 1, result);
            number[i] = false;
        }
    }

    private static boolean check(int n, String answer) {
        for (int i = 0; i < n; i++) {
            char[] chars = answer.toCharArray();
            if (arr[i].equals(">")) {
                if (chars[i] > chars[i + 1])
                    continue;
                return false;
            }
            if (arr[i].equals("<")) {
                if (chars[i] < chars[i + 1])
                    continue;
                return false;
            }
        }
        return true;
    }
}
