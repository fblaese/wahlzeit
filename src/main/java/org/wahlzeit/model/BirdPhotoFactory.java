package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

public class BirdPhotoFactory extends PhotoFactory {

	private static final Logger log = Logger.getLogger(BirdPhotoFactory.class.getName());
	private static BirdPhotoFactory instance = null;

	public BirdPhotoFactory() {
		super();
	}

	@Override
	public BirdPhoto createPhoto() {
		return new BirdPhoto();
	}

	@Override
	public BirdPhoto createPhoto(PhotoId id) {
		return new BirdPhoto(id);
	}

}
