package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
	patternName = "Template",
	participants = {
		"AbstractClass"
	}
)
public abstract class AbstractCoordinate implements Coordinate {
	protected static final double EPSILON = 0.00001;

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Coordinate))
			return false;

		Coordinate coordinate = (Coordinate) o;
		return isEqual(coordinate);
	}
}
