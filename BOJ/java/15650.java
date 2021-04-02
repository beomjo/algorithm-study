import java.io.IOException;
import java.util.Scanner;

class Main {
    static boolean[] c = new boolean[9];
    static int[] a = new int[9];
    static int n, m;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        go(1, 0);
    }

    static void go(int at, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= n; i++) {
            if (c[i]) continue;

            c[i] = true;
            a[depth] = i;
            go(i + 1, depth + 1);
            c[i] = false;
        }
    }
}