package com.alexander.day5.service.impl;

import com.alexander.day5.exception.ProgramException;
import com.alexander.day5.service.ChangeTextService;
import com.alexander.day5.service.TextService;

public class ChangeTextStringServiceImpl extends TextService
        implements ChangeTextService {
    private static final String separator = "[^\\p{Alpha}]+";

    @Override
    public String replaceIndexLetterInWord(int index, char symbol, String text)
            throws ProgramException {
        if (text == null || index < 0) {
            throw new ProgramException("Invalid input");
        }
        String[] words = text.split(separator);
        for (int i = 0; i < words.length; i++) {
            if (index < words[i].length()) {
                StringBuilder wordBuilder = new StringBuilder(words[i]);
                wordBuilder.insert(index, symbol);
                wordBuilder.deleteCharAt(index + 1);
                words[i] = wordBuilder.toString();
            }
        }
        return String.join(" ", words);
    }

    @Override
    public String fixMistake(String text, char previous, char mistake, char correct)
            throws ProgramException {
        if (text == null) {
            throw new ProgramException("Invalid input");
        }
        String wrongSequence = previous + String.valueOf(mistake);
        String correctSequence = previous + String.valueOf(correct);
        String resultText = text.replaceAll(wrongSequence, correctSequence);
        return resultText;
    }

    @Override
    public String replaceWordsCertainLength(String text, int length, String replacement)
            throws ProgramException {
        if (text == null || replacement == null || length < 0) {
            throw new ProgramException("Invalid input");
        }
        String[] words = text.split(separator);
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == length) {
                words[i] = replacement;
            }
        }
        return String.join(" ", words);
    }
}
