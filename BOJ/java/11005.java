import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder answer = new StringBuilder();

        while (n > 0) {
            long rest = n % b;
            if (rest >= 10) {
                answer.append((char) ((rest - 10) + 'A'));
            } else {
                answer.append((char) (rest + '0'));
            }
            n /= b;
        }
        System.out.println(answer.reverse().toString());
        sc.close();
    }
}