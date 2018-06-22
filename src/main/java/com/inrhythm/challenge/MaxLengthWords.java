package com.inrhythm.challenge;

import java.util.List;

public class MaxLengthWords {
	private final int length;
	private final List<String> words;

	public MaxLengthWords(final int length, final List<String> words) {
		this.length = length;
		this.words = words;
	}

	public List<String> getWords() {
		return words;
	}

	public int getLength() {
		return this.length;
	}

	@Override
	public String toString() {
		return "MaxLengthWords{" + "length=" + length + ", words=" + words + '}';
	}
}
