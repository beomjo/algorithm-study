/*
 * 불!
 * https://www.acmicpc.net/problem/4179 
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

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> h = new LinkedList<>();
        Queue<int[]> f = new LinkedList<>();
        String[][] board = new String[n][m];
        int[][] hDist = new int[n][m];
        int[][] fDist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = String.valueOf(s.charAt(j));
                if (board[i][j].equals("#") || board[i][j].equals(".")) {
                    hDist[i][j] = -1;
                    fDist[i][j] = -1;
                }
                if (board[i][j].equals("J")) {
                    h.offer(new int[]{i, j});
                }
                if (board[i][j].equals("F")) {
                    f.offer(new int[]{i, j});
                    hDist[i][j] = -1;
                }
            }
        }
        while (!f.isEmpty()) {
            int[] p = f.poll();
            for (int d = 0; d < 4; d++) {
                int x = p[0] + dx[d];
                int y = p[1] + dy[d];

                if (x < 0 || x >= n || y < 0 || y >= m) continue;
                if (board[x][y].equals("#") || fDist[x][y] > 0) continue;
                f.offer(new int[]{x, y});
                fDist[x][y] = fDist[p[0]][p[1]] + 1;
            }
        }

        while (!h.isEmpty()) {
            int[] p = h.poll();
            for (int d = 0; d < 4; d++) {
                int x = p[0] + dx[d];
                int y = p[1] + dy[d];

                if (x < 0 || x >= n || y < 0 || y >= m) {
                    System.out.println(hDist[p[0]][p[1]] + 1);
                    return;
                }
                if (hDist[x][y] > 0 || board[x][y].equals("#")) continue;
                if (fDist[x][y] != -1 && hDist[p[0]][p[1]] + 1 >= fDist[x][y]) continue;
                h.offer(new int[]{x, y});
                hDist[x][y] = hDist[p[0]][p[1]] + 1;
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
