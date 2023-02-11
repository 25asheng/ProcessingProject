import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
public class TintedPanel extends Panel {

    public TintedPanel(int _x, int _y, int _width, int _height){
        super(_x, _y, _width, _height);// calling the super/parent class constructor
    }

    // overriding the inherited display method
    public void display(){
        Main.app.tint(255, 0, 0, 200);
        super.display(); // calling the inherited display method
        Main.app.noTint();// turns off tint effect after the image is displayed
    }
}


