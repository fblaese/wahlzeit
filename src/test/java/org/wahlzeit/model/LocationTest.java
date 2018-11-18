package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LocationTest {

	@Test
	public void testCoordinateStorage() {
		Coordinate coordinate = new CartesianCoordinate(1,1,1);
		Location location = new Location(coordinate);
		assertTrue(location.getCoordinate() == coordinate);

		location = new Location(coordinate, "Test Location");
		assertTrue(location.getCoordinate() == coordinate);
	}

	@Test
	public void testNameStorage() {
		Location location = new Location(new CartesianCoordinate(1,1,1));
		assertTrue(location.getName() == null);

		String name = "Test Location";
		location.setName(name);
		assertTrue(location.getName() == name);

		location = new Location(new CartesianCoordinate(1,1,1), name);
		assertTrue(location.getName() == name);
	}

	@Test
	public void testEquals() {
		Location location1, location2;

		location1 = new Location(new CartesianCoordinate(1,1,1), "Test Location");
		location2 = new Location(new CartesianCoordinate(1,1,1), "Test Location");
		assertTrue(location1.equals(location2) == true);

		location2 = new Location(new CartesianCoordinate(1,2,3), "Test Location");
		assertTrue(location1.equals(location2) == false);

		location2 = new Location(new CartesianCoordinate(1,1,1), "Test");
		assertTrue(location1.equals(location2) == false);

		location2 = new Location(new CartesianCoordinate(1,2,3), "Test");
		assertTrue(location1.equals(location2) == false);

		location1 = new Location(new CartesianCoordinate(2,2,2), "");
		location2 = new Location(new CartesianCoordinate(2,2,2), "");
		assertTrue(location1.equals(location2) == true);

		location2 = new Location(new CartesianCoordinate(2,2,2), "Test Location");
		assertTrue(location1.equals(location2) == false);

		assertTrue(location1.equals(null) == false);
		assertTrue(location1.equals("Test Location") == false);
	}

}
