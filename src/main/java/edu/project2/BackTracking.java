package edu.project2;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("magicnumber")
public class BackTracking implements Generator {
    private Random random = new Random();
    private static final Logger LOGGER = LogManager.getLogger();
    private Cell[][] maze;
    private int height;
    private int width;

    private boolean check(int height, int width, Coordinate cord) {
        return ((cord.x() > 0 && cord.x() < height - 1) && (cord.y() > 0 && cord.y() < width - 1));
    }

    @Override
    public Cell[][] generate(int height, int width) {
        this.height = height;
        this.width = width;
        this.maze = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = new Cell(Cell.Type.WALL);
            }
        }
        Coordinate start = new Coordinate(random.nextInt(height - 2) + 1, random.nextInt(width - 2) + 1);
        generatePath(start);
        maze[start.x()][start.y()] = new Cell(Cell.Type.PASSAGE);
        return maze;
    }

    private void generatePath(Coordinate cord) {
        maze[cord.x()][cord.y()] = new Cell(Cell.Type.PASSAGE);
        Coordinate[] moves = {new Coordinate(1, 0), new Coordinate(-1, 0), new Coordinate(0, -1), new Coordinate(0, 1)};

        int[] ind = new int[4];
        for (int i = 0; i < 4; i++) {
            while (true) {
                ind[i] = random.nextInt(4);
                boolean check = true;
                for (int j = 0; j < i; j++) {
                    if (ind[j] == ind[i]) {
                        check = false;
                    }
                }
                if (check) {
                    break;
                }
            }
        }
        for (var move : ind) {
            Coordinate cur = new Coordinate(cord.x() + moves[move].x() * 2, cord.y() + moves[move].y() * 2);

            if (check(height, width, cur) && maze[cur.x()][cur.y()].type() == Cell.Type.WALL) {
                maze[cord.x() + moves[move].x()][cord.y() + moves[move].y()] = new Cell(Cell.Type.PASSAGE);
                generatePath(cur);
            }
        }
    }
}
