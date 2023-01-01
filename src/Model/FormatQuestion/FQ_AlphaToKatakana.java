package Model.FormatQuestion;

import Model.Letter;

public class FQ_AlphaToKatakana extends FormatQuestion{

    public String getfAskedLetter(Letter l){
        return l.getAlpha();
    }

    public String getfAnswer(Letter l){
        return l.getKatakana();
    }

}