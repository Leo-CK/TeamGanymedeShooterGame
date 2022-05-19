import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JPanel implements Runnable, KeyListener {
    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private Thread thread;
    private boolean isRunning = false;

    private int FPS = 60;
    private long targettime = 1000/FPS;

    private GameStateManager gsm;

    public GameWindow()
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        addKeyListener(this);
        setFocusable(true);

        start();
    }
    private void start()
    {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run()
    {
        long start, elapsed, wait;

        gsm = new GameStateManager();

        while(isRunning)
        {
            start = System.nanoTime();
            tick();
            repaint();
            elapsed = System.nanoTime() - start;
            wait = (long) (targettime - elapsed/1e6);
            //System.out.println(wait);

            if(wait<0)
            {
                wait = 0;
            }
            try
            {
                Thread.sleep(wait);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public void tick()
    {
        //System.out.println("Running");
        gsm.tick();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.clearRect(0,0,WIDTH, HEIGHT);
        gsm.draw(g);
    }
    @Override
    public void keyPressed(KeyEvent e)
    {
        gsm.keyPressed(e.getKeyCode());
    }
    @Override
    public void keyReleased(KeyEvent e)
    {
        gsm.keyReleased(e.getKeyCode());
    }
    @Override
    public void keyTyped(KeyEvent e)
    {}
}