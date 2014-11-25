package monsterGame;

import java.util.Scanner;

public class TxtGUI {

	// Keyboard scanner
	private Scanner in;

	// Variables to hold the Player and Monster Objects
	private Monster monster;
	private Player player;

	// Enum for the text alignments in the output
	private enum Align {
		LEFT, CENTER, RIGHT
	}

	// Setters for Monster and Player Objects
	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	// Default constructor
	// create a new Scanner to be used
	public TxtGUI() {
		in = new Scanner(System.in);
	}

	// Menu methods

	// Display and handle Main menu
	// return value = menu choice
	public int handleMainMenu() {
		String title = "What do you want to do?";
		String[] items = { "Attack Monster", "Drink Health Potion", "Run Away",
				"Quit Game" };
		int choice = doMenu(title, items);
		return choice;
	}

	// Display a menu to ask user if they want to
	// keep playing. Return TRUE if keep playing
	public boolean handleKeepPlayingMenu() {
		String title = "Do you really want to Quit?";
		String[] items = { "Yes, get me out!", "No, I'll stay." };
		int choice = doMenu(title, items);
		return (choice == 2);
	}

	public boolean handleResurrectionMenu() {
		String title = "Do you want to respawn?";
		String[] items = { "Yes, I want to live!", "No, I'd rather die." };
		int choice = doMenu(title, items);
		return (choice == 1);
	}

	// Display the title
	public void displayTitle() {
		printHeader();
		printLine("Monster Battle", Align.CENTER);
		printSeparator();
		printLine("a (stupid) game of", Align.CENTER);
		printLine("killing monsters", Align.CENTER);
		printFooter();
	}

	// Display the instructions
	public void displayInstructions() {
		printHeader();
		printLine("I N S T R U C T I O N S", Align.CENTER);
		printSeparator();
		printLine("This game is about staying alive", Align.LEFT);
		printLine("while killing monsters.", Align.LEFT);
		printSeparator();
		printLine("Each turn, you can decide to:", Align.LEFT);
		printSeparator();
		printLine("    (1)   Attack a monster", Align.LEFT);
		printLine("    (2)   Drink a health potion", Align.LEFT);
		printLine("    (3)   Run away", Align.LEFT);
		printLine("    (4)   Quit Game", Align.LEFT);
		printSeparator();
		printLine("Attacking a monster hurts the", Align.LEFT);
		printLine("monster. You might also get hurt.", Align.LEFT);
		printLine("Hit the monster until it's health", Align.LEFT);
		printLine("reaches 0 while keeping your", Align.LEFT);
		printLine("health as high as possible.", Align.LEFT);
		printSeparator();
		printLine("You have a limited number of", Align.LEFT);
		printLine("health potions that restore part", Align.LEFT);
		printLine("of your health.", Align.LEFT);
		printSeparator();
		printLine("Monsters sometimes drop Health", Align.LEFT);
		printLine("Potions when they are killed.", Align.LEFT);
		printFooter();
	}

	// Display when a new monster apperared
	public void displayNewMonster() {
		printHeader();
		printLine("MASTER!", Align.LEFT);
		printLine("A new monster has appeared!", Align.LEFT);
		printSeparator();
		printLine("Name:   " + monster.getName(), Align.LEFT);
		printLine("Health: " + monster.getHealth(), Align.LEFT);
		printFooter();
	}

	// Display the outcome of a fight
	public void displayFight(int damagePlayer, int damageMonster) {
		printHeader();
		printLine("You attack " + monster.getName() + ".", Align.LEFT);
		printLine("You deal " + damagePlayer + " Points damage.", Align.LEFT);
		printSeparator();
		printLine("In return, you receive", Align.LEFT);
		printLine("" + damageMonster + " Points damage.", Align.LEFT);
		printFooter();
	}

	// Display the result of drinking a health potion
	// success determines whether potion was drunk or not
	public void displayHealthPotion(boolean success) {
		if (success) {
			printHeader();
			printLine("You drank a health potion.", Align.LEFT);
			printSeparator();
			printLine("Your health has been", Align.LEFT);
			printLine("restored to: " + player.getHealth(), Align.LEFT);
			printSeparator();
			String potions = "You have "
					+ ((player.getHealthPotions() == 0) ? "no Health Potions"
							: (player.getHealthPotions() == 1) ? "1 Health Potion"
									: "" + player.getHealthPotions()
											+ " Health Potions") + " left.";
			printLine(potions, Align.LEFT);
			printFooter();
		} else {
			printHeader();
			printLine("You have no Health Potions left.", Align.LEFT);
			printSeparator();
			printLine("Try killing a few monsters to get", Align.LEFT);
			printLine("more health potions.", Align.LEFT);
			printFooter();
		}

	}

	// Display when running away from a monster
	public void displayRunAway(int damageMonster) {
		printHeader();
		printLine("In a cowardish move you", Align.LEFT);
		printLine("dash away from:", Align.LEFT);
		printLine(monster.getName(), Align.CENTER);
		if (damageMonster > 0) {
			printSeparator();
			printLine("Just before you could escape", Align.LEFT);
			printLine( monster.getName(), Align.CENTER);
			printLine("hit you and caused ", Align.LEFT);
			printLine("" + damageMonster + " health points damage.", Align.LEFT);
		}
		printFooter();
	}

	// Display the End game message
	public void displayEndMessage() {
		printHeader();
		printLine("FINAL STATISTICS", Align.CENTER);
		printSeparator();
		printLine("You killed: " + player.getKills() + " monsters.", Align.LEFT);
		printLine("You escaped: " + player.getRunawayCount() + " times.", Align.LEFT);
		printLine("You died:   " + player.getDeathCount() + " times.",
				Align.LEFT);
		printLine("Your final health is: " + player.getHealth() + " HP.",
				Align.LEFT);
		printLine("You drank: " + player.getHealthPotionCount()
				+ " Health Potions.", Align.LEFT);
		printSeparator();
		printHeader();
		printLine("G O O D B Y E !", Align.CENTER);
		printSeparator();
		printLine("May the odds be", Align.CENTER);
		printLine("ever in your favor!", Align.CENTER);
		printFooter();
	}

	// Display when player killed a monster
	public void displayMonsterKill() {
		printHeader();
		printLine("C O N G R A T U L A T I O N S !", Align.CENTER);
		printSeparator();
		printLine("You killed: ", Align.LEFT);
		printLine(monster.getName(), Align.CENTER);
		printSeparator();
		printLine("So far you have killed ", Align.LEFT);
		String monsterKills = ((player.getKills() == 0) ? "no monsters."
				: (player.getKills() == 1) ? "1 monster." : ""
						+ player.getKills() + " monsters.");

		printLine(monsterKills, Align.LEFT);
		printFooter();

	}

	// Display when player was killed by a monster
	public void displayPlayerKill() {
		printHeader();
		printLine("O H   N O!", Align.CENTER);
		printSeparator();
		printLine(monster.getName(), Align.CENTER);
		printLine("killed you!", Align.LEFT);
		printFooter();
	}

	// Display the statistics at the end of each round
	public void displayStats() {
		printHeader();
		printLine("S T A T I S T I C S", Align.CENTER);
		printSeparator();
		printLine("You currently have:", Align.LEFT);
		printLine("" + player.getHealth() + " health points left", Align.LEFT);
		printLine("and " + player.getHealthPotions() + " health potions.",
				Align.LEFT);
		printSeparator();
		printLine(monster.getName(), Align.LEFT);
		printLine(" has " + monster.getHealth() + " health points left.",
				Align.LEFT);
		printFooter();
	}

	// Display when a monster dropped a potion
	public void displayReceivePotion(int potions) {
		printHeader();
		printLine("Upon death, " + monster.getName(), Align.LEFT);
		String strPotions = "left you "
				+ ((potions == 0) ? "no Health Potions"
						: (potions == 1) ? "1 Health Potion" : "" + potions
								+ " Health Potions");
		printLine(strPotions, Align.LEFT);
		printSeparator();
		strPotions = "You now have "
				+ ((player.getHealthPotions() == 0) ? "no Health Potions."
						: (player.getHealthPotions() == 1) ? "1 Health Potion."
								: "" + player.getHealthPotions()
										+ " Health Potions.");
		printLine(strPotions, Align.LEFT);
		printFooter();
	}

	public void displayResurrection() {
		printHeader();
		printLine("R E J O I C E !", Align.CENTER);
		printSeparator();
		printLine("The Gods have been in a very", Align.LEFT);
		printLine("generous mood and have", Align.LEFT);
		printLine("decided that you have", Align.LEFT);
		printLine("proven to be a worthy fighter.", Align.LEFT);
		printSeparator();
		printLine("As a token of their appreciation", Align.LEFT);
		printLine("they offer to bring you back to", Align.LEFT);
		printLine("life.", Align.LEFT);
		printFooter();
	}

	// Auxiliary Methods

	// Print a section line
	private void printSection() {
		System.out.println("\t*******************************************");
	}

	// Print a separator line
	private void printSeparator() {
		System.out.println("\t***                                     ***");
	}

	// Print the header (Section line + Separator line)
	private void printHeader() {
		printSection();
		printSeparator();
	}

	// Print the Footer (Separator line + Section line + empty line)
	private void printFooter() {
		printSeparator();
		printSection();
		System.out.println();
	}

	// Print a formatted line aligned by align
	private void printLine(String text, Align align) {
		StringBuilder sb = new StringBuilder();
		sb.append("\t***  ");
		switch (align) {
		case LEFT: {
			sb.append(String.format("%-33s", text));
			break;
		}
		case RIGHT: {
			sb.append(String.format("%33s", text));
			break;

		}
		case CENTER: {
			do {
				text = " " + text + ((text.length() < 32) ? " " : "");
			} while (text.length() < 33);
			sb.append(text);
		}
		}
		sb.append("  ***");
		System.out.println(sb.toString());
	}

	// Print and handle menu choices
	// return value is the chosen menu item
	private int doMenu(String title, String[] items) {
		printHeader();
		printLine(title, Align.CENTER);
		printSeparator();
		for (int i = 0; i < items.length; i++) {
			printLine("    (" + (i + 1) + ")   " + items[i], Align.LEFT);
		}
		printFooter();

		// Menu Loop
		int choice;
		do {
			System.out.print("Please choose your action (1.." + items.length
					+ "): ");
			choice = in.nextInt();
			if ((choice < 1) || (choice > items.length)) {
				System.out.println("Invalid choice!");
				System.out.println();
			}
		} while ((choice < 1) || (choice > items.length));
		return choice;
	}

}
