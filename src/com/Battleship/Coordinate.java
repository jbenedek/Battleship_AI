package com.Battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jerbened 
 * 
 * Just the Math Coordinates
 * 
 * Index starts at 1. Board is 10x10, so indexes 1-10
 */
public class Coordinate {
	
	private int x;
	private int y;
	
	//Todo:  constructor, getters/setters
	
	
	//return a list of Neighbors
	public List<Coordinate> getNeighbors() {
		List<Coordinate> neighbors = new ArrayList<Coordinate>();
		return neighbors;
	}
}
