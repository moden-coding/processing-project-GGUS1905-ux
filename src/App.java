import processing.core.*;

public class App extends PApplet {
    float ball1X = 150;
    float ball1Y = 0;
    float speed = 5;
    float ball2x = 300;
    float ball2y = 0;
    float ball3x = 450;
    float ball3y = 0;
    float ball4x = 600;
    float ball4y = 0;
    float ball5x = 750;
    float ball5y = 0;
    float ball6x = 900;
    float ball6y = 0;
    float playerX = 200;
    float playerY = 550;
    float goodballx = (int) random(width);
    float goodbally = 0;
    float playerSpeed = 10;
    float sum = 55;
    boolean left, right;
    int scene = 1;
    int count = 0;
    int highScore = 0;
    int lives = 3;

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
            background(0, 200, 0);
            introText();
            startButton();
        }

        else if (scene == 2) {
            background(0, 0, 100);
            badBallSizeColor();
            Score();
            lives();
            badBallMovment();

            goodBallSizeColor();
            playerSizeColor();

            goodBallTouchGround();

            badBallTouchGround();

            checkForDeathTouch();
            extraPoints();

            playerMovment();
            goodBallMovment();

        } else if (scene == 3) {
            background(200, 0, 0);
            EndText();
            playAgain();

        }

    }

    public void introText() {  // this method is all the intro text and insrouctions
    
        fill(255);
        textSize(60);
        text("DODGE THE RED BALLS", 150, 120);   //i used chat here for desigining it at the right place 
    
    

        textSize(30);
        text("Use LEFT and RIGHT arrows to move", 200, 180);     //i used chat here for desigining it at the right place 
        text("Touch the ORANGE ball to gain more points!", 200, 220);    //i used chat here for desigining it at the right place 
    }

    public void startButton() {  //this method is the start button
    

        fill(0);
        rect(350, 300, 300, 120);

        fill(255);
        textSize(50);
        text("START", 420, 380);    //i used chat here for desigining it at the right place and in the rect
    
    }

    public void Score() { //this method is printting the score at scene 2 at the top left of the screen

        fill(255, 255, 0); // i used chat here for disigning where should i put the text and in which color
        textSize(30);
        text("Score: " + count, 20, 40);
    }

    public void lives() { //this method is printing how much lives you have left on the screen in scene 2
        fill(255, 255, 0);
        textSize(30);
        text("lives left: " + lives, 20, 80);
    }
 
     public void EndText() { //this method is printing all the text in scene 3 on the screen
        textSize(30);
        text("High Score: " + highScore, 20, 160);

        fill(255);
        textSize(70);
        text("GAME OVER", 300, 120);

        textSize(40);
        text("Score: " + count, 400, 200);

        if (highScore < count) { //this if stament is checking if count is bigger than the highscore so the count becomes the high score
            highScore = count;
        }
    }

    public void playAgain() { //this method is showing a button on the screen that says play again in it

        fill(0);
        rect(350, 300, 300, 120);

        fill(255);
        textSize(40);
        text("PLAY AGAIN?", 365, 380);  //i used chat here for desigining it at the right place in the rectangle
    
    }

    public void badBallMovment() { // this method is for the momvment of the bad ball
        ball1Y = ball1Y + speed;

        ball2y = ball2y + speed;

        ball3y = ball3y + speed;

        ball4y = ball4y + speed;

        ball5y = ball5y + speed;

        ball6y = ball6y + speed;

    }

    public void playerMovment() { //this method is saying that if left is true so the player moves to the left based on the speed and the same thing for the right
        if (left == true) {

            playerX -= playerSpeed;
        }
        if (right == true) {
            playerX += playerSpeed;
        }

        if (playerX < 0) {
            playerX = 0;
        }

        if (playerX > width) {
            playerX = width;
        }
    }

    public void goodBallMovment() { // this method is doing the movment of the orange ball + checking if the orange ball touch the player so the orange ball y is = to 0 and his x is = to random
        goodbally = goodbally + speed;
        if (sum >= dist(playerX, playerY, goodballx, goodbally)) {
            count = count + 1;
            goodbally = 0;
            goodballx = (int) random(width);
        }
    }

    public void reset() { // this method is working once the player gets to scene 3 and she resets all the variabals
        ball1X = 150;
        ball1Y = 0;
        speed = 5;
        ball2x = 300;
        ball2y = 0;
        ball3x = 450;
        ball3y = 0;
        ball4x = 600;
        ball4y = 0;
        ball5x = 750;
        ball5y = 0;
        ball6x = 900;
        ball6y = 0;
        goodbally = 0;
        goodballx = (int) random(width);
        playerX = 200;
        playerY = 550;
        playerSpeed = 10;
        sum = 55;
        count = 0;
        lives = 3;
    }

    public void goodBallTouchGround() { // this method is saying that if the orange ball touches the ground his y is = to 0 and his x is = to random

        if (goodbally > height) {
            goodbally = 0;
            goodballx = (int) random(width);

        }
    }

    public void badBallTouchGround() { //this method is checking for each bad ball if he touches the ground and if he does she resets his y to 0 and his x to random
        if (ball1Y > height) {
            ball1Y = 0;
            ball1X = (int) random(width);
            count = count + 1;
            speed = speed + 0.5f;
            playerSpeed = playerSpeed - 0.1f;
        }
        if (ball2y > height) {
            ball2y = 0;
            ball2x = (int) random(width);

        }
        if (ball3y > height) {
            ball3y = 0;
            ball3x = (int) random(width);

        }
        if (ball4y > height) {
            ball4y = 0;
            ball4x = (int) random(width);

        }
        if (ball5y > height) {
            ball5y = 0;
            ball5x = (int) random(width);

        }

        if (ball6y > height) {
            ball6y = 0;
            ball6x = (int) random(width);

        }
    }

    public void checkForDeathTouch() { //this method is checking when the player dies
      
       if (lives == 0) { //this if statment is saying that if the lives = 0 so the scene is becoming scene 3
                scene = 3;
             }


      
        if (sum >= dist(playerX, playerY, ball1X, ball1Y)) { // all of this lines are checking if the bad ball touches the playerr and if it does it taking off live and resets his y to 0 and his x to random
            lives = lives - 1;
              ball1Y = 0;
            ball1X = (int) random(width);

        }
        if (sum >= dist(playerX, playerY, ball2x, ball2y)) {
            lives = lives - 1;
              ball2y = 0;
            ball2x = (int) random(width);

        }
        if (sum >= dist(playerX, playerY, ball3x, ball3y)) {
            lives = lives - 1;
            ball3y = 0;
            ball3x = (int) random(width);

        }
        if (sum >= dist(playerX, playerY, ball4x, ball4y)) {
            lives = lives - 1;
            ball4y = 0;
            ball4x = (int) random(width);


        }
        if (sum >= dist(playerX, playerY, ball5x, ball5y)) {
            lives = lives - 1;
            ball5y = 0;
            ball5x = (int) random(width);


        }
        if (sum >= dist(playerX, playerY, ball6x, ball6y)) {
            lives = lives - 1;
            ball6y = 0;
            ball6x = (int) random(width);
        }

    }
      
    public void extraPoints() { // this method checking if the good ball touches the player and if it does its adding an extra point to the score
        if (sum >= dist(playerX, playerY, goodballx, goodbally)) { // this if statment is checking if the orqange ball touches the player and if he does she is adding 1 point to the score and reseting the y to 0 and x to random
            count = count + 1;
            goodbally = 0;
            goodballx = (int) random(width);

        }
    }

    public void playerSizeColor() { // this method is printig out the player circle at the green color 

        fill(0, 255, 0);
        circle(playerX, playerY, 70);

    }

    public void badBallSizeColor() { //this method is printing the bad balls at the circle shape in the red color

        fill(255, 0, 0);
        circle(ball1X, ball1Y, 40);

        fill(255, 0, 0);
        circle(ball2x, ball2y, 40);

        fill(255, 0, 0);
        circle(ball3x, ball3y, 40);

        fill(255, 0, 0);
        circle(ball4x, ball4y, 40);

        fill(255, 0, 0);
        circle(ball5x, ball5y, 40);

        fill(255, 0, 0);
        circle(ball6x, ball6y, 40);

    }

    public void goodBallSizeColor() { // this method is printing the good ball in a circle shap at the orange color 
        fill(255, 165, 0);
        circle(goodballx, goodbally, 40);

    }

    public void mousePressed() { //this method is checking if the player is pressing the button of play again or start so the scene is becoming 2

        if (scene == 1 && mouseX >= 350 && mouseX <= 650 && mouseY >= 300 && mouseY <= 420) {
            scene = 2;
        }

        if (scene == 3 && mouseX >= 350 && mouseX <= 650 && mouseY >= 300 && mouseY <= 420) {
            reset();
            scene = 2;
        }

    }

    public void keyPressed() { //this method is checking if the key left/right is pressd so they become true
        if (keyCode == LEFT) {
            left = true;
        }

        if (keyCode == RIGHT) {
            right = true;
        }

    }

    public void keyReleased() { //this method is checking if the key left/right is realesd so they become false again
        if (keyCode == LEFT) {
            left = false;

        }
        if (keyCode == RIGHT) {
            right = false;
        }

    }
}