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
import java.util.ArrayList;

public class Dictionary {
    public ArrayList<Word> word = new ArrayList<>();
    public void setWord(ArrayList<Word> newWord){
        for(int i =0 ;i < newWord.size();i++){
            this.word.add(newWord.get(i));
        }
    }

    public ArrayList<Word> getWord(){
        return word;
    }

    void setWord(Word a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

