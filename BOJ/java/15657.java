import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    static int[] a = new int[9];
    static int[] t;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        t = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(t);

        go(1, 0);

        System.out.println(sb.toString());
    }

    static void go(int at, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= n; i++) {
            a[depth] = t[i];
            go(i, depth + 1);
        }
    }
}