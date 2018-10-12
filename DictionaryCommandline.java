package com.company;

public class DictionaryCommandline {
    public DictionaryManagement dictionaryManagement = new DictionaryManagement();
    public void showAllwords(){

        int n = dictionaryManagement.dictionary.word.size();
       for(int i=0;i<n;i++){
           System.out.printf("%-5d%-15s %-15s\n",i,dictionaryManagement.dictionary.word.get(i).getWord_taget() , dictionaryManagement.dictionary.word.get(i).getWord_explain());
        }
    }
    public void dictionaryBasic(int n){
        DictionaryCommandline test = new DictionaryCommandline();
        test.dictionaryManagement.insertFromCommandline(n);
        test.dictionaryManagement.insertFromFile();
        test.showAllwords();
    }
    public void  dictionaryAdvanced(String s){
        DictionaryCommandline advan = new DictionaryCommandline();
        advan.dictionaryManagement.insertFromFile();
        advan.showAllwords();
        advan.dictionaryManagement.dictionaryLookup(s);

    }


}
