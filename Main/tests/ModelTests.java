import org.junit.Test;

import Model.BasicTower;
import Model.Board;
import Model.LinearBoard;
import Model.Lvl1Unit;
import Model.Tower;
import Model.Unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ModelTests {



  @Test
  public void testAddUnit() {
    Board testBoard = new LinearBoard(1000);
    Unit testUnit = new Lvl1Unit(100,20);
    testBoard.addUnit(testUnit);
    assertEquals(testBoard.unitsSize(), 1);
  }

  @Test
  public void testFight() {
    Board testBoard = new LinearBoard(1000);
    Unit testUnit = new Lvl1Unit(100, 20);
    Tower testTower = new BasicTower(500, 100);
    testBoard.addUnit(testUnit);
    testBoard.addTower(testTower,500);
    testBoard.fight();
    assertEquals(testBoard.towersSize(), 1);

  }

  @Test
  public void testGetMoney() {
    Board testBoard = new LinearBoard(1000);
    assertEquals(testBoard.getMoney(), 1000);
  }

  @Test
  public void testRepair() {
    Board testBoard = new LinearBoard(1000);
    Tower tempTower = new BasicTower(500, 100);
    tempTower.setHealth(50);
    testBoard.addTower(tempTower, 500);
    testBoard.repairTower(0);
    assertEquals(testBoard.getMoney(), 450);

  }

}
