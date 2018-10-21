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
import java.util.Scanner;

/**
 *
 * @author User
 */
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
        advan.dictionaryManagement.dictionaryLookup(s);

    }
//    public static void main(String[] args) {
//        Scanner scan =new Scanner(System.in);
//        DictionaryCommandline test = new DictionaryCommandline();
//        test.dictionaryManagement.insertFromFile();
//        int option;
//        do {
//            System.out.println("---------------------------------");
//            System.out.println("*****Wellcome My Dictionary******");
//            System.out.println("----------Your Selection---------");
//            System.out.println("1. Tra tu");
//            System.out.println("2. Tim kiem chinh xac");
//            System.out.println("3. Them tu");
//            System.out.println("4. Sua hoac xoa tu");
//            System.out.println("5. In tat ca cac tu trong tu dien");
//            System.out.println("6. Luu ket qua vao file moi");
//            System.out.println("7. Ket thuc");
//            System.out.println("---------------------------------");
//            option = scan.nextInt();
//            switch (option) {
//                case 1:
//                    test.dictionaryManagement.dictionarySearcher();
//                    break;
//                case 2:
//                    test.dictionaryManagement.dictionaryLookup("hi");
//                    break;
//                case 3:
//                    test.dictionaryManagement.insertFromCommandline();
//                    break;
//                case 4:
//                    test.dictionaryManagement.dictionaryFix();
//                    break;
//                case 5:
//                    test.showAllwords();
//                    break;
//                case 6:
//                    test.dictionaryManagement.dictionaryExportToFile("dictionaries.txt");
//                    break;
//                case 7:
//                    System.out.println("Thank for watching");
//                    break;
//            }
//        }
//        while (option >= 1 && option <= 6);
//    }
}
