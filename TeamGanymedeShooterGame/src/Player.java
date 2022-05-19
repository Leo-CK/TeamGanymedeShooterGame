import java.awt.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import static java.lang.Integer.signum;

public class Player {
    private static final long serialVersionUID = 1L;

    private int[] gravity = {0,5};

    //Score
    int score = 0;

    //Size of player
    private int[] playersize = {80,60};

    //Transform characteristics of player
    private int[] playerlocation = {0,0};
    private int[] playervelocity = {0,0};
    private int[] playeracceleration = {0,0};

    //Next frame interaction checking
    private int[] ghostlocation = {0,0};
    private int[] ghostvelocity = {0,0};
    private int[] ghostacceleration = {0,0};

    //Touching the ground?
    private boolean playergrounded = false;

    //Moving?
    private boolean playermoving = false;

    public Player() {}

    public void init() {
        //Reset starting conditions
        playerlocation[0] = 400;
        playerlocation[1] = 300;
        playervelocity[0] = 0;
        playervelocity[1] = 0;
        playeracceleration[0] = 0;
        playeracceleration[1] = 0;
    }

    public void tick() {
        //Check for collision
        ghostlocation[0] = playerlocation[0] + playervelocity[0];
        ghostlocation[1] = playerlocation[1] + playervelocity[1];

        if(playerlocation[1] < GameWindow.HEIGHT - Ground.groundbaseheight) {
            playergrounded = false;
        }
        if(ghostlocation[1] > GameWindow.HEIGHT - Ground.groundbaseheight) {
            playervelocity[1] = playervelocity[1] - (ghostlocation[1] - (GameWindow.HEIGHT - Ground.groundbaseheight));
            playergrounded = true;
        }

        //Displace player
        playerlocation[0] += playervelocity[0];
        playerlocation[1] += playervelocity[1];

        //Accelerate player
        playervelocity[0] += playeracceleration[0];
        playervelocity[1] += playeracceleration[1];

        if(playergrounded == false) {
            playervelocity[0] += gravity[0];
            playervelocity[1] += gravity[1];
        }

        //Friction
        playermoving = true;
        if(playervelocity[0] == 0) {
            playermoving = false;
        }
        if(playergrounded && playermoving) {
            playervelocity[0] = playervelocity[0] -signum(playervelocity[0]);
        }
    }

    public void draw(Graphics g) {
        //Width and height of player

        //Draw the score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Helvetica", Font.PLAIN, 72));
        String stringscore = String.valueOf(score);
        g.drawString(stringscore,700,75);

        //g.setColor(playercolor);

        //Draw the player
        g.setColor(Color.BLACK);
        g.fillRect(playerlocation[0] - playersize[0]/2,playerlocation[1] - playersize[1], playersize[0], playersize[1]);
    }

    public void keyPressed(int k)
    {
        if(k == KeyEvent.VK_UP && playergrounded) {
            playervelocity[1] = -40;
        }
        if(k == KeyEvent.VK_LEFT && playergrounded) {
            playervelocity[0] = -10;
        }
        if(k == KeyEvent.VK_RIGHT && playergrounded) {
            playervelocity[0] = 10;
        }
    }

    public void keyReleased(int k) {
        if(k == KeyEvent.VK_LEFT && playergrounded) {
            playervelocity[0] = 0;
        }
        if(k == KeyEvent.VK_RIGHT && playergrounded) {
            playervelocity[0] = 0;
        }
    }
}
