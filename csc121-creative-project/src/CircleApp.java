import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class CircleApp extends PApplet {
    HangmanImage h;
    WordImage w;
    
    public void settings() {
        this.size(400, 400);
        //TO-DO w.size(70, 70); trying to change font size for words 
    }
    
    public void setup() {
        h = new HangmanImage(0);
        w = new WordImage("pearl", 0, 5);
    }
    
    public void draw() {
        h = h.update();
    	h.draw(this);
    	w = w.update();
    	w.draw(this);
    }
    
    public void mousePressed(MouseEvent mev) {
        //w = w.mousePressed(mev);
        //h = h.mousePressed(mev);
        
    }
    
    public void keyPressed(KeyEvent kev) {
        // w = w.keyPressed(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "CircleApp" }, new CircleApp());
    }
}
