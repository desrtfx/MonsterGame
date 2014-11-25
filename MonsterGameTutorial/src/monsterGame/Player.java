package monsterGame;


// The player class represents the human player
// it is a subclass from AbstractBeing
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

	// Counter how many times the player died
	private int deathCount = 0;
	
	// Counter how many health potions the player consumed
	private int healthPotionCount = 0;
	
	// Counter how many times the player was resurrected
	private int resurrectionCount = 0;
	
	// Counter how many times the player ran away
	private int runawayCount = 0;

	// Flag that indicates that the player ran away
	private boolean runaway = false;

	// Flag that indicates that the player wants to quit
	private boolean quit = false;

	// Default Player starts with maximum health
	public Player() {
		super(MAX_PLAYER_HEALTH);
		resurrectionCount = 0;
		runawayCount = 0;
	}

	// initialise a player with a set health less than max health
	public Player(int health) {
		super((health <= MAX_PLAYER_HEALTH) ? health : MAX_PLAYER_HEALTH);
	}

	// Bring the player back from the dead if possible
	public void resurrect() {
		resurrectionCount++;
			health = MAX_PLAYER_HEALTH;
			runawayCount = 0;
	}
	
	// Can the player be resurrected?
	public boolean canResurrect() {
		return (resurrectionCount < MAX_PLAYER_RESURRECTION);
	}

	// Has the player run away?
	public boolean hasRunAway() {
		return runaway;
	}

	// The player runs away
	public void setRunAway() {
		runawayCount++;
		this.runaway = true;
	}

	// reset runaway flag (used when a new monster appears)
	public void resetRunAway() {
		this.runaway = false;
	}

	// Has the player quit?
	public boolean hasQuit() {
		return quit;
	}

	// The player wants to quit
	public void setQuit() {
		this.quit = true;
	}

	// The player does not want to quit
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

	// increment the player kill counter
	// and adjust the resurrection counter
	public void incKills() {
		kills++;
		adjustResurrectionCount();
	}

	// every x kills, the player gets an extra life
	// if they have been resurrected before
	private void adjustResurrectionCount() {
		if (kills % NEW_LIFE_EVERY == 0) {
			if (resurrectionCount > 0) {
				resurrectionCount--;
			}
		}

	}
	
	// increment the death counter
	public void incDeathCount() {
		deathCount++;
	}
	
	// return the death counter
	public int getDeathCount() {
		return deathCount;
	}
	
	// return the consumed health potion count
	public int getHealthPotionCount() {
		return healthPotionCount;
	}
	
	// return the runaway count
	public int getRunawayCount() {
		return runawayCount;
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
