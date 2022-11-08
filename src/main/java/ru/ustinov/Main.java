package ru.ustinov;


public class Main {
    private static final int LEFT_BORDER = 0;
    private static final int RIGHT_BORDER = 92;
    private static final int START_POSITION = 2;

    private static void fibonacci(int position) {
        long previous = 0;
        long current = 1;
        if (position > RIGHT_BORDER || position < LEFT_BORDER) {
            System.out.println("Incorrect value!");
        } else if (position == LEFT_BORDER) {
            System.out.println(previous);
        }
        for (int i = START_POSITION; i <= position; ++i) {
            long next = current + previous;
            previous = current;
            current = next;
        }
        if (position >= LEFT_BORDER && position <= RIGHT_BORDER) {
            System.out.println(current);
        }
    }

    public static void main(String[] args) {
        fibonacci(92);
        fibonacci(10);
        fibonacci(-1);
        fibonacci(228);
    }
}