package ru.ustinov;


import ru.ustinov.seminar.Seminar;

public class Main {
    public static void main(String[] args) {
        Seminar seminar = new Seminar(System.in, 10);
        seminar.begin();
    }
}