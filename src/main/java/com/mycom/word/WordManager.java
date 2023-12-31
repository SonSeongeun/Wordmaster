package com.mycom.word;

import java.util.Scanner;

public class WordManager {
    Scanner s = new Scanner(System.in); //import 해야 에러 안 남
    WordCRUD wordCRUD;

    WordManager(){
        wordCRUD = new WordCRUD(s);
    }



    public int selectMenu(){                      //메뉴 선택 창
        System.out.print("***영단어 마스터***\n"
                + "*******************\n"
                + "1. 모든 단어 보기\n"
                + "2. 수준 별 단어 보기\n"
                + "3. 단어 검색\n"
                + "4. 단어 추가\n"
                + "5. 단어 수정\n"
                + "6. 단어 삭제\n"
                + "7. 파일 저장\n"
                + "0. 나가기\n"
                + "******************\n"
                + "--> 원하는 메뉴의 번호를 입력해주세요.");
        return s.nextInt();                      //원하는 메뉴 입력받기
    }

    public void start() {

        wordCRUD.loadFile();                     //파일 실행 전 저장된 데이터 읽어오기

        while(true) {
            int menu = selectMenu();
            System.out.println(menu);
            if(menu == 0) {                      //프로그램 종료
                System.out.print("영단어마스터 프로그램이 종료되었습니다.");
                break;
            }
            if(menu == 4) {                      //단어 추가
                wordCRUD.addItem();
            }
            else if(menu == 1){                  //모든 단어 보기
                wordCRUD.listAll();
            }
            else if(menu == 2){                  //수준 별 단어 보기
                wordCRUD.searchLevel();
            }
            else if(menu == 3){                  //단어 검색
                wordCRUD.searchWord();
            }
            else if(menu == 5){                  //단어 수정
                wordCRUD.updateItem();
            }
            else if(menu == 6){                  //단어 삭제
                wordCRUD.deliteItem();
            }
            else if(menu == 7) {                 //단어 저장
                wordCRUD.saveFile();
            }
        }
    }
}
