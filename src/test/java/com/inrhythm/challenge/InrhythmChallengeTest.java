package com.inrhythm.challenge;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import static org.hamcrest.Matchers.*;


public class InrhythmChallengeTest {
	
	@Test
	public void testBaseCase()
	{
	    MaxLengthWords t1 = InrhythmChallenge.getMaxLengthWords("The cow jumped over the moon.");
	    List<String> checkWords = t1.getWords();
	    assertEquals(6,t1.getLength());
	    assertThat(checkWords,contains("jumped"));
	}
	
	
	@Test
	public void testMultipleSameLength()
	{
	    MaxLengthWords t1 = InrhythmChallenge.getMaxLengthWords("   The cow didn't jumped over the moon ");
	    List<String> checkWords = t1.getWords();
	    assertEquals(6,t1.getLength());
	    assertThat(checkWords,contains("didn't","jumped"));
	}
	
	@Test
	public void testEmptyString()
	{
	    MaxLengthWords t1 = InrhythmChallenge.getMaxLengthWords("");
	    List<String> checkWords = t1.getWords();
	    assertEquals(0,t1.getLength());
	    assertThat(checkWords,empty());
	}
	
	@Test
	public void testSingleString()
	{
	    MaxLengthWords t1 = InrhythmChallenge.getMaxLengthWords("cow");
	    List<String> checkWords = t1.getWords();
	    assertEquals(3,t1.getLength());
	    assertThat(checkWords,contains("cow"));
	}
	
	@Test
	public void testSpecialCharString()
	{
	    MaxLengthWords t1 = InrhythmChallenge.getMaxLengthWords("  ?? ");
	    List<String> checkWords = t1.getWords();
	    assertEquals(0,t1.getLength());
	    assertThat(checkWords,empty());
	}
	
	@Test
	public void testMultiString()
	{
	    MaxLengthWords t1 = InrhythmChallenge.getMaxLengthWords("What is your name? do you stay around?");
	    List<String> checkWords = t1.getWords();
	    assertEquals(6,t1.getLength());
	    assertThat(checkWords,contains("around"));
	}
}
