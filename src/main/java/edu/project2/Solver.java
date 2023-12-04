package edu.project2;

@SuppressWarnings({"arraytypestyle", "regexpsinglelinejava", "operatorwrap"})
public class Solver {
    private boolean used[][];

    public Maze solve(Maze maze, Coordinate start, Coordinate finish) {
        used = new boolean[maze.getHeight()][maze.getWidth()];
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                used[i][j] = false;
            }
        }
        boolean ok = dfs(maze, start, finish);
        if (!ok) {
            System.out.println("Невозможно добраться");
        }
        return maze;
    }

    private boolean check(int height, int width, Coordinate cord) {
        return ((cord.x() > 0 && cord.x() < height - 1) && (cord.y() > 0 && cord.y() < width - 1));
    }

    private boolean dfs(Maze maze, Coordinate cur, Coordinate finish) {
        used[cur.x()][cur.y()] = true;
        if (cur.x() == finish.x() && cur.y() == finish.y()) {
            return true;
        }
        Coordinate[] moves = {new Coordinate(1, 0), new Coordinate(-1, 0), new Coordinate(0, -1), new Coordinate(0, 1)};
        boolean ok = false;
        for (var to : moves) {
            Coordinate current = new Coordinate(to.x() + cur.x(), to.y() + cur.y());
            if (check(maze.getHeight(), maze.getWidth(), current) && maze.getCell(cur).type() != Cell.Type.WALL &&
                !used[current.x()][current.y()]) {
                ok = dfs(maze, current, finish);
            }
        }
        if (ok) {
            maze.setCell(cur, Cell.Type.PATH);
        }
        return ok;
    }
}
