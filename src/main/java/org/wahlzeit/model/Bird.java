package org.wahlzeit.model;

public class Bird {

	protected String name;
	protected String scientificName;
	protected int size;   // typical, centimeters
	protected int weight; // typical, grams

	public Bird(String name, int size, int weight) {
		this.name = name;
		this.size = size;
		this.weight = weight;
	}

	public Bird(String name, String scientificName, int size, int weight) {
		new Bird(name, size, weight);
		this.scientificName = scientificName;
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
