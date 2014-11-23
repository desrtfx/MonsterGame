package tutorials;

import java.util.Random;

public abstract class AbstractBeing {
	
	protected int health;
	protected Random rnd = new Random();
	
	AbstractBeing() {
		this.health = 0;
	}

	AbstractBeing(int health) {
		this.health = health;
	}
	
	public int getHealth() {
		return health;
	}
	
	protected void setHealth(int health) {
		this.health = health;
	}
	
	public void receiveDamage(int damage) {
		health -= damage;
	}
	
	public abstract int attack();
	
	public boolean isDead() {
		return (health < 1);
	}
	
}
