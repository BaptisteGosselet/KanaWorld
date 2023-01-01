package View;
import javax.swing.*;

import Controller.QC_Complete;
import Controller.QuestionController;
import Model.FormatQuestion.FQ_AlphaToHiragana;
import Model.FormatQuestion.FQ_AlphaToKana;
import Model.FormatQuestion.FQ_AlphaToKatakana;
import Model.FormatQuestion.FQ_HiraganaToAlpha;
import Model.FormatQuestion.FQ_HiraganaVsKatakana;
import Model.FormatQuestion.FQ_KanaToAlpha;
import Model.FormatQuestion.FQ_KatakanaToAlpha;
import Model.FormatQuestion.FormatQuestion;

import java.awt.*;
import java.awt.event.*;

public class IGKana extends JFrame implements KanaView {

    class PauseThread extends Thread{
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            questionController.generateQuestion();
        }
    }

    JLabel letterLabel =new JLabel();
    JButton[] buttons = new JButton[4];
    Color buttonColor;

    ButtonGroup modeGroup;
    ButtonGroup formatGroup;

    QuestionController questionController;

    public IGKana(){

        //Frame Configuration
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setTitle("Kana World");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setLayout(null);
        Container c=getContentPane();
        
        //Personnalisation
        Color frame_backgound_color = new Color(245,245,220);
        Color color_of_border = new Color(93,56,36);
        Color background_color_of_border = Color.WHITE;
        Font letter_in_borer_font = new Font("Monospaced", Font.BOLD, 80); 
        Font button_font = new Font("Monospaced", Font.PLAIN, 30);

        //Menu bar
        this.setJMenuBar(this.initMenuBar());


        //Border panel
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(color_of_border, 10));
        panel.setBackground(background_color_of_border);
        panel.setBounds(180,30,150,150);
        panel.add(this.letterLabel);
        this.letterLabel.setFont(letter_in_borer_font);
        this.letterLabel.setBounds(35,30,100,100);
        c.add(panel);

        //Answers panel
        JPanel panel2=new JPanel();
        JPanel label2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 4));
        label2.setBackground(new Color(0,0,0,.0f));

        for(int i=0;i<buttons.length;i++){
            buttons[i] = new JButton();
            buttons[i].setFont(button_font);
            buttons[i].setPreferredSize(new Dimension(100,100));
            buttons[i].setEnabled(false);
            label2.add(buttons[i]);
        }

        this.buttonColor = buttons[0].getBackground();

        buttons[0].addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){clickOnButton(0);}});
        buttons[1].addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){clickOnButton(1);}});
        buttons[2].addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){clickOnButton(2);}});
        buttons[3].addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){clickOnButton(3);}});
        
        panel2.add(label2);
        panel2.setBounds(20,200,460,150);
        c.add(panel2);
        

        c.setBackground(frame_backgound_color);
        this.setVisible(true);
    }

    public JMenuBar initMenuBar(){
        JMenuBar menubar = new JMenuBar();

        //Mode (Progressive : aiueo+1 ; Selective a/h/s/...; Complete)
        JMenu mode = new JMenu("Mode");
        this.modeGroup = new ButtonGroup();

        JRadioButtonMenuItem progressiveMode = new JRadioButtonMenuItem("Progressif"); 
        progressiveMode.setActionCommand("progressive");
        modeGroup.add(progressiveMode); 
        mode.add(progressiveMode);

        JRadioButtonMenuItem completeMode = new JRadioButtonMenuItem("Complet"); 
        completeMode.setActionCommand("complete");
        modeGroup.add(completeMode); 
        mode.add(completeMode);

        JRadioButtonMenuItem selectiveMode_a = new JRadioButtonMenuItem("Selectif : a"); 
        selectiveMode_a.setActionCommand("select_a");
        modeGroup.add(selectiveMode_a); 
        mode.add(selectiveMode_a);

        JRadioButtonMenuItem selectiveMode_k = new JRadioButtonMenuItem("Selectif : k"); 
        selectiveMode_k.setActionCommand("select_k");
        modeGroup.add(selectiveMode_k); 
        mode.add(selectiveMode_k);

        JRadioButtonMenuItem selectiveMode_s = new JRadioButtonMenuItem("Selectif : s"); 
        selectiveMode_s.setActionCommand("select_s");
        modeGroup.add(selectiveMode_s); 
        mode.add(selectiveMode_s);

        JRadioButtonMenuItem selectiveMode_t = new JRadioButtonMenuItem("Selectif : t"); 
        selectiveMode_t.setActionCommand("select_t");
        modeGroup.add(selectiveMode_t); 
        mode.add(selectiveMode_t);

        JRadioButtonMenuItem selectiveMode_n = new JRadioButtonMenuItem("Selectif : n"); 
        selectiveMode_n.setActionCommand("select_n");
        modeGroup.add(selectiveMode_n); 
        mode.add(selectiveMode_n);

        JRadioButtonMenuItem selectiveMode_h = new JRadioButtonMenuItem("Selectif : h"); 
        selectiveMode_h.setActionCommand("select_h");
        modeGroup.add(selectiveMode_h); 
        mode.add(selectiveMode_h);

        JRadioButtonMenuItem selectiveMode_m = new JRadioButtonMenuItem("Selectif : m"); 
        selectiveMode_m.setActionCommand("select_m");
        modeGroup.add(selectiveMode_m); 
        mode.add(selectiveMode_m);

        JRadioButtonMenuItem selectiveMode_y = new JRadioButtonMenuItem("Selectif : y"); 
        selectiveMode_y.setActionCommand("select_y");
        modeGroup.add(selectiveMode_y); 
        mode.add(selectiveMode_y);

        JRadioButtonMenuItem selectiveMode_r = new JRadioButtonMenuItem("Selectif : r"); 
        selectiveMode_r.setActionCommand("select_r");
        modeGroup.add(selectiveMode_r); 
        mode.add(selectiveMode_r);

        JRadioButtonMenuItem selectiveMode_w = new JRadioButtonMenuItem("Selectif : w"); 
        selectiveMode_w.setActionCommand("select_w");
        modeGroup.add(selectiveMode_w); 
        mode.add(selectiveMode_w);
        
        progressiveMode.setSelected(true);

        //Format (hiragana->alpha, ...)
        JMenu format = new JMenu("Format");
        this.formatGroup = new ButtonGroup();

        JRadioButtonMenuItem hiraganaToAlpha = new JRadioButtonMenuItem("Hiragana -> Alpha"); 
        hiraganaToAlpha.setActionCommand("hta");
        formatGroup.add(hiraganaToAlpha);
        format.add(hiraganaToAlpha);

        JRadioButtonMenuItem alphaToHiragana = new JRadioButtonMenuItem("Alpha -> Hiragana"); 
        alphaToHiragana.setActionCommand("ath");
        formatGroup.add(alphaToHiragana);
        format.add(alphaToHiragana);

        JRadioButtonMenuItem katakanaToAlpha = new JRadioButtonMenuItem("Katakana -> Alpha"); 
        katakanaToAlpha.setActionCommand("kta");
        formatGroup.add(katakanaToAlpha);
        format.add(katakanaToAlpha);

        JRadioButtonMenuItem alphaToKatakana = new JRadioButtonMenuItem("Alpha -> Katakana"); 
        alphaToKatakana.setActionCommand("atk");
        formatGroup.add(alphaToKatakana);
        format.add(alphaToKatakana);

        JRadioButtonMenuItem AlphaToKana = new JRadioButtonMenuItem("Alpha -> Kana"); 
        AlphaToKana.setActionCommand("at*");
        formatGroup.add(AlphaToKana);
        format.add(AlphaToKana);

        JRadioButtonMenuItem KanaToAlpha = new JRadioButtonMenuItem("Kana -> Alpha"); 
        KanaToAlpha.setActionCommand("*ta");
        formatGroup.add(KanaToAlpha);
        format.add(KanaToAlpha);
        
        JRadioButtonMenuItem HiraganaVsKatakana = new JRadioButtonMenuItem("Hiragana <-> Katakana"); 
        HiraganaVsKatakana.setActionCommand("hvk");
        formatGroup.add(HiraganaVsKatakana);
        format.add(HiraganaVsKatakana);

        hiraganaToAlpha.setSelected(true);

        //Play
        JMenu play = new JMenu("Jouer");
        play.addMouseListener(new MouseListener(){
                public void mouseClicked(MouseEvent e) {}
                public void mouseEntered(MouseEvent e) {}
                public void mouseExited(MouseEvent e) {}
                public void mousePressed(MouseEvent e) {
                    launchNewController();
                }
                public void mouseReleased(MouseEvent e) {}
        });
    
        //return 
        menubar.add(mode);
        menubar.add(format);
        menubar.add(play);
        return menubar;
    }

    public void launchNewController(){
        String mode = this.modeGroup.getSelection().getActionCommand();
        String format = this.formatGroup.getSelection().getActionCommand();

        FormatQuestion fq = new FQ_HiraganaToAlpha();

        //Format
        if(format.equals("hta")) fq = new FQ_HiraganaToAlpha();
        else if(format.equals("ath")) fq = new FQ_AlphaToHiragana();
        else if(format.equals("kta")) fq = new FQ_KatakanaToAlpha();
        else if(format.equals("atk")) fq = new FQ_AlphaToKatakana();
        else if(format.equals("at*")) fq = new FQ_AlphaToKana();
        else if(format.equals("*ta")) fq = new FQ_KanaToAlpha();
        else if(format.equals("hvk")) fq = new FQ_HiraganaVsKatakana();
        

        //Mode
        if(mode.equals("progressive")) System.out.println("Mode : Progressif");
        else if(mode.equals("complete")) this.questionController = new QC_Complete(this,fq);

        else if(mode.equals("select_a")) System.out.println("Mode : Selection a");
        else if(mode.equals("select_k")) System.out.println("Mode : Selection k");
        else if(mode.equals("select_s")) System.out.println("Mode : Selection s");
        else if(mode.equals("select_t")) System.out.println("Mode : Selection t");
        else if(mode.equals("select_n")) System.out.println("Mode : Selection n");
        else if(mode.equals("select_h")) System.out.println("Mode : Selection h");
        else if(mode.equals("select_m")) System.out.println("Mode : Selection m");
        else if(mode.equals("select_y")) System.out.println("Mode : Selection y");
        else if(mode.equals("select_r")) System.out.println("Mode : Selection r");
        else if(mode.equals("select_w")) System.out.println("Mode : Selection w");


        this.questionController.generateQuestion();
    }

    public void clickOnButton(int n){
        sendAnswerToController(n);
    }

    public void sendAnswerToController(int n){
        this.questionController.sendAnswer(n);
    }

    public void displayQuestion(String askedLetter, String[] answers){
        
        //Refresh GUI
        for(int i=0;i<this.buttons.length;i++){
            buttons[i].setText("");
            buttons[i].setEnabled(true);
            buttons[i].setBackground(buttonColor);
        }
        
        letterLabel.setText(askedLetter);
        buttons[0].setText(answers[0]);
        buttons[1].setText(answers[1]);
        buttons[2].setText(answers[2]);
        buttons[3].setText(answers[3]);
    }

    public void revealGoodAnswer(int n){
        
        //colorize button
        for(int i=0;i<buttons.length;i++){
            buttons[i].setBackground(Color.RED);
            buttons[i].setEnabled(false);
        }
        buttons[n].setBackground(Color.GREEN);


        PauseThread rt = new PauseThread();
        rt.start();
    }


}
