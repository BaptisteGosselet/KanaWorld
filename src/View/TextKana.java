package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.QC_Complete;
import Controller.QC_Progressive;
import Controller.QC_Selection;
import Controller.QuestionController;
import Model.FormatQuestion.FQ_AlphaToHiragana;
import Model.FormatQuestion.FQ_AlphaToKana;
import Model.FormatQuestion.FQ_AlphaToKatakana;
import Model.FormatQuestion.FQ_HiraganaToAlpha;
import Model.FormatQuestion.FQ_HiraganaVsKatakana;
import Model.FormatQuestion.FQ_KanaToAlpha;
import Model.FormatQuestion.FQ_KatakanaToAlpha;
import Model.FormatQuestion.FormatQuestion;

public class TextKana implements KanaView {
    private QuestionController questionController;
    private Scanner in = new Scanner(System.in);

    public TextKana(){
        setController(generateController());
        launchController();
    }

    public int intUserInput(int min, int max){
        System.out.print("Entrer un nombre : ");
        while(true){
            int n = in.nextInt();
            if(min<=n && n<=max){
                return n;
            }
            else{
                System.out.println("Invalide : non compris.");
            }
        }

        
        
    }

    public QuestionController generateController() {

        System.out.println("Quel format de question ?");
        System.out.println("0 - Hiragana -> Alpha");
        System.out.println("1 - Alpha -> Hiragana");
        System.out.println("2 - Katakana -> Alpha");
        System.out.println("3 - Alpha -> Katakana");
        System.out.println("4 - Kana -> Alpha");
        System.out.println("5 - Alpha -> Kana");
        System.out.println("6 - Hiragana <-> Katakana");

        FormatQuestion fq = new FQ_HiraganaToAlpha();

        int n = intUserInput(0, 6);
        if(n==0) fq = new FQ_HiraganaToAlpha();
        else if(n==1) fq = new FQ_AlphaToHiragana();
        else if(n==2) fq = new FQ_KatakanaToAlpha();
        else if(n==3) fq = new FQ_AlphaToKatakana();
        else if(n==4) fq = new FQ_KanaToAlpha();
        else if(n==5) fq = new FQ_AlphaToKana();
        else fq = new FQ_HiraganaVsKatakana();

        System.out.println("\nQuel mode ?");
        System.out.println("0 - Complet");
        System.out.println("1 - Progressif");
        System.out.println("2 - Selection : a");
        System.out.println("3 - Selection : k");
        System.out.println("4 - Selection : s");
        System.out.println("5 - Selection : t");
        System.out.println("6 - Selection : n");
        System.out.println("7 - Selection : h");
        System.out.println("8 - Selection : m");
        System.out.println("9 - Selection : r");

        n = intUserInput(0, 9);
        QuestionController qc;
        if(n==0) qc = new QC_Complete(this, fq);
        else if(n==1) qc = new QC_Progressive(this, fq);
        else if(n==2) qc = new QC_Selection(this, fq, 0, 5);
        else if(n==3) qc = new QC_Selection(this, fq, 5, 10);
        else if(n==4) qc = new QC_Selection(this, fq, 10, 15);
        else if(n==5) qc = new QC_Selection(this, fq, 15, 20);
        else if(n==6) qc = new QC_Selection(this, fq, 20, 25);
        else if(n==7) qc = new QC_Selection(this, fq, 25, 30);
        else if(n==8) qc = new QC_Selection(this, fq, 30, 35);
        else qc = new QC_Selection(this, fq, 38, 43);

        return qc;

    }
    
    public void setController(QuestionController qc) {
        this.questionController = qc;
        
    }

    public void launchController() {
        this.questionController.generateQuestion();
        
    }

    public void displayQuestion(String askedLetter, String[] answers) {
        System.out.print("-- " + askedLetter + " --");
        System.out.println();
        for(int i=0;i<answers.length;i++){
            System.out.println(i + " : " + answers[i]);
        }
        sendAnswerToController(intUserInput(0, 3));
        


    }

    public void sendAnswerToController(int n) {
        this.questionController.sendAnswer(n);
        
    }

    public void revealGoodAnswer(int n) {
        System.out.println("--> " + n + "\n");
        launchController();
    }
    

}
