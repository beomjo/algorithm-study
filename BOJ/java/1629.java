import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        System.out.println(pow(a, b, c));
    }

    private static long pow(long a, long b, long m) {
        if (b == 1) return a % m;
        long v = pow(a, b / 2, m);
        v = v * v % m;
        if (b % 2 == 0) return v % m;
        return v * a % m;
    }
}
