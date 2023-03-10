package View;
import javax.swing.*;

import Controller.*;
import Model.FormatQuestion.*;

import java.awt.*;
import java.awt.event.*;

public class IGKana extends JFrame implements KanaView {

    class PauseThread extends Thread{
        public void run() {
            try {
                Thread.sleep(1500);
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
        Font letter_in_border_font = new Font("Monospaced", Font.BOLD, 74); 
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
        this.letterLabel.setFont(letter_in_border_font);
        this.letterLabel.setBounds(35,30,150,100);
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

    private JMenuBar initMenuBar(){
        JMenuBar menubar = new JMenuBar();

        JMenu mode = new JMenu("Mode");
        this.modeGroup = new ButtonGroup();

        JRadioButtonMenuItem progressiveMode = new JRadioButtonMenuItem("Progressif"); 
        progressiveMode.setActionCommand("progressive");
        modeGroup.add(progressiveMode); 
        mode.add(progressiveMode);

        JRadioButtonMenuItem completeMode = new JRadioButtonMenuItem("Complet Simple"); 
        completeMode.setActionCommand("complete");
        modeGroup.add(completeMode); 
        mode.add(completeMode);

        JRadioButtonMenuItem variantMode = new JRadioButtonMenuItem("Variants"); 
        variantMode.setActionCommand("variants");
        modeGroup.add(variantMode); 
        mode.add(variantMode);

        JRadioButtonMenuItem trueCompleteMode = new JRadioButtonMenuItem("Complet Variants"); 
        trueCompleteMode.setActionCommand("trueComplete");
        modeGroup.add(trueCompleteMode); 
        mode.add(trueCompleteMode);

        JRadioButtonMenuItem selectiveMode_ak = new JRadioButtonMenuItem("Selectif : a / k"); 
        selectiveMode_ak.setActionCommand("select_ak");
        modeGroup.add(selectiveMode_ak); 
        mode.add(selectiveMode_ak);

        JRadioButtonMenuItem selectiveMode_st = new JRadioButtonMenuItem("Selectif : s / t"); 
        selectiveMode_st.setActionCommand("select_st");
        modeGroup.add(selectiveMode_st); 
        mode.add(selectiveMode_st);

        JRadioButtonMenuItem selectiveMode_nh = new JRadioButtonMenuItem("Selectif : n / h"); 
        selectiveMode_nh.setActionCommand("select_nh");
        modeGroup.add(selectiveMode_nh); 
        mode.add(selectiveMode_nh);

        JRadioButtonMenuItem selectiveMode_mr = new JRadioButtonMenuItem("Selectif : m / r"); 
        selectiveMode_mr.setActionCommand("select_mr");
        modeGroup.add(selectiveMode_mr); 
        mode.add(selectiveMode_mr);
        
        progressiveMode.setSelected(true);

        //Format (hiragana->alpha, ...)
        JMenu format = new JMenu("Format");
        this.formatGroup = new ButtonGroup();

        JRadioButtonMenuItem hiraganaToAlpha = new JRadioButtonMenuItem("Hiragana -> Romaji"); 
        hiraganaToAlpha.setActionCommand("hta");
        formatGroup.add(hiraganaToAlpha);
        format.add(hiraganaToAlpha);

        JRadioButtonMenuItem alphaToHiragana = new JRadioButtonMenuItem("Romaji -> Hiragana"); 
        alphaToHiragana.setActionCommand("ath");
        formatGroup.add(alphaToHiragana);
        format.add(alphaToHiragana);

        JRadioButtonMenuItem katakanaToAlpha = new JRadioButtonMenuItem("Katakana -> Romaji"); 
        katakanaToAlpha.setActionCommand("kta");
        formatGroup.add(katakanaToAlpha);
        format.add(katakanaToAlpha);

        JRadioButtonMenuItem alphaToKatakana = new JRadioButtonMenuItem("Romaji -> Katakana"); 
        alphaToKatakana.setActionCommand("atk");
        formatGroup.add(alphaToKatakana);
        format.add(alphaToKatakana);

        JRadioButtonMenuItem AlphaToKana = new JRadioButtonMenuItem("Romaji -> Kana"); 
        AlphaToKana.setActionCommand("at*");
        formatGroup.add(AlphaToKana);
        format.add(AlphaToKana);

        JRadioButtonMenuItem KanaToAlpha = new JRadioButtonMenuItem("Kana -> Romaji"); 
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
                    setController(generateController());
                    launchController();
                }
                public void mouseReleased(MouseEvent e) {}
        });
    
        //return 
        menubar.add(mode);
        menubar.add(format);
        menubar.add(play);
        return menubar;
    }

    public QuestionController generateController(){
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
        if(mode.equals("progressive")) return new QC_Progressive(this, fq);
        else if(mode.equals("complete")) return new QC_Selection(this,fq,0,46);
        else if(mode.equals("trueComplete")) return new QC_Selection(this, fq,0,70);
        else if(mode.equals("variants")) return new QC_Selection(this, fq, 46,70);
        else if(mode.equals("select_ak")) return new QC_Selection(this, fq, 0, 10);
        else if(mode.equals("select_st")) return new QC_Selection(this, fq, 10, 20);
        else if(mode.equals("select_nh")) return new QC_Selection(this, fq, 20, 30);
        else if(mode.equals("select_mr")) return new QC_Selection(this, fq, 30, 43);
        
        return new QC_Selection(this,fq,0,46);
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
        
        if(askedLetter.length() == 1){
            this.letterLabel.setBounds(35,30,150,100);
        }
        else if(askedLetter.length() == 2){
            this.letterLabel.setBounds(30,30,150,100);
        }
        else if(askedLetter.length() == 3){
            this.letterLabel.setBounds(7,30,150,100);
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

    public void launchController(){
        this.questionController.generateQuestion();
    }

    public void setController(QuestionController qc){
        this.questionController = qc;        
    }


}
