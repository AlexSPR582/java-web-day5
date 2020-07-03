package com.alexander.day5.service;

import com.alexander.day5.exception.ProgramException;

public interface DeleteTextService {
    String deleteNotLetter(String text) throws ProgramException;
    String deleteWordsBeginWithConstantCertainLength(String text, int length) throws ProgramException;
}
