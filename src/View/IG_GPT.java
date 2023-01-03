package View;

import javax.swing.*;

import Controller.*;
import Model.FormatQuestion.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IG_GPT extends JFrame implements ActionListener, KanaView {

    //CODE GENERE PAR CHATGPT 

    // Création des composants de l'interface
    private JLabel questionLabel;
    private JRadioButton[] choices;
    private ButtonGroup choiceGroup;
    private JButton submitButton;

    public IG_GPT() {
        // Création de la fenêtre principale
        setTitle("Kana World");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Création du label qui affichera la question
        questionLabel = new JLabel("Voici la question du quiz");
        add(questionLabel);

        // Création des boutons radio pour les propositions de réponse
        choices = new JRadioButton[4];
        choices[0] = new JRadioButton("Réponse 1");
        choices[1] = new JRadioButton("Réponse 2");
        choices[2] = new JRadioButton("Réponse 3");
        choices[3] = new JRadioButton("Réponse 4");
        choiceGroup = new ButtonGroup();
        for (JRadioButton choice : choices) {
            add(choice);
            choiceGroup.add(choice);
        }

        // Création du bouton de soumission de la réponse
        submitButton = new JButton("Soumettre");
        submitButton.addActionListener(this);
        add(submitButton);

        this.setController(this.generateController());
        this.launchController();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Code exécuté lorsque le bouton de soumission est cliqué
        if (e.getSource() == submitButton) {
            // Récupération de la réponse sélectionnée
            int selectedChoice = -1;
            for (int i = 0; i < choices.length; i++) {
                if (choices[i].isSelected()) {
                    selectedChoice = i;
                    break;
                }
            }

            // Traitement de la réponse
            if (selectedChoice == -1) {
                JOptionPane.showMessageDialog(this, "Vous n'avez sélectionné aucune réponse", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                sendAnswerToController(selectedChoice);
            }
        }
    }


    //Partie ajoutée

    QuestionController questionController;

    @Override
    public void setController(QuestionController qc) {
        this.questionController = qc;
        
    }

    @Override
    public QuestionController generateController() {
        return new QC_Progressive(this, new FQ_HiraganaToAlpha());
    }

    @Override
    public void launchController() {
        this.questionController.generateQuestion();
        
    }

    @Override
    public void displayQuestion(String askedLetter, String[] answers) {
        questionLabel.setText(askedLetter);
        for(int i=0;i<choices.length;i++) choices[i].setText(answers[i]);
    }

    @Override
    public void sendAnswerToController(int n) {
        questionController.sendAnswer(n);
        
    }

    @Override
    public void revealGoodAnswer(int n) {
        String toDisplay = this.questionLabel.getText() + "--->" + this.choices[n].getText();
        JOptionPane.showMessageDialog(this, toDisplay, "Réponse", JOptionPane.INFORMATION_MESSAGE);
        this.launchController();
    }

}
