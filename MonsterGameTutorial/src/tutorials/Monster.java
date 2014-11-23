package tutorials;

public class Monster extends AbstractBeing{

	private static final int MAX_MONSTER_HEALTH = 75;
	private static final int MIN_MONSTER_HEALTH = 15;
	private static final int MAX_MONSTER_ATTACK_DAMAGE = 25;
	private static final int HEALTH_POTION_DROP_CHANCE = 50; // Percentage
	private static final int MAX_NO_HEALTH_POTION_DROP = 4;
	
	private String name;
	
	public Monster() {
		this("Blabberghast",0);
	}
	
	public Monster(String name, int health) {
		super(health);
		this.name = name;
	}
	
	public Monster(String name) {
		super();
		this.name=name;
		health = rnd.nextInt(MAX_MONSTER_HEALTH - MIN_MONSTER_HEALTH + 1) + MIN_MONSTER_HEALTH;
	}
	
	

	@Override
	public int attack() {
		return rnd.nextInt(MAX_MONSTER_ATTACK_DAMAGE);
	}
	
	public int dropPotion() {
		if(rnd.nextInt(100) > HEALTH_POTION_DROP_CHANCE) {
			return rnd.nextInt(MAX_NO_HEALTH_POTION_DROP) + 1;
		}
		return 0;
	}

	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "\t" + name + "\tHP:" + health;
	}
}
