package View;

import Controller.QuestionController;

public interface KanaView {
    public void setController(QuestionController qc);
    public QuestionController generateController();
    public void launchController();
    public void displayQuestion(String askedLetter, String[] answers);
    public void sendAnswerToController(int n);
    public void revealGoodAnswer(int n);
}
