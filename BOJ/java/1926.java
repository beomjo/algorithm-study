/*
 * 그림
 * https://www.acmicpc.net/problem/1926
 */


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] board = new int[n + 1][m + 1];
        int[][] visit = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        int count = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && visit[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visit[i][j] = 1;
                    count++;

                    int size = 0;
                    while (!queue.isEmpty()) {
                        int[] p = queue.peek();
                        queue.poll();
                        size++;
                        for (int k = 0; k < 4; k++) {
                            int x = p[0] + dx[k];
                            int y = p[1] + dy[k];
                            if (x < 0 || x >= n || y < 0 || y >= m) continue;
                            if (visit[x][y] == 1 || board[x][y] != 1) continue;
                            visit[x][y] = 1;
                            queue.offer(new int[]{x, y});
                        }
                    }
                    if (max < size) max = size;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }
}
