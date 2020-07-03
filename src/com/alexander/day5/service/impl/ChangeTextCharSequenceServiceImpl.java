package com.alexander.day5.service.impl;

import com.alexander.day5.exception.ProgramException;
import com.alexander.day5.service.ChangeTextService;
import com.alexander.day5.service.TextService;

import java.util.List;

public class ChangeTextCharSequenceServiceImpl extends TextService
        implements ChangeTextService {
    @Override
    public String replaceIndexLetterInWord(int index, char symbol, String text)
            throws ProgramException {
        if (text == null || index < 0) {
            throw new ProgramException("Invalid input");
        }
        char[] textChars = text.toCharArray();
        List<String> words = splitWords(textChars);
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (word.length() > index) {
                char[] wordChars = word.toCharArray();
                wordChars[index] = symbol;
                words.set(i, new String(wordChars));
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
        char[] textChars = text.toCharArray();
        for (int i = 1; i < textChars.length; i++) {
            if (textChars[i] == mistake && textChars[i - 1] == previous) {
                textChars[i] = correct;
            }
        }
        return new String(textChars);
    }

    @Override
    public String replaceWordsCertainLength(String text, int length, String replacement)
            throws ProgramException {
        if (text == null || replacement == null) {
            throw new ProgramException("Invalid input");
        }
        char[] textChars = text.toCharArray();
        List<String> words = splitWords(textChars);
        StringBuilder resultText = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            char[] word = words.get(i).toCharArray();
            if (word.length == length) {
                resultText.append(replacement).append(" ");
            } else {
                resultText.append(word).append(" ");
            }
        }
        return resultText.toString().strip();
    }
}
