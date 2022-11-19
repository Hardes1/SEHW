package ru.ustinov.io;

import java.io.InputStream;
import java.util.Scanner;

public class Reader {
    private final Scanner scanner;

    public Reader(final InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public String read() {
        return scanner.next();
    }
}
