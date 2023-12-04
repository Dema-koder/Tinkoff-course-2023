package edu.project2;

@SuppressWarnings({"hideutilityclassconstructor", "magicnumber", "regexpsinglelinejava"})
public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze(20, 30, new BackTracking());
        Solver solver = new Solver();
        Coordinate start = null;
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getCell(new Coordinate(i, j)).type() == Cell.Type.PASSAGE) {
                    start = new Coordinate(i, j);
                    break;
                }
            }
        }
        Coordinate finish = null;
        for (int i = maze.getHeight() - 1; i >= 0; i--) {
            for (int j = maze.getWidth() - 1; j >= 0; j--) {
                if (maze.getCell(new Coordinate(i, j)).type() == Cell.Type.PASSAGE) {
                    finish = new Coordinate(i, j);
                    break;
                }
            }
        }
        System.out.println(start.x() + " " + start.y());
        System.out.println(finish.x() + " " + finish.y());
        maze = solver.solve(maze, start, finish);
        MazeRenderer render = new MazeRenderer();
        render.render(maze);
    }
}
