package Model;

/**
 * A Basic tower is....
 */
public class BasicTower implements Tower {
  final private int cost;
  final private int damage;
  private int health;

  /**
   *
   * @param cost
   * @param damage
   */
  public BasicTower(int cost, int damage) {
    this.cost = cost;
    this.damage = damage;
    this.health = 100;
  }

  @Override
  public void repairTower() {
    this.health = 100;
  }

  @Override
  public int repairCost() {
    return 100 - this.health;
  }

  @Override
  public int getHealth() {
    return health;
  }

  @Override
  public int getDamage() {
    return this.damage;
  }

  @Override
  public void setHealth(int newHealth) {
    this.health = newHealth;
  }


  @Override
  public int sellTowerCost() {
    return this.cost / 2;
  }

  @Override
  public void attack(Unit unit) {
    unit.takeDamage(this.damage);
  }
}
