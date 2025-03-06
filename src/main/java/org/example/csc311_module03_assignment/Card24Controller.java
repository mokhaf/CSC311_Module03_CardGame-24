package org.example.csc311_module03_assignment;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import java.util.Random;

public class Card24Controller {
    @FXML
    private Label cardLabel;

    @FXML
    private TextField expressionField;

    @FXML private ImageView card1Image;
    @FXML private ImageView card2Image;
    @FXML private ImageView card3Image;
    @FXML private ImageView card4Image;


    // Variables
    private int[] cards = new int[4];

    @FXML
    public void initialize() {
        generateNewCards();
    }

    @FXML
    private void generateNewCards() {
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            cards[i] = rand.nextInt(13) + 1;
        }
        updateCardImages();
    }

    private void updateCardImages() {
        card1Image.setImage(getCardImage(cards[0]));
        card2Image.setImage(getCardImage(cards[1]));
        card3Image.setImage(getCardImage(cards[2]));
        card4Image.setImage(getCardImage(cards[3]));
    }

    private Image getCardImage(int value) {
        String imagePath = "/cards/" + value + ".png";  // Example: "/cards/5.png"
        return new Image(getClass().getResourceAsStream(imagePath));
    }

    @FXML
    private void verifyExpression() {
        String userInput = expressionField.getText();
        try {
            if (isValidExpression(userInput) && evaluateExpression(userInput) == 24) {
                showAlert("Success", "Correct! The expression evaluates to 24.");
            } else {
                showAlert("Error", "Invalid expression or does not evaluate to 24.");
            }
        } catch (Exception e) {
            showAlert("Error", "Invalid mathematical expression.");
        }
    }

    private int evaluateExpression(String expr) throws Exception {
        return (int) new javax.script.ScriptEngineManager()
                .getEngineByName("JavaScript").eval(expr);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}