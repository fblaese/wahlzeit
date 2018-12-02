package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {
	private double phi, theta, radius;

	SphericCoordinate(double phi, double theta, double radius) {
		assertClassInvariants(phi, theta, radius);

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
