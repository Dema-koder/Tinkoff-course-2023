package edu.project2;

public final class Maze {
    private final int height;
    private final int width;
    private final Cell[][] maze;

    public Cell[][] getMaze() {
        return maze;
    }

    public Maze(int height, int width, Generator generator) {
        this.height = height;
        this.width = width;
        this.maze = generator.generate(height, width);
    }
}
