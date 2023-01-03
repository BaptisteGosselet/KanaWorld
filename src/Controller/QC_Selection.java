package Controller;

import Model.Letter;
import Model.LetterFactory;
import Model.FormatQuestion.FormatQuestion;
import View.KanaView;

public class QC_Selection extends QuestionController {
    int begin;
    int end;

    public QC_Selection(KanaView _kview, FormatQuestion _formatQ, int begin, int end) {
        super(_kview, _formatQ);
        this.begin = begin;
        this.end = end;
        initAvailableLetters();
    }

    private QC_Selection(KanaView _kview, FormatQuestion _formatQ){
        super(_kview, _formatQ);
    }

    public void initAvailableLetters() {
        Letter[] letters = LetterFactory.getAllLetters();
        this.availableLetters = new Letter[end-begin];
        for(int i=begin;i<end;i++){
            System.out.println(letters[i].getAlpha());
            this.availableLetters[i-begin] = letters[i];
        }

    }

}
