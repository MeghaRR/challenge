package com.inrhythm.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InrhythmChallenge {
	// assuming input string doesnt have punctuation to deal with.
    // for e.g. didn't has a non alpha char but its part of the word.
    public static MaxLengthWords getMaxLengthWords(final String string)
    {
        if (string == null || string.isEmpty()) { 
        	return new MaxLengthWords(0,Collections.<String>emptyList()); 
        }

        List<String> maxLengthWords = new ArrayList<>();

        int startIndex = -1, endIndex = -1, maxLength = 0;
        for (int i = 0; i <= string.length(); i++)
        {
        	// terminate and create a word if whitespace is reached or end of statement
        	if (i == string.length() || isSeparatorChar(string.charAt(i)))
        	{
                // this first part of the condition ensures we enter the if block only if length is at least 1
                final int len = endIndex - startIndex + 1;
                if (isValidIndices(startIndex, endIndex) && len >= maxLength)
                {
                    if (len > maxLength)
                    {
                        maxLengthWords = new ArrayList<>();
                        maxLength = len;
                    }

                    // create substring only when necessary
                    final String substr = string.substring(startIndex, endIndex + 1);

                    // add to List
                    maxLengthWords.add(substr);
                }

                //reset indexes on every whitespace
                startIndex = -1;
                endIndex = -1;
            }
            
            else
            {
                // set startIndex only if its the first char, end increments everytime
                startIndex = startIndex < 0 ? i : startIndex;
                endIndex = i;
            }
        }

        return new MaxLengthWords(maxLength, maxLengthWords);
    }

    private static boolean isSeparatorChar(final char ch)
    {
        return Character.isWhitespace(ch) || ch == '.' || ch == '!' || ch == '?' || ch == ',' || ch == ';';
    }

    private static boolean isValidIndices(final int startIndex, final int endIndex)
    {
        return startIndex > -1 && endIndex > -1 && endIndex >= startIndex;
    }
}


