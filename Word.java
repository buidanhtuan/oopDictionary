/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

/**
 *
 * @author User
 */
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
    public void printWord() {
        System.out.printf("%-20s%-20s\n", word_taget, word_explain);
    }
    public int compareTo(String str) {
        return this.word_taget.compareTo(str);
    }
}
