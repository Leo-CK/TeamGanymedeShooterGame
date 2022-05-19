import java.awt.*;
import java.awt.event.KeyEvent;

public class DemoState extends GameState{

    private Player player1;
    private Ground ground1;
    private Sky sky1;

    public DemoState(GameStateManager gsm)
    {
        super(gsm);
    }

    @Override
    public void init()
    {
        player1 = new Player();
        player1.init();
        ground1 = new Ground();
        ground1.init();
        sky1 = new Sky();
        sky1.init();
    }

    @Override
    public void tick()
    {
        player1.tick();
    }

    @Override
    public void draw(Graphics g)
    {
        sky1.draw(g);
        ground1.draw(g);
        player1.draw(g);
    }

    @Override
    public void keyPressed(int k)
    {
        player1.keyPressed(k);

        //Menu shortcut
        if(k == KeyEvent.VK_M) gsm.states.pop();
    }

    @Override
    public void keyReleased(int k)
    {
        player1.keyReleased(k);
    }
}