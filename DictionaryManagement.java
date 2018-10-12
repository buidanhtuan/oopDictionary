package com.company;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class DictionaryManagement extends Dictionary

{
    public Dictionary dictionary = new Dictionary();
    private Scanner scan = new Scanner(System.in);
    public void insertFromCommandline(int n){
        for(int i=0; i<n ; i++){
            Word temp = new Word();
            String s;
            String[] a=new String[2];
            s=scan.nextLine();
            a=s.split("\t",2);
            temp.setWord_taget(a[0]);
            temp.setWord_explain(a[1]);
            dictionary.word.add(temp);
        }
    }
    public void insertFromFile() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("dictionaries.txt"));
            String line = null;
            while ((line = in.readLine()) != null) {
                Word temp = new Word();
                String[] words = line.split("\t");
                temp.setWord_taget(words[0]);
                temp.setWord_explain(words[1]);
                dictionary.word.add(temp);
            }
            in.close();
        } catch (IOException ex) {
            System.out.println("Unable to open file");
        }
    }
    public void dictionaryLookup(String s) {
        int i=0;
        for (; i < dictionary.word.size(); i++) {
            if (dictionary.word.get(i).getWord_taget().equals(s)) {
                break;
            }
        }
        System.out.println( dictionary.word.get(i).getWord_explain());
    }
    public void dictionaryFix(){
        System.out.println("1   thay doi nghia");
        System.out.println("2   thay doi tu");
        System.out.println("3   xoa tu");
        Scanner scan = new Scanner(System.in);
        int i=0;

        System.out.println("Nhap tu ban muon sua hoac xoa");
        String s=scan.nextLine();
        int a=scan.nextInt();
        if(a==1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("moi nhap nghia moi");
            String string =sc.nextLine();
            for (; i < dictionary.word.size(); i++) {
                if (dictionary.word.get(i).getWord_taget().equals(s)) {
                    dictionary.word.get(i).setWord_explain(string);
                }
            }
        }
        if(a==2) {
            Scanner sc = new Scanner(System.in);
            System.out.println("moi nhap tu moi");
            String string =sc.nextLine();
            for (; i < dictionary.word.size(); i++) {
                if (dictionary.word.get(i).getWord_taget().equals(s)) {
                    dictionary.word.get(i).setWord_taget(string);
                }
            }
        }
        if(a==3) {
            Scanner sc = new Scanner(System.in);
            for (; i < dictionary.word.size(); i++) {
                if (dictionary.word.get(i).getWord_taget().equals(s)) {
                    dictionary.word.subList(i,i+1).clear();
                }
            }
        }
    }
    public void  dictionarySearcher(String s){
        for(int i=0;i<dictionary.word.size();i++){
            if(dictionary.word.get(i).getWord_taget().startsWith(s)){
                System.out.println(dictionary.word.get(i).getWord_taget());
            }
        }
    }
    public void dictionaryExportToFile(){
        String FILENAME ="out.txt";
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(fw);
            for(int i=0;i<dictionary.word.size();i++)
            {
                bw.newLine();
                bw.write(dictionary.word.get(i).getWord_taget());
                bw.write("\t");
                bw.write(dictionary.word.get(i).getWord_explain());
            }
            System.out.println("Ghi them noi dung file xong!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }
}
