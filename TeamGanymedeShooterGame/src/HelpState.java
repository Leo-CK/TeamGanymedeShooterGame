import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class HelpState extends GameState
{
    private String[] options = {"Back"};
    private int currentSelection = 0;
    private int step = 100;

    public HelpState(GameStateManager gsm)
    {
        super(gsm);
    }
    @Override
    public void init() {}

    @Override
    public void tick() {}

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,GameWindow.WIDTH,GameWindow.HEIGHT);
        for(int i = 0; i < options.length; i++)
        {
            if(i == currentSelection)
            {
                g.setColor(Color.RED);
            }
            else
            {
                g.setColor(Color.WHITE);
            }
            g.setFont(new Font("Helvetica", Font.PLAIN, 72));
            g.drawString(options[i], 50, 120 + i * step);
        }
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Helvetica", Font.PLAIN, 24));
        g.drawString("Press the left cursor key to move to the snakes left, the right", 50, 200);
        g.drawString("cursor key to move right, and leave well be to continue on on", 50, 248);
        g.drawString("your current bearing. Eat the apples until you reach full length;", 50, 296);
        g.drawString("snakes are full-grown at 20 units long.", 50, 344);
    }

    @Override
    public void keyPressed(int k)
    {
        if(k == KeyEvent.VK_DOWN)
        {
            currentSelection ++;
            if(currentSelection >= options.length)
            {
                currentSelection = 0;
            }
        }
        else if(k == KeyEvent.VK_UP)
        {
            currentSelection --;
            if(currentSelection < 0)
            {
                currentSelection = options.length - 1;
            }
        }
        else if(k == KeyEvent.VK_ENTER)
        {
            System.out.println(options[0]);
            gsm.states.pop();
        }
    }

    @Override
    public void keyReleased(int k) {}
}