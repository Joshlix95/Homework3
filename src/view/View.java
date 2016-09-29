package view;

import controller.Controller;
import model.Food;
import model.Model;
import model.Snake;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static view.Constants.PIXEL_SIZE;

/**
 * This is the User Interface class.
 */
public class View extends JFrame {

    private Model model;
    private GamePanel gamePanel;

    public View() {
        model = new Model();
        gamePanel = new GamePanel();
        setContentPane(gamePanel);
        setTitle("Snake!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT + 2 * Constants.PIXEL_SIZE);
        setVisible(true);//making the frame visible
        addKeyListener(new Controller());
    }

    public Model getModel() {
        return model;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public class GamePanel extends JPanel implements ActionListener {

        private boolean isStartScreen; // Whether the start text is displayed
        private int speed; // How often the screen is redrawn (when the snake is moved)
        private Timer timer; // How the screen redraw is controlled.

        public GamePanel() {
            isStartScreen = true;
            speed = 500;
            // TODO: Extra credit - have the snake speed up every time food is eaten.
            timer = new Timer(speed, this);
            timer.start();
        }

        // Flips the start text on and off the screen. When the start screen is enabled,
        // the snake should not move. (Works as an inadvertent pause button).
        // TODO: Extra credit - make an actual pause button that displays a 'Pause' message
        // TODO: and stops the snake from moving.
        public void flipStartScreen() {
            isStartScreen = !isStartScreen;
        }

        // Draw everything on the screen.
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            // create background
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

            if (isStartScreen) {
                g.setColor(Color.GREEN);
                g.setFont(new Font("Serif", Font.BOLD, 20));
                g.drawString(Constants.START_TEXT,
                        Constants.SCREEN_WIDTH /2 - 120,
                        (Constants.SCREEN_HEIGHT - g.getFontMetrics().getHeight())/2);
            }

            // Draw the other game elements
            // Draw the food
            g.setColor(Color.RED);
            Food food = model.getFood();
            g.fillRect(food.getX(), food.getY(), PIXEL_SIZE, PIXEL_SIZE);

            // Draw the snake
            g.setColor(Color.WHITE);
            List<Snake.Cell> cellList = model.getSnake().getCells();
            for (Snake.Cell cell : cellList) {
                g.fillRect(cell.getX(), cell.getY(), PIXEL_SIZE, PIXEL_SIZE);
            }

            // TODO: Draw the score Hint: g.drawString(String string, int x, int y)
        }

        /**
         * This is called by the timer at the speed interval.
         * This is where the game play is controlled.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isStartScreen) {
                // Don't move on the start screen
                return;
            }
            // Move and update game play.
            model.getSnake().move();

            // Check if the snake found food
            if (model.checkForFood()) {
                model.getSnake().grow();
                model.getFood().update();
                // TODO: Update the score
            }

            // TODO: When a game ends, leave its score on the screen until a new game starts.
            // Check if the snake ate itself or if it's out of bounds
            if (model.checkForCollision() || model.checkOutOfBounds()) {
                isStartScreen = true;
                model.getSnake().reset();
                model.getFood().update();
            }

            // Repaint the game screen.
            repaint();
        }
    }

    public static void main(String[] args) {
        View v = new View();
    }
}
