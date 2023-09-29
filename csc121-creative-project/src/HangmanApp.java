import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class HangmanApp extends PApplet {
    IWorld w;
    
    public void settings() {
        this.size(400, 400);
        //TO-DO w.size(70, 70); trying to change font size for words 
    }
    
    public void setup() {
    	//w = new HangmanWorld(new HangmanImage(0), new WordImage("pearl"));  startWorld() isn't updating
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
