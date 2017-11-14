package com.Battleship;

import java.util.List;

/**
 * 
 * @author jerbened
 * Class for the ship 
 * 
 */
public class Ship {
		
	private int size;
	private int health;
	private String name;
	private List<Tile> tiles;
	
	/**
	 * @param size
	 * @param name
	 * @param tiles
	 */
	public Ship(int size, String name, List<Tile> tiles) {
		this.size = size;
		this.name = name;
		this.tiles = tiles;
	}

	
	

	
	//Todo: constructor and getters/setters
	

}
