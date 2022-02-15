package Model;

/**
 * Describes a standard Tower that defends the player.
 */
public interface Tower {

  /**
   * Returns the 1/2 cost of the tower to sell a tower. Towers can only be sold at full health.
   * @return
   */
  public int sellTowerCost();

  /**
   * Attacks a unit based off the tower damage.
   * @param unit the given unit.
   */
  public void attack(Unit unit);

  /**
   * Repairs a tower's health to 100.
   */
  public void repairTower();

  /**
   * Gives the repair cost to bring a tower to full health.
   * @return an int of the repair cost.
   */
  public int repairCost();

  /**
   * Gets the current health of a specific tower
   * @return an int of the health.
   */
  public int getHealth();

  public int getDamage();

  /**
   * Sets the current health of a specific tower to the given value.
   * @param health an int of the desired health value.
   */
  public void setHealth(int health);


}
