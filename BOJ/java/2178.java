/*
 * 미로 탐색
 * https://www.acmicpc.net/problem/2178
 */


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] board = new int[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        dist[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] p = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int x = p[0] + dx[k];
                            int y = p[1] + dy[k];
                            if (x < 0 || x >= n || y < 0 || y >= m) continue;
                            if (board[x][y] != 1 || dist[x][y] > 0) continue;
                            queue.offer(new int[]{x, y});
                            dist[x][y] = dist[p[0]][p[1]] + 1;
                        }
                    }
                }
            }
        }

        System.out.println(dist[n - 1][m - 1]);
    }
}
