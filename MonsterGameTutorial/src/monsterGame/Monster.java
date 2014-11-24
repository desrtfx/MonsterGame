package monsterGame;

public class Monster extends AbstractBeing {

	// Monster related constants

	// Maximum monster health for monster creation
	private static final int MAX_MONSTER_HEALTH = 75;

	// Minimum monster health for monster creation
	private static final int MIN_MONSTER_HEALTH = 15;

	// Maximum monster attack damage
	private static final int MAX_MONSTER_ATTACK_DAMAGE = 25;

	// Drop chance for Health Potions in percent
	private static final int HEALTH_POTION_DROP_CHANCE = 50; // Percentage

	// Maximum number of Health Potions dropped
	private static final int MAX_NO_HEALTH_POTION_DROP = 4;

	// Instance variables

	// Name of the monster
	private String name;

	// Default constructor
	// Monster name is "Blabberghast" and
	// monster is created with minimum health
	public Monster() {
		this("Blabberghast", MIN_MONSTER_HEALTH);
	}

	// Full constructor
	// initializes a new monster
	// with name and health
	public Monster(String name, int health) {
		super((health > MAX_MONSTER_HEALTH) ? MAX_MONSTER_HEALTH : health);
		this.name = name;
	}

	// Name constructor
	// initializes a new monster
	// with name and a random health between min and max
	public Monster(String name) {
		super();
		this.name = name;
		health = rnd.nextInt(MAX_MONSTER_HEALTH - MIN_MONSTER_HEALTH + 1)
				+ MIN_MONSTER_HEALTH;
	}

	// Attack routine for monsters
	// overrides the abstract method from AbstractBeing
	// deals random damage between 0 and MAX_MONSTER_ATTACK_DAMAGE
	@Override
	public int attack() {
		return rnd.nextInt(MAX_MONSTER_ATTACK_DAMAGE);
	}

	// When a monster dies, there is a chance that the monster drops
	// one or more health potions.
	public int dropPotion() {
		// If the random number generated is larger than the 
		// drop chance, at least one health potion is dropped
		if (rnd.nextInt(100) > HEALTH_POTION_DROP_CHANCE) {
			return rnd.nextInt(MAX_NO_HEALTH_POTION_DROP) + 1;
		}
		// no health potions dropped
		return 0;
	}

	// return the monster name
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "\t" + name + "\tHP:" + health;
	}
}
