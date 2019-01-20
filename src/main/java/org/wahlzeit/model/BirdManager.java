package org.wahlzeit.model;

import java.util.HashSet;
import java.util.HashMap;

import java.util.Iterator;

import org.wahlzeit.services.ObjectManager;

public class BirdManager extends ObjectManager {

	private static BirdManager instance = new BirdManager();
	public static BirdManager getInstance() {
		return instance;
	}

	protected HashSet<Bird> birds = new HashSet<>();
	protected HashMap<String, BirdType> birdTypes = new HashMap<>();

	private BirdManager() {}

	public BirdType getTypeByName(String name) {
		return birdTypes.get(name);
	}

	public void addType(BirdType t) {
		if(!birdTypes.containsKey(t.getName())) {
			birdTypes.put(t.getName(), t);
		}
	}

	public void addInstance(Bird b) {
		birds.add(b);
	}

	public Iterator<Bird> getInstanceIterator() {
		return birds.iterator();
	}
}
