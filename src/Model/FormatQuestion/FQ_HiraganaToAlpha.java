package Model.FormatQuestion;

import Model.Letter;

public class FQ_HiraganaToAlpha extends FormatQuestion{

    public String getfAskedLetter(Letter l){
        return l.getHiragana();
    }

    public String getfAnswer(Letter l){
        return l.getAlpha();
    }

}