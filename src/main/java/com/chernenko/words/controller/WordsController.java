package com.chernenko.words.controller;

import com.chernenko.words.domain.Words;
import com.chernenko.words.service.WordsService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("words")
public class WordsController {

    public Words wordsList = new Words();;

    @GetMapping
    public Words list() {
        return wordsList;
    }

    @PostMapping
    public Words check(@RequestBody Words words) {
        WordsService wordsService = new WordsService();
        return wordsList = wordsService.check(words.getWords());
    }
}
