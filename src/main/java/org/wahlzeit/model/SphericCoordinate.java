package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {
	private double phi, theta, radius;

	SphericCoordinate(double phi, double theta, double radius) {
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
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
}
