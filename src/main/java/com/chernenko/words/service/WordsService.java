package com.chernenko.words.service;

import com.chernenko.words.domain.Words;

import java.util.ArrayList;
import java.util.List;

public class WordsService {

    public Words check(List<String> wordsToCheck) {

        Words words = new Words();

        if (wordsToCheck.size() == 0 || wordsToCheck.get(0).length() == 0) {
            words.setWords(new ArrayList<>());
            return words;
        }

        List<String> validWords = new ArrayList<>();

        for (int i = 0; i < wordsToCheck.size(); i++) {

            String currentWord = wordsToCheck.get(i);
            String endLetter = currentWord.substring(currentWord.length() - 1);

            if (i  < wordsToCheck.size() - 1) {
                String nextWord = wordsToCheck.get(i + 1);

                if (nextWord.startsWith(endLetter)) {
                    validWords.add(currentWord);
                } else {
                    validWords.add(currentWord);
                    break;
                }

            } else {
                validWords.add(currentWord);
            }
        }
        words.setWords(validWords);

        return words;
    }
}
