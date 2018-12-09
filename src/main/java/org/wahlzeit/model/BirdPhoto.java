package org.wahlzeit.model;

public class BirdPhoto extends Photo {

	protected Bird bird;

	public BirdPhoto() {
		super();
	}

	public BirdPhoto(PhotoId myId) {
		super(myId);
	}

	public BirdPhoto(Bird bird) {
		if (bird == null) {
			throw new IllegalArgumentException();
		}

		super();
		this.bird = bird;
	}

	public Bird getBird() {
		return bird;
	}

	public void setBird(Bird bird) {
		if (bird == null) {
			throw new IllegalArgumentException();
		}

		this.bird = bird;
	}
}
