package Controller;

import Model.Letter;
import Model.LetterFactory;
import Model.FormatQuestion.FormatQuestion;
import View.KanaView;

public class QC_Progressive extends QuestionController {

    int cpt = 0;
    int nbLetter;
    boolean complete = false;

    public QC_Progressive(KanaView _kview, FormatQuestion _formatQ) {
        super(_kview, _formatQ);
    }

    public void initAvailableLetters() {
        if(nbLetter == 0){
            nbLetter = 5;
        }

        Letter[] letters = LetterFactory.getAllLetters();
        this.availableLetters = new Letter[nbLetter];
        for(int i=0;i<nbLetter;i++){
            this.availableLetters[i] = letters[i];
        }
        
        if(nbLetter == letters.length) complete = true;
    }

    @Override
    public void sendAnswer(int n){
        super.sendAnswer(n);
        if(this.currentQuestion.checkAnswer(n)){
            increaseCpt();
        }
        else{
            resetCpt();
        }
    }

    public void resetCpt(){
        this.cpt = 0;
    }

    public void increaseCpt(){
        this.cpt++;
        if(cpt == 5){
            this.cpt = 0;
            this.addLetter();
        }
    }

    public void addLetter(){
        if(!complete){
            nbLetter++;
            initAvailableLetters();
        }
    }




}
