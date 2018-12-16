package org.wahlzeit.model;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * class to store properties for CartesianCoordinates for
 * comparison and hashing.
 */
class CartesianProp {
	private final double x, y, z;

	public CartesianProp(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof CartesianProp)) return false;

		CartesianProp prop = (CartesianProp) o;
		final double EPSILON = AbstractCoordinate.EPSILON;

		if (Math.abs(x - prop.x) > EPSILON)
			return false;
		if (Math.abs(y - prop.y) > EPSILON)
			return false;
		if (Math.abs(z - prop.z) > EPSILON)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}
}

public class CartesianCoordinate extends AbstractCoordinate {
	private static ConcurrentHashMap<CartesianProp, CartesianCoordinate> instances = new ConcurrentHashMap<>();
	private final double x, y, z;

	/**
	 * x, y and z must be finite double values.
	 */
	private CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;

		assertClassInvariants();
	}

	public static CartesianCoordinate createCoordinate(double x, double y, double z) {
		if (!Double.isFinite(x) || !Double.isFinite(y) || !Double.isFinite(z)) {
			throw new IllegalArgumentException("Parameters have to be finite");
		}

		CartesianProp prop = new CartesianProp(x, y, z);

		// return existing coordinate if possible
		if (instances.contains(prop)) {
			return instances.get(prop);
		}

		// create new otherwise
		CartesianCoordinate created = new CartesianCoordinate(x, y, z);
		instances.put(prop, created);
		return created;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		CartesianCoordinate a = this;
		CartesianCoordinate b = coordinate.asCartesianCoordinate();

		double dX = a.x - b.x;
		double dY = a.y - b.y;
		double dZ = a.z - b.z;
		double distance = Math.sqrt(dX*dX + dY*dY + dZ*dZ);

		return distance;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		// border case where angles are undefined
		if (x == 0 && y == 0 && z == 0)
			return SphericCoordinate.createCoordinate(0, 0, 0);

		System.out.println("x: " + x + ", y: " + y + ", z: " + z);

		double radius = Math.sqrt(x*x + y*y + z*z);
		double phi = Math.acos(z / radius);
		double theta = Math.atan2(y, x);
		System.out.println("phi: " + phi + ", theta: " + theta + ", radius: " + radius);

		return SphericCoordinate.createCoordinate(phi, theta, radius);
	}

	@Override
	public double getCentralAngle(Coordinate coordinate) {
		return this.asSphericCoordinate().getCentralAngle(coordinate);
	}

	@Override
	public boolean isEqual(Coordinate coordinate) {
		CartesianCoordinate coord = coordinate.asCartesianCoordinate();
		if (Math.abs(coord.x - x) > EPSILON)
			return false;
		if (Math.abs(coord.y - y) > EPSILON)
			return false;
		if (Math.abs(coord.z - z) > EPSILON)
			return false;

		return true;
	}

	protected void assertClassInvariants() {
		assertClassInvariants(x, y, z);
	}

	private void assertClassInvariants(double x, double y, double z) {
		assert Double.isFinite(x);
		assert Double.isFinite(y);
		assert Double.isFinite(z);
	}
}
