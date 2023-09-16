package com.mycom.word;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;               //단어목록
    Scanner s;                          //키보드 입력받는거
    final String fname = "Dictionary.txt";

    WordCRUD(Scanner key){
        list = new ArrayList<>();
        this.s = key;
    }


    @Override
    public Object add() {                                       //4. 단어 추가
        System.out.println(" 4. 단어 추가");
        System.out.print("--> 난이도 입력 (1,2,3) & 추가 할 단어 입력 : ");
        int level = s.nextInt();
        String word = s.nextLine();

        System.out.print("단어 뜻 입력 : ");
        String meaning = s.nextLine();

        return new Word(0, level, word, meaning);
    }

    public void addItem(){
        Word one = (Word)add();
        list.add(one);
        System.out.println("새로운 단어가 단어장에 추가되었습니다.\n\n");

    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }

    public void listAll() {                                       //1. 모든 단어 보기
        System.out.println(" 1. 모든 단어 보기 (레벨 / 영단어 / 뜻)");
        System.out.println("---------------------");
        for(int i = 0; i < list.size(); i++){
            System.out.print(i+1 + "번째 단어: " + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("---------------------\n\n");
    }

    public ArrayList<Integer> listAll(String keyword) {            //1. 모든 단어 보기

        ArrayList<Integer> idlist = new ArrayList<>();

        int j = 0;

        System.out.println(" 1. 모든 단어 보기 (레벨 / 영단어 / 뜻)");
        System.out.println("---------------------");
        for(int i = 0; i < list.size(); i++){
            String word = list.get(i).getWord();
            if(!word.contains(keyword)) continue;
            System.out.print(j+1 + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("---------------------\n\n");
        return idlist;
    }

    public void updateItem() {                                      //5. 단어 수정
        System.out.print("--> 수정할 단어 검색: ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("--> 수정할 번호 선택 : ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("--> 뜻 입력 : ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id-1));
        word.setMeaning(meaning);
        System.out.println("단어가 수정되었습니다. ");
    }

    public void deliteItem() {                                      // 6.단어 삭제
        System.out.print("--> 삭제할 단어 검색: ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("--> 삭제할 번호 선택 : ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("--> 정말로 삭제하시겠습니까? (Y/N) ");
        String ans = s.next();
        if(ans.equalsIgnoreCase("y")){                            //대문자Y
            list.remove((int)idlist.get(id-1));
            System.out.println("단어가 삭제되었습니다. ");
            }
        }

    public void loadFile(){                                         // 저장된 단어장 파일 불러오기
        try {
            BufferedReader br = new BufferedReader(new FileReader("Dictionary.txt"));
            String line;

            int count = 0;

            while(true){
                line = br.readLine();
                if(line == null) break;
                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                list.add(new Word(0, level, word, meaning));
                count++;
            }
            br.close();
            System.out.println("-->" + count + "개 로딩 완료!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile() {                                        //7.단어 저장
        try {
            PrintWriter pr = new PrintWriter(new FileWriter("Dictionary.txt"));
            for(Word one : list){
                pr.write(one.toFileString() + "\n");
            }

            pr.close();
            System.out.println("--> 데이터 저장 완료!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
