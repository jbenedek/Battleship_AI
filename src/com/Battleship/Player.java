package com.Battleship;

import java.util.Scanner;

public class Player {
	protected Board offensive;
	protected Board defensive;
	protected String name;
	
	public Player() {
		
	}
	public Player(String name) {
		offensive = new Board();
		defensive = new Board();
		this.name = name;
		promptForPlacement();
	}
	/**
	 * @deprecated 
	 * DEV TEST ONLY, SKIPS THE NEED TO PLACE A BOARD
	 * @param name
	 */
	@Deprecated
	public Player(String name, int i) {
		offensive = new Board();
		defensive = new Board();
		this.name = name;
		
		defensive.placeCarrier(new Coordinate("A1"), 1);
		defensive.placeBattleship(new Coordinate("A2"), 1);
		defensive.placeCruiser(new Coordinate("A3"), 1);
		defensive.placeSubmarine(new Coordinate("A4"), 1);
		defensive.placeDestroyer(new Coordinate("A5"), 1);

	}
	
	private void promptForPlacement() { //TODO validation
		System.out.println(name + " will now place their ships. \n");
		Utils u = new Utils(defensive);
		u.printSingleBoard();
		System.out.println("We will first place the Carrier (Size 5). Enter a starting Coordinate (in the form A1, D5, etc): ");
		Scanner in = new Scanner(System.in);
		Coordinate start = new Coordinate(in.nextLine());
		System.out.println("What direction would you like the ship to go? \n1.Right\n2.Left\n3.Up\n4.Down\n");
		int direction = in.nextInt();
		defensive.placeCarrier(start, direction);
		Utils u1 = new Utils(defensive);
		u1.printSingleBoard();
		
		System.out.println("Now lets place the Battleship (Size 4).  Enter a starting Coordinate (in the form A1, D5, etc): ");
		in = new Scanner(System.in);
		start = new Coordinate(in.nextLine());
		System.out.println("What direction would you like the ship to go? \n1.Right\n2.Left\n3.Up\n4.Down\n");
		direction = in.nextInt();
		defensive.placeBattleship(start, direction);
		Utils u2 = new Utils(defensive);
		u2.printSingleBoard();
		
		System.out.println("Now lets place the Cruiser (Size 3).  Enter a starting Coordinate (in the form A1, D5, etc): ");
		in = new Scanner(System.in);
		start = new Coordinate(in.nextLine());
		System.out.println("What direction would you like the ship to go? \n1.Right\n2.Left\n3.Up\n4.Down\n");
		direction = in.nextInt();
		defensive.placeCruiser(start, direction);
		Utils u3 = new Utils(defensive);
		u3.printSingleBoard();
		
		System.out.println("Now lets place the Submarine (Size 2).  Enter a starting Coordinate (in the form A1, D5, etc): ");
		in = new Scanner(System.in);
		start = new Coordinate(in.nextLine());
		System.out.println("What direction would you like the ship to go? \n1.Right\n2.Left\n3.Up\n4.Down\n");
		direction = in.nextInt();
		defensive.placeSubmarine(start, direction);
		Utils u4 = new Utils(defensive);
		u4.printSingleBoard();
		
		System.out.println("Now lets place the Destroyer (Size 2).  Enter a starting Coordinate (in the form A1, D5, etc): ");
		in = new Scanner(System.in);
		start = new Coordinate(in.nextLine());
		System.out.println("What direction would you like the ship to go? \n1.Right\n2.Left\n3.Up\n4.Down\n");
		direction = in.nextInt();
		defensive.placeDestroyer(start, direction);
		Utils u5 = new Utils(defensive);
		u5.printSingleBoard();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public boolean isDefeated() {
		if( defensive.getShipsSunk().size() == 5 ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getName() {
		return name;
	}
	public Board getDefensive() {
		return defensive;
	}
	public Board getOffensive() {
		return offensive;
	}
	
	
	public void displayBoards() {
		System.out.println("        " + getName() + "                ");
		System.out.println("OFF " + offensive.toString() + "\n");
		System.out.println("DEF " + defensive.toString() + "\n");
		System.out.println("KEY:        O: SHIP           X: HIT SHIP            -:MISSED SHOT  BLANK has yet to be explored");

	}
	public String getCoordToFire() throws InterruptedException {
		System.out.print(", it is your turn to fire. Please enter a coordinate (in form A1, D3, J10, etc): \n");
		Scanner in = new Scanner(System.in);
		String s = in.next();
		return s;
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [offensive=" + offensive + ", defensive=" + defensive + ", name=" + name + ", isDefeated()="
				+ isDefeated() + "]";
	}
	

}
