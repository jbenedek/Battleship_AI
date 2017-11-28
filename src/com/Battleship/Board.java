package com.Battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jerbened
 *
 *Index starts at 1. Board is 10x10, so indexes 1-10
 *A collection of Ships, which will take care of of ship hit/miss symbols. And a list of missed shots for marking.
 *
 *private Ship carrier;
 *private Ship battleship;
 *private Ship cruiser;
 *private Ship submarine;
 *private Ship destroyer;
 *private List<Tile> listOfMisses;
 *
 */
public class Board {
	
	public Ship carrier = new Ship(5, "Carrier", new ArrayList<Tile>());
	public Ship battleship = new Ship(4, "Battleship", new ArrayList<Tile>());
	public Ship cruiser = new Ship(3, "Cruiser", new ArrayList<Tile>());
	public Ship submarine = new Ship(3, "Submarine", new ArrayList<Tile>());
	public Ship destroyer = new Ship(2, "Destroyer", new ArrayList<Tile>());
	private List<Tile> listOfMisses = new ArrayList<Tile>();
	private List<Tile> listOfHits = new ArrayList<Tile>();
	
	private List<Ship> shipsSunk = new ArrayList<>();

	
	
	public int getTotalHits() {
		return carrier.getHits() + battleship.getHits() + cruiser.getHits() + submarine.getHits() + destroyer.getHits();
	}
	public int getTotalMisses() {
		return listOfMisses.size();
	}
	
	/**
	 * Verifies that there are enough spaces for the ship to valid. Takes direction, start, and size
	 * @param Cooridnate start
	 * @param int direction 
	 * <li> 0 FOR RIGHT
	 * <li> 1 FOR LEFT
	 * <li> 2 FOR UP
	 * <li> 3 FOR DOWN </li>
	 * @param int size 
	 * @return boolean
	 */
	private boolean isValidPlacement(Coordinate start, int direction, int size) {
		int x = start.getX();
		int y = start.getY();
		
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
	
	/**
	 * 
	 * @param Cooridnate start
	 * @param int direction 
	 * <li> 0 FOR RIGHT
	 * <li> 1 FOR LEFT
	 * <li> 2 FOR UP
	 * <li> 3 FOR DOWN
	 */
	public void placeCarrier(Coordinate start, int direction) {
		if (isValidPlacement(start,direction,5)) {
			List<Tile> tiles = new ArrayList<Tile>();
			
			Coordinate first = Coordinate.getNeighbor(start, direction);
			Coordinate second = Coordinate.getNeighbor(first, direction);
			Coordinate third = Coordinate.getNeighbor(second, direction);
			Coordinate forth = Coordinate.getNeighbor(third, direction);
			
			tiles.add(new Tile(start, "O"));
			tiles.add(new Tile(first, "O"));
			tiles.add(new Tile(second, "O"));
			tiles.add(new Tile(third, "O"));
			tiles.add(new Tile(forth, "O"));
			carrier.setTiles(tiles);
		}
	}
	
	/**
	 * 
	 * @param Cooridnate start
	 * @param int direction 
	 * <li> 0 FOR RIGHT
	 * <li> 1 FOR LEFT
	 * <li> 2 FOR UP
	 * <li> 3 FOR DOWN
	 */
	public void placeBattleship(Coordinate start, int direction) {
		if (isValidPlacement(start,direction,5)) {
			List<Tile> tiles = new ArrayList<Tile>();
			
			Coordinate first = Coordinate.getNeighbor(start, direction);
			Coordinate second = Coordinate.getNeighbor(first, direction);
			Coordinate third = Coordinate.getNeighbor(second, direction);
			
			tiles.add(new Tile(start, "O"));
			tiles.add(new Tile(first, "O"));
			tiles.add(new Tile(second, "O"));
			tiles.add(new Tile(third, "O"));
			battleship.setTiles(tiles);
		}
	}
	
	/**
	 * 
	 * @param Cooridnate start
	 * @param int direction 
	 * <li> 0 FOR RIGHT
	 * <li> 1 FOR LEFT
	 * <li> 2 FOR UP
	 * <li> 3 FOR DOWN
	 */
	public void placeCruiser(Coordinate start, int direction) {
		if (isValidPlacement(start,direction,5)) {
			List<Tile> tiles = new ArrayList<Tile>();
			
			Coordinate first = Coordinate.getNeighbor(start, direction);
			Coordinate second = Coordinate.getNeighbor(first, direction);
			
			tiles.add(new Tile(start, "O"));
			tiles.add(new Tile(first, "O"));
			tiles.add(new Tile(second, "O"));
			cruiser.setTiles(tiles);
		}
	}
	
	/**
	 * 
	 * @param Cooridnate start
	 * @param int direction 
	 * <li> 0 FOR RIGHT
	 * <li> 1 FOR LEFT
	 * <li> 2 FOR UP
	 * <li> 3 FOR DOWN
	 */
	public void placeSubmarine(Coordinate start, int direction) {
		if (isValidPlacement(start,direction,5)) {
			List<Tile> tiles = new ArrayList<Tile>();
			
			Coordinate first = Coordinate.getNeighbor(start, direction);
			Coordinate second = Coordinate.getNeighbor(first, direction);

			
			tiles.add(new Tile(start, "O"));
			tiles.add(new Tile(first, "O"));
			tiles.add(new Tile(second, "O"));

			submarine.setTiles(tiles);
		}
	}
	
	/**
	 * 
	 * @param Cooridnate start
	 * @param int direction 
	 * <li> 0 FOR RIGHT
	 * <li> 1 FOR LEFT
	 * <li> 2 FOR UP
	 * <li> 3 FOR DOWN
	 */
	public void placeDestroyer(Coordinate start, int direction) {
		if (isValidPlacement(start,direction,5)) {
			List<Tile> tiles = new ArrayList<Tile>();
			
			Coordinate first = Coordinate.getNeighbor(start, direction);
			
			tiles.add(new Tile(start, "O"));
			tiles.add(new Tile(first, "O"));
			destroyer.setTiles(tiles);
		}
	}
	
	public boolean coordinateIsShip(Coordinate c) {
		List<Coordinate> ships = new ArrayList<>();
		for (Tile t : carrier.getTiles()) {
			ships.add(t.getCoord());
		}
		for (Tile t : battleship.getTiles()) {
			ships.add(t.getCoord());
		}
		for (Tile t : cruiser.getTiles()) {
			ships.add(t.getCoord());
		}
		for (Tile t : submarine.getTiles()) {
			ships.add(t.getCoord());
		}
		for (Tile t : destroyer.getTiles()) {
			ships.add(t.getCoord());
		}
		
		return ships.contains(c);
	}
	
	/**
	 * Adds the coordinate to list of misses, creating a new tile with - symbol
	 */
	public void addMiss(Coordinate c) {
		listOfMisses.add(new Tile(c, "-"));
	}
	
	/**
	 * Finds what ship has the coordinate, and changes the symbol to a hit. Checks for sinks
	 * Adds symbol X
	 * 
	 * Waits an extra second if there is a hit
	 * @param c
	 * @throws InterruptedException 
	 */
	public void addHit(Coordinate c) throws InterruptedException {
		for (Tile t : carrier.getTiles()) {
			if(t.getCoord().equals(c)) {
				t.setSymbol("X");
				carrier.decrementHealth();
				if( carrier.checkIfSunk() ) { //SHIP SUNK
					shipsSunk.add(carrier);
					System.out.println("\nYou sunk the opponent's CARRIER (5)");
					Thread.sleep(1000);
				}
			}
		}
		for (Tile t : battleship.getTiles()) {
			if(t.getCoord().equals(c)) {
				t.setSymbol("X");
				battleship.decrementHealth();
				if( battleship.checkIfSunk() ) { //SHIP SUNK
					shipsSunk.add(battleship);
					System.out.println("\nYou sunk the opponent's BATTLESHIP (4)");
					Thread.sleep(1000);

				}
			}	
		}
		for (Tile t : cruiser.getTiles()) {
			if(t.getCoord().equals(c)) {
				t.setSymbol("X");
				cruiser.decrementHealth();
				if( cruiser.checkIfSunk() ) { //SHIP SUNK
					shipsSunk.add(cruiser);
					System.out.println("\nYou sunk the opponent's CRUISER (3)");
					Thread.sleep(1000);

				}
			}		}
		for (Tile t : submarine.getTiles()) {
			if(t.getCoord().equals(c)) {
				t.setSymbol("X");
				submarine.decrementHealth();
				if( submarine.checkIfSunk() ) { //SHIP SUNK
					shipsSunk.add(submarine);
					System.out.println("\nYou sunk the opponent's SUBMARINE (3)");
					Thread.sleep(1000);

				}
			}		}
		for (Tile t : destroyer.getTiles()) {
			if(t.getCoord().equals(c)) {
				t.setSymbol("X");
				destroyer.decrementHealth();
				if( destroyer.checkIfSunk() ) { //SHIP SUNK
					shipsSunk.add(destroyer);
					System.out.println("\nYou sunk the opponent's DESTROYER (2)");
					Thread.sleep(1000);

				}
			}		}
		listOfHits.add(new Tile(c, "X")); //THIS IS DONE SO THE FIRING PLAYER CAN REFLECT THE HIT

	}
	
	public List<Tile> getAllShipCoords(){
		List<Tile> ships = new ArrayList<>();
		for (Tile t : carrier.getTiles()) {
			ships.add(t);
		}
		for (Tile t : battleship.getTiles()) {
			ships.add(t);
		}
		for (Tile t : cruiser.getTiles()) {
			ships.add(t);
		}
		for (Tile t : submarine.getTiles()) {
			ships.add(t);
		}
		for (Tile t : destroyer.getTiles()) {
			ships.add(t);
		}
		return ships;
	}
	
	@Override
	public String toString() {
		List<Coordinate> ships = new ArrayList<>();
		for (Tile t : carrier.getTiles()) {
			ships.add(t.getCoord());
		}
		for (Tile t : battleship.getTiles()) {
			ships.add(t.getCoord());
		}
		for (Tile t : cruiser.getTiles()) {
			ships.add(t.getCoord());
		}
		for (Tile t : submarine.getTiles()) {
			ships.add(t.getCoord());
		}
		for (Tile t : destroyer.getTiles()) {
			ships.add(t.getCoord());
		}
				
		return "All Ship Tiles: " + ships.toString() + "\nMissedTiles: " + listOfMisses.toString() + "\nHits: " + listOfHits.toString();
	}
	
	public List<Ship> getShipsSunk() {
		return shipsSunk;
	}
	/**
	 * @return the listOfMisses
	 */
	public List<Tile> getListOfMisses() {
		return listOfMisses;
	}
	public List<Tile> getListOfHits() {
		return listOfHits;
	}	
}
