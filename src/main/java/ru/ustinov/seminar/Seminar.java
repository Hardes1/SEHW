package ru.ustinov.seminar;

import ru.ustinov.io.Reader;
import ru.ustinov.io.Writer;
import ru.ustinov.student.Student;
import ru.ustinov.student.StudentGenerator;

import java.io.InputStream;
import java.util.*;


public class Seminar {
    private static final int MAX_MARK = 10;

    private final List<Student> students;

    private final Reader reader;
    private int answeredStudents;
    private final Random random;

    public Seminar(InputStream inputStream, int count) {
        reader = new Reader(inputStream);
        answeredStudents = 0;
        random = new Random();
        StudentGenerator generator = new StudentGenerator();
        students = generator.generateStudents(count);
    }


    private void showHints() {
        Writer.Print("\"/r\" - выбрать учащегося для ответа");
        Writer.Print("\"/l\" - показать список учеников, которые уже отвечали");
        Writer.Print("\"/h\" - вызвать подсказку");
        Writer.Print("\"/e\" - закончить семинар");
    }

    public void begin() {
        Writer.Print("Семинар начался!");
        showHints();
        while (true) {
            String command = reader.read();
            switch (command) {
                case "/r" -> askQuestion();
                case "/l" -> printStudents();
                case "/h" -> showHints();
                case "/e" -> {
                    end();
                    return;
                }
                default -> Writer.Print("Неизвестная команда, попробуйте ещё раз!");
            }
        }
    }

    private void end() {
        Writer.Print("Семинар закончился, спасибо за внимание!");
    }
    private Student chooseStudent() {
        Student student = null;
        boolean isFoundToAnswer = false;
        while (!isFoundToAnswer) {
            student = students.get(random.nextInt(students.size()));
            if (student.getMark() == null) {
                answeredStudents++;
                isFoundToAnswer = true;
            }
        }
        return student;
    }

    private void printStudents() {
        for (Student student : students) {
            Writer.Print(student.toString());
        }
    }

    private void askQuestion() {
        if (answeredStudents == students.size()) {
            Writer.Print("Нельзя никого спрашивать, все студенты уже ответили!");
            return;
        }
        Student student = chooseStudent();
        Writer.Print(Questions.GetRandomQuestion());
        Writer.Print(String.format("Отвечает %s %s.", student.getLastName(), student.getFirstName()));
        reader.read();
        student.setMark(random.nextInt(MAX_MARK));
        Writer.Print(String.format("Оценка %d", student.getMark()));
    }

}
