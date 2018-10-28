package org.wahlzeit.model;

public class Coordinate {
	protected double latitude, longitude;

	Coordinate(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double distanceTo(Coordinate locB) {
		Coordinate locA = this;

		double R = 6371e3;
		double phi1 = Math.toRadians(locA.latitude);
		double phi2 = Math.toRadians(locB.latitude);
		double deltaPhi = Math.toRadians(locB.latitude - locA.latitude);
		double deltaLambda = Math.toRadians(locB.longitude - locA.longitude);

		// Haversine formula
		double a = Math.pow(Math.sin(deltaPhi/2),2) +
			Math.cos(phi1) * Math.cos(phi2) * Math.pow(Math.sin(deltaLambda/2),2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		return R * c;
	}

	public boolean equals(Object o) {
		if (!(o instanceof Coordinate))
			return false;

		Coordinate coord = (Coordinate) o;
		if (!(coord.latitude == this.latitude))
			return false;
		if (!(coord.longitude == this.longitude))
			return false;

		return true;
	}
}
