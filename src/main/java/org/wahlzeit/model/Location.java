package org.wahlzeit.model;

public class Location {
	protected Coordinate coordinate;
	protected String name;

	Location(Coordinate coordinate) {
		if (coordinate == null) {
			throw new IllegalArgumentException("null is not a valid location coordinate");
		}

		this.coordinate = coordinate;
	}

	Location(Coordinate coordinate, String name) {
		this(coordinate);

		if (name == null) {
			throw new IllegalArgumentException("null is not a valid location name");
		}

		this.name = name;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object o) {
		if (!(o instanceof Location))
			return false;

		Location loc = (Location) o;
		if (!(loc.coordinate.equals(this.coordinate)))
			return false;
		if ((loc.name != this.name) && !(loc.name.equals(this.name)))
			return false;

		return true;
	}
}
