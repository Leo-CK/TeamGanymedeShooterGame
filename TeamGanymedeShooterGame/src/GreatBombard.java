import java.awt.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GreatBombard {
    private static final long serialVersionUID = 1L;

    private int[] bombardlocation = {GameWindow.WIDTH/2,GameWindow.HEIGHT-Ground.groundbaseheight};
    private int[] bombardsize = {120,20};

    private double bombardangle = 2.35619;
    private int bombardvelocity = 90;

    //private Rectangle barrel = new Rectangle(0,bombardsize[1]/2,bombardsize[0],bombardsize[1]);


    public GreatBombard() {}

    public void init() {}

    public void tick() {}

    public void draw(Graphics g) {

        //Draw the barrel

        //g.setColor(Color.DARK_GRAY);
        //g.rotate(Math.toRadians(bombardangle));

        //Graphics2D g2d = (Graphics2D)g;

        Graphics2D gg = (Graphics2D) g.create();
        gg.setColor(Color.DARK_GRAY);
        gg.rotate(bombardangle, bombardlocation[0] + bombardsize[0]/2, bombardlocation[1] + bombardsize[1]/2);
        gg.fillRect(bombardlocation[0], bombardlocation[1], bombardsize[0], bombardsize[1]);
        gg.dispose();

        //g2d.rotate(Math.toRadians(bombardangle));
        //g2d.translate(bombardlocation[0],bombardlocation[1]);
        //g2d.draw(barrel);
        //g2d.fill(barrel);
    }

}
