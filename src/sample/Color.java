package sample;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Instances of this class are used for operations on six colors.
 * It provides methods used for setting colors of circles and setting key to guess.
 */
public class Color {

    /**
     * <code>ArrayList</code> containing possible colors.
     */
    private ArrayList<String> colors;

    /**
     * Field used for counting which color from <code>colors</code> will be used
     */
    private int counter = 0;

    /** @hidden */
    private void setArray() {
        String blue = "0x1e90ffff";
        String red = "0xb62a2aff";
        String green = "0x248e39ff";
        String yellow = "0xfff200ff";
        String white = "0xffffffff";
        String black = "0x000000ff";
        colors = new ArrayList<>(Arrays.asList(blue, green, yellow, white, black, red));
    }

    /**
     * Method used for getting next color from <code>colors</code>.
     * @return one color from <code>colors</code>
     */
    public String getColors() {

        setArray();
        if (counter == colors.size()) {
            counter = 0;
        }
        counter++;
        return colors.get(counter - 1);
    }

    /**
     * Method used for setting key to guess
     * @param controllerCollors <code>ArrayList</code> object containing color values.
     * @return <code>ArrayList</code> with Integers that are the key to guess
     */
    public ArrayList<Integer> setMyKey(ArrayList<String> controllerCollors) {
        setArray();
        ArrayList<Integer> key = new ArrayList<>();

        for (int i = 0; i < controllerCollors.size(); i++) {
            for (int j = 0; j < colors.size(); j++) {
                if (colors.get(j).equals(controllerCollors.get(i))) {
                    key.add(j);
                }
            }
        }
        return key;
    }

    /**
     * Method used to convert key in <code>int</code> to color in <code>String</code>
     * @param k key
     * @return color
     */
    public String keyToColor(int k) {
        setArray();
        String col = "";
        for (int i = 0; i < colors.size(); i++) {
            if (i == k) {
                col = colors.get(k);
            }
        }
        return col;
    }


}