package sample;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import mastermind_calc.Calculations;
import mastermind_calc.Counter;

import java.util.*;

/**
 * Class used for updating the course of the game and JavaFx objects
 */
public class Engine implements Runnable, JavaFXUpdater {

    /**
     * <code>ArrayList</code> containing key to guess.
     */
    private ArrayList<Integer> key;

    /**
     * Grid pane used to show the course of the game.
     */
    private GridPane gridPane;

    /**
     * Instance of class <code>Color</code> used for setting colors of hidden colors.
     */
    private Color color = new Color();

    /**
     * Instance of class <code>Thread</code> used as a timer.
     */
    private Thread thread;

    /**
     * Field used for controlling the game process.
     */
    private volatile boolean isRunning;

    /**
     *Field used for storing information, in which column in <code>gridPane</code> new items are added.
     */
    private int column;

    /**
     *Field used for storing information, in which row in <code>gridPane</code> new items are added.
     */
    private int row;

    /**
     * <code>ArrayList</code> containing labels in which the results of 'position' and 'color only' are stored.
     */
    private ArrayList<Label> results;

    /**
     *Field used for storing the number of colors that are the same as in key.
     */
    private int colorCounter;

    /**
     *Field used for storing the number of colors that are in the same position as in key.
     */
    private int positionCounter;

    /**
     *Field used for storing the guess.
     */
    private String guess;

    /**
     * Method used for setting the fields of the class.
     * @param gridPane used to show the course of the game.
     * @param results <code>ArrayList</code> containing labels in which the results of 'position' and 'color only' are stored.
     */
    public void setVariables(GridPane gridPane, ArrayList<Label> results) {
        this.gridPane = gridPane;
        this.results = results;
    }

    /**
     * Method used for setting the key
     * @param arrayKey <code>ArrayList</code> containing key to guess.
     */
    public void setKey(ArrayList<Integer> arrayKey) {
        key = new ArrayList<>(arrayKey);
    }

    /**
     * Method used for returning the key.
     * @return <code>ArrayList</code> containing key to guess.
     */
    public ArrayList<Integer> getKey() {
        return key;
    }

    /**
     * Method used for creating the timer thread and launching the timer.
     */
    public void start() {
        thread = new Thread(this, "built-in timer");
        thread.start();
    }

    /**
     * Method used for stopping the timer.
     */
    public void stop() {
        isRunning = false;
    }

    /**
     * Method called after executing method <code>start()</code>.
     * It calculates what the next guess will be and updates JavaFX objects.
     */
    @Override
    public void run() {
        isRunning = true;
        Set<String> possibleNumbers = Calculations.generatePossibleNumbers();
        positionCounter = 0;
        colorCounter = 0;
        String key = fromArrayToString(getKey());

        while (isRunning) {

            for (row = 1; row < 7; row++) {
                Iterator<String> iterator = possibleNumbers.iterator();
                guess = iterator.next();

                for (int i = 0; i < key.length(); i++) {
                    for (int j = 0; j < key.length(); j++) {
                        if (guess.charAt(j) == key.charAt(i)) {
                            colorCounter++;
                        }
                    }
                    if (key.charAt(i) == guess.charAt(i)) {
                        positionCounter++;
                    }
                }
                colorCounter = colorCounter - positionCounter;
                Calculations.removeWrongNumbers(new Counter(positionCounter, colorCounter), guess, possibleNumbers);
                System.out.println(guess.toCharArray());



                for (column = 1; column < 5; column++) {

                    updateFxObjects();

                    try { Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (positionCounter == 4) {
                    isRunning = false;
                    break;
                }

                try { Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                positionCounter = 0;
                colorCounter = 0;
            }
        }
        isRunning = false;
    }

    /**
     * Method used for setting parameters of JavaFx objects. The method is intended to be called via default
     * <code>updateFxObjects()</code> method from <code>JavaFxUpdater</code> interface, which will
     * launch the method in <code>Platform.runLater(Runnable runnable)</code>.
     */
    @Override
    public void initUpdate() {
        Circle circle = new Circle();
        circle.setRadius(20);
        circle.setFill(javafx.scene.paint.Color.valueOf(color.keyToColor(toArray(guess).get(column - 1))));
        circle.setStroke(javafx.scene.paint.Color.valueOf("BLACK"));
        circle.setStrokeWidth(1.5);
        gridPane.add(circle, column, row);
        int rows = row * 2;
        switch (rows) {
            case 2: {
                results.get(rows - 2).setText(String.valueOf(positionCounter));
                results.get(rows - 1).setText(String.valueOf(colorCounter));
            }
            case 4: {
                results.get(rows - 2).setText(String.valueOf(positionCounter));
                results.get(rows - 1).setText(String.valueOf(colorCounter));
            }

            case 6: {
                results.get(rows - 2).setText(String.valueOf(positionCounter));
                results.get(rows - 1).setText(String.valueOf(colorCounter));
            }
            case 8: {
                results.get(rows - 2).setText(String.valueOf(positionCounter));
                results.get(rows - 1).setText(String.valueOf(colorCounter));
            }
            case 10: {
                results.get(rows - 2).setText(String.valueOf(positionCounter));
                results.get(rows - 1).setText(String.valueOf(colorCounter));
            }
            case 12: {
                results.get(rows - 2).setText(String.valueOf(positionCounter));
                results.get(rows - 1).setText(String.valueOf(colorCounter));
            }

        }
        if (positionCounter == 4) {
            isRunning = false;
        }
    }

    /**
     * Method used for converting <code>String</code> to <code>ArrayList</code>
     * @param string strings to convert
     * @return <code>ArrayList<Integer></code>
     */
    private ArrayList<Integer> toArray(String string) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            integers.add((int) string.charAt(i) - 48);

        }
        return integers;

    }

    /**
     * Method used for converting <code>ArrayList<Integer></></code> to <code>String</code>
     * @param integers <code>ArrayList<Integer><code/> to convert
     * @return <code>String</code>
     */
    private String fromArrayToString(ArrayList<Integer> integers) {
        String string = "";
        for (Integer integer : integers) {
            string += integer;
        }
        return string;


    }
}
