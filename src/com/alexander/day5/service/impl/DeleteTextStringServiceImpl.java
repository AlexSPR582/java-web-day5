package com.alexander.day5.service.impl;

import com.alexander.day5.exception.ProgramException;
import com.alexander.day5.service.DeleteTextService;
import com.alexander.day5.service.TextService;

public class DeleteTextStringServiceImpl extends TextService
        implements DeleteTextService {
    private static final String notLetter = "[^\\p{Alpha}]";
    private static final String separator = "[^\\p{Alpha}]+";

    @Override
    public String deleteNotLetter(String text) throws ProgramException {
        if (text == null) {
            throw new ProgramException("Invalid input");
        }
        String resultText = text.replaceAll(notLetter, " ");
        return resultText;
    }

    @Override
    public String deleteWordsBeginWithConstantCertainLength(String text, int length)
            throws ProgramException {
        if (text == null || length < 0) {
            throw new ProgramException("Invalid input");
        }
        String[] words = text.split(separator);
        StringBuilder resultText = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() != length) {
                resultText.append(words[i]).append(" ");
            } else if (!isStartWithConsonant(words[i])) {
                resultText.append(words[i]).append(" ");
            }
        }
        return resultText.toString().strip();
    }
}
