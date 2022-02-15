package Controller;



import java.util.Scanner;

import Model.BasicTower;
import Model.Board;
import Model.Lvl1Unit;
import View.IView;

public class Controller implements IController {
  protected Board board;
  protected IView view;
  protected Readable r;

  public Controller(Board board, IView view, Readable r) throws IllegalArgumentException {
    if (board == null || view == null || r == null) {
      throw new IllegalArgumentException("Null parameters");
    }
    this.board = board;
    this.view = view;
    this.r = r;

  }



  @Override
  public void startGame() {
    view.renderMessage("Welcome to the Justin Wu's basic Tower Defense Game!" + "\n");
    view.renderMenu();
    Scanner s = new Scanner(this.r);
    view.renderMessage("\n");
    returnMoney();
    while (!board.gameOver()) {
      if (s.hasNext()) {
        String cmd = s.next().toLowerCase();
        if (cmd.equals("q") || cmd.equals("quit") || board.gameOver()) {
          view.renderMessage("Game Over!");
          return;
        } else {
          switch (cmd) {
            case "buy":
              buyMenu();
              String subject = s.next().toLowerCase();
              switch(subject) {
                case "tower1":
                  try {
                    board.addTower(new BasicTower(500, 100), 500);
                    returnMoney();
                  } catch (IllegalArgumentException e) {
                    view.renderMessage("Insufficient funds!");
                  }
                case "tower2":
              }
              break;
            case "start":
              if (board.towersSize() == 0) {
                view.renderMessage("Must have towers present! Buy some Towers!");
              } else {
                view.renderMessage("Wave " + board.getWaveLevel() + "!\n");
                switch (board.getWaveLevel()) {
                  case 1:
                    board.addUnit(new Lvl1Unit(100, 20));
                    board.addUnit(new Lvl1Unit(100, 20));
                    fightResult();
                    break;
                  case 2:
                    board.addUnit(new Lvl1Unit(500, 50));
                    board.addUnit(new Lvl1Unit(100, 100));
                    fightResult();
                    break;
                  case 3:
                    for (int i = 0; i < 5; i++) {
                      board.addUnit(new Lvl1Unit(100, 95));
                    }
                    board.addUnit(new Lvl1Unit(1000, 30));
                    view.renderMessage("Boss Battle! Unit has 1000 health, 30 damage" + "\n");
                    fightResult();
                    break;
                }
              }
              break;
            case "towers":
              view.renderMessage(board.returnTowers());
              break;
            case "repair":
              view.renderMessage(board.returnTowers());
              view.renderMessage("Type the int of the tower name." + "\n");
              int next = s.nextInt();
              if ((next >= 0) && next <= board.towersSize()) {
                board.repairTower(next - 1);
                view.renderMessage("Tower: " + next + " Repaired!" + "\n");
                returnMoney();
              } else {
                view.renderMessage("Invalid tower number.");
              }
                break;
            case "restart":
              board.setWaveLevel(1);
              board.setMoney(1000);
              board.clearUnits();
              board.clearTowers();
              view.renderMessage("Game has been Restarted!");
              returnMoney();
              break;
            case "help":
              listCommands();
              break;
            default:
              view.renderMessage("Invalid command!\n");
              break;

          }
        }
      }
    }

  }




  private void returnMoney() {
    view.renderMessage("\nMoney: $" + board.getMoney() + "\n");
  }

  private void buyMenu() {
    view.renderMessage("You can buy:" +" \n" + "Tower1: 100 Health, 100 Damage, $500 Cost\n");
  }

  private void fightResult() {
    view.renderMessage(board.unitsSize() + " vs " + board.towersSize() + "\n");
    returnUnits();
    board.fight();
    if (board.fightResult()) {
      view.renderMessage("You Won! :)" + "\n");
      view.renderMessage("+ $1000" + "\n");
      view.renderMessage("+ $500 \n\n---------------------\n");
      returnTowers();
      board.addMoney(1500);
      if (board.getWaveLevel() == 3) {
        view.renderMessage("Game Won!");
      }
      board.setWaveLevel(board.getWaveLevel() + 1);
    } else {
      view.renderMessage("You Lost :(\n");
      returnUnits();
      view.renderMessage("+ $200" + "\n");
      view.renderMessage("+ $500" + "\n\n--------------------\n");
      board.addMoney(700);
      board.clearUnits();

    }
    returnMoney();
  }

  private void returnUnits() {
    view.renderMessage(board.returnUnits());
  }

  private void returnTowers() {
    view.renderMessage(board.returnTowers());
  }

  private void listCommands() {
    view.renderMessage("buy\nstart\ntowers\nrepair\nrestart\n");
  }

}
