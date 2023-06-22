 
//
import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class Drawcenter extends Applet
{
    private int x,y;// the x and y of the position of the player
    private BufferedImage image, pos;

    public void init(  )
    {
        try
        {
            image = ImageIO.read(new File("aa.png"));
            pos = ImageIO.read(new File("bb.png"));
        }
        catch (IOException ex)
        {

        }
        x = 150; y = 171;
    }

    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();

        switch( keyCode )
        {
            case KeyEvent.VK_UP: if( y>0 )
            {
                y=y-19;
                repaint();

            }

            break;
            case KeyEvent.VK_DOWN: if( y<171 )
            {
                y=y+19;
                repaint();

            }

            break;
            case KeyEvent.VK_LEFT:if( x>0 )
            {
                x=x-15;
                repaint();

            }

            break;
            case KeyEvent.VK_RIGHT:if( x<285 )
            {
                x=x+15;
                repaint();

            }

            break;
        }
        e.consume();
    }

    public void keyReleased(){

    }

    public void paint( Graphics g )
    {
        g.drawImage(image, 0, 0, null);
        g.drawImage(pos, x, y, null);
    }
}
