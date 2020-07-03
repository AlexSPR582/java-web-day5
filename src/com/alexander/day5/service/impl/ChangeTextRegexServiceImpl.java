package com.alexander.day5.service.impl;

import com.alexander.day5.exception.ProgramException;
import com.alexander.day5.service.ChangeTextService;
import com.alexander.day5.service.TextService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeTextRegexServiceImpl extends TextService
        implements ChangeTextService {
    @Override
    public String replaceIndexLetterInWord(int index, char symbol, String text)
            throws ProgramException {
        if (text == null || index < 0) {
            throw new ProgramException("Invalid input");
        }
        Pattern pattern = Pattern.compile(wordPattern);
        Matcher matcher = pattern.matcher(text);
        StringBuilder resultText = new StringBuilder();
        while (matcher.find()) {
            String word = matcher.group();
            if (index < word.length()) {
                StringBuilder wordBuilder = new StringBuilder(word);
                wordBuilder.deleteCharAt(index);
                wordBuilder.insert(index, symbol);
                resultText.append(wordBuilder.toString()).append(" ");
            } else {
                resultText.append(word).append(" ");
            }
        }
        return resultText.toString().trim();
    }

    @Override
    public String fixMistake(String text, char previous, char mistake, char correct)
            throws ProgramException {
        if (text == null) {
            throw new ProgramException("Invalid input");
        }
        String wrongSequence = previous + String.valueOf(mistake);
        String correctSequence = previous + String.valueOf(correct);
        Pattern pattern = Pattern.compile(wrongSequence);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            text = matcher.replaceAll(correctSequence);
        }
        return text;
    }

    @Override
    public String replaceWordsCertainLength(String text, int length, String replacement)
            throws ProgramException {
        if (text == null || replacement == null) {
            throw new ProgramException("Invalid input");
        }
        Pattern pattern = Pattern.compile(wordPattern);
        Matcher matcher = pattern.matcher(text);
        StringBuilder resultText = new StringBuilder();
        while (matcher.find()) {
            String word = matcher.group();
            if (word.length() == length) {
                resultText.append(replacement).append(" ");
            } else {
                resultText.append(word).append(" ");
            }
        }
        return resultText.toString().trim();
    }
}
