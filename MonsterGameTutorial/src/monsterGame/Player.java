package monsterGame;

public class Player extends AbstractBeing {

	// Player related constants
	// Maximum Player health
	public static final int MAX_PLAYER_HEALTH = 100;

	// Maximum Player damage
	private static final int MAX_PLAYER_ATTACK_DAMAGE = 50;

	// Healing amount of a single Health Potion
	public static final int HEALTH_POTION_HEAL_AMOUNT = 30;

	// Maximum number of health potions that a player can hold
	private static final int MAX_HEALTH_POTIONS = 5;

	// Maximum player resurrection allowed
	private static final int MAX_PLAYER_RESURRECTION = 3;

	// Player gets new Resurrection chance every x kills
	private static final int NEW_LIFE_EVERY = 20;

	// Player defaults
	// Initial number of Health Potions
	private int healthPotions = 3;

	// Initial number of kills
	private int kills = 0;

	private int deathCount = 0;
	
	private int healthPotionCount = 0;
	
	// Count how many times the player was resurrected
	private int resurrectionCount = 0;

	// Flag that indicates that the player ran away
	private boolean runaway = false;

	// Flag that indicates that the player wants to quit
	private boolean quit = false;

	// Default Player starts with maximum health
	public Player() {
		super(MAX_PLAYER_HEALTH);
		resurrectionCount = 0;
	}

	// initialise a player with a set health less than max health
	public Player(int health) {
		super((health <= MAX_PLAYER_HEALTH) ? health : MAX_PLAYER_HEALTH);
	}

	public boolean resurrect() {
		resurrectionCount++;
		if (resurrectionCount <= MAX_PLAYER_RESURRECTION) {
			health = MAX_PLAYER_HEALTH;
			return true;
		}
		return false;
	}
	
	public boolean canResurrect() {
		return (resurrectionCount < MAX_PLAYER_RESURRECTION);
	}
	


	public boolean hasRunAway() {
		return runaway;
	}

	public void setRunAway() {
		this.runaway = true;
	}

	public void resetRunAway() {
		this.runaway = false;
	}

	public boolean hasQuit() {
		return quit;
	}

	public void setQuit() {
		this.quit = true;
	}

	public void resetQuit() {
		this.quit = false;
	}

	// add amount health potions up to the maximum
	public void addHealthPotions(int amount) {
		if (healthPotions + amount <= MAX_HEALTH_POTIONS) {
			healthPotions += amount;
		} else {
			healthPotions = MAX_HEALTH_POTIONS;
		}
	}

	public void incKills() {
		kills++;
		adjustResurrectionCount();
	}

	private void adjustResurrectionCount() {
		if (kills % NEW_LIFE_EVERY == 0) {
			if (resurrectionCount > 0) {
				resurrectionCount--;
			}
		}

	}
	
	public void incDeathCount() {
		deathCount++;
	}
	public int getDeathCount() {
		return deathCount;
	}
	
	public int getHealthPotionCount() {
		return healthPotionCount;
	}

	// return the kill counter
	public int getKills() {
		return kills;
	}

	// return the number of health potions in inventory
	public int getHealthPotions() {
		return healthPotions;
	}

	// drink a health potion
	// returns true if potion was drunken successfully
	public boolean drinkHealthPotion() {
		if (healthPotions > 0) {
			if (health < MAX_PLAYER_HEALTH) {
				healthPotions--;
				health += HEALTH_POTION_HEAL_AMOUNT;
				health = (health > MAX_PLAYER_HEALTH ? MAX_PLAYER_HEALTH
						: health);
				healthPotionCount++;
				return true;
			}
		}
		return false;
	}

	// Attack routine for players
	// overrides the abstract method from AbstractBeing
	// deals random damage between 0 and MAX_PLAYER_ATTACK_DAMAGE
	@Override
	public int attack() {
		return rnd.nextInt(MAX_PLAYER_ATTACK_DAMAGE);
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(String.format("You currently have %3d health points.\n",
				health));
		buf.append(String.format("You have %3d health potions left.\n",
				healthPotions));
		buf.append(String
				.format("You have already killed %3d monsters.", kills));

		return buf.toString();
	}

}
