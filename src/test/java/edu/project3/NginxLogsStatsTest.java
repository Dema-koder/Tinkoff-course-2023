package edu.project3;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NginxLogsStatsTest {
    private final static String DIRECTORY_PATH = "test_nginx";

    @BeforeEach
    void createDirectory() throws Exception {
        deleteDirectory(new File(DIRECTORY_PATH));
        Files.createDirectory(Path.of(DIRECTORY_PATH));
    }

    @AfterEach
    void deleteAllFiles() throws Exception {
        deleteDirectory(new File(DIRECTORY_PATH));
    }

    public static void deleteDirectory(File directory) throws Exception {
        if(!directory.exists()) {
            return;
        }

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    deleteDirectory(file);
                }
            }
        }

        // Удаляем саму директорию
        if (!directory.delete()) {
            throw new Exception("Не удалось удалить файл");
        }
    }
    @Test
    void withoutPath() {
        assertThrows(
            IllegalArgumentException.class,
            () -> NginxLogsStats.nginxLogsStats(new String[] {})
        );
    }
}
