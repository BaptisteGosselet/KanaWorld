package Model.FormatQuestion;

import java.util.Random;

import Model.Letter;

public class FQ_HiraganaVsKatakana extends FormatQuestion{
    boolean b = false;


    public String getfAskedLetter(Letter l){
        Random rand = new Random(); 
        this.b = rand.nextBoolean();

        if(this.b){
            return l.getHiragana();
        }
        else{
            return l.getKatakana();
        }

    }

    public String getfAnswer(Letter l){
        if(!this.b){
            return l.getHiragana();
        }
        else{
            return l.getKatakana();
        }

    }

}