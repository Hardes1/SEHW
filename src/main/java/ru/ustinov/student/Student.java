package ru.ustinov.student;

import java.util.Objects;

public class Student {
    private final String firstName;
    private final String lastName;

    private Integer mark;

    public Student(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Student other)) {
            return false;
        }
        if (other.mark != null) {
            return other.lastName.equals(lastName) && other.firstName.equals(firstName) && other.mark.equals(mark);
        } else {
            return other.lastName.equals(lastName) && other.firstName.equals(firstName) && mark == null;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "%s %s: %s",
                lastName,
                firstName,
                (mark == null ? "ещё не отвечал" : String.format("оценка %d", mark))
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, mark);
    }
}
