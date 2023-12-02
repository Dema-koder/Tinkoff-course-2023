package edu.hw6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class AbstractFilterTest {
    private static final Logger LOGGER = LogManager.getLogger();
    @Test
    public void testAbstractFilter() throws IOException {
        Path file1 = Files.createFile(Paths.get("test1.txt"));
        Path file2 = Files.createFile(Paths.get("test2.png"));
        Path file3 = Files.createFile(Paths.get("test3.txt"));

        AbstractFilter filter = AbstractFilter.REGULAR_FILE
            .and(AbstractFilter.READABLE)
            .and(AbstractFilter.regexContains(".*.txt$"));

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Paths.get(""), filter)) {
            int count = 0;
            for (Path entry : entries) {
                count++;
                assertTrue(Files.isRegularFile(entry));
                assertTrue(Files.isReadable(entry));
                assertTrue(entry.getFileName().toString().endsWith(".txt"));
            }
            assertEquals(2, count);
        }
        Files.deleteIfExists(file1);
        Files.deleteIfExists(file2);
        Files.deleteIfExists(file3);
    }
}
