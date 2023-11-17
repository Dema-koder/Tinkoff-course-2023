package edu.hw6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("regexpsinglelinejava")
public class DiskMap implements Map<String, String> {
    private String filePath;

    public DiskMap(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public int size() {
        return readMap().size();
    }

    @Override
    public boolean isEmpty() {
        return readMap().isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return readMap().containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return readMap().containsValue(value);
    }

    @Override
    public String get(Object key) {
        return readMap().get(key);
    }

    @Override
    public String put(String key, String value) {
        Map<String, String> map = readMap();
        String previousValue = map.put(key, value);
        writeMap(map);
        return previousValue;
    }

    @Override
    public String remove(Object key) {
        Map<String, String> map = readMap();
        String removedValue = map.remove(key);
        writeMap(map);
        return removedValue;
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        Map<String, String> map = readMap();
        map.putAll(m);
        writeMap(map);
    }

    @Override
    public void clear() {
        writeMap(new HashMap<>());
    }

    @Override
    public @NotNull Set<String> keySet() {
        return readMap().keySet();
    }

    @Override
    public @NotNull Collection<String> values() {
        return readMap().values();
    }

    @Override
    public @NotNull Set<Entry<String, String>> entrySet() {
        return readMap().entrySet();
    }

    private Map<String, String> readMap() {
        Map<String, String> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];
                    map.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    private void writeMap(Map<String, String> map) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Entry<String, String> entry : map.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
