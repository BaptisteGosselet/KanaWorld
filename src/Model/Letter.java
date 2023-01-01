package Model;

public class Letter {
    private String alpha;
    private String hiragana;
    private String katakana;

    public Letter(String a, String h, String k){
        this.alpha = a;
        this.hiragana = h;
        this.katakana = k;
    }

    public String getAlpha(){
        return this.alpha;
    }

    public String getHiragana(){
        return this.hiragana;
    }

    public String getKatakana(){
        return this.katakana;
    }

}
