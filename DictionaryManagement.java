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
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DictionaryManagement

{
    public Dictionary dictionary = new Dictionary();
    public void insertFromCommandline(){
        System.out.println("Nhap so tu ban muon them");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        for(int i=0; i<n ; i++){
            Word temp = new Word();
            String s;
            String[] a=new String[2];
            System.out.println("Nhap tu va nghia cua tu thu "+(i+1) +" cach nhau boi dau tab");
            s=scan.nextLine();
            a=s.split("\t",2);
            temp.setWord_taget(a[0]);
            temp.setWord_explain(a[1]);
            dictionary.word.add(temp);
        }
    }
    public void sortList(){
        Comparator<Word> check = new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.getWord_taget().compareTo(o2.getWord_taget());
            }
        };
        Collections.sort(dictionary.word,check);
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
    public String dictionaryLookup(String str) {
        
        int i= binarySreachWord(str);
        if(i==-1) {
            return "";
        }
        else
           return  dictionary.word.get(i).getWord_explain();
        

    }
    public void  dictionarySearcher(){
        System.out.println("Nhap chu cai can tim ");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        boolean f = false;
        for(int i = 0; i < dictionary.word.size(); i++){
            if(dictionary.word.get(i).getWord_taget().startsWith(s)){
                dictionary.word.get(i).printWord();
                f = true;
            }
        }
        if(f == false) System.out.println("Khong tim duoc ");
    }
    public int binarySreachWord(String str) {
        sortList();
        int n = dictionary.word.size();
        int lo = 0;
        int hi = n-1;
        int mid;
        while (lo <= hi){
            mid = lo +(hi-lo)/2;
            int tem = dictionary.word.get(mid).compareTo(str);
            if(tem < 0){
                lo = mid +1;
            }
            else  if(tem >0){
                hi = mid -1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    public void dictionaryFix(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap tu ban muon sua hoac xoa");
        String s=scan.nextLine();
        System.out.println("Nhap thao tac ban muon thuc hien");
        System.out.println("1   Thay doi nghia");
        System.out.println("2   Thay doi tu");
        System.out.println("3   Xoa tu");

        int index = binarySreachWord(s);
        int a=scan.nextInt();
        if(a==1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Moi nhap nghia moi");
            String string =sc.nextLine();
            dictionary.word.get(index).setWord_explain(string);
        }
        if(a==2) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Moi nhapp tu moi");
            String string =sc.nextLine();
            dictionary.word.get(index).setWord_taget(string);
        }
        if(a==3) {
            Scanner sc = new Scanner(System.in);
            dictionary.word.subList(index,index+1).clear();
        }
    }
// xuat ra file ma chong len nhau
    public void dictionaryExportToFile(String s){
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(s, false);
            bw = new BufferedWriter(fw);
            for(int i=0;i<dictionary.word.size();i++)
            {
                bw.write(dictionary.word.get(i).getWord_taget());
                bw.write("\t");
                bw.write(dictionary.word.get(i).getWord_explain());
                bw.newLine();
            }
            System.out.println("Ghi them noi dung file hoan thanh !");
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
