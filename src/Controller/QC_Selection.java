package Controller;

import Model.Letter;
import Model.LetterFactory;
import Model.FormatQuestion.FormatQuestion;
import View.KanaView;

public class QC_Selection extends QuestionController {
    private int begin;
    private int end;


    public QC_Selection(KanaView _kview, FormatQuestion _formatQ, int begin, int end) {
        super(_kview, _formatQ);
        this.begin = begin;
        this.end = end;
        initAvailableLetters();
    }

    public void initAvailableLetters() {
        Letter[] letters = LetterFactory.getAllLetters();
        this.availableLetters = new Letter[end-begin];
        for(int i=begin;i<end;i++){
            this.availableLetters[i-begin] = letters[i];
        }

    }

}
