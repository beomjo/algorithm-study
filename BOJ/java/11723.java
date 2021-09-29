/*
 * 집합
 * https://www.acmicpc.net/problem/11723
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int bit = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String op = input[0];
            int index = -1;
            if (!op.equals("all") && !op.equals("empty")) {
                index = Integer.parseInt(input[1]) - 1;
            }

            switch (op) {
                case "add":
                    bit = setBit(bit, index);
                    break;
                case "remove":
                    bit = clearBit(bit, index);
                    break;
                case "check":
                    sb.append(getBit(bit, index) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    bit = toggleBit(bit, index);
                    break;
                case "all":
                    bit = -1;
                    break;
                case "empty":
                    bit = 0;
                    break;
            }
        }

        System.out.println(sb);
    }

    static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    static int setBit(int num, int i) {
        return num | (1 << i);
    }

    static int clearBit(int num, int i) {
        return num & (~(1 << i));
    }

    static int toggleBit(int num, int i) {
        return num ^ (1 << i);
    }
}
