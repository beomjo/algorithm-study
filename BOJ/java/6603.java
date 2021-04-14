import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] a;
    static boolean[] c;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            c = new boolean[n];
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);

            System.out.println();
        }

    }

    private static void dfs(int start, int depth) {
        if (depth == 6) {
            print();
        }
        for (int i = start; i < n; i++) {
            c[i] = true;
            dfs(i + 1, depth + 1);
            c[i] = false;
        }
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            if (c[i]) System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}