package org.wahlzeit.utils;

import java.lang.annotation.Repeatable;

@Repeatable(Pattern.class)
public @interface PatternInstance {
	String patternName();
	String[] participants();
}
