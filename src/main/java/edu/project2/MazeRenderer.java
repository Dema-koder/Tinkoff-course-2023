package edu.project2;


@SuppressWarnings({"hideutilityclassconstructor", "magicnumber", "regexpsinglelinejava"})
public class MazeRenderer {
    public static void render(Maze maze) {
        for (var row : maze.getMaze()) {
            for (var cell : row) {
                if (cell.type() == Cell.Type.PASSAGE) {
                    System.out.print(' ');
                } else {
                    if (cell.type() == Cell.Type.PATH) {
                        System.out.print('#');
                    } else {
                        System.out.print('▉');
                    }
                }
            }
            System.out.println();
        }
    }
}
