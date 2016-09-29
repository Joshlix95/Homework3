package model;

import view.Constants;

import java.util.Random;

/**
 * This class represents the food that the snake eats to grow.
 */
public class Food {

    // It's position on the screen.
    private int x = 0;
    private int y = 0;
    // A random number generator to move it from place to place.
    private Random rand;

    public Food() {
        this(0, 0);
        update(); // The food starts at some random position on the screen.
    }

    // This constructor allows the food to be initialized at a specific
    // x, y position.
    public Food(int x, int y) {
        this.x = x;
        this.y = y;
        rand = new Random();
    }

    // Returns the x position
    public int getX() {
        return x;
    }

    // Returns the y position
    public int getY() {
        return y;
    }

    // Sets the x position
    public void setX(int x) {
        this.x = x;
    }

    // Set the y position
    public void setY(int y) {
        this.y = y;
    }

    // Moves the food to a new random position.
    public void update() {
        // Gets a pixel inside the screen frame
        int newX = rand.nextInt((Constants.SCREEN_WIDTH - 1)/ Constants.PIXEL_SIZE);
        int newY = rand.nextInt((Constants.SCREEN_HEIGHT - 1) / Constants.PIXEL_SIZE);
        // Ensures that the new position will be at some multiple of PIXEL_SIZE
        // so that the snake head will overlap.
        setX(newX * Constants.PIXEL_SIZE);
        setY(newY * Constants.PIXEL_SIZE);
    }

}
