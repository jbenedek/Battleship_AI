package com.Battleship;

public class Game {
	
	public Game() throws InterruptedException {
		startFiring();
	}
	
	/**
	 * Method for handling the back and forth of firing between players.
	 * @throws InterruptedException 
	 */
	public void startFiring() throws InterruptedException {
		Utils.clearDisplay();
		String coordToFire;
		while(gameInProgress()) {
			Battleship.TOTAL_TURNS += 1;
			switch(Battleship.PLAYER_ON_TURN) {
			case 1: //PLAYER 1
				System.out.println(Battleship.GLOBAL_PLAYER_1.getName() + "'s turn!");
				System.out.println("               Player 1 has sunk: " + Battleship.GLOBAL_PLAYER_2.getDefensive().getShipsSunk().size() + "                                 Player 2 has sunk: " + Battleship.GLOBAL_PLAYER_1.getDefensive().getShipsSunk().size() );
				Utils u = new Utils(Battleship.GLOBAL_PLAYER_1.getOffensive(), Battleship.GLOBAL_PLAYER_1.getDefensive());
				u.printDoubleBoard();
				//Battleship.GLOBAL_PLAYER_1.displayBoards();
				System.out.print(Battleship.GLOBAL_PLAYER_1.getName() );
				coordToFire = Battleship.GLOBAL_PLAYER_1.getCoordToFire();
				Coordinate fire = new Coordinate(coordToFire); //TODO VALIDATION
				if(Battleship.GLOBAL_PLAYER_2.getDefensive().coordinateIsShip(fire)) { //THIS IS A HIT
					Battleship.GLOBAL_PLAYER_1.getOffensive().addHit(fire);
					Battleship.GLOBAL_PLAYER_2.getDefensive().addHit(fire);
					System.out.println("HIT at " + fire.toPrettyString());
					Thread.sleep(2000);
				}
				else {//THIS IS A MISS
					Battleship.GLOBAL_PLAYER_1.getOffensive().addMiss(fire);
					System.out.println("MISS at " + fire.toPrettyString() );
					Thread.sleep(2000);
				}
				break;
			case -1: //PLAYER 2
				System.out.println(Battleship.GLOBAL_PLAYER_2.getName() + "'s turn!");
				System.out.println("               Player 1 has sunk: " + Battleship.GLOBAL_PLAYER_2.getDefensive().getShipsSunk().size() + "                                 Player 2 has sunk: " + Battleship.GLOBAL_PLAYER_1.getDefensive().getShipsSunk().size() );
				Utils u2 = new Utils(Battleship.GLOBAL_PLAYER_2.getOffensive(), Battleship.GLOBAL_PLAYER_2.getDefensive());
				u2.printDoubleBoard();
				//Battleship.GLOBAL_PLAYER_2.displayBoards();
				System.out.print(Battleship.GLOBAL_PLAYER_2.getName() );
				coordToFire = Battleship.GLOBAL_PLAYER_2.getCoordToFire();
				Coordinate fire2 = new Coordinate(coordToFire); //TODO VALIDATION
				if(Battleship.GLOBAL_PLAYER_1.getDefensive().coordinateIsShip(fire2)) { //THIS IS A HIT
					Battleship.GLOBAL_PLAYER_2.getOffensive().addHit(fire2);
					Battleship.GLOBAL_PLAYER_1.getDefensive().addHit(fire2);
					System.out.println("HIT at " + fire2.toPrettyString());
					Thread.sleep(2000);
				}
				else {//THIS IS A MISS
					Battleship.GLOBAL_PLAYER_2.getOffensive().addMiss(fire2);
					System.out.println("MISS at " + fire2.toPrettyString() );
					Thread.sleep(2000);
				}
				break;
			}
			
			
			Battleship.PLAYER_ON_TURN = Battleship.PLAYER_ON_TURN * -1;
			Utils.delay();			
		}
	}
	
	protected boolean gameInProgress() {
		if( Battleship.GLOBAL_PLAYER_1.isDefeated() ) {
			return false; 
		}
		if (Battleship.GLOBAL_PLAYER_2.isDefeated()) {
			return false;
		}
		else {
			return true;
		}
	}

	
	@Override
	public String toString() {
		return "GLOBAL_GAME_MODE: " + Battleship.GLOBAL_GAME_MODE + " GLOBAL_OFFENSIVE_DIFFICULTY: " + Battleship.GLOBAL_OFFENSIVE_DIFFICULTY + 
				" GLOBAL_DEFENSIVE_DIFFICULTY: " + Battleship.GLOBAL_DEFENSIVE_DIFFICULTY + " GLOBAL_OFFENSIVE_DIFFICULTY_2: " + 
				Battleship.GLOBAL_OFFENSIVE_DIFFICULTY_2 + " GLOBAL_DEFENSIVE_DIFFICULTY_2: " + Battleship.GLOBAL_DEFENSIVE_DIFFICULTY_2 + 
				" GLOBAL_PLAYER_1: " + Battleship.GLOBAL_PLAYER_1 + " GLOBAL_PLAYER_2: " + Battleship.GLOBAL_PLAYER_2;
	}

}
