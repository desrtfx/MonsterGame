package monsterGame;

import java.util.Random;

public class Game {

	// Chance in percent that a monster attacks a fleeing player
	private static final int MONSTER_ATTACK_CHANCE = 30;

	// Internal variables
	Player player;
	TxtGUI gui;
	Random rnd;
	Monster monster;

	// names of the Monsters
	String[] enemies = { "Count Dooku", "Azok", "Zuul", "The Predator",
			"Alien Queen" };

	// Upon Game creation
	// create a new Text GUI for the displays
	// and create a random generator
	public Game() {
		gui = new TxtGUI();
		rnd = new Random();
	}

	// display the title and instructions
	public void init() {
		gui.displayTitle();
		gui.displayInstructions();

	}

	// the actual Gameplay
	public void play() {

		// When the game loop starts, create a new Player
		player = new Player();

		// Hand the player Object to the GUI
		gui.setPlayer(player);

		do { // Outer Game loop

			// Reset the runaway Flag on a new monster
			player.resetRunAway();

			// First step in a new game loop is to create a new Monster
			monster = getNewMonster();

			// Hand the new Monster to the GUI
			gui.setMonster(monster);

			// Now that we have a monster, we should display the monster
			gui.displayNewMonster();

			// All Objects created, enter the inner loop
			doInnerGameLoop();

			// Either the player quit, or the monster is dead, or the player is
			// dead, or the player ran away
			if ((!player.hasQuit()) && (!player.hasRunAway())) {

				// Check if the player killed the monster
				// and handle monster drops
				if (monster.isDead()) {
					monsterIsDead();
				}

				// Check if the monster killed the player
				// and handle resurrection
				if (player.isDead()) {
					playerIsDead();
				}
			}

			// Outer game loop runs until the player quits
		} while (!player.hasQuit()); // End Outer Game loop

		// Display the final statistics and end message
		gui.displayEndMessage();

	}

	// The inner game loop
	private void doInnerGameLoop() {
		do {
			// Produce and handle the main menu
			doMainMenu();

			// Menu choices handled, display some statistics
			// omit the statistics if the player has quit
			if (!player.hasQuit()) {
				gui.displayStats();
			}

		} while ((!player.hasQuit()) && (!player.hasRunAway())
				&& (!monster.isDead()) && (!player.isDead()));
	}

	// Handle the main in-game menu
	private void doMainMenu() {
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
			doRunAway();
			break;
		}
		case 4: { // Player quits
			doQuit();
			break;
		}
		default: { // do nothing
			// If this code is reached something went seriously wrong
			// The menu handler should prevent reaching this code
			throw new UnsupportedOperationException("Invalid menu choice!");
		}

		}
	}

	// Game menu choice handlers
	// The following methods handle the actions chosen in the main in-game menu

	// Handle the monster fight
	private void fightMonster() {
		// Determine the amount of damage done
		int damagePlayer = player.attack();
		int damageMonster = monster.attack();

		// apply the damage to player and Monster
		player.receiveDamage(damageMonster);
		monster.receiveDamage(damagePlayer);

		// display fight results
		gui.displayFight(damagePlayer, damageMonster);
	}

	// Drink a health potion
	private void drinkPotion() {
		boolean success = player.drinkHealthPotion();
		gui.displayHealthPotion(success);
	}

	// Run away handler
	private void doRunAway() {
		player.setRunAway();
		int damageMonster = 0;
		if (rnd.nextInt(100) < MONSTER_ATTACK_CHANCE) {
			damageMonster = monster.attack();
		}
		gui.displayRunAway(damageMonster);
		player.receiveDamage(damageMonster);
	}

	// Quit handler
	private void doQuit() {
		if (!gui.handleKeepPlayingMenu()) {
			player.setQuit();
		}
	}

	// Auxiliary Functions
	// Game methods that were not initiated by a menu choice

	// Handle the player death
	private void playerIsDead() {
		// increment the death count
		player.incDeathCount();
		// display the player is dead message
		gui.displayPlayerKill();
		// See if the player can be resurrected
		if (player.canResurrect()) {
			// Display the resurrection dialog
			gui.displayResurrection();
			// Ask the player if they want to continue playing
			if (gui.handleResurrectionMenu()) {
				player.resurrect();
			} else {
				player.setQuit();
			}
		}
	}

	// Handle a monster death
	private void monsterIsDead() {
		// Increment the player kills
		player.incKills(); 
		// Display the monster killed dialog
		gui.displayMonsterKill();

		// The monster could drop a health potion
		int potions = monster.dropPotion();
		if (potions > 0) {
			// Give the player the dropped potions
			player.addHealthPotions(potions);
			// Display a dialog
			gui.displayReceivePotion(potions);
		}
	}

	// Create a new monster to fight
	private Monster getNewMonster() {
		// find a random enemy
		String name = enemies[rnd.nextInt(enemies.length)];
		// create a new monster
		Monster monster = new Monster(name);
		// return the new monster
		return monster;
	}

}
