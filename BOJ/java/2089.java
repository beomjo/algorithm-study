import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        long n = sc.nextLong();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        while (n != 0) {
            sb.insert(0, Math.abs(n % -2));
            n = (long) Math.ceil((double) n / -2);
        }

        System.out.println(sb.toString());
        sc.close();
    }
}