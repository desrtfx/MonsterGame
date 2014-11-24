package tutorials;

import java.util.Scanner;

public class TxtGUI {

	private Scanner in;

	private enum Align {
		LEFT, CENTER, RIGHT
	}

	TxtGUI() {
		in = new Scanner(System.in);
	}

	public void displayTitle() {
		printHeader();
		printLine("Monster Battle", Align.CENTER);
		printSeparator();
		printLine("a (stupid) game of", Align.CENTER);
		printLine("killing monsters", Align.CENTER);
		printFooter();
	}

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

	public int handleMainMenu() {
		printHeader();
		printLine("What do you want to do?", Align.CENTER);
		printSeparator();
		printLine("    (1)   Attack Monster", Align.LEFT);
		printLine("    (2)   Drink Health Potion", Align.LEFT);
		printLine("    (3)   Run Away", Align.LEFT);
		printLine("    (4)   Quit Game", Align.LEFT);
		printFooter();

		// Menu Loop
		int choice;
		do {
			System.out.print("Please choose your action (1..4): ");
			choice = in.nextInt();
			if ((choice < 1) || (choice > 4)) {
				System.out.println("Invalid choice!");
				System.out.println();
			}
		} while ((choice < 1) || (choice > 4));
		return choice;
	}

	public void displayNewMonster(Monster monster) {
		printHeader();
		printLine("MASTER!", Align.LEFT);
		printLine("A new monster has appeared!", Align.LEFT);
		printSeparator();
		printLine("Name:   " + monster.getName(), Align.LEFT);
		printLine("Health: " + monster.getHealth(), Align.LEFT);
		printFooter();
	}

	public void displayFight(Player player, Monster monster, int damagePlayer,
			int damageMonster) {
		// TODO displayFight Auto-generated method stub

	}

	public void displayHealthPotion(Player player, boolean success) {
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

	public void displayRunAway(Player player, Monster monster) {
		printHeader();
		printLine("In a cowardish move you", Align.LEFT);
		printLine("dash away from:", Align.LEFT);
		printLine(monster.getName(), Align.CENTER);
		printFooter();
	}

	public void displayEndMessage(Player player) {
		// TODO displayEndMessage Auto-generated method stub

	}

	public void displayMonsterKill(Player player, Monster monster) {
		printHeader();
		printLine("C O N G R A T U L A T I O N S !", Align.CENTER);
		printSeparator();
		printLine("You killed: ", Align.LEFT);
		printLine(monster.getName(), Align.CENTER);
		printSeparator();
		printLine("So far you have killed ", Align.LEFT);
		String monsterKills = ((player.getKills() == 0) ? "no monsters." : (player
				.getKills() == 1) ? "1 monster." : "" + player.getKills()
				+ " monsters.");

		printLine(monsterKills, Align.LEFT);
		printFooter();

	}

	public void displayPlayerKill(Player player, Monster monster) {
		printHeader();
		printLine("O H   N O!", Align.CENTER);
		printSeparator();
		printLine(monster.getName(),Align.CENTER);
		printLine("killed you!", Align.LEFT);
		printSeparator();
		printHeader();
		printLine("FINAL STATISTICS", Align.CENTER);
		printSeparator();
		printLine("You have killed ", Align.LEFT);
		String monsterKills = ((player.getKills() == 0) ? "no monsters." : (player
				.getKills() == 1) ? "1 monster." : "" + player.getKills()
				+ " monsters.");

		printLine(monsterKills, Align.LEFT);
		printFooter();
	}

	public void displayStats(Player player, Monster monster) {
		// TODO displayStats Auto-generated method stub

	}

	public void displayReceivePotion(Player player, Monster monster, int potions) {
		printHeader();
		printLine("Upon death, " + monster.getName(), Align.LEFT);
		String strPotions = "left you "
				+ ((potions == 0) ? "no Health Potions"
						: (potions == 1) ? "1 Health Potion"
								: "" + potions
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

	private void printSection() {
		System.out.println("\t*******************************************");
	}

	private void printSeparator() {
		System.out.println("\t***                                     ***");
	}

	private void printHeader() {
		printSection();
		printSeparator();
	}

	private void printFooter() {
		printSeparator();
		printSection();
		System.out.println();
	}

	private String format(String text, Align align) {
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
		return sb.toString();
	}

	private void printLine(String text, Align align) {
		System.out.println(format(text, align));
	}
}
