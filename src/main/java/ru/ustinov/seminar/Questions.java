package ru.ustinov.seminar;

import java.util.Random;

public class Questions {
    private static final String[] questions = {"Небо чёрное?", "Море белое?", "Трава зелёная?", "Это бабочка?"};
    private static final Random random = new Random();

    public static String GetRandomQuestion() {
        return questions[random.nextInt(questions.length)];
    }

}
