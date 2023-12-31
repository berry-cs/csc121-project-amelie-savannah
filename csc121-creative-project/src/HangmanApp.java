import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class HangmanApp extends PApplet {
    private IWorld w;
    final static int SETX = 400;
    final static int SETY = 400;
    
    public void settings() {
        this.size(SETX, SETY);
    }
    
    public void setup() {
        w = new StartWorld();
    }
    
    public void draw() {
    	w.draw(this);
    	w = w.update();
    }
    
    public void mousePressed(MouseEvent mev) {
        //w = w.mousePressed(mev);        
    }
    
    public void keyPressed(KeyEvent kev) {
        w = w.keyPressed(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "HangmanApp" }, new HangmanApp());
    }
}
