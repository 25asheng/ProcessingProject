import processing.core.PApplet;
import java.util.ArrayList;
import java.lang.Math;
import processing.core.PImage;

public class Main extends PApplet {
    final int NUM_PANELS_HORIZONTAL = 4; // the horizontal quantity of panels
    final int NUM_PANELS_VERTICAL = 4; // the vertical quantity of panels
    private ArrayList<Panel> panels;
    public static PApplet app;

    public Main(){
        super();
        app = this;
    }

    public static void main(String[] args){
        PApplet.main("Main");
    }

    public void settings(){
        size(600,600);
    }

    public void setup(){
        size(600, 600);
        panels = new ArrayList<Panel>();
        //NUM_PANELS_HORIZONTAL * NUM_PANELS_VERTICAL

        int index = 0;
        for (int i = 0; i < NUM_PANELS_VERTICAL; i++){
            for (int j = 0; j < NUM_PANELS_HORIZONTAL; j++){
                int w = width/NUM_PANELS_HORIZONTAL;
                int h = height/NUM_PANELS_VERTICAL;
                int x = j * w;
                int y = i * h;
                Panel s;
                if (i % 4 == 0){
                    s = new Panel( x, y, w, h);
                } else if (i % 4 == 1) {
                    s = new TintedPanel(  x, y, w, h);
                } else if (i % 4 == 2){
                    s = new ContrastedPanel(  x, y, w, h);
                } else {
                    s = new RotatingPanel( x, y, w, h);
                }
                s.setupImage("bunny.png");
                panels.add(s);
                index++;
            }
        }
    }

    public void draw(){
        fancyBackground();

        for (int i = 0; i < panels.size(); i++){
            Panel s = panels.get(i);
            s.display();
        }
    }

    public void mouseClicked(){
        for(Panel p : panels){
            p.handleMouseClicked(mouseX, mouseY);
        }
    }

    public void keyPressed(){
        if(key =='s'){
            Panel firstPanel = panels.get(0);
            int oldFirstPanelX = firstPanel.getX();
            int oldFirstPanelY = firstPanel.getY();
            Panel lastPanel = panels.get(panels.size() - 1);

            firstPanel.setX(lastPanel.getX());
            firstPanel.setY(lastPanel.getY());
            lastPanel.setX(oldFirstPanelX);
            lastPanel.setY(oldFirstPanelY);

        } else if (key=='r') {
            int rand = (int)random(0,panels.size() - 1);
            Panel original = panels.get(rand);
            Panel replace = null;
            if(original instanceof ContrastedPanel){
                replace = new RotatingPanel(original.getX(), original.getY(), original.getWidth(), original.getHeight());
            } else if(original instanceof RotatingPanel){
                replace = new TintedPanel(original.getX(), original.getY(), original.getWidth(), original.getHeight());
            } else if(original instanceof TintedPanel){
                replace = new Panel(original.getX(), original.getY(), original.getWidth(), original.getHeight());
            } else if(original instanceof Panel){
                replace = new ContrastedPanel(original.getX(), original.getY(), original.getWidth(), original.getHeight());
            }
            replace.setupImage("bunny.png");
            panels.set(rand,replace);
        }
    }
    private void fancyBackground(){
        loadPixels();

        for (int x = 0; x < width; x++ ) {
            for (int y = 0; y < height; y++ ) {

                int loc = x + y * width;

                if (x % 30 == 0 || x % 30 == 1 || x % 30 == 2 || x % 30 == 3 || x % 30 == 4 || x % 30 == 5) {
                    pixels[loc] = color(160,219,190);
                } else {
                    pixels[loc] = color(211,240,231);
                }
            }
        }

        updatePixels();
    }
}