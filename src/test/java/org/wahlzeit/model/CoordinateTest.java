package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class CoordinateTest {

	private static final double EPSILON = 0.000001;

	@Test
	public void testEqualsCartesian() {
		Coordinate coordinate = CartesianCoordinate.createCoordinate(1, 1, 1);
		assertTrue(coordinate.equals(CartesianCoordinate.createCoordinate(1, 1, 1)));
		assertTrue(!coordinate.equals(CartesianCoordinate.createCoordinate(1, 2, 1)));
		assertTrue(!coordinate.equals(CartesianCoordinate.createCoordinate(2, 1, 1)));
		assertTrue(!coordinate.equals(CartesianCoordinate.createCoordinate(1, 1, 2)));

		coordinate = CartesianCoordinate.createCoordinate(4, 5, 6);
		assertTrue(coordinate.equals(CartesianCoordinate.createCoordinate(4, 5, 6)));
		assertTrue(!coordinate.equals(CartesianCoordinate.createCoordinate(5, 6, 7)));
		assertTrue(!coordinate.equals(CartesianCoordinate.createCoordinate(6, 5, 4)));

		coordinate = CartesianCoordinate.createCoordinate(-4, -4, 5);
		assertTrue(coordinate.equals(CartesianCoordinate.createCoordinate(-4, -4, 5)));
		assertTrue(!coordinate.equals(CartesianCoordinate.createCoordinate(-4, 4, 5)));
		assertTrue(!coordinate.equals(CartesianCoordinate.createCoordinate(4, -4, 5)));

		coordinate = CartesianCoordinate.createCoordinate(49.5979, 11.0045, 9.1034);
		assertTrue(coordinate.equals(CartesianCoordinate.createCoordinate(49.5979, 11.0045, 9.1034)));
		assertTrue(!coordinate.equals(CartesianCoordinate.createCoordinate(50, 11.0045, 9.1034)));
		assertTrue(!coordinate.equals(CartesianCoordinate.createCoordinate(49.5979, 12, 9.1034)));

		assertTrue(!coordinate.equals(null));
		assertTrue(!coordinate.equals("Test"));
	}

	@Test
	public void testEqualsSpheric() {
		Coordinate coordinate = SphericCoordinate.createCoordinate(1, 1, 1);
		assertTrue(coordinate.equals(SphericCoordinate.createCoordinate(1, 1, 1)));
		assertTrue(!coordinate.equals(SphericCoordinate.createCoordinate(1, 2, 1)));
		assertTrue(!coordinate.equals(SphericCoordinate.createCoordinate(2, 1, 1)));
		assertTrue(!coordinate.equals(SphericCoordinate.createCoordinate(1, 1, 2)));

		coordinate = SphericCoordinate.createCoordinate(2, -3, 6);
		assertTrue(coordinate.equals(SphericCoordinate.createCoordinate(2, -3, 6)));
		assertTrue(!coordinate.equals(SphericCoordinate.createCoordinate(2, 2, 7)));
		assertTrue(!coordinate.equals(SphericCoordinate.createCoordinate(3, -1, 4)));

		coordinate = SphericCoordinate.createCoordinate(2, 0, 5);
		assertTrue(coordinate.equals(SphericCoordinate.createCoordinate(2, 0, 5)));
		assertTrue(!coordinate.equals(SphericCoordinate.createCoordinate(0, 2, 5)));
		assertTrue(!coordinate.equals(SphericCoordinate.createCoordinate(2, 3, 0)));

		coordinate = SphericCoordinate.createCoordinate(2.5979, 1.0045, 9.1034);
		assertTrue(coordinate.equals(SphericCoordinate.createCoordinate(2.5979, 1.0045, 9.1034)));
		assertTrue(!coordinate.equals(SphericCoordinate.createCoordinate(0, 1.0045, 9.1034)));
		assertTrue(!coordinate.equals(SphericCoordinate.createCoordinate(1.5979, 2, 9.1034)));

		assertTrue(!coordinate.equals(null));
		assertTrue(!coordinate.equals("Test"));
	}

	@Test
	public void testIsEqual() {
		Coordinate coordinate = SphericCoordinate.createCoordinate(1, 1, 1);
		assertTrue(coordinate.isEqual(SphericCoordinate.createCoordinate(1, 1, 1)));
		assertTrue(!coordinate.isEqual(SphericCoordinate.createCoordinate(1, 2, 1)));
		assertTrue(!coordinate.isEqual(SphericCoordinate.createCoordinate(2, 1, 1)));
		assertTrue(!coordinate.isEqual(SphericCoordinate.createCoordinate(1, 1, 2)));

		coordinate = SphericCoordinate.createCoordinate(1, 2, 6);
		assertTrue(coordinate.isEqual(SphericCoordinate.createCoordinate(1, 2, 6)));
		assertTrue(!coordinate.isEqual(SphericCoordinate.createCoordinate(1, 3, 7)));
		assertTrue(!coordinate.isEqual(SphericCoordinate.createCoordinate(1, 1, 4)));

		coordinate = SphericCoordinate.createCoordinate(0, 3, 5);
		assertTrue(coordinate.isEqual(SphericCoordinate.createCoordinate(0, 3, 5)));
		assertTrue(!coordinate.isEqual(SphericCoordinate.createCoordinate(3, 0, 5)));
		assertTrue(!coordinate.isEqual(SphericCoordinate.createCoordinate(3, 3, 5)));

		coordinate = SphericCoordinate.createCoordinate(1.5979, -1.0045, 9.1034);
		assertTrue(coordinate.isEqual(SphericCoordinate.createCoordinate(1.5979, -1.0045, 9.1034)));
		assertTrue(!coordinate.isEqual(SphericCoordinate.createCoordinate(2.0, -1.0045, 9.1034)));
		assertTrue(!coordinate.isEqual(SphericCoordinate.createCoordinate(1.5979, 1.2, 9.1034)));

		// Test with different Coordinate Implementations
		Coordinate coordinate1 = SphericCoordinate.createCoordinate(2, 1, 4);
		Coordinate coordinate2 = CartesianCoordinate.createCoordinate(1.965181986, 3.060589605, -1.664587346);
		assertTrue(coordinate1.isEqual(coordinate2));
		assertTrue(coordinate2.isEqual(coordinate1));
	}

	@Test
	public void testAsSpheric() {
		Coordinate coordinate1 = SphericCoordinate.createCoordinate(1, 1, 1);
		Coordinate coordinate2 = CartesianCoordinate.createCoordinate(2, 2, 2);

		assertTrue(coordinate1.isEqual(coordinate1.asSphericCoordinate()));
		assertTrue(coordinate2.isEqual(coordinate2.asSphericCoordinate()));

		// same as coordinate2
		Coordinate coordinate3 = SphericCoordinate.createCoordinate(0.95531661812451, 0.78539816339745, 3.4641016151378);
		assertTrue(coordinate3.isEqual(coordinate2.asSphericCoordinate()));
	}

	@Test
	public void testAsCartesian() {
		Coordinate coordinate1 = SphericCoordinate.createCoordinate(1, 1, 1);
		Coordinate coordinate2 = CartesianCoordinate.createCoordinate(2, 2, 2);

		assertTrue(coordinate1.isEqual(coordinate1.asCartesianCoordinate()));
		assertTrue(coordinate2.isEqual(coordinate2.asCartesianCoordinate()));

		// same as coordinate2
		Coordinate coordinate3 = SphericCoordinate.createCoordinate(0.95531661812451, 0.78539816339745, 3.4641016151378);
		assertTrue(coordinate2.isEqual(coordinate3.asCartesianCoordinate()));
	}

	@Test
	public void testCartesianDistance() {
		Coordinate coordinate1 = CartesianCoordinate.createCoordinate(1, 1, 1);
		Coordinate coordinate2 = CartesianCoordinate.createCoordinate(2, 2, 2);
		assertTrue(Math.abs(coordinate1.getCartesianDistance(coordinate2) - Math.sqrt(3)) < EPSILON);

		coordinate2 = CartesianCoordinate.createCoordinate(4, 4, 4);
		assertTrue(Math.abs(coordinate1.getCartesianDistance(coordinate2) - 3*Math.sqrt(3)) < EPSILON);
		assertTrue(coordinate1.getCartesianDistance(coordinate2) == coordinate2.getCartesianDistance(coordinate1));

		coordinate2 = CartesianCoordinate.createCoordinate(-4, 4, 4);
		assertTrue(Math.abs(coordinate1.getCartesianDistance(coordinate2) - Math.sqrt(43)) < EPSILON);
		assertTrue(coordinate1.getCartesianDistance(coordinate2) == coordinate2.getCartesianDistance(coordinate1));

		coordinate1 = CartesianCoordinate.createCoordinate(49.5738, 11.0270, 9.1034);
		coordinate2 = CartesianCoordinate.createCoordinate(49.5749, 11.0298, 9.1034);
		assertTrue(Math.abs(coordinate1.getCartesianDistance(coordinate2) - 0.0030083218) < EPSILON);

		Coordinate coordinate3 = SphericCoordinate.createCoordinate(1, 1, 1);
		Coordinate coordinate4 = SphericCoordinate.createCoordinate(2, 2, 2);
		assertTrue(Math.abs(coordinate3.getCartesianDistance(coordinate4) - 2.0605185659) < EPSILON);

		coordinate1 = SphericCoordinate.createCoordinate(1, 2, 3);
		assertTrue(Math.abs(coordinate3.getCartesianDistance(coordinate1) - 2.4398766989) < EPSILON);
		assertTrue(Math.abs(coordinate1.getCartesianDistance(coordinate3) - 2.4398766989) < EPSILON);
	}

	@Test
	public void testCentralAngle() {
		
	}
}
