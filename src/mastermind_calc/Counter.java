package mastermind_calc;

/**
 * Class used for comparing fields from instance of <code>Counter</code> class
 */
public class Counter {

    /**
     *Field used for storing the number of colors that are in the same position as in key.
     */
    private int positionCounter;

    /**
     *Field used for storing the number of colors that are the same as in key.
     */
    private int colorCounter;

    /**
     * Constructor setting the <code>int</code> objects.
     * @param positionCounter number of colors that are in the same position as in key.
     * @param colorCounter number of colors that are the same as in key.
     */
    public Counter(int positionCounter, int colorCounter) {
        this.positionCounter = positionCounter;
        this.colorCounter = colorCounter;
    }

    /**
     * Method used for comparing fields from <code>Counter</code> class
     * @param counter instance of the class <code>Counter</code>
     * @return true if fields contains the same value, false if not
     */
    boolean equals(Counter counter) {
        return positionCounter == counter.positionCounter && colorCounter == counter.colorCounter;
    }


    public int getPositionCounter() {
        return positionCounter;
    }

    public int getColorCounter() {
        return colorCounter;
    }
}