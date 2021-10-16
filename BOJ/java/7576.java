/*
 * 토마토
 * https://www.acmicpc.net/problem/7576
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        Queue<int[]> queue = new LinkedList<>();
        int[][] board = new int[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int t = Integer.parseInt(s.nextToken());
                board[i][j] = t;
                if (t == 1) queue.offer(new int[]{i, j});
                if (t == 0) dist[i][j] = -1;
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = p[0] + dx[k];
                int y = p[1] + dy[k];
                if (x < 0 || x >= n || y < 0 || y >= m) continue;
                if (dist[x][y] >= 0) continue;
                queue.offer(new int[]{x, y});
                dist[x][y] = dist[p[0]][p[1]] + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == -1) {
                    System.out.println(-1);
                    System.exit(0);
                }
                if (max < dist[i][j]) max = dist[i][j];
            }
        }
        System.out.println(max);
    }
}
