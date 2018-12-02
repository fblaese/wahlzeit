package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {
	private double x, y, z;

	/**
	 * x, y and z must be finite double values.
	 */
	CartesianCoordinate(double x, double y, double z) {
		assertClassInvariants(x, y, z);

		this.x = x;
		this.y = y;
		this.z = z;

		assertClassInvariants();
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
		double phi = Math.atan(Math.sqrt(x*x + y*y) / z);
		double theta = Math.atan(y / x);
		double radius = Math.sqrt(x*x + y*y + z*z);

		while(phi < 0) {
			phi += Math.PI;
		}

		while(theta < 0) {
			theta += Math.PI;
		}

		return new SphericCoordinate(phi, theta, radius);
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
