package com.Battleship;

import java.util.List;

/**
 * 
 * @author jerbened
 * Class for the ship 
 * <li> private int size;</li> 
 * <li> private int health; //Number of spots open
 * <li>	private String name;
 * <li>private List<Tile> tiles;
 * <li>	private boolean isSunk;

 */
public class Ship {
		
	private int size;
	private int health; //Number of spots open
	private String name;
	private List<Tile> tiles;
	private boolean isSunk;
	
	/**
	 * @param size
	 * @param name
	 * @param tiles
	 */
	public Ship(int size, String name, List<Tile> tiles) {
		this.size = size;
		this.name = name;
		this.tiles = tiles;
		this.health = size;
		this.isSunk = false;
	}

	public int getSize() {
		return size;
	}
	
	/**
	 * Switches the isSunk bool to True. Does not perform any validation.
	 */
	public void sinkShip() {
		isSunk = true;
	}
	
	/**
	 * 
	 * @return true if the ship has 0 health.
	 */
	public boolean checkIfSunk() {
		if (health == 0) {
			sinkShip();
			return true;
		}
		else {
			return false;
		}
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getHealth() {
		return health;
	}

	/**
	 * 
	 * @return int, the number of tiles hit on the ship.
	 */
	public int getHits() {
		return size - health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void decrementHealth() {
		health = health - 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Tile> getTiles() {
		return tiles;
	}

	public void setTiles(List<Tile> tiles) {
		this.tiles = tiles;
	}

	
	

	
	//Todo: constructor and getters/setters
	

}
