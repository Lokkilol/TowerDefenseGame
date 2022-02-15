package Model;

import java.util.Set;

/**
 * Represents a standard board with basic towers and units.
 */
public interface Board {

  /**
   * Adds a unit to attack the towers.
   * @param unit
   */
  public void addUnit(Unit unit);

  /**
   * Adds a Tower to the defense for the player.
   * @param tower Any type of tower for the defense
   * @param cost Cost of tower
   * @throws IllegalArgumentException if cost of tower is above total amount of money.
   */
  public void addTower(Tower tower, int cost) throws IllegalArgumentException;

  public void repairTower(int index);

  public void sellTower(int index);

  public boolean gameOver();

  public int getScore();

  public int getMoney();

  public void addMoney(int value);

  public void fight();

  public boolean fightResult();

  public int unitsSize();

  public int towersSize();

  public String returnTowers();

  public void clearUnits();

  public int getWaveLevel();

  public void setWaveLevel(int value);

  public void setMoney(int value);

  public void clearTowers();

  public String returnUnits();

}
