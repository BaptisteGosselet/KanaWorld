package Model;

public abstract class LetterFactory {
    
    private static Letter[] letters = {
        new Letter("a", "あ", "ア"),
        new Letter("i", "い", "イ"),
        new Letter("u", "う", "ウ"),
        new Letter("e", "え", "エ"),
        new Letter("o", "お", "オ"),
        new Letter("ka", "か", "カ"),
        new Letter("ki", "き", "キ"),
        new Letter("ku", "く", "ク"),
        new Letter("ke", "け", "ケ"),
        new Letter("ko", "こ", "コ"),
        new Letter("sa", "さ", "サ"),
        new Letter("shi", "し", "シ"),
        new Letter("su", "す", "ス"),
        new Letter("se", "せ", "セ"),
        new Letter("so", "そ", "ソ"),
        new Letter("ta", "た", "タ"),
        new Letter("chi", "ち", "チ"),
        new Letter("tsu", "つ", "ツ"),
        new Letter("te", "て", "テ"),
        new Letter("to", "と", "ト"),
        new Letter("na", "な", "ナ"),
        new Letter("ni", "に", "ニ"),
        new Letter("nu", "ぬ", "ヌ"),
        new Letter("ne", "ね", "ネ"),
        new Letter("no", "の", "ノ"),
        new Letter("ha", "は", "ハ"),
        new Letter("hi", "ひ", "ヒ"),
        new Letter("fu", "ふ", "フ"),
        new Letter("he", "へ", "ヘ"),
        new Letter("ho", "ほ", "ホ"),
        new Letter("ma", "ま", "マ"),
        new Letter("mi", "み", "ミ"),
        new Letter("mu", "む", "ム"),
        new Letter("me", "め", "メ"),
        new Letter("mo", "も", "モ"),
        new Letter("ya", "や", "ヤ"),
        new Letter("yu", "ゆ", "ユ"),
        new Letter("yo", "よ", "ヨ"),
        new Letter("ra", "ら", "ラ"),
        new Letter("ri", "り", "リ"),
        new Letter("ru", "る", "ル"),
        new Letter("re", "れ", "レ"),
        new Letter("ro", "ろ", "ロ"),
        new Letter("wa", "わ", "ワ"),
        new Letter("wo", "を", "ヲ"),
        new Letter("n", "ん", "ン")
    };

    private static Letter[] variants = {
        //TODO
    };

    public static Letter[] getAllLetters(){
        return letters;
    }



}
