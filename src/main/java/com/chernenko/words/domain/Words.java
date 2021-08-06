package com.chernenko.words.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Words {

    private List<String> words;

    public Words() {
       this.words = new ArrayList<>();
    }
}
