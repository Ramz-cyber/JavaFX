package org.example.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CalculatorApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TextField num1Field = new TextField();
        TextField num2Field = new TextField();
        Label resultLabel = new Label("Result");

        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplicationButton = new Button("*");
        Button divisionButton = new Button("/");


        addButton.setOnAction(e ->calculate(num1Field, num2Field, resultLabel, "+"));
        subtractButton.setOnAction(e ->calculate(num1Field, num2Field, resultLabel, "+"));
        multiplicationButton.setOnAction(e ->calculate(num1Field, num2Field, resultLabel, "+"));
        divisionButton.setOnAction(e ->calculate(num1Field, num2Field, resultLabel, "+"));


       HBox inputField = new HBox(10, new Label("num1"), num1Field,new Label ("num2"), num2Field );
        HBox button = new HBox(10, addButton, subtractButton, multiplicationButton, divisionButton);

        VBox root = new VBox(10, inputField, button, resultLabel);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 200, 400);
        stage.setScene(scene);
        stage.setTitle("Calculator Application");
        stage.show();
    }

  private void calculate( TextField num1Field, TextField num2Field, Label resultLabel, String operation) {
   try {
       double num1 = Double.parseDouble(num1Field.getText());
       double num2 = Double.parseDouble(num2Field.getText());
       double result;
       switch (operation){
           case "+" -> result = num1 + num2;
           case "-" -> result = num1 - num2;
           case "*" -> result = num1 * num2;
           case "/" -> {
               if (num2 == 0) {
                   resultLabel.setText("Cannot divide by zero");
                   return;
               }
                   result = num1 / num2;
               }
               default -> throw new IllegalArgumentException("Invalid operation");
           }

           resultLabel.setText("Result: " + result);

   } catch (NumberFormatException e) {
       resultLabel.setText("Error:  Invalid input");
   }
  }
   public static void main(String[] args) {
        launch(args);
   }
}
