package org.wahlzeit.model;

public class Location {
	protected Coordinate coordinate;
	protected String name;

	Location(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	Location(Coordinate coordinate, String name) {
		this(coordinate);
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
		if (!(loc.name.equals(this.name)))
			return false;

		return true;
	}
}
