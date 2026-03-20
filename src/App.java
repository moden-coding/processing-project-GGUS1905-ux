import processing.core.*;

public class App extends PApplet {

    PVector ball1 = new PVector(150, 0);
    PVector ball2 = new PVector(300, 0);
    PVector ball3 = new PVector(450, 0);
    PVector ball4 = new PVector(600, 0);
    PVector ball5 = new PVector(750, 0);
    PVector ball6 = new PVector(900, 0);
    PVector player = new PVector(200, 550);
    PVector goodball = new PVector((int) random(width), 0);

    float speed = 5;
    float playerSpeed = 10;
    float sum = 55;
    boolean left, right;
    int scene = 1;
    int count = 0;
    int highScore = 0;
    int lives = 3;
    int score = 0;

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
            score = count/7;
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

    public void introText() { // this method is all the intro text and insrouctions

        fill(255);
        textSize(60);
        text("DODGE THE RED BALLS", 150, 120); // i used chat here for desigining it at the right place

        textSize(30);
        text("Use LEFT and RIGHT arrows to move", 200, 180); // i used chat here for desigining it at the right place
        text("Touch the ORANGE ball to gain more points!", 200, 220); // i used chat here for desigining it at the right
                                                                      // place
    }

    public void startButton() { // this method is the start button

        fill(0);
        rect(350, 300, 300, 120);

        fill(255);
        textSize(50);
        text("START", 420, 380); // i used chat here for desigining it at the right place and in the rect

    }

    public void Score() { // this method is printting the score at scene 2 at the top left of the screen

        fill(255, 255, 0); // i used chat here for disigning where should i put the text and in which color
        textSize(30);
        text("Score: " + score, 20, 40);
        
    }

    public void lives() { // this method is printing how much lives you have left on the screen in scene 2
        fill(255, 255, 0);
        textSize(30);
        text("lives left: " + lives, 20, 80);
    }

    public void EndText() { // this method is printing all the text in scene 3 on the screen
        textSize(30);
        text("High Score: " + highScore, 20, 160);

        fill(255);
        textSize(70);
        text("GAME OVER", 300, 120);

        textSize(40);
        text("Score: " + score, 400, 200);

        if (highScore < score) { // this if stament is checking if count is bigger than the highscore so the
                                 // count becomes the high score
            highScore = score;
        }
    }

    public void playAgain() { // this method is showing a button on the screen that says play again in it

        fill(0);
        rect(350, 300, 300, 120);

        fill(255);
        textSize(40);
        text("PLAY AGAIN?", 365, 380); // i used chat here for desigining it at the right place in the rectangle

    }

    public void badBallMovment(PVector ball) {
        ball.y = ball.y + speed;

    }

    public void badBallMovment() { // this method is for the momvment of the bad ball
        badBallMovment(ball1);
        badBallMovment(ball2);
        badBallMovment(ball3);
        badBallMovment(ball4);
        badBallMovment(ball5);
        badBallMovment(ball6);
        // ball1.y = ball1.y + speed;

        // ball2.y = ball2.y + speed;

        // ball3.y = ball3.y + speed;

        // ball4.y = ball4.y + speed;

        // ball5.y = ball5.y + speed;

        // ball6.y = ball6.y + speed;

    }

    public void playerMovment() { // this method is saying that if left is true so the player moves to the left
                                  // based on the speed and the same thing for the right
        if (left == true) {

            player.x -= playerSpeed;
        }
        if (right == true) {
            player.x += playerSpeed;
        }

        if (player.x < 0) {
            player.x = 0;
        }

        if (player.x > width) {
            player.x = width;
        }
    }

    public void goodBallMovment() { // this method is doing the movment of the orange ball + checking if the orange
                                    // ball touch the player so the orange ball y is = to 0 and his x is = to random
        goodball.y = goodball.y + speed;
        if (sum >= dist(player.x, player.y, goodball.x, goodball.y)) {
            count = count + 1;
            goodball.y = 0;
            goodball.x = (int) random(width);
        }
    }

    public void reset() { // this method is working once the player gets to scene 3 and she resets all the
                          // variabals
                          System.out.println("reset");
        ball1.x = 150;
        ball1.y = 0;
        speed = 5;
        ball2.x = 300;
        ball2.y = 0;
        ball3.x = 450;
        ball3.y = 0;
        ball4.x = 600;
        ball4.y = 0;
        ball5.x = 750;
        ball5.y = 0;
        ball6.x = 900;
        ball6.y = 0;
        goodball.y = 0;
        goodball.x = (int) random(width);
        player.x = 200;
        player.y = 550;
        playerSpeed = 10;
        sum = 55;
        count = 0;
        lives = 3;
       
    }

    public void goodBallTouchGround() { // this method is saying that if the orange ball touches the ground his y is =
                                        // to 0 and his x is = to random

        if (goodball.y > height) {
            goodball.y = 0;
            goodball.x = (int) random(width);

        }
    }

    public void ballTouchGround(PVector ball) {
        if (ball.y > height) {
            System.out.println("ball touch ground");
            ball.y = 0;
            ball.x = (int) random(width);
            count = count + 1;
            if (random(1) < .15) {
                System.out.println("touch");
                
                speed = speed + 0.5f;
                playerSpeed = playerSpeed - 0.1f;
            }

        }
    }

    public void badBallTouchGround() { // this method is checking for each bad ball if he touches the ground and if he does she resets his y to 0 and his x to random
        ballTouchGround(ball1);
        ballTouchGround(ball2);
        ballTouchGround(ball3);
        ballTouchGround(ball4);
        ballTouchGround(ball5);
        ballTouchGround(ball6);
    }

    public void checkForDeathTouch(PVector ball){
         if (sum >= dist(player.x, player.y, ball.x, ball.y)) { // all of this lines are checking if the bad ball touches the playerr and if it does it taking off live and resets his y to 0 and his x to random
            lives = lives - 1;
            ball.y = 0;
            ball.x = (int) random(width);
    }
    }
   
    public void checkForDeathTouch() { // this method is checking when the player dies


        checkForDeathTouch(ball1);
        checkForDeathTouch(ball2);
        checkForDeathTouch(ball3);
        checkForDeathTouch(ball4);
        checkForDeathTouch(ball5);
        checkForDeathTouch(ball6);
        if (lives == 0) { // this if statment is saying that if the lives = 0 so the scene is becoming scene 3
            scene = 3;
        }

       // if (sum >= dist(player.x, player.y, ball1.x, ball1.y)) { 
          //  lives = lives - 1;
            //ball1.y = 0;
           // ball1.x = (int) random(width);

        //}
        //if (sum >= dist(player.x, player.y, ball2.x, ball2.y)) {
        //    lives = lives - 1;
      //      ball2.y = 0;
    //        ball2.x = (int) random(width);

//        }
  //      if (sum >= dist(player.x, player.y, ball3.x, ball3.y)) {
          //  lives = lives - 1;
           //  ball3.y = 0;
           // ball3.x = (int) random(width);

       // }
       // if (sum >= dist(player.x, player.y, ball4.x, ball4.y)) {
          //  lives = lives - 1;
          //  ball4.y = 0;
           // ball4.x = (int) random(width);

        //}
       // if (sum >= dist(player.x, player.y, ball5.x, ball5.y)) {
        //    lives = lives - 1;
          //  ball5.y = 0;
         //   ball5.x = (int) random(width);

       // }
      //  if (sum >= dist(player.x, player.y, ball6.x, ball6.y)) {
          //  lives = lives - 1;
          //  ball6.y = 0;
          //  ball6.x = (int) random(width);
       // }

    }

    public void extraPoints() { // this method checking if the good ball touches the player and if it does its
                                // adding an extra point to the score
        if (sum >= dist(player.x, player.y, goodball.x, goodball.y)) { // this if statment is checking if the orange ball touches the player and if he does she is adding 1 point to the score and reseting the y to 0 and x to random
            count = count + 1;
            goodball.y = 0;
            goodball.x = (int) random(width);

        }
    }

    public void playerSizeColor() { // this method is printig out the player circle at the green color

        fill(0, 255, 0);
        circle(player.x, player.y, 70);

    }

    public void badBallSizeColor(PVector ball) {
        fill(255, 0, 0);
        circle(ball.x, ball.y, 40);
    }

    public void badBallSizeColor() { // this method is printing the bad balls at the circle shape in the red color
        badBallSizeColor(ball1);
        badBallSizeColor(ball2);
        badBallSizeColor(ball3);
        badBallSizeColor(ball4);
        badBallSizeColor(ball5);
        badBallSizeColor(ball6);

      //  fill(255, 0, 0);
      //  circle(ball1.x, ball1.y, 40);
      //  fill(255, 0, 0);
     //   circle(ball2.x, ball2.y, 40);
      //  fill(255, 0, 0);
      //  circle(ball3.x, ball3.y, 40);
      //  fill(255, 0, 0);
      //  circle(ball4.x, ball4.y, 40);
      //  fill(255, 0, 0);
       // circle(ball5.x, ball5.y, 40);
       // fill(255, 0, 0);
      //  circle(ball6.x, ball6.y, 40);

    }

    public void goodBallSizeColor() { // this method is printing the good ball in a circle shap at the orange color
        fill(255, 165, 0);
        circle(goodball.x, goodball.y, 40);

    }

    public void mousePressed() { // this method is checking if the player is pressing the button of play again or
                                 // start so the scene is becoming 2

        if (scene == 1 && mouseX >= 350 && mouseX <= 650 && mouseY >= 300 && mouseY <= 420) {
            scene = 2;
        }

        if (scene == 3 && mouseX >= 350 && mouseX <= 650 && mouseY >= 300 && mouseY <= 420) {
            reset();
            scene = 2;
        }

    }

    public void keyPressed() { // this method is checking if the key left/right is pressd so they become true
        if (keyCode == LEFT) {
            left = true;
        }

        if (keyCode == RIGHT) {
            right = true;
        }

    }

    public void keyReleased() { // this method is checking if the key left/right is realesd so they become false
                                // again
        if (keyCode == LEFT) {
            left = false;

        }
        if (keyCode == RIGHT) {
            right = false;
        }

    }
}