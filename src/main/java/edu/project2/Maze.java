package edu.project2;


@SuppressWarnings({"hideutilityclassconstructor", "magicnumber", "regexpsinglelinejava"})
public final class Maze {
    private final int height;
    private final int width;
    private final Cell[][] maze;

    public Cell[][] getMaze() {
        return maze;
    }

    public void setCell(Coordinate cord, Cell.Type type) {
        maze[cord.x()][cord.y()] = new Cell(type);
    }

    public Cell getCell(Coordinate cord) {
        return maze[cord.x()][cord.y()];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Maze(int height, int width, Generator generator) {
        this.height = height;
        this.width = width;
        this.maze = generator.generate(height, width);
    }
}
