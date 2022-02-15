package Model;

import java.util.ArrayList;


public class LinearBoard implements Board {

  private ArrayList<Unit> units;
  private ArrayList<Tower> towers;
  private int money;
  private int score;
  private int waveNumber;

  public LinearBoard(int money) {
    units = new ArrayList<Unit>();
    towers = new ArrayList<Tower>();
    this.money = money;
    this.score = 0;
    waveNumber = 1;
  }

  @Override
  public void addUnit(Unit unit) {
    units.add(unit);
  }

  @Override
  public void addTower(Tower tower, int cost) throws IllegalArgumentException {
    if (cost > this.money) {
      throw new IllegalArgumentException("Cannot buy Tower");
    }
    this.money = this.money - cost;
    towers.add(tower);

  }


  @Override
  public void repairTower(int index) {
    Tower tempTower = towers.get(index);
    if (this.money > tempTower.repairCost()) {
      this.money = this.money - tempTower.repairCost();
      towers.get(index).repairTower();

    }
  }

  @Override
  public void sellTower(int index) {
    int sellCost = towers.get(index).sellTowerCost();
    towers.remove(index);
    this.money = this.money + sellCost;
  }

  @Override
  public boolean gameOver() {
    return waveNumber > 3;
  }

  @Override
  public int getScore() {
    return score;

  }

  @Override
  public int getMoney() {
    return money;
  }

  @Override
  public void addMoney(int value) {
    this.money = this.money + value;
  }


  //TODO: Combat Log? Instead of calculating totals, I could do attack by attack with a while loop?
  //TODO: Maybe you can do a for loop and find the total dps from all the units, so that they all
  //simultaneously attack the tower?
  @Override
  public void fight() {
    while (!units.isEmpty() && !towers.isEmpty()) {
      Unit tempUnit = units.get(0);
      Tower tempTower = towers.get(0);
      int unitTotal = tempUnit.getDamage() * tempUnit.getHealth();
      int towerTotal = tempTower.getHealth() * tempTower.getDamage();
      if (towerTotal > unitTotal) {
        int healthRemaining = (towerTotal - unitTotal) / tempTower.getHealth();
        tempTower.setHealth(healthRemaining);
        units.remove(0);
        towers.set(0, tempTower);
      } else {
        if (towerTotal < unitTotal) {
          int healthRemaining = (unitTotal - towerTotal) / tempUnit.getHealth();
          tempUnit.setHealth(healthRemaining);
          towers.remove(0);
          units.set(0, tempUnit);
        } else {
          towers.remove(0);
          units.remove(0);
        }
      }
    }
}

  @Override
  public boolean fightResult() {
    return !towers.isEmpty();
  }

  @Override
  public int unitsSize() {
    return units.size();
  }

  @Override
  public int towersSize() {
    return towers.size();
  }

  @Override
  public String returnTowers() {
    StringBuilder result = new StringBuilder();
    result.append("Current Towers: \n");
    if (towers.size() > 0) {
      for (int i = 0; i < towers.size(); i++) {
        result.append("Tower: ").append(i + 1).append(", Health: ").append(towers.get(i).getHealth()).
                append(", Damage: ").append(towers.get(i).getDamage()).append("\n");
      }
      return result.toString();
    } else {
      return "Your base has no towers.";
    }

  }

  @Override
  public void clearUnits() {
    units.clear();
  }

  @Override
  public int getWaveLevel() {
    return this.waveNumber;
  }

  @Override
  public void setWaveLevel(int value) {
    this.waveNumber = value;

  }

  @Override
  public void setMoney(int value) {
    this.money = value;
  }

  @Override
  public void clearTowers() {
    towers.clear();
  }

  @Override
  public String returnUnits() {
    StringBuilder result = new StringBuilder();
    result.append("Units:\n");
    if (this.units.size() > 0) {
      for (int i = 0; i < units.size(); i++) {
        result.append("Unit: ").append(i + 1).append(", Health: ").append(units.get(i).getHealth()).
                append(", Damage: ").append(units.get(i).getDamage()).append("\n");
      }
      return result.toString();
    } else {
      return "No units!";
    }

  }

}
