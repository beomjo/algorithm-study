import java.util.Arrays;
import java.util.Scanner;

class Main {
    static int[] d = new int[1001];
    static int[] p = new int[1001];
    static int maxValue = 1000 * 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        Arrays.fill(d, maxValue);

        sc.close();
        System.out.println(go(n));
    }

    static int go(int i) {
        if (i == 0) return 0;
        if (d[i] != maxValue) return d[i];

        for (int j = 1; j <= i; j++) {
            d[i] = Math.min(d[i], go(i - j) + p[j]);
        }

        return d[i];
    }
}
