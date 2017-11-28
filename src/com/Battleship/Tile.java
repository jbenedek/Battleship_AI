package com.Battleship;

public class Tile {
	
	protected Coordinate coord;
	protected String symbol;
	protected int heuristicValue;
	
	/**
	 * 
	 * @param coord
	 * @param symbol
	 * <li> X for ship HIT
	 * <li> O for ship UNHIT
	 * <li> - for MISSED SHOT
	 * <li> &nbsp; for EMPTY
	 */
	public Tile(Coordinate coord, String symbol) {
		super();
		this.coord = coord;
		this.symbol = symbol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coord == null) ? 0 : coord.hashCode());
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
		Tile other = (Tile) obj;
		if (coord == null) {
			if (other.coord != null)
				return false;
		} else if (!coord.equals(other.coord))
			return false;
		return true;
	}

	public Coordinate getCoord() {
		return coord;
	}

	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getHeuristicValue() {
		return heuristicValue;
	}

	public void setHeuristicValue(int heuristicValue) {
		this.heuristicValue = heuristicValue;
	}

	@Override
	public String toString() {
		return "Tile [coord=" + coord + ", symbol=" + symbol + ", heuristicValue=" + heuristicValue + "]";
	}
	
	
}
