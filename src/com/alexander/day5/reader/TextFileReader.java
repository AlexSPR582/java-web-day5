package com.alexander.day5.reader;

import com.alexander.day5.exception.ProgramException;

import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class TextFileReader {
    private static final String defaultPath = "res/input.txt";

    public String readText(String filename) throws ProgramException {
        if (filename == null) {
            filename = defaultPath;
        }
        File file = new File(filename);
        if (!file.exists()) {
            filename = defaultPath;
        }
        StringBuilder textBuilder = new StringBuilder();
        try (FileReader fr = new FileReader(filename);
             Scanner sc = new Scanner(fr)) {
            while (sc.hasNextLine()) {
                textBuilder.append(sc.nextLine());
            }
        } catch (IOException e) {
            throw new ProgramException("exception occur");
        }
        return textBuilder.toString();
    }
}
