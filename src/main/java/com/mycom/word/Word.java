package com.mycom.word;

public class Word {

    private int id;          //단어 번호
    private int level;       // 단어 레벨
    private String word;     // 영단어
    private String meaning;  // 단어 뜻

    @Override
    public String toString() {

        String slevel = "";
        for (int i = 0; i < level; i++) slevel += "*";
        String str = String.format("%-3s", slevel)
                + String.format("%10s", word)
                + "  "
                + meaning;
        return str;
    }

    public String toFileString() {
        return this.level + "|" + this.word + "|" + this.meaning;
    }





    Word(){}
    Word(int id, int level, String word, String meaning){
        this.id = id;
        this.level = level;
        this. word = word;
        this. meaning = meaning;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
