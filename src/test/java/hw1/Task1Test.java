package hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import static hw1.Task1.minutesToSeconds;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    @DisplayName("Корректные строки")
    void correctStrings() {
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            Long answer = random.nextLong(Long.MAX_VALUE);
            Long minutes = answer / 60;
            Long seconds = answer % 60;
            String request = minutes + ":" + seconds;
            assertEquals(answer, minutesToSeconds(request));
        }
    }

    @Test
    @DisplayName("Некоррекстные строки")
    void incorrectStrings() {
        String[] exampleStrings =
            new String[] {"99999999999999999999999999999999999999:12", "dvnnspdopodk", "1232:100", ":::::::::::",
                "lwkmddl:cm"};
        for (var str: exampleStrings) {
            assertEquals(-1, minutesToSeconds(str));
        }
    }
}
