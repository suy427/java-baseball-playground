package study;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class StringCalculator {
    private final Scanner sc = new Scanner(System.in);
    private final Queue<Integer> numbers = new ArrayDeque<>();
    private final Queue<String> ops = new ArrayDeque<>();

    public int sum(String expr) {
        String[] chars = expr.split(" ");
        for (String c: chars) {
            if (isOps(c)) {
                ops.add(c);
                continue;
            }
            numbers.add(Integer.parseInt(c));
        }

        return calc();
    }

    private boolean isOps(String ch) {
        return ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/");
    }

    private int calc() {
        int result = numbers.poll();
        while (!ops.isEmpty()) {
            String op = ops.poll();
            if (op.equals("+")) {
                result = result + numbers.poll();
            } else if (op.equals("-")) {
                result = result - numbers.poll();
            } else if (op.equals("*")) {
                result = result * numbers.poll();
            } else if (op.equals("/")) {
                result = result / numbers.poll();
            }
        }

        return result;
    }
}
