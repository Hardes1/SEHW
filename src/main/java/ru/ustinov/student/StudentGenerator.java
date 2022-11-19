package ru.ustinov.student;

import java.util.*;

public class StudentGenerator {
    private static final String[] firstNames = {"Коля", "Петя", "Вася", "Гена", "Саша", "Женя"};
    private static final String[] lastNames = {"Устинов", "Семёнов", "Васькин", "Чуйкин", "Безруков", "Пупкин"};

    private final Set<Student> usedStudents;
    private final Random random;

    public StudentGenerator() {
        usedStudents = new HashSet<>();
        random = new Random();
    }

    public List<Student> generateStudents(int count) {
        if (count > firstNames.length * lastNames.length) {
            return new ArrayList<>();
        }
        List<Student> list = new ArrayList<>(count);
        for (int i = 0; i < count; ++i) {
            list.add(generate());
        }
        return list;
    }

    public Student generate() {
        boolean isGenerated = false;
        Student student = null;
        while (!isGenerated) {
            int firstNamesLength = firstNames.length;
            int lastNamesLength = lastNames.length;
            student =
                    new Student(firstNames[random.nextInt(firstNamesLength)], lastNames[random.nextInt(lastNamesLength)]);
            if (!usedStudents.contains(student)) {
                isGenerated = true;
                usedStudents.add(student);
            }
        }
        return student;
    }
}
