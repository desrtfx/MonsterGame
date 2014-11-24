package monsterGame;

import java.util.Random;

public class Game {

	Player player;
	TxtGUI gui;
	Random rnd;
	Monster monster;
	boolean keepPlaying = true;

	// names of the Monsters
	String[] enemies = { "Count Dooku", "Azok", "Zuul", "The Predator",
			"Alien Queen" };

	public Game() {
		gui = new TxtGUI();
		rnd = new Random();
	}

	public void init() {
		gui.displayTitle();
		gui.displayInstructions();

	}

	public void resurrect() {
		player.setHealth(Player.MAX_PLAYER_HEALTH);
	}

	public void play() {

		// When the game loop starts, create a new Player
		player = new Player();

		// Helper variable to terminate the monster-fight
		// loop upon player run away
		boolean runaway = false;

		do { // Outer Game loop

			// First step in a new game loop is to create a new Monster
			monster = getNewMonster();

			// Now that we have a monster, we should display the monster
			gui.displayNewMonster(monster);

			// set a variable for running away
			runaway = false;

			// Start the inner game loop - until the player or monster is killed
			do {
				// Let's display the Menu and ask the user what they want to do
				int choice = gui.handleMainMenu();

				switch (choice) {
				case 1: { // Player attacks monster
					fightMonster();
					break;
				}
				case 2: { // Player drinks health potion
					drinkPotion();
					break;
				}
				case 3: { // Player runs away
					// set the runaway flag
					runaway = true;
					break;
				}
				case 4: { // Player quits
					gui.displayEndMessage(player);
					if (!gui.handleKeepPlayingMenu()) {
						return;
					}
					break;
				}
				default: { // do nothing
					// If this code is reached something went seriously wrong
					// The menu handler should prevent reaching this code
					break;
				}

				}

				// Menu choices handled, display some statistics
				gui.displayStats(player, monster);

				// Here is the end of the inner game loop
				// the inner game loop runs until a monster is killed
				// or until the player is dead
				// or until the player runs away or quits

			} while ((!runaway) && (!monster.isDead()) && (!player.isDead()));

			// Either the player quit, or the monster is dead, or the player is
			// dead, or the player ran away
			if (!runaway) { // If the player didn't quit, nor
							// ran away, either player or
							// monster is dead
				// Check if the player killed the monster
				// and handle monster drops
				checkMonsterDeath(monster);

				// Check if the monster killed the player
				checkPlayerDeath(monster);
			}
			if (runaway) {
				// Player ran away, we need a new monster and display some text
				gui.displayRunAway(player, monster);
			}
		} while (!player.isDead()); // End Outer Game loop
		// TODO: Handle Player Death
	}

	private void checkPlayerDeath(Monster monster) {
		if (player.isDead()) { // Player is dead, display some info
			gui.displayPlayerKill(player, monster);
		}
	}

	private void checkMonsterDeath(Monster monster) {
		if (monster.isDead()) { // Monster is dead, display some info
			player.addKills(1); // Increment the player kills
			gui.displayMonsterKill(player, monster);

			// The monster could drop a health potion
			int potions = monster.dropPotion();
			if (potions > 0) {
				player.addHealthPotions(potions);
				gui.displayReceivePotion(player, monster, potions);
			}
		}
	}

	// Create a new monster to fight
	private Monster getNewMonster() {
		String name = enemies[rnd.nextInt(enemies.length)];
		Monster monster = new Monster(name);
		return monster;
	}

	// Handle the monster fight
	private void fightMonster() {
		// Determine the amount of damage done
		int damagePlayer = player.attack();
		int damageMonster = monster.attack();

		// apply the damage to player and Monster
		player.receiveDamage(damageMonster);
		monster.receiveDamage(damagePlayer);

		// display the statistics
		gui.displayFight(monster, damagePlayer, damageMonster);
	}

	// Drink a health potion
	private void drinkPotion() {
		boolean success = player.drinkHealthPotion();
		gui.displayHealthPotion(player, success);
	}

}
