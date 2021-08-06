package org.chernenko.words.service;

import com.chernenko.words.domain.Words;
import com.chernenko.words.service.WordsService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordsServiceTest {

    private final WordsService wordsService = new WordsService();

    @Test
    public void checkShouldReturnSameListIfAllWordsAreValid() {
        Words expected = new Words();
        List<String> testList = new ArrayList<String>(){{
            add("fish");
            add("horse");
            add("egg");
            add("goose");
            add("eagle");
        }};

        expected.setWords(testList);

        Words actual = wordsService.check(testList);

        assertEquals(expected, actual);
    }

    @Test
    public void checkShouldReturnValidListIfOneOfTheWordsAreNotValid() {
        Words expected = new Words();
        expected.setWords(new ArrayList<String>(){{
            add("fish");
            add("horse");
        }});

        List<String> testList = new ArrayList<String>(){{
            add("fish");
            add("horse");
            add("snake");
            add("goose");
            add("eagle");
        }};

        Words actual = wordsService.check(testList);

        assertEquals(expected, actual);
    }

    @Test
    public void checkShouldReturnValidListIfOneOfTheWordsIsEmpty() {
        Words expected = new Words();
        expected.setWords(new ArrayList<String>(){{
            add("fish");
            add("horse");
        }});

        List<String> testList = new ArrayList<String>(){{
            add("fish");
            add("horse");
            add("");
            add("goose");
            add("eagle");
        }};

        Words actual = wordsService.check(testList);

        assertEquals(expected, actual);
    }

    @Test
    public void checkShouldReturnEmptyListIfFirstWordisEmpty() {
        Words expected = new Words();
        expected.setWords(new ArrayList<>());

        List<String> testList = new ArrayList<String>(){{
            add("");
            add("horse");
            add("");
            add("goose");
            add("eagle");
        }};

        Words actual = wordsService.check(testList);

        assertEquals(expected, actual);
    }
}
