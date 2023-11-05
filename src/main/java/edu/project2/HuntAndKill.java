package edu.project2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;

public class HuntAndKill implements Generator {
    private Random random = new Random();
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Cell[][] generate(int height, int width) {
        Cell[][] maze = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = new Cell(Cell.Type.WALL);
            }
        }

        int startX = random.nextInt(height);
        int startY = random.nextInt(width);
        maze[startX][startY] = new Cell(Cell.Type.PASSAGE);

        int curX = startX;
        int curY = startY;

        for (int k = 0; k < 100; k++){
            LOGGER.info(curX + " " + curY);
            Coordinate[] neighbors =
                {new Coordinate(curX - 2, curY), new Coordinate(curX + 2, curY), new Coordinate(curX, curY - 2),
                    new Coordinate(curX, curY + 2)};
            boolean hasUnvisitedNeighbor = false;

            for (var neighbor : neighbors) {
                if (neighbor.x() >= 0 && neighbor.x() < height && neighbor.y() >= 0 && neighbor.y() < width &&
                    maze[neighbor.x()][neighbor.y()].type() == Cell.Type.WALL) {
                    hasUnvisitedNeighbor = true;
                    break;
                }
            }

            if (hasUnvisitedNeighbor) {
                while (true) {
                    Coordinate randomNeighbor = neighbors[random.nextInt(neighbors.length)];
                    if (randomNeighbor.x() >= 0 && randomNeighbor.x() < height && randomNeighbor.y() >= 0 &&
                        randomNeighbor.y() < width &&
                        maze[randomNeighbor.x()][randomNeighbor.y()].type() == Cell.Type.WALL) {
                        maze[randomNeighbor.x()][randomNeighbor.y()] = new Cell(Cell.Type.PASSAGE);
                        maze[curX + (randomNeighbor.x() - curX) / 2][curY + (randomNeighbor.y() - curY) / 2] = new Cell(
                            Cell.Type.PASSAGE);
                        curX = randomNeighbor.x();
                        curY = randomNeighbor.y();
                        break;
                    }
                }
            } else {
                boolean foundUnvisitedCell = false;

                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (maze[i][j].type() == Cell.Type.WALL) {
                            boolean hasVisitedNeighbor = false;
                            Coordinate[] cellNeighbors =
                                {new Coordinate(curX - 1, curY), new Coordinate(curX + 1, curY),
                                    new Coordinate(curX, curY - 1),
                                    new Coordinate(curX, curY + 1)};
                            for (var neighbor : cellNeighbors) {
                                if (neighbor.x() >= 0 && neighbor.x() < height && neighbor.y() >= 0 &&
                                    neighbor.y() < width &&
                                    maze[neighbor.x()][neighbor.y()].type() == Cell.Type.PASSAGE) {
                                    hasVisitedNeighbor = true;
                                    break;
                                }
                            }
                            if (hasVisitedNeighbor) {
                                curX = i;
                                curY = j;
                                foundUnvisitedCell = true;
                                break;
                            }
                        }
                    }
                    if (foundUnvisitedCell) {
                        break;
                    }
                }
                if (!foundUnvisitedCell) {
                    break;
                }
            }
        }
        return maze;
    }
}
