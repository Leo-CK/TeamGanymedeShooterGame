import java.awt.*;
import java.awt.Graphics;

public class Sky {
    private static final long serialVersionUID = 1L;

    public Sky() {}

    public void init() {}

    public void tick() {}

    public void draw(Graphics g) {
        //Draw the sky
        Color skycolor = new Color(101, 151, 196);
        g.setColor(skycolor);
        g.fillRect(0,0, GameWindow.WIDTH, GameWindow.HEIGHT);
    }

    public void keyPressed(int k) {}

    public void keyReleased(int k) {}
}