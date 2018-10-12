package com.company;

import java.util.Scanner;

public class DictionaryCommandline {
    public DictionaryManagement dictionaryManagement = new DictionaryManagement();
    public void showAllwords(){
        int n = dictionaryManagement.dictionary.word.size();
        dictionaryManagement.sortList();
        for(int i=0;i<n;i++){
            System.out.printf("%-4s%c%-20s%c%-20s\n",(i+1),'|',dictionaryManagement.dictionary.word.get(i).getWord_taget() ,'|', dictionaryManagement.dictionary.word.get(i).getWord_explain());
        }
    }
    public void dictionaryBasic(int n){
        DictionaryCommandline test = new DictionaryCommandline();
        test.dictionaryManagement.insertFromCommandline();
        test.dictionaryManagement.insertFromFile();
        test.showAllwords();
    }
    public void  dictionaryAdvanced(String s){
        DictionaryCommandline advan = new DictionaryCommandline();
        advan.dictionaryManagement.insertFromFile();
        advan.showAllwords();
        advan.dictionaryManagement.dictionaryLookup();

    }
}
