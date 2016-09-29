package model;

import view.Constants;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    // Direction encoding
    public static enum Direction {
        UP(0), DOWN(1), LEFT(2), RIGHT(3);
        private static final Direction[] opposites = new Direction[]{
                Direction.DOWN, Direction.UP, Direction.RIGHT, Direction.LEFT};

        private int value;
        Direction(int value) {
            this.value = value;
        }

        public Direction getOpposite() {
            return opposites[value];
        }
    };

    private List<Cell> cells;

    public Snake() {
        cells = new ArrayList<Cell>();
        startInMiddle();
    }

    public List<Cell> getCells() {
        return cells;
    }

    /**
     * This is called when the snake finds food.
     * The snake should grow 1 cell.
     */
    public void grow() {
        /* Implement this */
    }

    /**
     * This should be called when a user clicks an arrow key.
     * Implement it so that the head starts going in that direction,
     * but the body must pass that point before turning.
     */
    public void changeDirection(Direction direction) {
        /* Implement this */
    }

    /**
     * This controls how the snake moves. Note that the snake will lead
     * with it's head and the rest of its body will follow in the exact same path.
     */
    public void move() {
        /* Implement this */
    }

    public void reset() {
        cells.clear();
        startInMiddle();
    }

    private void startInMiddle() {
        int x = Constants.SCREEN_WIDTH /2;
        int y = Constants.SCREEN_HEIGHT /2;
        for (int i = 0; i < Constants.START_LENGTH; i++) {
            cells.add(new Cell(x, y, Direction.UP));
            y += Constants.PIXEL_SIZE;
        }
    }

    /**
     * This class is designated for defining cells on the snake.
     * Each cell has an (x, y) position and a direction associated with it.
     */
    public class Cell {
        private int x, y;
        private Direction dir;

        public Cell(Cell p) {
            this.x = p.getX();
            this.y = p.getY();
            this.dir = p.getDirection();
        }

        public Cell(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Cell() {
            this(0, 0, Direction.UP);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Direction getDirection() {
            return dir;
        }

        public void setDirection(Direction dir) {
            this.dir = dir;
        }

        // Moves the cell in it's associated direction.
        public void move() {
            move(false);
        }

        // Moves the cell in its associated direction. Or opposite it's associated
        // direction if goOpposite is true.
        public void move(boolean goOpposite) {
            Direction toMove = goOpposite ? dir.getOpposite() : dir;
            switch(toMove) {
                case UP:
                    y -= Constants.PIXEL_SIZE;
                    break;
                case DOWN:
                    y += Constants.PIXEL_SIZE;
                    break;
                case LEFT:
                    x -= Constants.PIXEL_SIZE;
                    break;
                case RIGHT:
                    x += Constants.PIXEL_SIZE;
                    break;
                default: // do nothing
                    break;
            }
        }

        // Returns true if the x and y values are the same.
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Cell cell = (Cell) o;

            if (x != cell.x) return false;
            return y == cell.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return String.format("Cell{x=%d,y=%d,dir=%s}", x, y, dir.toString());
        }
    }
}
