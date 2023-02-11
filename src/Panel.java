
import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
public class Panel {
    // private instance variables
    private PImage img;
    private int x;
    private int y;
    private int w;
    private int h;

    // constructor
    public Panel(int _x, int _y, int _w, int _h) {
        x = _x;
        y = _y;
        w = _w;
        h = _h;
    }

    public void setupImage(String imageName) {
        img = Main.app.loadImage(imageName);
    }

    public void display() {Main.app.image(img, x, y, w, h);
    }

    public void handleMouseClicked(int _x, int _y) {
        System.out.println("Mouse clicked ");
    }

    public PImage getImageCopy() {
        return img.copy();
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int _x) {
        x = _x;
    }

    public void setY(int _y) {
        y = _y;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {return h;
    }
}