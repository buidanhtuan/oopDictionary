package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Word {

    private String word_taget;
    private String word_explain;
    public Word () {
        word_taget="";
        word_explain="";
    }
    public Word ( String word_taget , String word_explain ) {

        this.word_taget = word_taget;
        this.word_explain = word_explain;
    }
    public void setWord_taget(String word_taget) {
        this.word_taget = word_taget;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String getWord_taget() {
        return word_taget;
    }

    public String getWord_explain() {
        return word_explain;
    }
    public static void main(String[] args) {
        int n;
        Scanner scan =new Scanner(System.in);
        n=scan.nextInt();
        DictionaryCommandline test = new DictionaryCommandline();
        test.dictionaryManagement.insertFromCommandline(n);
        test.dictionaryManagement.insertFromFile();
        String s = scan.nextLine();
        test.dictionaryManagement.dictionaryLookup(s);
        test.dictionaryManagement.dictionarySearcher("H");
        test.dictionaryManagement.dictionaryFix();
        test.showAllwords();
        test.dictionaryManagement.dictionaryExportToFile();
    }
}
