import java.awt.*;
import java.applet.*;

/*
<applet code="Smily" width=400 height=500>
</applet>
*/

public class Smily extends Applet{
public void blink()
{
	
		repaint();
}
	
	public void paint(Graphics g)
{
	g.setColor(Color.yellow);
	g.fillOval(20,20,400,400);
	g.setColor(Color.black);
	g.fillArc(100,120,250,250,180,180);
	
	try{
		
	Thread.sleep(1000);
	g.setColor(Color.black);
	g.fillOval(125,70,80,90);
	g.fillOval(250,70,80,90);
	Thread.sleep(1000);
	blink();


	}catch(Exception e){}

	}
	}