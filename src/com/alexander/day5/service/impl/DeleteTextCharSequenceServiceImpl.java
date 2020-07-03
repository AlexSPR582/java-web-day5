package com.alexander.day5.service.impl;

import com.alexander.day5.exception.ProgramException;
import com.alexander.day5.service.DeleteTextService;
import com.alexander.day5.service.TextService;

import java.util.List;

public class DeleteTextCharSequenceServiceImpl extends TextService
        implements DeleteTextService {
    @Override
    public String deleteNotLetter(String text) throws ProgramException {
        if (text == null) {
            throw new ProgramException("Invalid input");
        }
        char[] textSequence = text.toCharArray();
        for (int i = 0; i < textSequence.length; i++) {
            if (!isLetter(textSequence[i])) {
                textSequence[i] = ' ';
            }
        }
        return new String(textSequence);
    }

    @Override
    public String deleteWordsBeginWithConstantCertainLength(String text, int length)
            throws ProgramException {
        if (text == null || length < 0) {
            throw new ProgramException("Invalid input");
        }
        char[] textChars = text.toCharArray();
        List<String> words = splitWords(textChars);
        StringBuilder resultText = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            char[] word = words.get(i).toCharArray();
            if (!consonant.contains(String.valueOf(word[0])) || word.length != length) {
                resultText.append(word).append(" ");
            }
        }
        return resultText.toString().strip();
    }
}
