import java.applet.Applet;
import java.awt.Image;

public class Container extends Applet{

	int x,y;
	int xSpeed;
	Image background,aa,bb,cc;
	
	public void setup() {
		size(600,600);
		background =loadImage("cc.png");
	
		aa =loadImage("aa.png");
		
		
		x=300; y=300;
		
		xSpeed = 3;
		
		
	}
	
	private Image loadImage(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private void size(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
		background(background);
		
		if(x >= 500) xSpeed = -xSpeed;
		if(x <= 500) xSpeed = -xSpeed;
		
		x=x+xSpeed;
		//ellipse(x,y,50,50);
		image(aa,300,300);
	}
	
	
	
	private void background(Image background2) {
		// TODO Auto-generated method stub
		
	}

	private void image(Image aa2, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
