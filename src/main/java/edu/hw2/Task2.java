package edu.hw2;

public class Task2 {
    public static class Rectangle {
        private int width;
        private int height;

        public Rectangle(int height, int width) {
            this.height = height;
            this.width = width;
        }

        public Rectangle() {
        }

        public Rectangle setHeight(int height) {
            return new Rectangle(height, width);
        }

        public Rectangle setWidth(int width) {
            return new Rectangle(height, width);
        }

        double area() {
            return width * height;
        }
    }

    public static class Square extends Rectangle {
        public Square() {
        }

        public Square(int side) {
            super(side, side);
        }
    }
}

