package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class CoordinateTest {

	private static final double EPSILON = 1; // 1 meter precision

	@Test
	public void testCoordinatesStorage() {
		Coordinate coordinate = new Coordinate(1, 1);
		assertTrue (coordinate.getLatitude() == 1);
		assertTrue (coordinate.getLongitude() == 1);

		coordinate = new Coordinate(4, 4);
		assertTrue (coordinate.getLatitude() == 4);
		assertTrue (coordinate.getLongitude() == 4);

		coordinate = new Coordinate(49.5979, 11.0045);
		assertTrue (coordinate.getLatitude() == 49.5979);
		assertTrue (coordinate.getLongitude() == 11.0045);
	}

	@Test
	public void testEquals() {
		Coordinate coordinate = new Coordinate(1, 1);
		assertTrue (coordinate.equals(new Coordinate(1, 1)));
		assertTrue (!coordinate.equals(new Coordinate(1, 2)));
		assertTrue (!coordinate.equals(new Coordinate(2, 1)));

		coordinate = new Coordinate(4, 4);
		assertTrue (coordinate.equals(new Coordinate(4, 4)));
		assertTrue (!coordinate.equals(new Coordinate(4, 1)));
		assertTrue (!coordinate.equals(new Coordinate(1, 4)));

		coordinate = new Coordinate(-4, -4);
		assertTrue (coordinate.equals(new Coordinate(-4, -4)));
		assertTrue (!coordinate.equals(new Coordinate(-4, 4)));
		assertTrue (!coordinate.equals(new Coordinate(4, -4)));

		coordinate = new Coordinate(49.5979, 11.0045);
		assertTrue (coordinate.equals(new Coordinate(49.5979, 11.0045)));
		assertTrue (!coordinate.equals(new Coordinate(50, 11.0045)));
		assertTrue (!coordinate.equals(new Coordinate(49.5979, 12)));
	}

	private double difference(double a, double b) {
		return Math.abs(a - b);
	}

	@Test
	public void testDistance() {
		Coordinate coordinate1 = new Coordinate(1, 1);
		Coordinate coordinate2 = new Coordinate(2, 2);
		assertTrue (difference(coordinate1.distanceTo(coordinate2), 157225.43) < EPSILON);

		coordinate2 = new Coordinate(4, 4);
		assertTrue (difference(coordinate1.distanceTo(coordinate2), 471508.55) < EPSILON);
		assertTrue (coordinate1.distanceTo(coordinate2) == coordinate2.distanceTo(coordinate1));

		coordinate2 = new Coordinate(-4, 4);
		assertTrue (difference(coordinate1.distanceTo(coordinate2), 648258.90) < EPSILON);
		assertTrue (coordinate1.distanceTo(coordinate2) == coordinate2.distanceTo(coordinate1));

		coordinate1 = new Coordinate(49.5738, 11.0270);
		coordinate2 = new Coordinate(49.5749, 11.0298);
		assertTrue (difference(coordinate1.distanceTo(coordinate2), 236.06) < EPSILON);
	}
}
