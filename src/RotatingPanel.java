
import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
public class RotatingPanel extends Panel {
    private float degrees;
    private boolean rotating;

    public RotatingPanel(int _x, int _y, int _width, int _height) {
        super( _x, _y, _width, _height);
        degrees = 1;
        rotating = false;
    }

    public void display() {
        if (!rotating) {
            super.display();
            Main.app.fill(0);
            Main.app.textAlign(Main.app.CENTER);
            Main.app.text("Click me!", getX() + getWidth()/2, getY() + getHeight()/2);
        } else {
            Main.app.imageMode(Main.app.CENTER);
            int x = getX();
            int y = getY();

            Main.app.push();

            Main.app.translate(x + getWidth()/2, y + getHeight()/2);
            Main.app.rotate(Main.app.radians(degrees));
            degrees+=10;

            setX(0);
            setY(0);
            super.display();
            setX(x);
            setY(y);

            Main.app.pop();

            Main.app.imageMode(Main.app.CORNER);
        }
    }

    public void handleMouseClicked(int _x, int _y) {
        if (_x > getX() && _x < getX() + getWidth() &&
                _y > getY() && _y < getY() + getHeight()) {
            rotating = !rotating;
        }
    }
}