import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class MenuState extends GameState
{
    private String[] options = {"Play Game", "Help", "Quit"};
    private int currentSelection = 0;
    private int step = 100;

    public MenuState(GameStateManager gsm)
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
        //g.setColor(Color.YELLOW);
        //g.drawLine(Board.WIDTH/2,0,Board.WIDTH/2, Board.HEIGHT);
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
            if(currentSelection == 0)
            {
                System.out.println(options[0]);
                gsm.states.push(new DemoState(gsm));
            }
            else if(currentSelection == 1)
            {
                System.out.println(options[1]);
                gsm.states.push(new HelpState(gsm));
            }
            else if(currentSelection == 2)
            {
                System.out.println(options[2]);
                System.exit(0);
            }
        }
    }

    @Override
    public void keyReleased(int k) {}
}