package Model.FormatQuestion;

import Model.Letter;

public class FQ_KatakanaToAlpha extends FormatQuestion{

    public String getfAskedLetter(Letter l){
        return l.getKatakana();
    }

    public String getfAnswer(Letter l){
        return l.getAlpha();
    }

}