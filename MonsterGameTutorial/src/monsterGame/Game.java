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
					runAway();
					break;
				}
				case 4: { // Player quits
					// TODO: Quit handling needs changing
					gui.displayEndMessage(player);
					if (!gui.handleKeepPlayingMenu()) {
						player.doQuit();
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
				// TODO: Revise inner loop conditions
			} while ((!player.hasRunaway()) && (!monster.isDead()) && (!player.isDead()));

			// TODO: Rewrite loop end of inner loop

			
			// Either the player quit, or the monster is dead, or the player is
			// dead, or the player ran away
			if (!player.hasRunaway()) { // If the player didn't quit, nor
							// ran away, either player or
							// monster is dead
				// Check if the player killed the monster
				// and handle monster drops
				checkMonsterDeath();

				// Check if the monster killed the player
				checkPlayerDeath();
			}
			// TODO: Runaway handling needs changing
			//if (runaway) {
				// Player ran away, we need a new monster and display some text
				//gui.displayRunAway(monster);
			//}
		} while (!player.isDead()); // End Outer Game loop
		// TODO: Handle Player Death
	}

	// Game menu choice handlers
	
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

	// Run away handler
	private void runAway() {
		player.doRunaway();
		gui.displayRunAway(monster);
	}
	
	// Quit handler
	// TODO: Implement quit handler

	// Auxiliary Functions

	// Check if the player died
	// TODO: Change PlayerDeath code
	private void checkPlayerDeath() {
		if (player.isDead()) { // Player is dead, display some info
			gui.displayPlayerKill(player, monster);
		}
	}

	
	// Check if the monster died
	// TODO: Change MonsterDeath code
	private void checkMonsterDeath() {
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

}
