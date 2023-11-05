package edu.project2;

@SuppressWarnings("whitespacearound")
public record Cell(Type type) {
    public enum Type {WALL, PASSAGE, PATH}
}
