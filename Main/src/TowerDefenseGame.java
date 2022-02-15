import java.io.BufferedReader;
import java.io.InputStreamReader;


import Controller.Controller;
import Controller.IController;
import Model.Board;
import Model.LinearBoard;
import View.TextView;

public class TowerDefenseGame {

  public static void main(String[] args) {
    Readable in = new BufferedReader(new InputStreamReader(System.in));
    Board defaultBoard = new LinearBoard(1000);
    IController controller = new Controller(defaultBoard, new TextView(System.out), in);
    controller.startGame();
  }
}
