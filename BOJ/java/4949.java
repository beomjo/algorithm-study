/*
 * 균형잡힌 세상
 * https://www.acmicpc.net/problem/4949
 */

import java.io.*;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        while (!input.equals(".")) {
            Stack<Character> s = new Stack<>();
            boolean isPerfect = true;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (!Character.isDigit(c) && c != '.' && c != ' ') {
                    if (!s.isEmpty() && s.peek() == '[' && c == ']') {
                        s.pop();
                    } else if (!s.isEmpty() && s.peek() == '(' && c == ')') {
                        s.pop();
                    } else if (c == '(' || c == '[') {
                        s.push(c);
                    } else if (c == ')' || c == ']') {
                        isPerfect = false;
                    }
                }
            }
            if (s.isEmpty() && isPerfect) bw.write("yes\n");
            else bw.write("no\n");
            input = br.readLine();
        }
        bw.flush();
        bw.close();
    }
}