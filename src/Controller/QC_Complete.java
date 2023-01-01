package Controller;

import Model.LetterFactory;
import Model.FormatQuestion.FormatQuestion;
import View.KanaView;

public class QC_Complete extends QuestionController {

    public QC_Complete(KanaView _kview, FormatQuestion _formatQ) {
        super(_kview, _formatQ);
    }

    public void initAvailableLetters() {
        this.availableLetters = LetterFactory.getAllLetters();
    }

}
