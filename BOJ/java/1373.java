
/*
 * 2진수 8진수
 * https://www.acmicpc.net/problem/1373
 */

import java.io.*;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        Stack<Integer> stack = new Stack<>();

        if (input.length() % 3 != 0) {
            for (int i = 0; i < input.length() % 3; i++) {
                input = "0" + input;
            }
        }
        for (int i = input.length() - 1; i > 0; i -= 3) {
            int oneSeat = Character.getNumericValue(input.charAt(i));
            int twoSeat = Character.getNumericValue(input.charAt(i - 1));
            int fourSeat = Character.getNumericValue(input.charAt(i - 2));
            stack.push(oneSeat + twoSeat * 2 + fourSeat * 4);
        }
        while (!stack.isEmpty()) {
            bw.write(stack.pop().toString());
        }
        bw.flush();
        bw.close();
    }
}