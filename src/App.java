import processing.core.*;

public class App extends PApplet {
    int ball1X = 200;
    int ball1Y = 0;
    int speed = 4;
    int ball2x = 400;
    int ball2y = 0;
    int ball3x = 600;
    int ball3y = 0;
    int ball4x = 800;
    int ball4y = 0;
    int playerX = 200;
    int playerY = 550;
    int playerSpeed = 10;
    int sum = 55;
    boolean left, right;
    int scene = 1;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        left = false;
        right = false;

    }

    public void settings() {
        size(1000, 600);

    }

    public void draw() {
        if (scene == 1) {
            background(0, 255, 0);
            textSize(50);
            text(" DO NOT TOUCH THE RED BALLS!",100, 100);
            rect(200, 200, 200, 200);
            text("START",230 ,200);

        } else if (scene == 2) {
            background(0, 0, 255);

            fill(255, 0, 0);
            circle(ball1X, ball1Y, 40);

            fill(255, 0, 0);
            circle(ball2x, ball2y, 40);

            fill(255, 0, 0);
            circle(ball3x, ball3y, 40);

            fill(255, 0, 0);
            circle(ball4x, ball4y, 40);

            ball1Y = ball1Y + speed;

            ball2y = ball2y + speed;

            ball3y = ball3y + speed;

            ball4y = ball4y + speed;

            fill(0, 255, 0);
            circle(playerX, playerY, 70);

            if (ball1Y > height) {
                ball1Y = 0;
            }
            if (ball2y > height) {
                ball2y = 0;
            }
            if (ball3y > height) {
                ball3y = 0;
            }
            if (ball4y > height) {
                ball4y = 0;
            }
            if (playerX < 0) {
                playerX = 0;
            }

            if (playerX > width) {
                playerX = width;
            }

            if (sum >= dist(playerX, playerY, ball1X, ball1Y)) {
               scene = 3;

            }
            if (sum >= dist(playerX, playerY, ball2y, ball2y)) {
               scene = 3;

            }
            if (sum >= dist(playerX, playerY, ball3x, ball3y)) {
                scene = 3;

            }
            if (sum >= dist(playerX, playerY, ball4x, ball4y)) {
               scene = 3;

            }
            if (left == true) {
                playerX -= playerSpeed;
            }
            if (right == true) {
                playerX += playerSpeed;
            }

        }
        else if (scene == 3) {
            background(255,0,0);
            text("GAME OVER", 100, 100);
            rect(200, 200, 200, 200);
            text("PLAY AGAIN?", 200,200);
        }

    }
    public void mousePressed(){
        if (mouseX >= 200 && mouseY >= 200  ) {
            scene = 2;
        }
        if (mouseX >= 200 && mouseY >= 200  ) {
            scene = 2;
        }
    }

    public void keyPressed() {
        System.out.println("pressed");
        if (keyCode == LEFT) {
            left = true;
        }

        if (keyCode == RIGHT) {
            right = true;
        }
        

    }

    public void keyReleased() {
        if (keyCode == LEFT) {
            left = false;

        }
        if (keyCode == RIGHT) {
            right = false;
        }

    }
}