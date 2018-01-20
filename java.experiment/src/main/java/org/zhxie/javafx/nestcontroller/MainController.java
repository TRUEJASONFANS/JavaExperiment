package org.zhxie.javafx.nestcontroller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainController extends Application {

  @FXML private SecondController secondController;

  @Override
  public void start(Stage primaryStage) throws Exception {
    HBox hbox = new HBox();

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
    fxmlLoader.setController(this);
    Object resultNode = fxmlLoader.load();
    hbox.getChildren().add((Node)resultNode);
    primaryStage.setScene(new Scene(hbox));
    primaryStage.setTitle("Custom Control");
    primaryStage.show();
  }

  @FXML
  private void mainFXMLBtn() {
    System.out.println("This is :"+ this.getClass().getName() + "Main FXML button was clicked!");
  }

  public static void main(String[] args) {
    launch();
  }
}
