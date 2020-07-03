package com.alexander.day5.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextService {
    protected static final String wordPattern = "([\\p{Alpha}]+[\\-']?[\\p{Alpha}]+)|([\\p{Alpha}]+)";
    protected static final String beginWithConsonant = "[BCDFGHJKLMNPQRSTVWXZbcdfghjklmnpqrstvwxz][\\p{Alpha}]+";
    protected static final String consonant = "[BCDFGHJKLMNPQRSTVWXZbcdfghjklmnpqrstvwxz]";
    protected static final String notLetter = "[^\\p{Alpha}]";

    protected List<String> splitWords(char[] text) {
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < text.length; i++) {
            if (i == text.length - 1 && word.length() > 0) {
                if (isWordPart(text[i], i, text)) {
                    word.append(text[i]);
                }
                words.add(word.toString());
            } else if (isWordPart(text[i], i, text)) {
                word.append(text[i]);
            } else if (word.length() > 0 ) {
                words.add(word.toString());
                word = new StringBuilder();
            }
        }
        return words;
    }

    private boolean isWordPart(char symbol, int position, char[] text) {
        boolean isWordPart = false;
        if (isLetter(symbol)) {
            isWordPart = true;
        } else if ((symbol == '\'' || symbol == '-') &&
                position > 0 && position < text.length - 1) {
            if (isLetter(text[position - 1]) &&
                    isLetter(text[position + 1])) {
                isWordPart = true;
            }
        }
        return isWordPart;
    }

    protected boolean isLetter(char symbol) {
        return (symbol >= 'A' && symbol <= 'Z') ||
                (symbol >= 'a' && symbol <= 'z');
    }

    protected boolean isStartWithConsonant(String word) {
        Pattern pattern = Pattern.compile(beginWithConsonant);
        Matcher matcher = pattern.matcher(word);
        boolean beginWithConsonant = false;
        if (matcher.find()) {
            beginWithConsonant = true;
        }
        return beginWithConsonant;
    }
}
