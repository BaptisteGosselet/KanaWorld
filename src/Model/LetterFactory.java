package Model;

public abstract class LetterFactory {
    
    private static Letter[] letters = {
        new Letter("a", "あ", "ア"),
        new Letter("i", "い", "イ"),
        new Letter("u", "う", "ウ"),
        new Letter("e", "え", "エ"),
        new Letter("o", "お", "オ")
    };

    private static Letter[] variants = {
        //TODO
    };

    public static Letter[] getAllLetters(){
        return letters;
    }



}
