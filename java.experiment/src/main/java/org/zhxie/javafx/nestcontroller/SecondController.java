package org.zhxie.javafx.nestcontroller;

import javafx.fxml.FXML;

public class SecondController  {

  @FXML
  private void secondFXMLBtn() {
    System.out.println("This is :"+ this.getClass().getName() +" Second FXML button was clicked!");
  }
}
