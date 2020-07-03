package com.alexander.day5.service;

import com.alexander.day5.exception.ProgramException;

public interface ChangeTextService {
    String replaceIndexLetterInWord(int index, char symbol, String text) throws ProgramException;
    String fixMistake(String text, char previous, char mistake, char correct) throws ProgramException;
    String replaceWordsCertainLength(String text, int length, String replacement) throws ProgramException;
}
