package Model;

/**
 * Represents a standard that attacks the player's defense.
 */
public interface Unit {

  /**
   * Used when a unit takes damage from a Tower.
   * @param damage
   */

  public void takeDamage(int damage);

  /**
   * Gets the damage per second of the unit.
   * @return an int
   */
  public int getDamage();

  /**
   * Gets the health of the unit.
   * @return an int
   */
  public int getHealth();

  public void setHealth(int value);


}
