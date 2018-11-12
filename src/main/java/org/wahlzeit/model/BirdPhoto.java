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
		super();
		this.bird = bird;
	}

	public Bird getBird() {
		return bird;
	}

	public void setBird(Bird bird) {
		this.bird = bird;
	}
}
