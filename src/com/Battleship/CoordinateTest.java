package com.Battleship;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CoordinateTest {

	Coordinate invalid = new Coordinate(0,0);
	Coordinate minCorner = new Coordinate(1,1);
	Coordinate minX = new Coordinate(1,5);
	Coordinate maxX = new Coordinate(10,5);
	Coordinate minY = new Coordinate(5,1);
	Coordinate maxY = new Coordinate(5,10);
	Coordinate maxCorner = new Coordinate(10,10);
	Coordinate rand = new Coordinate(5,6);
	
	
	@Test
	void testGetNeighbors() {
		List<Coordinate> invalidNeigh = invalid.getNeighbors();
		List<Coordinate> minCornerNeigh = minCorner.getNeighbors();
		List<Coordinate> maxCornerNeigh = maxCorner.getNeighbors();
		List<Coordinate> randNeigh = rand.getNeighbors();
		List<Coordinate> minXNeigh = minX.getNeighbors();
		List<Coordinate> minYNeigh = minY.getNeighbors();
		List<Coordinate> maxXNeigh = maxX.getNeighbors();
		List<Coordinate> maxYNeigh = maxY.getNeighbors();

		assertEquals(null, invalidNeigh);
		assertEquals(2, minCornerNeigh.size());
		assertEquals(2, maxCornerNeigh.size());
		assertEquals(4, randNeigh.size());
		assertEquals(3, minXNeigh.size());
		assertEquals(3, minYNeigh.size());
		assertEquals(3, maxXNeigh.size());
		assertEquals(3, maxYNeigh.size());

	}
	
	@Test
	void testCoordinateCreation() {
		Coordinate a = new Coordinate("A1");
		Coordinate b = new Coordinate("B5");
		Coordinate j = new Coordinate("J1");
		Coordinate ten = new Coordinate("J10");
		
		assertEquals(1, a.getX());
		assertEquals(1, a.getY());
		
		assertEquals(2, b.getX());
		assertEquals(5, b.getY());
		
		assertEquals(10, j.getX());
		assertEquals(1, j.getY());
		
		assertEquals(10, ten.getX());
		assertEquals(10, ten.getY());
	}


	

}
