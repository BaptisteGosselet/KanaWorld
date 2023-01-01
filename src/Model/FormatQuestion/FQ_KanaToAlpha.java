package Model.FormatQuestion;

import java.util.Random;

import Model.Letter;

public class FQ_KanaToAlpha extends FormatQuestion{
   
    public String getfAskedLetter(Letter l){
        Random rand = new Random(); 
        if(rand.nextBoolean()){
            return l.getHiragana();
        }
        else{
            return l.getKatakana();
        }
    }

    public String getfAnswer(Letter l){
        return l.getAlpha();
    }

    
}