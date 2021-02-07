
import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcp = getGCP(a, b);
        int lcm = getLCM(a, b, gcp);

        System.out.println(gcp);
        System.out.println(lcm);
        sc.close();
    }

    static int getGCP(int a, int b) {
        int r = 1;
        for (int i = 2; i < Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                r = i;
            }
        }
        return r;
    }

    static int getGCPByEuclideanCase1(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getGCPByEuclideanCase1(b, a % b);
        }
    }

    static int getGCPByEuclideanCase2(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static int getLCM(int a, int b, int gcp) {
        return a * b / gcp;
    }
}