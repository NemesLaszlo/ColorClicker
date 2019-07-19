
package colorclicker;

import java.awt.Color;

public class Field {
    private int value = -1;
    private Color color = null;

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public void setValue(int value) {
        if(this.value == -1){
            this.value = value;
        }
    }

    public void setColor(Color color) {
        if(this.color == null){
            this.color = color;
        }
    }

}
