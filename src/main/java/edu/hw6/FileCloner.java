package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@SuppressWarnings({"hideutilityclassconstructor", "regexpsinglelinejava"})
public class FileCloner {
    public static void cloneFile(Path path) {
        final String FILE_NAME = path.getFileName().toString();
        final String BASE_NAME = FILE_NAME.substring(0, FILE_NAME.lastIndexOf('.'));
        final String EXTENSION = FILE_NAME.substring(FILE_NAME.lastIndexOf('.'));
        int copyNumber = 1;

        Path copyPath = path.resolveSibling(BASE_NAME + " - копия" + EXTENSION);
        while (Files.exists(copyPath)) {
            copyNumber++;
            copyPath = path.resolveSibling(BASE_NAME + " - копия (" + copyNumber + ")" + EXTENSION);
        }

        try {
            Files.copy(path, copyPath, StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
