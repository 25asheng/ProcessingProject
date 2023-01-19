import processing.core.PApplet;

public class Main extends PApplet {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    final int NUM_PANELS_HORIZONTAL = 4; // the horizontal quantity of panels
    final int NUM_PANELS_VERTICAL = 4; // the vertical quantity of panels
    Panel[] panels;

    public void setup(){
        size(600, 600);
        panels = new Panel[NUM_PANELS_HORIZONTAL * NUM_PANELS_VERTICAL];

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
                panels[index] = s;
                index++;
            }
        }
    }

    public void draw(){
        fancyBackground();

        for (int i = 0; i < panels.length; i++){
            Panel s = panels[i];
            s.display();
        }
    }

    public void mouseClicked(){
        for (int i = 0; i < panels.length; i++){
            Panel s = panels[i];
            s.handleMouseClicked(mouseX, mouseY);
        }
    }

    private void fancyBackground(){
        loadPixels();

        for (int x = 0; x < width; x++ ) {
            for (int y = 0; y < height; y++ ) {

                int loc = x + y * width;

                if (x % 2 == 0) {
                    pixels[loc] = color(255);
                } else {
                    pixels[loc] = color(0);
                }
            }
        }

        updatePixels();
    }
}