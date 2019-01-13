package org.wahlzeit.model;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.wahlzeit.utils.PatternInstance;

/**
 * class to store properties for SphericCoordinates for
 * comparison and hashing.
 */
@PatternInstance(
	patternName = "Flyweight",
	participants = {
		"Flyweight",
		"FlyweightFactory"
	}
)
@PatternInstance(
	patternName = "Template",
	participants = {
		"AbstractClass"
	}
)
class SphericProp {
	private final double phi, theta, radius;

	public SphericProp(double phi, double theta, double radius) {
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof SphericProp)) return false;

		SphericProp prop = (SphericProp) o;
		final double EPSILON = AbstractCoordinate.EPSILON;

		if (Math.abs(phi - prop.phi) > EPSILON)
			return false;
		if (Math.abs(theta - prop.theta) > EPSILON)
			return false;
		if (Math.abs(radius - prop.radius) > EPSILON)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(phi, theta, radius);
	}
}

public class SphericCoordinate extends AbstractCoordinate {
	private static ConcurrentHashMap<SphericProp, SphericCoordinate> instances = new ConcurrentHashMap<>();
	private final double phi, theta, radius;

	/**
	 * phi, theta and radius must be finite double values.
	 * phi must be inside [0;pi]
	 * theta must be inside (-pi;+pi]
	 * radius must be positive or zero.
	 */
	private SphericCoordinate(double phi, double theta, double radius) {
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;

		assertClassInvariants();
	}

	public static SphericCoordinate createCoordinate(double phi, double theta, double radius) {
		if (!Double.isFinite(phi) || !Double.isFinite(theta) || !Double.isFinite(radius)) {
			throw new IllegalArgumentException("Parameters have to be finite");
		}
		if (!(0 <= phi && phi <= Math.PI && -Math.PI < theta && theta <= Math.PI && radius >= 0)) {
			throw new IllegalArgumentException("Invalid parameters");
		}

		SphericProp prop = new SphericProp(phi, theta, radius);

		// return existing coordinate if possible
		if (instances.contains(prop)) {
			return instances.get(prop);
		}

		// create new otherwise
		SphericCoordinate created = new SphericCoordinate(phi, theta, radius);
		instances.put(prop, created);
		return created;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double x = radius * Math.sin(phi) * Math.cos(theta);
		double y = radius * Math.sin(phi) * Math.sin(theta);
		double z = radius * Math.cos(phi);

		return CartesianCoordinate.createCoordinate(x, y, z);
	}

	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		return asCartesianCoordinate().getCartesianDistance(coordinate);
	}

	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public double getCentralAngle(Coordinate coordinate) {
		SphericCoordinate coord = coordinate.asSphericCoordinate();

		//TODO: calculate!
		return 0.0;
	}

	@Override
	public boolean isEqual(Coordinate coordinate) {
		SphericCoordinate coord = coordinate.asSphericCoordinate();

		if (Math.abs(coord.phi - phi) > EPSILON)
			return false;
		if (Math.abs(coord.theta - theta) > EPSILON)
			return false;
		if (Math.abs(coord.radius - radius) > EPSILON)
			return false;

		return true;
	}

	protected void assertClassInvariants() {
		assertClassInvariants(phi, theta, radius);
	}

	private void assertClassInvariants(double phi, double theta, double radius) {
		assert Double.isFinite(phi);
		assert Double.isFinite(theta);
		assert Double.isFinite(radius);

		assert 0 <= phi && phi <= Math.PI;
		assert -Math.PI < theta && theta <= Math.PI;
		assert 0 <= radius;
	}
}
