package Model;

public class Question {
    private Letter askedLetter;
    private Letter[] answers;

    public Question(Letter l, Letter[] ans){
        this.askedLetter = l;
        this.answers = ans;
    }

    public boolean checkAnswer(int i){
        return this.answers[i].equals(askedLetter);
    }

    public int getGoodAnswerIndex(){
        for(int i=0;i<this.answers.length;i++){
            if(checkAnswer(i)){
                return i;
            }
        }
        return -1;
    }

    public Letter getAskedLetter(){
        return this.askedLetter;
    }

    public Letter[] getAnswers(){
        return this.answers;
    }

}
