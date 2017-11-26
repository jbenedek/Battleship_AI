package com.Battleship;

import java.util.Scanner;

public class Battleship {
	
	/**
	 * Global constant for what the game mode is.
	 * <ul>
	 * <li> 1 for Human vs. Human</li>
	 * <li> 2 for Human vs. AI</li>
	 * <li> 3 for AI vs AI</li>
	 * <li> -10 for DEV TEST (NOT PUBLIC)</li>
	 * </ul>
	 */
	public static int GLOBAL_GAME_MODE;
	/**
	 * Global constant for the AI Difficulty OFFENSIVE for 1st AI
	 * <ul>
	 * <li> 1 for NAIVE</li>
	 * <li> 2 </li>
	 * <li> 3 </li>
	 * </ul>
	 */
	public static int GLOBAL_OFFENSIVE_DIFFICULTY;
	/**
	 * Global constant for the AI Difficulty DEFFENSIVE for 1st AI
	 * <ul>
	 * <li> 1 for NAIVE</li>
	 * <li> 2 </li>
	 * <li> 3 </li>
	 * </ul>
	 */
	public static int GLOBAL_DEFENSIVE_DIFFICULTY;
	/**
	 * Global constant for the AI Difficulty OFFENSIVE for 2nd AI ONLY APPLIES TO AI vs. AI
	 * <ul>
	 * <li> 1 for NAIVE</li>
	 * <li> 2 </li>
	 * <li> 3 </li>
	 * </ul>
	 */
	public static int GLOBAL_OFFENSIVE_DIFFICULTY_2;
	/**
	 * Global constant for the AI Difficulty DEFFENSIVE for 2nd AI ONLY APPLIES TO AI vs. AI
	 * <ul>
	 * <li> 1 for NAIVE</li>
	 * <li> 2 </li>
	 * <li> 3 </li>
	 * </ul>
	 */
	public static int GLOBAL_DEFENSIVE_DIFFICULTY_2;
	/**
	 * Global Instance of the Game
	 */
	public static Game GLOBAL_GAME_INSTANCE;
	/**
	 * Global Instance of the the First Player
	 */
	public static Player GLOBAL_PLAYER_1;
	/**
	 * Global Instance of the the Second Player
	 */
	public static Player GLOBAL_PLAYER_2;
	/**
	 * Global marker of player on turn
	 * <li> 1 for Player 1
	 * <li> -1 for Player 2
	 * 
	 * 
	 * Default is player 1
	 * This allows players to be switched with a * -1
	 */
	public static int PLAYER_ON_TURN = 1;
	/**
	 * Total number of turns taken
	 */
	public static int TOTAL_TURNS = 0;
	
	

	public static void main(String[] args) {
		try {
			preGame();
			postGame();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void preGame() throws InterruptedException {
		System.out.println("Welcome to BattleShip. This was created by Jeremy Benedek and Kyle Lemmel for B351 - Intro to AI");
		System.out.println("Would you like to play: \n1. Human vs. Human \n2. Human vs. AI \n3.AI vs AI?");
		Scanner in = new Scanner(System.in);
		GLOBAL_GAME_MODE = in.nextInt();
		switch(GLOBAL_GAME_MODE) {
		case 1:
			GLOBAL_PLAYER_1 = new Player("Player 1");
			GLOBAL_PLAYER_2 = new Player("Player 2"); //TODO
			break;
		case 2:
			System.out.println("What difficulty would you like the Offensive AI to be?"); //TODO
			GLOBAL_OFFENSIVE_DIFFICULTY = in.nextInt();
			System.out.println("What difficulty would you like the Defensive AI to be?");
			GLOBAL_DEFENSIVE_DIFFICULTY = in.nextInt();
			GLOBAL_PLAYER_1 = new Player("Player 1");
			GLOBAL_PLAYER_2 = new AI("Player 2");
			break;
		case 3:
			System.out.println("What difficulty would you like the Player 1 Offensive AI to be?"); //TODO
			GLOBAL_OFFENSIVE_DIFFICULTY = in.nextInt();
			System.out.println("What difficulty would you like the Player 1 Defensive AI to be?");
			GLOBAL_DEFENSIVE_DIFFICULTY = in.nextInt();
			System.out.println("What difficulty would you like the Player 2 Offensive AI to be?"); //TODO
			GLOBAL_OFFENSIVE_DIFFICULTY_2 = in.nextInt();
			System.out.println("What difficulty would you like the Player 2 Defensive AI to be?");
			GLOBAL_DEFENSIVE_DIFFICULTY_2 = in.nextInt();
			GLOBAL_PLAYER_1 = new AI("Player 1");
			GLOBAL_PLAYER_2 = new AI("Player 2");
			break;
		case -10:
			GLOBAL_PLAYER_1 = new Player("Player 1", 1);
			GLOBAL_PLAYER_2 = new Player("Player 2", 1); //TODO
			break;
		default:
			System.out.println("I'm sorry, you entered an invalid input. Try again.");
			preGame();
			break;
		}
		GLOBAL_GAME_INSTANCE = new Game();

	}
	
	public static void postGame() {
		System.out.println("The game is over!!!!\n");
		System.out.println("WHAT PLAYER WON??");//TODO
		System.out.println("It took " + TOTAL_TURNS/2 + " moves to win.");
		System.out.println("\n\nGame Options: \n" + GLOBAL_GAME_INSTANCE.toString());
	}
	
	
}
