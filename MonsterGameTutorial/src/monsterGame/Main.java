package monsterGame;

public class Main {

	public static void main(String[] args) {

		Game game = new Game();

		// Initialize the Game
		game.init();

		// Flag to keep playing in case the player dies
		// and wants to be resurrected
		boolean keepPlaying;

		// Here the main game loop starts
		do {
			keepPlaying = game.play();
		} while (keepPlaying);

	}

}
