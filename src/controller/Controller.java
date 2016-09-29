package controller;

import view.View;
import model.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The controller is the communication link between the system and the user.
 * The user interacts with they system by pressing keys.
 */
public class Controller implements KeyListener {

    /**
     * When a key is typed (pressed, then released) this method is called.
     * Right now, it responds to the space bar by stopping game play
     * and displaying the start screen message.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // Get the source component (in this case it's View)
        View view = (View) e.getComponent();
        View.GamePanel gamePanel = view.getGamePanel();

        switch (e.getExtendedKeyCode()) {
            case KeyEvent.VK_SPACE:
                gamePanel.flipStartScreen();
                break;
            default: // do nothing
                break;
        }
        // Repaint the game panel
        gamePanel.repaint();
    }

    /**
     * When a key is pressed this method is called.
     * Note: The arrow keys do not trigger the keyTyped method.
     * You should add code to change the direction of the snake according
     * to the arrow key.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // Get the source component (in this case it's View)
        View view = (View) e.getComponent();
        Model model = view.getModel();
        View.GamePanel gamePanel = view.getGamePanel();

        // TODO: Implement these
        switch (e.getExtendedKeyCode()) {
            case KeyEvent.VK_UP:
                break;
            case KeyEvent.VK_DOWN:
                break;
            case KeyEvent.VK_LEFT:
                break;
            case KeyEvent.VK_RIGHT:
                break;
            default: // do nothing
                break;
        }
        // Repaint the game panel
        gamePanel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
