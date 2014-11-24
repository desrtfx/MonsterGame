package monsterGame;

import java.util.Random;

public abstract class AbstractBeing {

	// Health of the being. Health = 0 ==> Being is dead
	protected int health;
	
	// Random number generator
	protected Random rnd = new Random();

	// Default constructor,
	// creates an extremely weak being
	AbstractBeing() {
		this.health = 1;
	}

	// Constructor
	// Creates a being with health.
	AbstractBeing(int health) {
		this.health = health;
	}

	// Return the health
	public int getHealth() {
		return health;
	}

	// Set the health (for resurrection)
	protected void setHealth(int health) {
		this.health = health;
	}

	// Handle damage caused by attacks
	public void receiveDamage(int damage) {
		
		// apply damage to health
		health -= damage;
		
		// If too much damage was dealt (health < 0)
		// set health to 0 as negative health 
		// (deader than dead) does not make sense.
		health = (health < 0) ? 0 : health;
	}

	// ABSTRACT method
	// to be implemented in subclasses
	// as the attack values can differ
	public abstract int attack();

	// Check if being is dead
	public boolean isDead() {
		return (health < 1);
	}

}
