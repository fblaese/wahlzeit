package org.wahlzeit.model;

public class Bird {

	protected String name;
	protected int size;
	protected int weight;

	protected BirdType type;

	public Bird(BirdType type) {
		if (type == null) {
			throw new IllegalArgumentException("null is not a valid type.");
		}

		this.type = type;
	}

	public Bird(BirdType type, String name, int size, int weight) {
		new Bird(type);

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

	public BirdType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
