package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {
	private final double phi, theta, radius;

	/**
	 * phi, theta and radius must be finite double values.
	 * phi must be inside [0;2*pi[
	 * theta must be inside [0;pi]
	 * radius must be positive or zero.
	 */
	SphericCoordinate(double phi, double theta, double radius) {
		if (!Double.isFinite(phi) || !Double.isFinite(theta) || !Double.isFinite(radius)) {
			throw new IllegalArgumentException("Parameters have to be finite");
		}
		if (!(0 <= phi && phi < 2*Math.PI && 0 <= theta && theta <= Math.PI && radius >= 0)) {
			throw new IllegalArgumentException("Invalid parameters");
		}

		this.phi = phi;
		this.theta = theta;
		this.radius = radius;

		assertClassInvariants();
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double x = radius * Math.sin(phi) * Math.cos(theta);
		double y = radius * Math.sin(phi) * Math.sin(theta);
		double z = radius * Math.cos(phi);

		return new CartesianCoordinate(x, y, z);
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

		assert 0 <= phi && phi < 2 * Math.PI;
		assert 0 <= theta && theta <= Math.PI;
		assert 0 <= radius;
	}
}
