package Model.FormatQuestion;

import java.util.Random;

import Model.Letter;

public class FQ_AlphaToKana extends FormatQuestion{

    public String getfAskedLetter(Letter l){
        return l.getAlpha();
    }

    public String getfAnswer(Letter l){
        Random rand = new Random(); 
        if(rand.nextBoolean()){
            return l.getHiragana();
        }
        else{
            return l.getKatakana();
        }
        
    }

}