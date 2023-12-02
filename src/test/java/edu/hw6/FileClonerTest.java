package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class FileClonerTest {
    @Test
    public void cloneFileTest() throws IOException {
        Path originalFile = Files.createTempFile("test", ".txt");
        String originalFileName = originalFile.getFileName().toString();
        FileCloner.cloneFile(originalFile);

        String baseName = originalFileName.substring(0, originalFileName.lastIndexOf('.'));
        String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
        Path copyPath = originalFile.resolveSibling(baseName + " - копия" + extension);
        assertTrue(Files.exists(copyPath));

        Files.deleteIfExists(originalFile);
        Files.deleteIfExists(copyPath);
    }
}
