package Controller;

import java.util.Random;

import Model.Letter;
import Model.Question;
import Model.FormatQuestion.FormatQuestion;
import View.KanaView;

public abstract class QuestionController {
    protected KanaView kview;
    protected FormatQuestion formatQ;

    protected Letter[] availableLetters;

    protected Question currentQuestion;

    public QuestionController(KanaView _kview, FormatQuestion _formatQ){
        this.kview = _kview;
        this.formatQ = _formatQ;
    }

    public Letter[] pickFourLetters(){
        Letter[] copy = this.shuffleLetterArray(this.availableLetters);

        Letter[] selection = new Letter[4];
        for(int i=0;i<selection.length;i++){
            selection[i] = copy[i];
        }

        return selection;
    }

    public Letter[] shuffleLetterArray(Letter[] arrayToShuffle){
        Random rand = new Random();

        Letter[] copy = new Letter[arrayToShuffle.length];
        for(int i=0;i<arrayToShuffle.length;i++){
            copy[i] = arrayToShuffle[i];
        }

		for (int i = 0; i < copy.length; i++) {
			int randomIndexToSwap = rand.nextInt(arrayToShuffle.length-1);
            Letter temp = copy[randomIndexToSwap];
			copy[randomIndexToSwap] = copy[i];
			copy[i] = temp;
		}

        return copy;
    }

    public void generateQuestion(){
        Letter[] selectLetters = this.pickFourLetters();
        this.currentQuestion = new Question(selectLetters[0],shuffleLetterArray(selectLetters));
        kview.displayQuestion(
            formatQ.getfAskedLetter(currentQuestion.getAskedLetter()),
            formatQ.getfAnswers(currentQuestion.getAnswers())
        );
    };

    public void sendAnswer(int i){
        kview.revealGoodAnswer(this.currentQuestion.getGoodAnswerIndex());
    }

    public abstract void initAvailableLetters();
    


}
