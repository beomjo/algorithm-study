import java.util.Scanner;

class Main {
    static int[] a;
    static int[] p;
    static int n;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        p = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        go(0, 0);
        System.out.println(result);
    }

    static void go(int day, int total) {
        if (day == n) {
            result = Math.max(result, total);
            return;
        }
        go(day + 1, total);
        if (day + a[day] <= n) {
            go(day + a[day], total + p[day]);
        }

    }
}