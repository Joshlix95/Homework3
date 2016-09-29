package model;

import view.Constants;

/**
 * This class tracks the number of points earned and the number
 * of food pieces eaten.
 * TODO:These values should be displayed on the game screen somewhere.
 */
public class Score {
    private int points = 0;
    private int numFoodEaten = 0;

    public int getPoints() {
        return points;
    }

    public int getNumFoodEaten() {
        return numFoodEaten;
    }

    /**
     * Increments the points and numFoodEaten.
     * TODO: This should be called whenever the snake encounters food.
     *
     * TODO: Extra credit - let the user get more points for each food eaten.
     * E.g. the first bite gets 10 points. The next bite gets 11 points. The next
     * bite gets 12 points, and so on.
     */
    public void eatFood() {
        this.points += Constants.POINTS_PER_FOOD;
        numFoodEaten++;
    }
}
