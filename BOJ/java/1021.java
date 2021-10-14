/*
 * 회전하는 큐
 * https://www.acmicpc.net/problem/1021
 */

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str1 = br.readLine().split(" ");
        int n = Integer.parseInt(str1[0]);
        int m = Integer.parseInt(str1[1]);

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= n; i++) deque.add(i);

        String[] str2 = br.readLine().split(" ");
        int result = 0;
        for (int z = 0; z < m; z++) {
            int number = Integer.parseInt(str2[z]);
            while (true) {
                int idx = 0;
                Iterator<Integer> it = deque.iterator();
                while (it.hasNext()) {
                    if (it.next() == number) break;
                    idx++;
                }
                if (idx == 0) {
                    deque.pollFirst();
                    break;
                } else if (deque.size() / 2 >= idx) {
                    deque.addLast(deque.pollFirst());
                    result++;
                } else {
                    deque.addFirst(deque.pollLast());
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}