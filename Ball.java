import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BALL_SIZE = 50;
    private static final int DELAY = 10;
    private static final int BALL_SPEED = 2;

    private int ballX = WIDTH / 2;
    private int ballY = HEIGHT / 2;
    private int ballXSpeed = BALL_SPEED;
    private int ballYSpeed = BALL_SPEED;

    public Ball() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // Create a timer to update the ball's position
        Timer timer = new Timer(DELAY, e -> {
            updateBallPosition();
            repaint();
        });
        timer.start();
    }

    private void updateBallPosition() {
        ballX += ballXSpeed;
        ballY += ballYSpeed;

        // Check for collision with walls
        if (ballX <= 0 || ballX + BALL_SIZE >= WIDTH)
            ballXSpeed = -ballXSpeed;
        if (ballY <= 0 || ballY + BALL_SIZE >= HEIGHT)
            ballYSpeed = -ballYSpeed;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
    }
}
