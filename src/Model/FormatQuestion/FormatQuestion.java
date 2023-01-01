package Model.FormatQuestion;

import Model.Letter;

public abstract class FormatQuestion {
    
    public abstract String getfAskedLetter(Letter l);
    public abstract String getfAnswer(Letter l);
    
    public String[] getfAnswers(Letter[] answers){
        String[] fAnswers = new String[answers.length];
        for(int i=0;i<fAnswers.length;i++){
            fAnswers[i] = getfAnswer(answers[i]);
        }
        return fAnswers;
    }
}
