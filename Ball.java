import java.awt.*;
import java.awt.event.*;

class Ball extends Frame implements Runnable
{
    int x,y,dx,dy,rad;

    static Ball obj=new Ball();

    Ball()
    {
        x=y=50;
        dx=dy=10;
        rad=50;

        Thread t=new Thread(this);
        t.start();

        this.setBackground(Color.yellow);

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });


    }

    public void run()
    {
        while(true)
        {
            try
            {
                Thread.sleep(16);
            }
            catch(InterruptedException ie)
            {
            }
            x=x+dx;
            y=y+dy;

            if(x<=0 || (x+dx+rad)>=obj.getWidth())
            {
                dx=-dx;
            }
            if(y<=0 || (y+dy+rad)>=obj.getHeight())
            {
                dy=-dy;
            }

            repaint();
        }
    }

    public void paint(Graphics g)
    {
        //super.paint(g);
        g.setColor(Color.red);
        g.fillArc(x,y,rad,rad,0,360);
    }

    public static void main(String[]args)
    {
        obj.setTitle("Ball");
        obj.setSize(400,500);
        obj.setVisible(true);
    }
}
