package Model;

public class Lvl1Unit implements Unit {

  private int health;
  private final int damage;

  public Lvl1Unit(int health, int damage) {
    this.health = health;
    this.damage = damage;
  }

  @Override
  public void takeDamage(int damage) {
    this.health = this.health - damage;
    clamp();
  }

  @Override
  public int getDamage() {
    return this.damage;
  }

  @Override
  public int getHealth() {
    return this.health;
  }

  @Override
  public void setHealth(int value) {
    this.health = value;
  }


  private void clamp() {
    if (this.health <= 0) {
      health = 0;
    }
  }
}
