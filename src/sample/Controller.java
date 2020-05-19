package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Controller class for the game view. It is used to allow interaction with the application.
 */
public class Controller implements Initializable {


    /**
     * Grid pane used to show the course of the game.
     */
    @FXML
    private GridPane gridPane;

    /**
     * Label used for showing how many colors are in the same position as hidden colors after the first guess.
     */
    @FXML
    private Label labelPosition1;

    /**
     * Label used for showing how many colors are the same as hidden colors after the first guess.
     */
    @FXML
    private Label labelColor1;

    /**
     * Label used for showing how many colors are in the same position as hidden colors after the second guess.
     */
    @FXML
    private Label labelPosition2;

    /**
     * Label used for showing how many colors are the same as hidden colors after the second guess.
     */
    @FXML
    private Label labelColor2;

    /**
     * Label used for showing how many colors are in the same position as hidden colors after the third guess.
     */
    @FXML
    private Label labelPosition3;

    /**
     * Label used for showing how many colors are the same as hidden colors after the third guess.
     */
    @FXML
    private Label labelColor3;

    /**
     * Label used for showing how many colors are in the same position as hidden colors after four guesses.
     */
    @FXML
    private Label labelPosition4;

    /**
     * Label used for showing how many colors are the same as hidden colors after four guesses.
     */
    @FXML
    private Label labelColor4;

    /**
     * Label used for showing how many colors are in the same position as hidden colors after five guesses.
     */
    @FXML
    private Label labelPosition5;

    /**
     * Label used for showing how many colors are the same as hidden colors after five guesses.
     */
    @FXML
    private Label labelColor5;

    /**
     * Label used for showing how many colors are in the same position as hidden colors after six guesses.
     */
    @FXML
    private Label labelColor6;

    /**
     * Label used for showing how many colors are the same as hidden colors after six guesses.
     */
    @FXML
    private Label labelPosition6;

    /**
     * Circle showing the first hidden color.
     */
    @FXML
    private Circle hiddenOne;

    /**
     * Circle showing the second hidden color.
     */
    @FXML
    private Circle hiddenTwo;

    /**
     * Circle showing the third hidden color.
     */
    @FXML
    private Circle hiddenThree;

    /**
     * Circle showing the fourth hidden color.
     */
    @FXML
    private Circle hiddenFour;

    /**
     * Instance of class <code>Color</code> used for setting colors of hidden colors.
     */
    private Color color = new Color();

    /**
     * Instance of class <code>Engine</code> used to start the game process.
     */
    private Engine engine = new Engine();

    /**
     * OnClick event function, executed after pressing button <b>START</b>, used for starting the game
     * @param event Event object
     */
    @FXML
    void buttonPlayClicked(ActionEvent event) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList(hiddenOne.getFill().toString(), hiddenTwo.getFill().toString(), hiddenThree.getFill().toString(), hiddenFour.getFill().toString()));
        engine.setKey(color.setMyKey(colors));
        ArrayList<Label> wyniki = new ArrayList<>(Arrays.asList(labelPosition1, labelColor1, labelPosition2, labelColor2, labelPosition3, labelColor3, labelPosition4, labelColor4, labelPosition5, labelColor5, labelPosition6, labelColor6));
        engine.setVariables(gridPane, wyniki);
        engine.start();
    }

    /**
     * OnClick event function, executed after pressing Circle <code>hiddenOne</code>, used for changing the color of the circle.
     * @param event Event object
     */
    @FXML
    void hiddenOneClicked(MouseEvent event) {
        hiddenOne.setFill(javafx.scene.paint.Color.valueOf(color.getColors()));
    }

    /**
     * OnClick event function, executed after pressing Circle <code>hiddenTwo</code>, used for changing the color of the circle.
     * @param event Event object
     */
    @FXML
    void hiddenTwoClicked(MouseEvent event) {
        hiddenTwo.setFill(javafx.scene.paint.Color.valueOf(color.getColors()));
    }

    /**
     * OnClick event function, executed after pressing Circle <code>hiddenThree</code>, used for changing the color of the circle.
     * @param event Event object
     */
    @FXML
    void hiddenThreeClicked(MouseEvent event) {
        hiddenThree.setFill(javafx.scene.paint.Color.valueOf(color.getColors()));
    }

    /**
     * OnClick event function, executed after pressing Circle <code>hiddenFour</code>, used for changing the color of the circle.
     * @param event Event object
     */
    @FXML
    void hiddenFourClicked(MouseEvent event) {
        hiddenFour.setFill(javafx.scene.paint.Color.valueOf(color.getColors()));
    }

    /**
     * Method called after FXML file read. It sets properties to the fields of the class.
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hiddenOne.setFill(javafx.scene.paint.Color.valueOf("0xb62a2aff"));
        hiddenTwo.setFill(javafx.scene.paint.Color.valueOf("0xb62a2aff"));
        hiddenThree.setFill(javafx.scene.paint.Color.valueOf("0xb62a2aff"));
        hiddenFour.setFill(javafx.scene.paint.Color.valueOf("0xb62a2aff"));
    }
}
