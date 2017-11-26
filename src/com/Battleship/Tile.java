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
