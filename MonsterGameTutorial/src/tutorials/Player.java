package tutorials;

public class Player extends AbstractBeing {

	private static final int MAX_PLAYER_DAMAGE = 50;
	private static final int HEALTHPOTION_HEAL_AMOUNT = 30;
	
	private int healthPotions = 3;
	private int kills = 0;
	
	public Player() {
		// Default Player starts with 100 health
		super(100);
	}
	
	public Player(int health) {
		super(health);
	}
	
	public void addHealthPotions(int amount) {
		healthPotions += amount;
	}
	
	public void addKills(int amount) {
		kills += amount;
	}
	
	public int getKills() {
		return kills;
	}
	
	public int getHealthPotions() {
		return healthPotions;
	}
	
	public int getHealingAmount() {
		return HEALTHPOTION_HEAL_AMOUNT;
	}
	
	
	public boolean drinkHealthPotion() {
		if (healthPotions > 0) {
			healthPotions--;
			health += HEALTHPOTION_HEAL_AMOUNT;
			return true;
		}
		return false;
	}
	
	@Override
	public int attack() {
		return rnd.nextInt(MAX_PLAYER_DAMAGE);
	}

	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(String.format("You currently have %3d health points.\n",health));
		buf.append(String.format("You have %3d health potions left.\n", healthPotions));
		buf.append(String.format("You have already killed %3d monsters.", kills));
		
		return buf.toString();
	}
	
}
