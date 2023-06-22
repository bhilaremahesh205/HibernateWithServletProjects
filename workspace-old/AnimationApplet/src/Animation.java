import java.applet.Applet;
import java.awt.*;
import java.awt.Image;

public class Animation extends Applet {

	public void init() {
		// TODO Auto-generated method stub
setSize(1200,800);
	}

	public void paint(Graphic g) {
		int x,y;
		Image img=getImage(getCodeBase(),"a.jpg");
		for(x=0;x<800;x++)
		{
			g.drawImage(img, x, 0, null);
			try {
				Thread.sleep(20);
			}catch(ClassNotFoundException ie) {
				
			}
		}
	}
	
}
