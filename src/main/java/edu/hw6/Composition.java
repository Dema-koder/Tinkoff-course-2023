package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

@SuppressWarnings({"hideutilityclassconstructor", "uncommentedmain", "regexpsinglelinejava"})
public class Composition {
    public static void main(String[] args) {
        String text = "Programming is learned by writing programs. - Brian Kernighan";
        Path filePath = Path.of("output.txt");

        try (OutputStream fileOutputStream = Files.newOutputStream(filePath, StandardOpenOption.CREATE);
             OutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new CRC32());
             OutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
             Writer writer = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
             PrintWriter printWriter = new PrintWriter(writer)) {

            printWriter.println(text);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
