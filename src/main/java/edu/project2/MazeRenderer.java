package edu.project2;

public class MazeRenderer {
    public static void main(String[] args) {
        Maze maze = new Maze(10, 10, new HuntAndKill());
        render(maze);
    }
    public static void render(Maze maze) {
        for (var row: maze.getMaze()) {
            for (var cell: row) {
                if (cell.type() == Cell.Type.PASSAGE) {
                    System.out.print('\u0068');
                } else {
                    System.out.print('\u006f');
                }
            }
            System.out.println();
        }
    }
}
