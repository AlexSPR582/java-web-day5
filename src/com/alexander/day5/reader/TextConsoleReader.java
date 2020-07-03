package com.alexander.day5.reader;

import java.util.Scanner;

public class TextConsoleReader {
    public String readText() {
        StringBuilder textBuilder = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            textBuilder.append(line);
        }
        return textBuilder.toString();
    }
}
