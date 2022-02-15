package View;

import java.io.IOException;


public class TextView implements IView {

  private Appendable out;

  public TextView(Appendable out) throws IllegalArgumentException {
    if (out == null) {
      throw new IllegalArgumentException("Invalid Appendable");
    }

    this.out = out;
  }

  @Override
  public void renderMessage(String message) {
    try {
      out.append(message);
    } catch (IOException e) {
      throw new IllegalStateException("Failed to output message");
    }
  }

  @Override
  public void renderMenu() {
    renderMessage("\nThe basics of this game is to beat the waves of the tower " +
            "defense game. You start off with 1000 dollars and buy towers to \n" +
            "fight off units that come from each wave. Each round if you win, " +
            "you win 1000 gold, if you lose, you passively gain 500. To begin, \n" +
            "buy towers and type 'start' when ready. \nType 'help' for a list of commands");
  }
}


