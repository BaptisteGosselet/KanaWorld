package Controller;

import javax.sound.midi.SysexMessage;

import Model.Letter;
import Model.LetterFactory;
import Model.FormatQuestion.FormatQuestion;
import View.KanaView;

public class QC_Progressive extends QuestionController {

    int cpt = 0;
    int begin;
    int end;

    public QC_Progressive(KanaView _kview, FormatQuestion _formatQ) {
        super(_kview, _formatQ);
    }

    public void initAvailableLetters() {
        if(end == 0){
            begin = 0;
            end = 5;
        }

        Letter[] letters = LetterFactory.getAllLetters();
        this.availableLetters = new Letter[end-begin];
        for(int i=begin;i<end;i++){
            this.availableLetters[i-begin] = letters[i];
        }
        
        if(end == letters.length){
            this.kview.setController(new QC_Complete(this.kview, this.formatQ));
        }
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
        begin++;
        end++;
        initAvailableLetters();
    }




}
