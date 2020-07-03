package com.alexander.day5.service.impl;

import com.alexander.day5.exception.ProgramException;
import com.alexander.day5.service.DeleteTextService;
import com.alexander.day5.service.TextService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteTextRegexServiceImpl extends TextService
        implements DeleteTextService {
    @Override
    public String deleteNotLetter(String text) throws ProgramException {
        if (text == null) {
            throw new ProgramException("Invalid input");
        }
        Pattern pattern = Pattern.compile(TextService.notLetter);
        Matcher matcher = pattern.matcher(text);
        String resultText = null;
        if (matcher.find()) {
            resultText = matcher.replaceAll(" ");
        }
        return resultText;
    }

    @Override
    public String deleteWordsBeginWithConstantCertainLength(String text, int length)
            throws ProgramException {
        if (text == null || length < 0) {
            throw new ProgramException("Invalid input");
        }
        StringBuilder resultText = new StringBuilder();
        Pattern pattern = Pattern.compile(wordPattern);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (word.length() != length) {
                resultText.append(word).append(" ");
            } else if (!isStartWithConsonant(word)) {
                resultText.append(word).append(" ");
            }
        }
        return resultText.toString().strip();
    }
}
