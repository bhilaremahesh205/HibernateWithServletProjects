import java.awt.*;
import java.applet.*;

/*
public class NewApplet extends Applet implements Runnable {
   String msg = " It is a moving Banner. ";
   char cha;
   boolean stopFlag = true;
   Thread t = null;
   
   public void start() {
      t = new Thread(this);
      stopFlag = false; 
      t.start();
   } 
   public void run() {
      for(;;) { 
         try { 
            repaint();
            Thread.sleep(250);
            cha = msg.charAt(0);
            msg = msg.substring(1,msg.length());
            msg = msg + cha;
            if(stopFlag) break;
         } 
         catch(InterruptedException e) {}
      } 
   } 
   public void stop(){
      stopFlag = true; 
      t = null;
   } 
   public void paint(Graphics g) { 
      g.drawString(msg,60,30);
   }
}

 */
import java.awt.*;
import java.applet.*;

public class NewApplet extends Applet implements Runnable {
   String str = "This is a simple Banner ";
   Thread t ;
   boolean b;
   
   public void init() {
      setBackground(Color.gray);
      setForeground(Color.yellow);
   }
   public void start() {
      t = new Thread(this);
      b = false;
      t.start();
   }
   public void run () {
      char ch;
      for( ; ; ) {
      try {
         repaint();
         Thread.sleep(250);
         ch = str.charAt(0);
         str = str.substring(1, str.length());
         str = str + ch;
      }
      catch(InterruptedException e) {}
      }
   }
   public void paint(Graphics g) {
      g.drawRect(1,1,300,150);
      g.setColor(Color.yellow);
      g.fillRect(1,1,300,150);
      g.setColor(Color.red);
      g.drawString(str, 1, 150);
   }
