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
 * 
 * Allows form of A1 - J10 where the char is X and the num is Y
 */
public class Coordinate {
	
	private int x;
	private int y;
	private final int MAX_COORD = 10;
	private final int MIN_COORD = 1;
	
	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @param String s, a coord in friendly form A1, B4, J5, etc). A-J 1-10
	 */
	public Coordinate(String s) {
		this.x = Character.toUpperCase(s.charAt(0)) - 64;
		this.y = Integer.parseInt(s.substring(1) );
	}

	/**
	 * A1 = 11
	 * A2 = 12
	 * A10 = 110
	 * B1 = 21
	 * J1 = 101
	 * J10 = 1010
	 * @return
	 */
	public int getSingleValueRepresentation() { 
		if (x==-1) {return 11;}
		if(y==-1) {return 11;}
		String sx = x + "";
		String sy = y + "";
		String combo = sx + sy;
		return Integer.parseInt(combo);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	//return a list of Neighbors
	public List<Coordinate> getNeighbors() {
		if (x >= 1 && y >= 1) {
			List<Coordinate> neighbors = new ArrayList<Coordinate>();
			if (x + 1 <= MAX_COORD) {
				neighbors.add(new Coordinate(x + 1, y));
			}
			if (y + 1 <= MAX_COORD) {
				neighbors.add(new Coordinate(x, y + 1));
			}
			if (x - 1 >= MIN_COORD) {
				neighbors.add(new Coordinate(x - 1, y));
			}
			if (y - 1 >= MIN_COORD) {
				neighbors.add(new Coordinate(x, y - 1));
			}
			return neighbors;
		}
		return null;
	}
	
	/**
	 * 
	 * @param c, current coordinate
	 * @param direction, RIGHT 0, LEFT 1, UP 3
	 * @return
	 */
		public static Coordinate getNeighbor(Coordinate c, int direction) {
			switch(direction) {
			case 1: //GOING RIGHT X+Size
				return new Coordinate(c.getX() + 1, c.getY());
			case 2: //LEFT X - SIZE
				return new Coordinate(c.getX() - 1, c.getY());
			case 3: //UP Y - SIZE
				return new Coordinate(c.getX(), c.getY() - 1);
			case 4: //DOWN Y + SIZE
				return new Coordinate(c.getX(), c.getY() + 1);
			}
			return null;
		}

	@Override
	public String toString() {
		return "["+x+","+y+"]";
	}
	
	public String toPrettyString() {
		char c = (char)(x + 64);
		return c + "" + y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
