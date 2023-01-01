package View;

public interface KanaView {
    public void launchNewController();
    public void displayQuestion(String askedLetter, String[] answers);
    public void sendAnswerToController(int n);
    public void revealGoodAnswer(int n);
}
