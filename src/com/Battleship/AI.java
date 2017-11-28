package com.Battleship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AI extends Player {

	public AI(String name) {
		super();
		offensive = new Board();
		defensive = new Board();
		this.name = name;
		placeShips();
	}
	Coordinate lastFire;
	
	private void placeShips() {
		switch(Battleship.GLOBAL_GAME_MODE) {
		case 1: //hvh
			break; //never
		case 2: //just 1 ai
			switch(Battleship.GLOBAL_DEFENSIVE_DIFFICULTY) {
			case 1: //naive
				randomAIPlacement();
				break;
			case 2://cluster
				intelligentPlacementCenter();
				break;
			case 3: //spread
				intelligentPlacementPerimeter();
				break;
			}
		case 3: //2 ai
			if(getName().equals("Player 1")) {
				switch(Battleship.GLOBAL_DEFENSIVE_DIFFICULTY) {
				case 1: //naive
					randomAIPlacement();
					break;
				case 2://cluster
					intelligentPlacementCenter();
					break;
				case 3: //spread
					intelligentPlacementPerimeter();
					break;
				}
			}
			else {
				switch(Battleship.GLOBAL_DEFENSIVE_DIFFICULTY_2) {
				case 1: //naive
					randomAIPlacement();
					break;
				case 2://cluster
					intelligentPlacementCenter();
					break;
				case 3: //spread
					intelligentPlacementPerimeter();
					break;
				}
			}
			break;
		case -10: //DEV TEST
			defensive.placeCarrier(new Coordinate("A1"), 1);
			defensive.placeBattleship(new Coordinate("A2"), 1);
			defensive.placeCruiser(new Coordinate("A3"), 1);
			defensive.placeSubmarine(new Coordinate("A4"), 1);
			defensive.placeDestroyer(new Coordinate("A5"), 1);
			break;
		}
}
	
	private ArrayList<Tile> evalFunction(ArrayList<Tile> toHit) {
		if(offensive.getListOfHits().contains(new Tile(lastFire, " "))) {
			toHit.clear();
			for(Coordinate c: lastFire.getNeighbors()) {
				if(!offensive.getListOfHits().contains(c)) {
					if(!offensive.getListOfMisses().contains(c)) {
						toHit.add(new Tile(c, " "));
					}
				}
			}
		}
		else {
			toHit.clear();
			toHit.add(new Tile(new Coordinate(randomAIFire()), " "));
			//ArrayList<Tile> toHit = new ArrayList<Tile>();
			for(Tile t: offensive.getListOfHits()) { //If we hit the ship, set value to 0
				if(toHit.contains(t)) toHit.remove(t);
				t.setHeuristicValue(-1000000000);
				toHit.add(t);
			}
			for(Tile t: offensive.getListOfMisses()) { //If we miss the ship, set value to -1000
				if(toHit.contains(t)) toHit.remove(t);
				t.setHeuristicValue(-10000);
				toHit.add(t);
			}
			for(Tile t: offensive.getListOfHits()) {
				if(toHit.contains(t)) {
					toHit.remove(t);
				}
				else {
					for(Coordinate neigh : t.getCoord().getNeighbors()) { //Neighbor is hit, add15
						Tile tile = new Tile(neigh, " ");
						tile.setHeuristicValue(tile.getHeuristicValue() + 15);
						toHit.add(tile);
					}
				}
			}
			for(Tile t: offensive.getListOfMisses()) {
				if(toHit.contains(t)) {
					toHit.remove(t);
				}
				else {
					
				
				for(Coordinate neigh : t.getCoord().getNeighbors()) { //Neighbor is miss, minus 5
					Tile tile = new Tile(neigh, " ");
					tile.setHeuristicValue(tile.getHeuristicValue() -5);
					toHit.add(tile);
				}
				}
			}
			
			/*for(int x = 1; x<10; x = x + 2) { //MIN PARITY (2)
				for(int y = 1; y<10; y = y+2) {
					Tile tile = new Tile(new Coordinate(x,y), " ");
					if(toHit.contains(tile)) {
						
					}
					else {
					tile.setHeuristicValue(10);
					toHit.add(tile);
					}
				}
			}
			for(int x = 10; x>1; x = x -5) { //Max PARITY (5)
				for(int y = 10; y>1; y = y-5) {
					Tile tile = new Tile(new Coordinate(x,y), " ");
					if(toHit.contains(tile)) {
						
					}
					else {
					tile.setHeuristicValue(10);
					toHit.add(tile);
					}
				}*/
			//}

			//Remove Duups and invalids
			Set<Tile> setTile = new HashSet<>();
			setTile.addAll(toHit);
			toHit.clear();
			toHit.addAll(setTile);

			for(Tile t:toHit) {
				if( t.getCoord().getX() < 0 || t.getCoord().getX() > 10 ||  t.getCoord().getY() < 0 || t.getCoord().getY() > 10) {
					toHit.remove(t); //Remove inValids
				}
			}

		}
		
			//If empty, search the not-parity
			if(toHit.isEmpty()) {
				for(int x = 1; x<10; x = x + 1) { //MIN PARITY (2)
					for(int y = 1; y<10; y = y+1) {
						Tile tile = new Tile(new Coordinate(x,y), " ");
						tile.setHeuristicValue(8);
						toHit.add(tile);
					}
				}
			}

			/*ArrayList<Tile> temp = new ArrayList();
		//Filter the List
		for(Tile t : toHit) {
			if(temp.contains(t)) {//already in, compare vals
				for(Tile tem : temp) {
					if (t.getCoord().equals(tem.getCoord())){ //2 tiles with the same Coord, add the values
						t.setHeuristicValue( t.getHeuristicValue() - tem.getHeuristicValue() );
						temp.remove(tem);//remove duup
						temp.add(t); //add new duup with val
					}
				}
			}
			else {//not in
				temp.add(t);
			}

		}*/
		
		return toHit;
	}

	private ArrayList<Tile> evalFunctionEasy(ArrayList<Tile> toHit) {
		toHit.add(new Tile(new Coordinate(randomAIFire()), " "));

		//ArrayList<Tile> toHit = new ArrayList<Tile>();
		for(Tile t: offensive.getListOfHits()) { //If we hit the ship, set value to 0
			t.setHeuristicValue(-1000000000);
			toHit.add(t);
		}
		for(Tile t: offensive.getListOfMisses()) { //If we miss the ship, set value to -1000
			t.setHeuristicValue(-10000);
			toHit.add(t);
		}
		for(Tile t: offensive.getListOfHits()) {
			for(Coordinate neigh : t.getCoord().getNeighbors()) { //Neighbor is hit, add15
				Tile tile = new Tile(neigh, " ");
				tile.setHeuristicValue(tile.getHeuristicValue() + 15);
				toHit.add(tile);
				for(Coordinate neigh2: neigh.getNeighbors()) { //Double neighbor hit, add25
					Tile tile2 = new Tile(neigh2, " ");
					tile2.setHeuristicValue(tile2.getHeuristicValue()+25);
					toHit.add(tile2);
				}
			}
		}
		for(Tile t: offensive.getListOfMisses()) {
			for(Coordinate neigh : t.getCoord().getNeighbors()) { //Neighbor is miss, minus 5
				Tile tile = new Tile(neigh, " ");
				tile.setHeuristicValue(tile.getHeuristicValue() -5);
				toHit.add(tile);
				for(Coordinate neigh2: neigh.getNeighbors()) { //Double neighbor miss, minus 15
					Tile tile2 = new Tile(neigh2, " ");
					tile2.setHeuristicValue(tile2.getHeuristicValue()-15);
					toHit.add(tile2);
				}
			}
		}
		for(int x = 1; x<10; x = x + 4) { //MIN PARITY (4)
			for(int y = 1; y<10; y = y+4) {
				Tile tile = new Tile(new Coordinate(x,y), " ");
				tile.setHeuristicValue(10);
				toHit.add(tile);
			}
		}
		
		
		
		//Remove Duups
		Set<Tile> setTile = new HashSet<>();
		setTile.addAll(toHit);
		toHit.clear();
		toHit.addAll(setTile);
		
		//Filter the List
	//	for(Tile t : toHit) {
	//		for(Tile t2 : toHit) {
	//			if (t.getCoord().equals(t2.getCoord())){ //2 tiles with the same Coord, add the values
	//				t.setHeuristicValue( t.getHeuristicValue() + t2.getHeuristicValue() );
	//				toHit.remove(t2);
	//			}
	//		}
		//}
		
		return toHit;
	}
	
	private Integer randomNumber(int min, int max) {
		Random rand = new Random();
		int  n = rand.nextInt(max) + min;
		return n;
		}
	
	private String randomAIFire() {
		int randomX = randomNumber(1, 10);
		int randomY = randomNumber(1, 10);
		Coordinate randomCoordinate = new Coordinate(randomX, randomY);
		for(Tile t: offensive.getListOfMisses()) {
			if (t.getCoord().equals(randomCoordinate)) {
					randomAIFire();
			}
			else if (t.getCoord().equals(randomCoordinate)) {
				randomAIFire();
			}
		}
		return randomCoordinate.toPrettyString();
	}
	
	public String getCoordToFire() {
		ArrayList<Tile> toHit = new ArrayList<Tile>();
		int max = 0;
		boolean isValid = false;
		String output = "B5";
		System.out.print(", it is your turn to fire. Please enter a coordinate (in form A1, D3, J10, etc): \n");	
		while (!isValid) {
			switch (Battleship.GLOBAL_GAME_MODE) {
			case 1: // Never should be here
				break;
			case 2: // Just 1 AI
				switch (Battleship.GLOBAL_OFFENSIVE_DIFFICULTY) {
				case 1: // Naive
					output = randomAIFire();

					break;
				case 3: // Moderate
					toHit = evalFunctionEasy(toHit); // Propogate once
					// toHit1 = evalFunctionEasy(toHit1); //Twice
					ArrayList<Integer> heuristicVals = new ArrayList<Integer>();
					for (Tile t : toHit) {
						heuristicVals.add(t.getHeuristicValue());
					}
					max = Collections.max(heuristicVals);
					for (Tile t : toHit) {
						if (t.getHeuristicValue() == max) {
							output = t.getCoord().toPrettyString();
							break;
						}
					}
					break;

				case 2: // HARD
					toHit = evalFunction(toHit); // Propogate once
					// toHit = evalFunction(toHit); //Twice
					ArrayList<Integer> heuristicVals1 = new ArrayList<Integer>();
					for (Tile t : toHit) {
						heuristicVals1.add(t.getHeuristicValue());
					}
					max = Collections.max(heuristicVals1);
					for (Tile t : toHit) {
						if (t.getHeuristicValue() == max) {
							output = t.getCoord().toPrettyString();
							break;
						}
					}
					break;
				case 4: // COMBO
					toHit = evalFunction(toHit); // Propogate once
					toHit = evalFunctionEasy(toHit); // Twice
					// toHit11 = evalFunctionEasy(toHit11); //Propogate once
					// toHit11 = evalFunction(toHit11); //Twice
					ArrayList<Integer> heuristicVals11 = new ArrayList<Integer>();
					for (Tile t : toHit) {
						heuristicVals11.add(t.getHeuristicValue());
					}
					max = Collections.max(heuristicVals11);
					for (Tile t : toHit) {
						if (t.getHeuristicValue() == max) {
							output = t.getCoord().toPrettyString();
							break;
						}
					}
					break;
				}

				break;
			case 3: // 2 AIs
				if (getName().equals("Player 1")) {// Read Player 1 difficulties
					switch (Battleship.GLOBAL_OFFENSIVE_DIFFICULTY) {
					case 1: // Naive
						output = randomAIFire();

						break;
					case 3: // Moderate
						toHit = evalFunctionEasy(toHit); // Propogate once
						// toHit1 = evalFunctionEasy(toHit1); //Twice
						ArrayList<Integer> heuristicVals = new ArrayList<Integer>();
						for (Tile t : toHit) {
							heuristicVals.add(t.getHeuristicValue());
						}
						max = Collections.max(heuristicVals);
						for (Tile t : toHit) {
							if (t.getHeuristicValue() == max) {
								output = t.getCoord().toPrettyString();
								break;
							}
						}
						break;

					case 2: // HARD
						toHit = evalFunction(toHit); // Propogate once
						// toHit = evalFunction(toHit); //Twice
						ArrayList<Integer> heuristicVals1 = new ArrayList<Integer>();
						for (Tile t : toHit) {
							heuristicVals1.add(t.getHeuristicValue());
						}
						max = Collections.max(heuristicVals1);
						for (Tile t : toHit) {
							if (t.getHeuristicValue() == max) {
								output = t.getCoord().toPrettyString();
								break;
							}
						}
						break;
					case 4: // COMBO
						toHit = evalFunction(toHit); // Propogate once
						toHit = evalFunctionEasy(toHit); // Twice
						// toHit11 = evalFunctionEasy(toHit11); //Propogate once
						// toHit11 = evalFunction(toHit11); //Twice
						ArrayList<Integer> heuristicVals11 = new ArrayList<Integer>();
						for (Tile t : toHit) {
							heuristicVals11.add(t.getHeuristicValue());
						}
						int max11 = Collections.max(heuristicVals11);
						for (Tile t : toHit) {
							if (t.getHeuristicValue() == max11) {
								output = t.getCoord().toPrettyString();
								break;
							}
						}
						break;
					}

				} else { // Read Player 2 Difficulties
					switch (Battleship.GLOBAL_OFFENSIVE_DIFFICULTY_2) {
					case 1: // Naive
						output = randomAIFire();

						break;
					case 3: // Moderate
						toHit = evalFunctionEasy(toHit); // Propogate once
						// toHit1 = evalFunctionEasy(toHit1); //Twice
						ArrayList<Integer> heuristicVals = new ArrayList<Integer>();
						for (Tile t : toHit) {
							heuristicVals.add(t.getHeuristicValue());
						}
						max = Collections.max(heuristicVals);
						for (Tile t : toHit) {
							if (t.getHeuristicValue() == max) {
								output = t.getCoord().toPrettyString();
								break;
							}
						}
						break;

					case 2: // HARD
						toHit = evalFunction(toHit); // Propogate once
						// toHit = evalFunction(toHit); //Twice
						ArrayList<Integer> heuristicVals1 = new ArrayList<Integer>();
						for (Tile t : toHit) {
							heuristicVals1.add(t.getHeuristicValue());
						}
						int max1 = Collections.max(heuristicVals1);
						for (Tile t : toHit) {
							if (t.getHeuristicValue() == max1) {
								output = t.getCoord().toPrettyString();
								break;
							}
						}
						break;
					case 4: // COMBO
						toHit = evalFunction(toHit); // Propogate once
						toHit = evalFunctionEasy(toHit); // Twice
						// toHit11 = evalFunctionEasy(toHit11); //Propogate once
						// toHit11 = evalFunction(toHit11); //Twice
						ArrayList<Integer> heuristicVals11 = new ArrayList<Integer>();
						for (Tile t : toHit) {
							heuristicVals11.add(t.getHeuristicValue());
						}
						int max11 = Collections.max(heuristicVals11);
						for (Tile t : toHit) {
							if (t.getHeuristicValue() == max11) {
								output = t.getCoord().toPrettyString();
								break;
							}
						}
						break;
					}

				}
				break;
			}
			isValid = true;
			Coordinate outCoord = new Coordinate(output);
			Tile outTile = new Tile(outCoord, "X");
			if( offensive.getListOfMisses().contains(outCoord)) {
				isValid = false;
			}
			for (Tile t : offensive.getListOfMisses()) {
				if (t.getCoord().equals(outCoord)) {
					isValid = false; // Invalid guess, try again
					toHit.remove(new Tile( new Coordinate(output), " "));
					for (Tile t1 : toHit) {
						if (t1.getHeuristicValue() == max) {
							output = t1.getCoord().toPrettyString();
							isValid = true;
							break;
						}
					}
				}
			}
			for (Tile t : offensive.getListOfHits()) {
				if (t.getCoord().equals(outCoord)) {
					isValid = false; // Invalid guess, try again
					toHit.remove(new Tile( new Coordinate(output), " "));
					for (Tile t1 : toHit) {
						if (t1.getHeuristicValue() == max) {
							output = t1.getCoord().toPrettyString();
							isValid = true;
							break;
						}
					}
					
				}
			}
			toHit.add(new Tile(new Coordinate(randomAIFire()), " "));

		}

		lastFire = new Coordinate(output);
		System.out.println(output);
		return output;

	}
	
	
	
	//Placement

	private void randomAIPlacement() { //Naive
		int randomX = 1;
		int randomY = 1;
		int randomDirection = 1;
		ArrayList<Ship> ships = new ArrayList<>();

		// Randomly place the Carrier.
		while(!isValidPlacement(new Coordinate(randomX, randomY), randomDirection, 5, ships)) {
			randomX = randomNumber(1, 10);
			randomY = randomNumber(1, 10);
			//Coordinate randomCoordinate = new Coordinate(randomX, randomY);
			randomDirection = randomNumber(1, 4);
		}
		defensive.placeCarrier(new Coordinate(3, 4), randomDirection);
		ships.add(defensive.carrier);

		// Randomly place the Battleship.
		while(!isValidPlacement(new Coordinate(randomX, randomY), randomDirection, 5, ships)) {
			randomX = randomNumber(1, 10);
			randomY = randomNumber(1, 10);
			randomDirection = randomNumber(1, 4);
		}
		defensive.placeBattleship(new Coordinate(randomX, randomY), randomDirection);
		ships.add(defensive.battleship);

		// Randomly place the Cruiser.
		while(!isValidPlacement(new Coordinate(randomX, randomY), randomDirection, 4, ships)) {
			randomX = randomNumber(1, 10);
			randomY = randomNumber(1, 10);
			randomDirection = randomNumber(1, 4);
		}
		defensive.placeCruiser(new Coordinate(randomX, randomY), randomDirection);
		ships.add(defensive.cruiser);

		// Randomly place the Submarine.
		while(!isValidPlacement(new Coordinate(randomX, randomY), randomDirection, 4, ships)) {
			randomX = randomNumber(1, 10);
			randomY = randomNumber(1, 10);
			randomDirection = randomNumber(1, 4);
		}
		defensive.placeSubmarine(new Coordinate(randomX, randomY), randomDirection);
		ships.add(defensive.submarine);

		// Randomly place the Destroyer.
		while(!isValidPlacement(new Coordinate(randomX, randomY), randomDirection, 3, ships)) {
			randomX = randomNumber(1, 10);
			randomY = randomNumber(1, 10);
			randomDirection = randomNumber(1, 4);
		}
		defensive.placeDestroyer(new Coordinate(randomX, randomY), randomDirection);
		ships.add(defensive.destroyer);
	}

	// 1: RIGHT
	// 2: LEFT
	// 3: UP
	// 4: DOWN

	public boolean isValidPlacementCenter(Coordinate start, int direction, int size, ArrayList<Ship> ships) {

		int x = start.getX();
		int y = start.getY();

		// Check if starting position is within another ship (prevents overlapping).
		for(Ship s: ships) {
			for(Tile t: s.getTiles()) {
				if(t.getCoord().equals(start)) {
					return false;
				}
			}
		}

		switch(direction) {
		case 1: //GOING RIGHT X+Size
			if(x+size > 8) {
				return false;
			}
			break;
		case 2: //LEFT X - SIZE
			if(x-size < 3) {
				return false;
			}
			break;
		case 3: //UP Y - SIZE
			if(y - size < 3) {
				return false;
			}
			break;
		case 4: //DOWN Y + SIZE
			if(y+size > 8) {
				return false;
			}
			break;
		default:
			return false;
		}

		return true;
	}

	// Valid area is 4-8 (x) 4-8 (y) 
	public void intelligentPlacementCenter() { //Cluster

		int randomX = 4;
		int randomY = 5;
		int randomDirection = 1;
		ArrayList<Ship> ships = new ArrayList<>();

		// Intelligently place the Carrier.
		while(!isValidPlacementCenter(new Coordinate(randomX, randomY), randomDirection, 5, ships)) {
			randomX = randomNumber(3, 8);
			randomY = randomNumber(3, 8);
			//Coordinate randomCoordinate = new Coordinate(randomX, randomY);
			randomDirection = randomNumber(1, 4);
		}
		defensive.placeCarrier(new Coordinate(4, 5), 1);
		ships.add(defensive.carrier);

		// Intelligently place the Battleship.
		while(!isValidPlacementCenter(new Coordinate(randomX, randomY), randomDirection, 5, ships)) {
			randomX = randomNumber(3, 8);
			randomY = randomNumber(3, 8);
			randomDirection = randomNumber(1, 4);
		}
		defensive.placeBattleship(new Coordinate(randomX, randomY), randomDirection);
		ships.add(defensive.battleship);

		// Intelligently place the Cruiser.
		while(!isValidPlacementCenter(new Coordinate(randomX, randomY), randomDirection, 4, ships)) {
			randomX = randomNumber(3, 8);
			randomY = randomNumber(3, 8);
			randomDirection = randomNumber(1, 4);
		}
		defensive.placeCruiser(new Coordinate(randomX, randomY), randomDirection);
		ships.add(defensive.cruiser);

		// Intelligently place the Submarine.
		while(!isValidPlacementCenter(new Coordinate(randomX, randomY), randomDirection, 4, ships)) {
			randomX = randomNumber(3, 8);
			randomY = randomNumber(3, 8);
			randomDirection = randomNumber(1, 4);
		}
		defensive.placeSubmarine(new Coordinate(randomX, randomY), randomDirection);
		ships.add(defensive.submarine);

		// Intelligently place the Destroyer.
		while(!isValidPlacementCenter(new Coordinate(randomX, randomY), randomDirection, 3, ships)) {
			randomX = randomNumber(3, 8);
			randomY = randomNumber(3, 8);
			randomDirection = randomNumber(1, 4);
		}
		defensive.placeDestroyer(new Coordinate(randomX, randomY), randomDirection);
		ships.add(defensive.destroyer);
	}

	public void intelligentPlacementPerimeter() {

		int randomX = -1;
		int randomY = -1;
		int randomDirection = 1;
		ArrayList<Ship> ships = new ArrayList<>();

		// Intelligently place the Carrier.
		while(!isValidPlacement(new Coordinate(randomX, randomY), randomDirection, 5, ships)) {
			randomX = randomNumber(1, 10);
			if(randomX < 3 || randomX > 8) {
				randomDirection = 1;
			}
			randomY = randomNumber(1, 10);
			//Coordinate randomCoordinate = new Coordinate(randomX, randomY);
			randomDirection = randomNumber(3, 8);
		}
		defensive.placeCarrier(new Coordinate(1, 1), 4);
		ships.add(defensive.carrier);

		// Intelligently place the Battleship.
		while(!isValidPlacement(new Coordinate(randomX, randomY), randomDirection, 4, ships)) {
			randomX = randomNumber(1, 10);
			randomY = randomNumber(1, 10);
			randomDirection = randomNumber(1, 4);
		}
		defensive.placeBattleship(new Coordinate(9, 9), 2);
		ships.add(defensive.battleship);

		// Intelligently place the Cruiser.
		while(!isValidPlacement(new Coordinate(randomX, randomY), randomDirection, 3, ships)) {
			randomX = randomNumber(1, 10);
			randomY = randomNumber(1, 10);
			randomDirection = randomNumber(1, 4);
		}
		defensive.placeCruiser(new Coordinate(9, 7), 3);
		ships.add(defensive.cruiser);

		// Intelligently place the Submarine.
		while(!isValidPlacement(new Coordinate(randomX, randomY), randomDirection, 3, ships)) {
			randomX = randomNumber(1, 10);
			randomY = randomNumber(1, 10);
			randomDirection = randomNumber(1, 4);
		}
		defensive.placeSubmarine(new Coordinate(2, 5), 4);
		ships.add(defensive.submarine);

		// Intelligently place the Destroyer.
		while(!isValidPlacement(new Coordinate(randomX, randomY), randomDirection, 2, ships)) {
			randomX = randomNumber(1, 10);
			randomY = randomNumber(1, 10);
			randomDirection = randomNumber(1, 4);
		}
		defensive.placeDestroyer(new Coordinate(1, 10), 1);
		ships.add(defensive.destroyer);
	}
	public boolean isValidPlacement(Coordinate start, int direction, int size, ArrayList<Ship> ships) {
		int x = start.getX();
		int y = start.getY();
		if(x==-1) return false;
		if(y==-1) return false;

		// Check if starting position is within another ship (prevents overlapping).
		for(Ship s: ships) {
			for(Tile t: s.getTiles()) {
				if(t.getCoord().equals(start)) {
					return false;
				}
			}
		}

		switch(direction) {
		case 1: //GOING RIGHT X+Size
			if(x+size > 10) {
				return false;
			}
			break;
		case 2: //LEFT X - SIZE
			if(x-size < 0) {
				return false;
			}
			break;
		case 3: //UP Y - SIZE
			if(y - size < 0) {
				return false;
			}
			break;
		case 4: //DOWN Y + SIZE
			if(y+size >10) {
				return false;
			}
			break;
		default:
			return false;
		}

		return true;
	}
	
	
	

	
}
