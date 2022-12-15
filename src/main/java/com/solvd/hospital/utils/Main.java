package com.solvd.hospital.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        String text = StringUtils.replaceAll(FileUtils.readFileToString(new File("src/main/resources/test.txt"), StandardCharsets.UTF_8), "\\p{Punct}", "");
        LinkedHashSet<String> uniqueWords = new LinkedHashSet<>(List.of(StringUtils.split(text)));
        List<String> listOfEachWord = new ArrayList<>();
        uniqueWords.forEach(x -> listOfEachWord.add(x + " " + StringUtils.countMatches(text, x)));
        FileUtils.writeLines(new File("src/main/resources/result.txt"), listOfEachWord);

    }
}
