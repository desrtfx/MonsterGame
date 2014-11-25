package monsterGame;

import java.util.Random;

public class Game {
	
	// Chance in percent that a monster attacks a fleeing player
	private static final int MONSTER_ATTACK_CHANCE = 30;
	
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

			// The inner game loop has ended.
			// This could be because
			// - the player killed the monster
			// + new monster needed
			// + stay in the main loop
			// - the player ran away
			// + new monster needed
			// + stay in the main loop
			// - the monster killed the player
			// + resurrect the player if possible & wanted
			// + stay in the main loop
			// - the player quit
			// + exit the main loop

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
			// Even if the player dies.
			// If the player dies and does not resurrect
			// hasQuit will be set.
		} while (!player.hasQuit()); // End Outer Game loop
		
		gui.displayEndMessage();
		
	}

	private void doInnerGameLoop() {
		// Start the inner game loop - until the player or monster is killed
		do {
			// Produce and handle the main menu
			doMainMenu();

			// Menu choices handled, display some statistics
			if(!player.hasQuit()) {
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

	// Handle the monster fight
	private void fightMonster() {
		// Determine the amount of damage done
		int damagePlayer = player.attack();
		int damageMonster = monster.attack();

		// apply the damage to player and Monster
		player.receiveDamage(damageMonster);
		monster.receiveDamage(damagePlayer);

		// display the statistics
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

	// Check if the player died
	private void playerIsDead() {
		player.incDeathCount();
		gui.displayPlayerKill();
		if (player.canResurrect()) {
			gui.displayResurrection();
			if(gui.handleResurrectionMenu()) {
				player.resurrect();
			} 
			else {
				player.setQuit();
			}
		}
	}

	// Check if the monster died
	private void monsterIsDead() {
		if (monster.isDead()) { // Monster is dead, display some info
			player.incKills(); // Increment the player kills
			gui.displayMonsterKill();

			// The monster could drop a health potion
			int potions = monster.dropPotion();
			if (potions > 0) {
				player.addHealthPotions(potions);
				gui.displayReceivePotion(potions);
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
