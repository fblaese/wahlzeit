package org.wahlzeit.model;

public class BirdType {

	protected String name;
	protected String scientificName;
	protected int size;   // typical, centimeters
	protected int weight; // typical, grams

	protected BirdType superType = null;

	public BirdType(String name, int size, int weight) {
		if (name == null) {
			throw new IllegalArgumentException("null is not a valid name.");
		}

		if (size < 0 || weight < 0) {
			throw new IllegalArgumentException("invalid size or weight.");
		}

		this.name = name;
		this.size = size;
		this.weight = weight;
	}

	public BirdType(String name, String scientificName, int size, int weight) {
		new BirdType(name, size, weight);

		if (scientificName == null) {
			throw new IllegalArgumentException("null is not a valid scientific name.");
		}

		this.scientificName = scientificName;
	}

	public boolean isSubtype(BirdType t) {
		BirdType tmp = this;
		while (tmp != null) {
			if (tmp == t)
				return true;

			tmp = tmp.getSuperType();
		}

		return false;
	}

	public BirdType getSuperType() {
		return superType;
	}

	public void setSuperType(BirdType superType) {
		this.superType = superType;
	}

	public String getName() {
		return name;
	}

	public String getScientificName() {
		return scientificName;
	}

	public int getSize() {
		return size;
	}

	public int getWeight() {
		return weight;
	}

}
