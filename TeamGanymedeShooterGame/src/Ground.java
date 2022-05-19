import java.awt.*;
import java.awt.Graphics;

public class Ground {
    private static final long serialVersionUID = 1L;

    //Ground level
    public static final int groundbaseheight = 160;

    public Ground() {}

    public void init() {}

    public void tick() {}

    public void draw(Graphics g) {
        //Draw the ground
        Color groundcolor = new Color(51, 70, 25);
        g.setColor(groundcolor);
        g.fillRect(0,GameWindow.HEIGHT - groundbaseheight, GameWindow.WIDTH, groundbaseheight);
    }

    public void keyPressed(int k) {}

    public void keyReleased(int k) {}
}